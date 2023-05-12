/*
-- --------------------------------------------------------------------------
-- this program belongs to lentra ai. it is considered a trade secret and
-- is not to be divulged or used by parties who have not received written
-- authorization from lentra ai.
-- --------------------------------------------------------------------------
-- database 	  : postgresql
-- module         : VMS
-- author         : Afroze A
-- review date    : 05.05.2023
-- description    : insert properties in vms
-- ---------------------------------------------------------------------------
-- usage : deploy via flyway migrate
-- --------------------------------------------------------------------------- 
-- note : 
-- 1. request to go ahead with lowercase in postgres when checking dictionary tables.
-- 2. since flyway default schema is set to '{ph_schema} which is same as default schema', actions will be performed in same schema. so, typically v_schema_name is not required but kept as on safe side.
-- 3. in flyway, if script fails - everything will be rollbacked. so explicitly rollback will cause error: invalid transaction termination
-- 4. flywway have not impact on auto commit on / off;
-- 5. Due to error state  : 25001  message: CREATE TABLESPACE cannot run inside a transaction block
-- 6.  We cannot havtransactional and non-transactional statements within the same migration. Hence going ahead with normal executions.
-- 7.  CREATE TABLESPACE cannot run inside a transaction block
*/

do
$$

declare
	-- do not change the tablespace name ----
	--v_tablespace_dts varchar(20) := '{ph_schema}_dts';
	--v_tablespace_mtd varchar(20) := '{ph_schema}_mtd';
	--v_tablespace_ind varchar(20) := '{ph_schema}_ind';

	-- do not change the schema name ----
	v_schema_name varchar(50) 	 := '${ph_schema}';
	--- you can changes the file name ----
	v_filename varchar(100)		 := 'V202305051448__FORM_CLEAN_UP.sql';
	--- you can changes the file name ----
	c record;
	
	v_state   text;
    v_msg     text;
    v_detail  text;
    v_hint    text;
    v_context text;
    v_text    text;
begin

-- **************************       your sql code starts below this line       **************************


	v_text = ' insert into ' || v_schema_name ||'.properties
				(
				key,
				value,
				description
				)
				values
				(''DO_FORM_CLEANUP'',
				''{"DO_FORM_CLEANUP": "true",
				"do_form_cleanup_duration": "1d",
				"batch_job_execution_frequency": "0 0 0 */2 * *"}'',
				''do form clean, duration after which vms will be auto deleted two months old records and frequency of do form cleanup functionality execution''
			    )';

	 execute v_text;

-- **************************       your sql code ends above this line       **************************

	 raise notice 'successfully deployed script % in schema %', v_filename ,v_schema_name ;


exception

		when others then
				raise notice 'in exception, transaction will be rolled back';
				--rollback;

				get stacked diagnostics
					v_state   = returned_sqlstate,
					v_msg     = message_text,
					v_detail  = pg_exception_detail,
					v_hint    = pg_exception_hint,
					v_context = pg_exception_context;

				raise notice e'got exception:
					state  : %
					message: %
					detail : %
					hint   : %
					context: %', v_state, v_msg, v_detail, v_hint, v_context;

				raise notice ' script % failed to execute in schema %', v_filename ,v_schema_name ;
				raise exception ' script failed';

end;

$$;
