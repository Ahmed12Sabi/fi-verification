
create or replace 
function insert_update_delete_trigger()
    returns trigger
    security definer
    language plpgsql
as $$
declare
    v_new_record_jsonb jsonb = to_jsonb(new);
    v_old_record_jsonb jsonb = to_jsonb(old);
    v_new_record_id    int;
begin

 if v_new_record_jsonb = v_old_record_jsonb
 then
    return new;
 end if;

    WITH pk_columns (attname) AS (
        SELECT CAST(a.attname AS TEXT) 
        FROM pg_index i JOIN pg_attribute a 
        ON a.attrelid = i.indrelid 
        AND a.attnum = ANY(i.indkey) 
        WHERE  i.indrelid = TG_RELID  
        AND i.indisprimary
    )
    SELECT value INTO v_new_record_id
    FROM jsonb_each(v_new_record_jsonb)
    WHERE key IN(SELECT attname FROM pk_columns);

   

    insert into record_version(
        rv_record_id,
        rv_operation,
        rv_table_oid,
        rv_table_schema,
        rv_table_name,
        rv_new_record,
        rv_old_record
    )
    select
        v_new_record_id,
        TG_OP,
        TG_RELID,
        TG_TABLE_SCHEMA,
        TG_TABLE_NAME,
        v_new_record_jsonb,
        v_old_record_jsonb;

    return coalesce(new, old);
end;
$$;