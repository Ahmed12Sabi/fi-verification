create or replace function disable_tracking(regclass)
    returns void
    volatile
    security definer
    language plpgsql
as $$
declare
    statement_row text = format(
        'drop trigger if exists audit_i_u_d on %I;',
        $1
    );
begin
    execute statement_row;
end;
$$;