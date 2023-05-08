
/*
-- --------------------------------------------------------------------------
-- this program belongs to lentra ai. it is considered a trade secret and
-- is not to be divulged or used by parties who have not received written
-- authorization from lentra ai.
-- --------------------------------------------------------------------------
-- database 	  : postgresql
-- module         : VMS Service
-- author         : Afroze A
-- review date    : 27.04.2023
-- description    : Create VMS Configuration tables
-- ---------------------------------------------------------------------------
-- usage : deploy via flyway migrate
-- ---------------------------------------------------------------------------
-- note :
-- 1. request to go ahead with lowercase in postgres when checking dictionary tables.
-- 2. since flyway default schema is set to '{ph_schema} which is same as default schema', actions will be performed in same schema. so, typically v_schema_name is not required but kept as on safe side.
-- 3. in flyway, if script fails - everything will be rollbacked. so explicitly rollback will cause error: invalid transaction termination
-- 4. flyway have not impact on auto commit on / off;
-- 5. Due to error state  : 25001  message: CREATE TABLESPACE cannot run inside a transaction block
-- 6.  We cannot have transactional and non-transactional statements within the same migration. Hence going ahead with normal executions.
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
--     v_schema_name varchar(50) 	 := 'leads';
	v_schema_name varchar(50) 	 := '${ph_schema}';

--- you can changes the file name ----
	v_filename varchar(100)		 := 'V202304272135_CONFIGURATIONS.sql';
	--- you can changes the file name ----
	c record;

	v_state   text;
    v_msg     text;
    v_detail  text;
    v_hint    text;
    v_context text;

--data type enum - Text: 1, Multi-line Text : 2, Number: 3, Date: 4,Date Time: 5, Currency: 6, Lookup: 7, Boolean:8
	v_text           int = 1;
	v_multiline_text int = 2;
	v_number         int = 3;
	v_date           int = 4;
	v_datetime       int = 5;
	v_currency       int = 6;
	v_lookup         int = 7;
	v_boolean        int = 8;

--Column type enum - id: 5, label: 2, key: 1, boolean:4
	v_id          int = 5;
	v_label       int = 2;
	v_key         int = 1;
	v_col_boolean int = 4;
	v_col_text    int = 3;

begin

-- **************************       your sql code starts below this line       **************************
     --DDL Statement for table - master_verification_configuration

    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('master_verification_configuration')) loop
    execute 'create table ' ||v_schema_name||'.master_verification_configuration
                (
                 id bigserial NOT NULL,
				e_sign bool NOT NULL,
				institution_id int8 NOT NULL,
				multi_verification_allowed varchar(50) NOT NULL,
				product_level_logic varchar(255) NULL,
				profile_id int8 NOT NULL,
				profile_name varchar(255) NULL,
				retriger_verification bool NOT NULL,
				sub_profile_name varchar(255) NULL,
				user_type varchar(50) NOT NULL,
				v_type varchar(255) NULL,
				created_by varchar(255) null ,
                created_on  timestamptz,
                modified_by varchar(255) null,
                modified_on  timestamptz,
				CONSTRAINT master_verification_configuration_pkey PRIMARY KEY (id)

                )';

	end loop;

    --DDL Statement for table - product_config
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('product_config')) loop
    execute 'create table ' ||v_schema_name||'.product_config
                (
                product_id bigserial NOT NULL,
				data_populated bool NULL DEFAULT false,
				institute_id varchar(255) NULL,
				mandatory bool NULL DEFAULT false,
				product_type varchar(255) NULL,
				profile_name varchar(255) NULL,
				waiver_allowed bool NULL DEFAULT false,
				created_by varchar(255) null ,
                created_on  timestamptz,
                modified_by varchar(255) null,
                modified_on  timestamptz,
				CONSTRAINT product_config_pkey PRIMARY KEY (product_id)

                )';

	end loop;

    --DDL Statement for table - report_config
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('report_config')) loop
    execute 'create table ' ||v_schema_name||'.report_config
                (
                    id bigserial NOT NULL,
					form_name varchar(255) NULL,
					institute_id int4 NULL,
                    created_by varchar(255) null ,
                    created_on  timestamptz,
                    modified_by varchar(255) null,
                    modified_on  timestamptz,
					CONSTRAINT report_config_pkey PRIMARY KEY (id)
                )';

	end loop;

    --DDL Statement for table - report_config_fields
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('report_config_fields')) loop
    execute 'create table ' ||v_schema_name||'.report_config_fields
                (
                id bigserial NOT NULL,
				fields varchar(255) NULL,
				f_id int8 NULL,
				created_by varchar(255) null ,
                created_on  timestamptz,
                modified_by varchar(255) null,
                modified_on  timestamptz,
				CONSTRAINT report_config_fields_pkey PRIMARY KEY (id)

                )';

	end loop;

    --DDL Statement for table - role_config
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('role_config')) loop
    execute 'create table ' ||v_schema_name||'.role_config
                (
                 role_id bigserial NOT NULL,
				institute_id varchar(255) NULL,
				role_name varchar(255) NULL,
				status bool NULL,
				vms_role_name varchar(255) NULL,
				created_by varchar(255) null ,
                created_on  timestamptz,
                modified_by varchar(255) null,
                modified_on  timestamptz,
				CONSTRAINT role_config_pkey PRIMARY KEY (role_id)

                )';

	end loop;

    --DDL Statement for table - score_master
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('score_master')) loop
    execute 'create table ' ||v_schema_name||'.score_master
                (
                s_id int8 NOT NULL,
				sc_name varchar(255) NOT NULL,
				max_range int4 NULL,
				min_range int4 NULL,
				range_indicator bool NULL,
				sc_value int4 NULL,
				created_by varchar(255) null ,
                created_on  timestamptz,
                modified_by varchar(255) null,
                modified_on  timestamptz,
				CONSTRAINT score_master_pkey PRIMARY KEY (s_id, sc_name)

                )';

	end loop;

    --DDL Statement for table - verification_form_config
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('verification_form_config')) loop
    execute 'create table ' ||v_schema_name||'.verification_form_config
                (
                form_id bigserial NOT NULL,
				form_description varchar(50) NOT NULL,
				form_name varchar(50) NULL,
				hidden bool NOT NULL,
				sub_profile_name varchar(255) NULL,
				v_id int8 NULL,
				created_by varchar(255) null ,
                created_on  timestamptz,
                modified_by varchar(255) null,
                modified_on  timestamptz,
				CONSTRAINT verification_form_config_pkey PRIMARY KEY (form_id)
                )';

	end loop;

    --DDL Statement for table - verification_form_fields_config
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('verification_form_fields_config')) loop
    execute 'create table ' ||v_schema_name||'.verification_form_fields_config
                (
                    field_id bigserial NOT NULL,
					data_auto_population bool NOT NULL,
					field_name varchar(50) NOT NULL,
					field_type varchar(50) NOT NULL,
					hidden bool NOT NULL,
					is_look_up bool NOT NULL,
					is_scoring bool NOT NULL,
					look_table varchar(255) NULL,
					max_length int4 NULL,
					max_range int4 NULL,
					min_length int4 NULL,
					min_range int4 NULL,
					required bool NOT NULL,
					scoring_name varchar(255) NULL,
					status bool NOT NULL,
					form_id int8 NULL,
                    created_by varchar(255) null ,
                    created_on  timestamptz,
                    modified_by varchar(255) null,
                    modified_on  timestamptz,
					CONSTRAINT verification_form_fields_config_pkey PRIMARY KEY (field_id)

                )';

	end loop;

    --DDL Statement for table - verification_form_fields_master
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('verification_form_fields_master')) loop
    execute 'create table ' ||v_schema_name||'.verification_form_fields_master
                (
                    field_id int8 NOT NULL,
					s_id int8 NOT NULL,
					sc_name varchar(255) NOT NULL,
					field_name varchar(255) NULL,
					field_type varchar(255) NULL,
					hidden bool NULL,
					is_scoring bool NULL,
					max_range int4 NULL,
					min_range int4 NULL,
					required bool NULL,
					status bool NULL,
                    created_by varchar(255) null ,
                    created_on  timestamptz,
                    modified_by varchar(255) null,
                    modified_on  timestamptz,
					CONSTRAINT verification_form_fields_master_pkey PRIMARY KEY (field_id, s_id, sc_name)

                )';

	end loop;

    --DDL Statement for table - verification_form_master
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('verification_form_master')) loop
    execute 'create table ' ||v_schema_name||'.verification_form_master
                (
                 form_id bigserial NOT NULL,
				form_description varchar(50) NULL,
				form_name varchar(50) NULL,
				created_by varchar(255) null ,
                created_on  timestamptz,
                modified_by varchar(255) null,
                modified_on  timestamptz,
				CONSTRAINT verification_form_master_pkey PRIMARY KEY (form_id)

                )';

	end loop;

    --DDL Statement for table - verification_form_fields_master
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('verification_form_fields_master')) loop
    execute 'create table ' ||v_schema_name||'.verification_form_fields_master
                (
                    field_id int8 NOT NULL,
					s_id int8 NOT NULL,
					sc_name varchar(255) NOT NULL,
					field_name varchar(255) NULL,
					field_type varchar(255) NULL,
					hidden bool NULL,
					is_scoring bool NULL,
					max_range int4 NULL,
					min_range int4 NULL,
					required bool NULL,
					status bool NULL,
                    created_by varchar(255) null ,
                    created_on  timestamptz,
                    modified_by varchar(255) null,
                    modified_on  timestamptz,
					CONSTRAINT verification_form_fields_master_pkey PRIMARY KEY (field_id, s_id, sc_name)

                )';

	end loop;
	--DDL Statement for table - Offline_pdf_data_mapping
        for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('Offline_pdf_data_mapping')) loop
        execute 'create table ' ||v_schema_name||'.Offline_pdf_data_mapping
                    (
                   id bigserial NOT NULL,
                   field_id int8 NOT NULL,
                   field_name varchar(255) NOT NULL,
                   field_table varchar(255) NOT null,
                   institute_name varchar(255) NOT null,
                   created_by varchar(255) null ,
                   created_on  timestamptz,
                   modified_by varchar(255) null,
                   modified_on  timestamptz 

                    )';

    	end loop;
-- **************************       your sql code ends above this line       **************************

	 --raise notice 'exit for loop';
	 raise notice 'successfully deployed script % in schema %', v_filename ,v_schema_name ;


exception
        when others then
                get stacked diagnostics
                    v_state   = returned_sqlstate,
                    v_msg     = message_text,
                    v_detail  = pg_exception_detail,
                    v_hint    = pg_exception_hint,
                    v_context = pg_exception_context;

                raise exception e' In exception, transaction will be rolled back !!
                script % failed to execute in schema %
                got exception:
                    state  : %
                    message: %
                    detail : %
                    hint   : %
                    context: %', v_filename ,v_schema_name, v_state, v_msg, v_detail, v_hint, v_context;

end;

$$;