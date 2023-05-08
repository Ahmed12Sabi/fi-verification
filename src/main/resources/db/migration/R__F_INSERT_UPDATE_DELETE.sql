
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
    v_client_user varchar(250);
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
    
    begin
        v_client_user = current_setting('schema_client1_vms.ClientUser');
    exception 
        when sqlstate '42704' 
        then 
        v_client_user = null;
    end ;    

    insert into record_version(
        rv_record_id,
        rv_operation,
        rv_table_oid,
        rv_table_schema,
        rv_table_name,
        rv_new_record,
        rv_old_record,
        rv_loginid
    )
    select
        v_new_record_id,
        TG_OP,
        TG_RELID,
        TG_TABLE_SCHEMA,
        TG_TABLE_NAME,
        v_new_record_jsonb,
        v_old_record_jsonb,
        v_client_user
        ;

    return coalesce(new, old);
end;
$$;