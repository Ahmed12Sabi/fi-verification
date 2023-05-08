create or replace 
function enable_tracking(regclass)
    returns void
    volatile
    security definer
    language plpgsql
as $$
declare
    statement_row text = format('
        create trigger audit_i_u_d
            before insert or update or delete
            on %I
            for each row
            execute procedure insert_update_delete_trigger();',
        $1
    );

begin
        execute statement_row;

end;
$$;