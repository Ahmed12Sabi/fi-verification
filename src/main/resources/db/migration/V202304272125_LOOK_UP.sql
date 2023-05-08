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
-- description    : Create leads lookup table and its entries
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
	v_filename varchar(100)		 := 'V202211012100__CREATE_VMS_LOOKUP.sql';
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
     --DDL Statement for table - m_address_proof_id

    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_address_proof_id')) loop
    execute 'create table ' ||v_schema_name||'.m_address_proof_id
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_appliances
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_appliances')) loop
    execute 'create table ' ||v_schema_name||'.m_appliances
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_bike_ownership_type
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_bike_ownership_type')) loop
    execute 'create table ' ||v_schema_name||'.m_bike_ownership_type
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_car_fuel_type
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_car_fuel_type')) loop
    execute 'create table ' ||v_schema_name||'.m_car_fuel_type
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_car_ownership_type
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_car_ownership_type')) loop
    execute 'create table ' ||v_schema_name||'.m_car_ownership_type
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_child_educational_level
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_child_educational_level')) loop
    execute 'create table ' ||v_schema_name||'.m_child_educational_level
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_citizenship
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_citizenship')) loop
    execute 'create table ' ||v_schema_name||'.m_citizenship
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_civil_status
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_civil_status')) loop
    execute 'create table ' ||v_schema_name||'.m_civil_status
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_classification
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_classification')) loop
    execute 'create table ' ||v_schema_name||'.m_classification
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_commute_options
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_commute_options')) loop
    execute 'create table ' ||v_schema_name||'.m_commute_options
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_company_type
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_company_type')) loop
    execute 'create table ' ||v_schema_name||'.m_company_type
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_ease_of_officelocation
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_ease_of_officelocation')) loop
    execute 'create table ' ||v_schema_name||'.m_ease_of_officelocation
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_education_level
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_education_level')) loop
    execute 'create table ' ||v_schema_name||'.m_education_level
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_house_condition
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_house_condition')) loop
    execute 'create table ' ||v_schema_name||'.m_house_condition
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_income_source
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_income_source')) loop
    execute 'create table ' ||v_schema_name||'.m_income_source
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_insurance_type
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_insurance_type')) loop
    execute 'create table ' ||v_schema_name||'.m_insurance_type
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_tems_sighted_in_office
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_tems_sighted_in_office')) loop
    execute 'create table ' ||v_schema_name||'.m_tems_sighted_in_office
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_job_domain
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_job_domain')) loop
    execute 'create table ' ||v_schema_name||'.m_job_domain
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_nature_of_business
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_nature_of_business')) loop
    execute 'create table ' ||v_schema_name||'.m_nature_of_business
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_neighbourhood_type
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_neighbourhood_type')) loop
    execute 'create table ' ||v_schema_name||'.m_neighbourhood_type
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_no_of_storey
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_no_of_storey')) loop
    execute 'create table ' ||v_schema_name||'.m_no_of_storey
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_office_address_country
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_office_address_country')) loop
    execute 'create table ' ||v_schema_name||'.m_office_address_country
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_office_construction
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_office_construction')) loop
    execute 'create table ' ||v_schema_name||'.m_office_construction
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_office_exterior
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_office_exterior')) loop
    execute 'create table ' ||v_schema_name||'.m_office_exterior
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_office_interior
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_office_interior')) loop
    execute 'create table ' ||v_schema_name||'.m_office_interior
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_office_locality
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_office_locality')) loop
    execute 'create table ' ||v_schema_name||'.m_office_locality
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_other_exp
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_other_exp')) loop
    execute 'create table ' ||v_schema_name||'.m_other_exp
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_other_findings
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_other_findings')) loop
    execute 'create table ' ||v_schema_name||'.m_other_findings
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_property_age
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_property_age')) loop
    execute 'create table ' ||v_schema_name||'.m_property_age
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_campaign
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_campaign')) loop
    execute 'create table ' ||v_schema_name||'.m_property_interior
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_property_make_type
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_property_make_type')) loop
    execute 'create table ' ||v_schema_name||'.m_property_make_type
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_residence_type
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_residence_type')) loop
    execute 'create table ' ||v_schema_name||'.m_residence_category
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_residence_type
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_residence_type')) loop
    execute 'create table ' ||v_schema_name||'.m_residence_type
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_residency
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_residency')) loop
    execute 'create table ' ||v_schema_name||'.m_residency
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --DDL Statement for table - m_sim_type
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_sim_type')) loop
    execute 'create table ' ||v_schema_name||'.m_sim_type
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;
	   --DDL Statement for table - m_spouse_citizenship
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_spouse_citizenship')) loop
    execute 'create table ' ||v_schema_name||'.m_spouse_citizenship
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;
	   --DDL Statement for table - m_spouse_occupation
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_spouse_occupation')) loop
    execute 'create table ' ||v_schema_name||'.m_spouse_occupation
                (
                    id        serial primary key,
                    label     varchar(255) not null unique,
                    key       varchar(255) not null unique,
                    is_active boolean not null default true
                )';

	end loop;

    --inserting lookup_tables data for table - m_m_appliances
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'm_appliances', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_m_appliances
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'm_appliances'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'm_appliances'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'm_appliances'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'm_appliances'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_address_proof_id
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'address_proof_id', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_address_proof_id
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'address_proof_id'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'address_proof_id'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'address_proof_id'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'address_proof_id'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_bike_ownership_type
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'bike_ownership_type', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_bike_ownership_type
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'bike_ownership_type'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'bike_ownership_type'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'bike_ownership_type'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'bike_ownership_type'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_car_fuel_type
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, car_fuel_type 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_car_fuel_type
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = car_fuel_type), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = car_fuel_type), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = car_fuel_type), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = car_fuel_type), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_car_ownership_type
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, car_ownership_type 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_car_ownership_type
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = car_ownership_type), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = car_ownership_type), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = car_ownership_type), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = car_ownership_type), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_child_educational_level
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, child_educational_level, 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_child_educational_level
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = child_educational_level), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = child_educational_level), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = child_educational_level), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = child_educational_level), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_citizenship
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'citizenship, 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_citizenship
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'citizenship), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'citizenship), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'citizenship), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'citizenship), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_civil_status
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, civil_status, 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_civil_status
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = civil_status), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = civil_status), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = civil_status), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = civil_status), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_classification
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'classification, 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_classification
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'classification), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'classification), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'classification), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'classification), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_commute_options
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, commute_options, 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_commute_options
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = commute_options), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = commute_options), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = commute_options), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = commute_options), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_company_type
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, company_type, 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_company_type
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = company_type), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = company_type), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = company_type), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = company_type), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_ease_of_officelocation
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, ease_of_officelocation, 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_ease_of_officelocation
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = ease_of_officelocation), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = ease_of_officelocation), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = ease_of_officelocation), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = ease_of_officelocation), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_education_level
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, education_level, 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_education_level
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = education_level), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = education_level), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = education_level), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = education_level), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_house_condition
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, house_condition 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_house_condition
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = house_condition), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = house_condition), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = house_condition), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = house_condition), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_income_source
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, income_source, 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_income_source
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = income_source), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = income_source), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = income_source), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = income_source), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_insurance_type
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE,'insurance_type', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_insurance_type
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id ='insurance_type'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id ='insurance_type'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id ='insurance_type'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id ='insurance_type'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_tems_sighted_in_office
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'tems_sighted_in_office', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_tems_sighted_in_office
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'tems_sighted_in_office'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'tems_sighted_in_office'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'tems_sighted_in_office'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'tems_sighted_in_office'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_job_domain
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'job_domain', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_job_domain
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'job_domain'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'job_domain'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'job_domain'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'job_domain'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_nature_of_business
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'nature_of_business', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_nature_of_business
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'nature_of_business'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'nature_of_business'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'nature_of_business'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'nature_of_business'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_neighbourhood_type
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'neighbourhood_type', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_neighbourhood_type
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'neighbourhood_type'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'neighbourhood_type'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'neighbourhood_type'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'neighbourhood_type'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_no_of_storey
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'no_of_storey', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_no_of_storey
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'no_of_storey'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'no_of_storey'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'no_of_storey'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'no_of_storey'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_office_address_country
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'address_type', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_office_address_country
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'address_type'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'address_type'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'address_type'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'address_type'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_office_construction
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'office_construction', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_office_construction
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'office_construction'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'office_construction'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'office_construction'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'office_construction'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_office_exterior
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'leads_external_id_type', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_office_exterior
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'leads_external_id_type'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'leads_external_id_type'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'leads_external_id_type'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'leads_external_id_type'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_office_interior
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'office_interior', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_office_interior
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'office_interior'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'office_interior'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'office_interior'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'office_interior'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_office_locality
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'office_locality', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_office_locality
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'office_locality'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'office_locality'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'office_locality'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'office_locality'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_other_exp
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'other_exp', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_other_exp
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'other_exp'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'other_exp'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'other_exp'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'other_exp'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_other_findings
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'other_findings', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_other_findings
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'other_findings'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'other_findings'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'other_findings'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'other_findings'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_property_age
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'property_age', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_property_age
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'property_age'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'property_age'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'property_age'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'property_age'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_campaign
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'campaign', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_campaign
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'campaign'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'campaign'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'campaign'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'campaign'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_property_make_type
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'property_make_type', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_property_make_type
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'property_make_type'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'property_make_type'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'property_make_type'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'property_make_type'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_residence_type
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'residence_type', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_residence_type
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'residence_type'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'residence_type'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'residence_type'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'residence_type'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_residency
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'residency', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_residency
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'residency'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'residency'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'residency'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'residency'), v_col_boolean, v_boolean, 'is_active');

    --inserting lookup_tables data for table - m_spouse_occupation
    insert into lookup_tables (lt_is_standard, lt_lookup_id, lt_version, lt_created, lt_created_by, lt_last_updated_structure, lt_last_updated_data) values (TRUE, 'spouse_occupation', 0, NOW(), 'System', NOW(), NOW());

    --start - inserting business entities attribute data for table - m_spouse_occupation
    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'spouse_occupation'), v_id, v_number, 'id');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'spouse_occupation'), v_label, v_text, 'label');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'spouse_occupation'), v_key, v_text, 'key');

    insert into lookup_table_columns (ltc_lt_id, ltc_column_type, ltc_data_type, ltc_name)
    values ((select lt_id from lookup_tables where lt_lookup_id = 'spouse_occupation'), v_col_boolean, v_boolean, 'is_active');

	-- lookup data insert scripts starts..

	--m_education_level

	insert into  m_education_level (key, label, is_active) values  ('HIGH SCHOOL','HIGH SCHOOL','TRUE');
	insert into  m_education_level (key, label, is_active) values  ('COLLEGE','COLLEGE','TRUE');
	insert into  m_education_level (key, label, is_active) values  ('POST GRADUATE','POST GRADUATE','TRUE');
	insert into  m_education_level (key, label, is_active) values  ('OTHERS','OTHERS','TRUE');

	--m_income_source

	insert into  m_income_source (key, label, is_active) values  ('EMPLOYMENT','EMPLOYMENT','TRUE');
	insert into  m_income_source (key, label, is_active) values  ('BUSINESS/SELF_EMPLOYED','BUSINESS/SELF_EMPLOYED','TRUE');
	insert into  m_income_source (key, label, is_active) values  ('NONE','NONE','TRUE');

	--m_civil_status

	insert into  m_civil_status (key, label, is_active) values  ('VETERAN','VETERAN','TRUE');
	insert into  m_civil_status (key, label, is_active) values  ('NON-VETERAN/NON-GOVT OFFICIAL','NON-VETERAN/NON-GOVT OFFICIAL','TRUE');
	insert into  m_civil_status (key, label, is_active) values  ('GOVT OFFICIAL','GOVT OFFICIAL','TRUE');

	-- m_sim_type

	insert into  m_sim_type (key, label, is_active) values  ('PREPAID','PREPAID','TRUE');
	insert into  m_sim_type (key, label, is_active) values  ('POSTPAID','POSTPAID','TRUE');

	--m_office_locality

	insert into  m_office_locality (key, label, is_active) values  ('COMMERCIAL COMPLEX','COMMERCIAL COMPLEX','TRUE');
	insert into  m_office_locality (key, label, is_active) values  ('RESIDENTIAL','RESIDENTIAL','TRUE');
	insert into  m_office_locality (key, label, is_active) values  ('BUSINESS CENTER','BUSINESS CENTER','TRUE');
	insert into  m_office_locality (key, label, is_active) values  ('INDUSTRY/FACTORY','INDUSTRY/FACTORY','TRUE');
	insert into  m_office_locality (key, label, is_active) values  ('SHOP/OFFICE COMPLEX','SHOP/OFFICE COMPLEX','TRUE');
	insert into  m_office_locality (key, label, is_active) values  ('OTHERS','OTHERS','TRUE');

	--m_office_construction

	insert into  m_office_construction (key, label, is_active) values  ('CONCRETE','CONCRETE','TRUE');
	insert into  m_office_construction (key, label, is_active) values  ('SEMI-CONCRETE','SEMI-CONCRETE','TRUE');
	insert into  m_office_construction (key, label, is_active) values  ('PAINTED','PAINTED','TRUE');
	insert into  m_office_construction (key, label, is_active) values  ('FENCE','FENCE','TRUE');

	--m_office_exterior

	insert into  m_office_exterior (key, label, is_active) values  ('VERY GOOD','VERY GOOD','TRUE');
	insert into  m_office_exterior (key, label, is_active) values  ('GOOD','GOOD','TRUE');
	insert into  m_office_exterior (key, label, is_active) values  ('FAIR','FAIR','TRUE');
	insert into  m_office_exterior (key, label, is_active) values  ('POOR','POOR','TRUE');

	--m_office_interior
	insert into  m_office_interior (key, label, is_active) values  ('VERY GOOD','VERY GOOD','TRUE');
	insert into  m_office_interior (key, label, is_active) values  ('GOOD','GOOD','TRUE');
	insert into  m_office_interior (key, label, is_active) values  ('FAIR','FAIR','TRUE');
	insert into  m_office_interior (key, label, is_active) values  ('POOR','POOR','TRUE');

	--m_no_of_storey
	insert into  m_no_of_storey (key, label, is_active) values  ('SINGLE STOREY','SINGLE STOREY','TRUE');
	insert into  m_no_of_storey (key, label, is_active) values  ('TWO STOREY','TWO STOREY','TRUE');
	insert into  m_no_of_storey (key, label, is_active) values  ('MULTI-STOREY','MULTI-STOREY','TRUE');


	insert into  m_ease_of_officelocation (key, label, is_active) values  ('EASY','EASY','TRUE');
	insert into  m_ease_of_officelocation (key, label, is_active) values  ('DIFFICULT','DIFFICULT','TRUE');
	insert into  m_ease_of_officelocation (key, label, is_active) values  ('UNTRACEABLE','UNTRACEABLE','TRUE');

	--m_items_sighted_in_office
	insert into  m_items_sighted_in_office (key, label, is_active) values  ('SOFA','SOFA','TRUE');
	insert into  m_items_sighted_in_office (key, label, is_active) values  ('TV','TV','TRUE');
	insert into  m_items_sighted_in_office (key, label, is_active) values  ('PRINTING MACHINE','PRINTING MACHINE','TRUE');
	insert into  m_items_sighted_in_office (key, label, is_active) values  ('AC','AC','TRUE');
	insert into  m_items_sighted_in_office (key, label, is_active) values  ('LAPTOPS','LAPTOPS','TRUE');
	insert into  m_items_sighted_in_office (key, label, is_active) values  ('LED PROJECTOR','LED PROJECTOR','TRUE');

	--m_employment_type
	insert into  m_employment_type (key, label, is_active) values  ('PERMANENT','PERMANENT','TRUE');
	insert into  m_employment_type (key, label, is_active) values  ('CONTRACT','CONTRACT','TRUE');
	insert into  m_employment_type (key, label, is_active) values  ('FREELANCE','FREELANCE','TRUE');
	insert into  m_employment_type (key, label, is_active) values  ('PART TIME','PART TIME','TRUE');

	--m_designation
	insert into  m_designation (key, label, is_active) values  ('ASSISTANT','ASSISTANT','TRUE');
	insert into  m_designation (key, label, is_active) values  ('CLERK','CLERK','TRUE');
	insert into  m_designation (key, label, is_active) values  ('SUPERVISOR','SUPERVISOR','TRUE');
	insert into  m_designation (key, label, is_active) values  ('SKILLED LABOUR','SKILLED LABOUR','TRUE');
	insert into  m_designation (key, label, is_active) values  ('TYPIST','TYPIST','TRUE');
	insert into  m_designation (key, label, is_active) values  ('SR/MID MANAGEMENT','SR/MID MANAGEMENT','TRUE');
	insert into  m_designation (key, label, is_active) values  ('JR MANAGEMENT','JR MANAGEMENT','TRUE');
	insert into  m_designation (key, label, is_active) values  ('OTHERS','OTHERS','TRUE');

	--m_company_type
	insert into  m_company_type (key, label, is_active) values  ('PRIVATE','PRIVATE','TRUE');
	insert into  m_company_type (key, label, is_active) values  ('PUBLIC','PUBLIC','TRUE');

	--m_job_domain
	insert into  m_job_domain (key, label, is_active) values  ('IT','IT','TRUE');
	insert into  m_job_domain (key, label, is_active) values  ('NON-IT','NON-IT','TRUE');

	insert into  m_nature_of_business (key, label, is_active) values  ('PROFESSIONAL','PROFESSIONAL','TRUE');
	insert into  m_nature_of_business (key, label, is_active) values  ('MANUFACTURER','MANUFACTURER','TRUE');
	insert into  m_nature_of_business (key, label, is_active) values  ('TRADE/SHOPKEEPER','TRADE/SHOPKEEPER','TRUE');
	insert into  m_nature_of_business (key, label, is_active) values  ('SERVICE PROVIDER (LIC AGENT, BROKER, COMMISSION AGENT, OTHERS)','SERVICE PROVIDER (LIC AGENT, BROKER, COMMISSION AGENT, OTHERS)','TRUE');

	--m_insurance_type
	insert into  m_insurance_type (key, label, is_active) values  ('LIFE','LIFE','TRUE');
	insert into  m_insurance_type (key, label, is_active) values  ('CAR','CAR','TRUE');
	insert into  m_insurance_type (key, label, is_active) values  ('HEALTH','HEALTH','TRUE');
	insert into  m_insurance_type (key, label, is_active) values  ('TWO-WHEELER','TWO-WHEELER','TRUE');
	insert into  m_insurance_type (key, label, is_active) values  ('HOME','HOME','TRUE');
	insert into  m_insurance_type (key, label, is_active) values  ('TERM','TERM','TRUE');

	--m_other_exp
	insert into  m_other_exp (key, label, is_active) values  ('OFFICE TRANSPORTATION COST','OFFICE TRANSPORTATION COST','TRUE');
	insert into  m_other_exp (key, label, is_active) values  ('SCHOOL FEES','SCHOOL FEES','TRUE');
	insert into  m_other_exp (key, label, is_active) values  ('COLLEGE FEES','COLLEGE FEES','TRUE');
	insert into  m_other_exp (key, label, is_active) values  ('OTHERS','OTHERS','TRUE');

	--m_child_educational_level
	insert into  m_child_educational_level (key, label, is_active) values  ('HIGH SCHOOL','HIGH SCHOOL','TRUE');
	insert into  m_child_educational_level (key, label, is_active) values  ('COLLEGE','COLLEGE','TRUE');
	insert into  m_child_educational_level (key, label, is_active) values  ('POST GRADUATE','POST GRADUATE','TRUE');
	insert into  m_child_educational_level (key, label, is_active) values  ('OTHERS','OTHERS','TRUE');

	--m_spouse_occupation
	insert into  m_spouse_occupation (key, label, is_active) values  ('EMPLOYMENT','EMPLOYMENT','TRUE');
	insert into  m_spouse_occupation (key, label, is_active) values  ('BUSINESS/SELF_EMPLOYED','BUSINESS/SELF_EMPLOYED','TRUE');
	insert into  m_spouse_occupation (key, label, is_active) values  ('NONE','NONE','TRUE');

	--m_residence_category
	insert into  m_residence_category (key, label, is_active) values  ('RENTED','RENTED','TRUE');
	insert into  m_residence_category (key, label, is_active) values  ('OWNED','OWNED','TRUE');

	--m_ownership_type
	insert into  m_ownership_type (key, label, is_active) values  ('OWNERSHIP','OWNERSHIP','TRUE');
	insert into  m_ownership_type (key, label, is_active) values  ('TENANCY','TENANCY','TRUE');

	--m_residence_type
	insert into  m_residence_type (key, label, is_active) values  ('BUNGALOW','BUNGALOW','TRUE');
	insert into  m_residence_type (key, label, is_active) values  ('DUPLEIX','DUPLEIX','TRUE');
	insert into  m_residence_type (key, label, is_active) values  ('APARTMENT','APARTMENT','TRUE');
	insert into  m_residence_type (key, label, is_active) values  ('RAW-HOUSE','RAW-HOUSE','TRUE');
	insert into  m_residence_type (key, label, is_active) values  ('MANSION','MANSION','TRUE');

	--m_no_of_storey
	insert into  m_no_of_storey (key, label, is_active) values  ('SINGLE STOREY','SINGLE STOREY','TRUE');
	insert into  m_no_of_storey (key, label, is_active) values  ('TWO STOREY','TWO STOREY','TRUE');
	insert into  m_no_of_storey (key, label, is_active) values  ('MULTI-STOREY','MULTI-STOREY','TRUE');

	--m_classification
	insert into  m_classification (key, label, is_active) values  ('LOW COST','LOW COST','TRUE');
	insert into  m_classification (key, label, is_active) values  ('MEDIUM COST','MEDIUM COST','TRUE');
	insert into  m_classification (key, label, is_active) values  ('HIGH COST','HIGH COST','TRUE');
	insert into  m_classification (key, label, is_active) values  ('ELEGANT','ELEGANT','TRUE');
	insert into  m_classification (key, label, is_active) values  ('GOVT. HOUSE','GOVT. HOUSE','TRUE');

	--m_house_condition
	insert into  m_house_condition (key, label, is_active) values  ('NEW','NEW','TRUE');
	insert into  m_house_condition (key, label, is_active) values  ('WELL-MAINTAINED','WELL-MAINTAINED','TRUE');
	insert into  m_house_condition (key, label, is_active) values  ('FAIRLY-MAINTAINED','FAIRLY-MAINTAINED','TRUE');
	insert into  m_house_condition (key, label, is_active) values  ('OLD','OLD','TRUE');
	insert into  m_house_condition (key, label, is_active) values  ('DILAPIDATED','DILAPIDATED','TRUE');

	--m_property_age
	insert into  m_property_age (key, label, is_active) values  ('<1 YR','<1 YR','TRUE');
	insert into  m_property_age (key, label, is_active) values  ('1-3 YRS','1-3 YRS','TRUE');
	insert into  m_property_age (key, label, is_active) values  ('4-6 YRS','4-6 YRS','TRUE');
	insert into  m_property_age (key, label, is_active) values  ('7-10 YRS','7-10 YRS','TRUE');
	insert into  m_property_age (key, label, is_active) values  ('10-15 YRS','10-15 YRS','TRUE');
	insert into  m_property_age (key, label, is_active) values  ('>15 YRS','>15 YRS','TRUE');

	--m_property_make_type
	insert into  m_property_make_type (key, label, is_active) values  ('WOODEN','WOODEN','TRUE');
	insert into  m_property_make_type (key, label, is_active) values  ('CONCRETE','CONCRETE','TRUE');
	insert into  m_property_make_type (key, label, is_active) values  ('SEMI-CONCRETE','SEMI-CONCRETE','TRUE');
	insert into  m_property_make_type (key, label, is_active) values  ('PAINTED','PAINTED','TRUE');
	insert into  m_property_make_type (key, label, is_active) values  ('FENCE','FENCE','TRUE');

	--m_property_interior
	insert into  m_property_interior (key, label, is_active) values  ('VERY GOOD','VERY GOOD','TRUE');
	insert into  m_property_interior (key, label, is_active) values  ('GOOD','GOOD','TRUE');
	insert into  m_property_interior (key, label, is_active) values  ('FAIR','FAIR','TRUE');
	insert into  m_property_interior (key, label, is_active) values  ('POOR','POOR','TRUE');

	--m_appliances
	insert into  m_appliances (key, label, is_active) values  ('TV','TV','TRUE');
	insert into  m_appliances (key, label, is_active) values  ('DVD','DVD','TRUE');
	insert into  m_appliances (key, label, is_active) values  ('STEREO','STEREO','TRUE');
	insert into  m_appliances (key, label, is_active) values  ('AC','AC','TRUE');
	insert into  m_appliances (key, label, is_active) values  ('FRIDGE','FRIDGE','TRUE');
	insert into  m_appliances (key, label, is_active) values  ('WASHING MACHINE','WASHING MACHINE','TRUE');
	insert into  m_appliances (key, label, is_active) values  ('COMPUTER','COMPUTER','TRUE');
	insert into  m_appliances (key, label, is_active) values  ('SOFA SET','SOFA SET','TRUE');
	insert into  m_appliances (key, label, is_active) values  ('DINNER SET','DINNER SET','TRUE');
	insert into  m_appliances (key, label, is_active) values  ('NOT SEEN','NOT SEEN','TRUE');

	--m_commute_options
	insert into  m_commute_options (key, label, is_active) values  ('BUS','BUS','TRUE');
	insert into  m_commute_options (key, label, is_active) values  ('JEEPNEYS','JEEPNEYS','TRUE');
	insert into  m_commute_options (key, label, is_active) values  ('TRICYCLE ONLY','TRICYCLE ONLY','TRUE');
	insert into  m_commute_options (key, label, is_active) values  ('PRIVATE VEHICLE','PRIVATE VEHICLE','TRUE');
	insert into  m_commute_options (key, label, is_active) values  ('RAILWAYS','RAILWAYS','TRUE');
	insert into  m_commute_options (key, label, is_active) values  ('OTHERS','OTHERS','TRUE');
	insert into  m_commute_options (key, label, is_active) values  ('NOT ACCESSIBLE','NOT ACCESSIBLE','TRUE');

	--m_neighbourhood_type
	insert into  m_neighbourhood_type (key, label, is_active) values  ('RESIDENTIAL','RESIDENTIAL','TRUE');
	insert into  m_neighbourhood_type (key, label, is_active) values  ('COMMERCIAL','COMMERCIAL','TRUE');
	insert into  m_neighbourhood_type (key, label, is_active) values  ('INDUSTRIAL','INDUSTRIAL','TRUE');
	insert into  m_neighbourhood_type (key, label, is_active) values  ('AGRICULTURAL','AGRICULTURAL','TRUE');
	insert into  m_neighbourhood_type (key, label, is_active) values  ('SUBDIVIVISION','SUBDIVIVISION','TRUE');
	insert into  m_neighbourhood_type (key, label, is_active) values  ('GOVT PROJECT','GOVT PROJECT','TRUE');
	insert into  m_neighbourhood_type (key, label, is_active) values  ('PRIVATE','PRIVATE','TRUE');
	insert into  m_neighbourhood_type (key, label, is_active) values  ('PUBLIC','PUBLIC','TRUE');

	--m_residency
	insert into  m_residency (key, label, is_active) values  ('VERIFIED','VERIFIED','TRUE');
	insert into  m_residency (key, label, is_active) values  ('NOT VERIFIED','NOT VERIFIED','TRUE');
	insert into  m_residency (key, label, is_active) values  ('ALLEGED RESIDENT','ALLEGED RESIDENT','TRUE');
	insert into  m_residency (key, label, is_active) values  ('NOT A RESIDENT','NOT A RESIDENT','TRUE');

	--m_address_proof_id
	insert into  m_address_proof_id (key, label, is_active) values  ('AADHAR CARD','AADHAR CARD','TRUE');
	insert into  m_address_proof_id (key, label, is_active) values  ('VOTER ID CARD','VOTER ID CARD','TRUE');

	--m_vehicle_type
	insert into  m_vehicle_type (key, label, is_active) values  ('TWO-WHEELER','TWO-WHEELER','TRUE');
	insert into  m_vehicle_type (key, label, is_active) values  ('THREE-WHEELER','THREE-WHEELER','TRUE');
	insert into  m_vehicle_type (key, label, is_active) values  ('FOUR-WHEELER','FOUR-WHEELER','TRUE');

	--m_car_ownership_type
	insert into  m_car_ownership_type (key, label, is_active) values  ('PERSONAL-OWNED','PERSONAL-OWNED','TRUE');
	insert into  m_car_ownership_type (key, label, is_active) values  ('PERSONAL-MORTGAGED','PERSONAL-MORTGAGED','TRUE');
	insert into  m_car_ownership_type (key, label, is_active) values  ('COMPANY PROVIDED','COMPANY PROVIDED','TRUE');
	insert into  m_car_ownership_type (key, label, is_active) values  ('NONE','NONE','TRUE');

	--m_bike_ownership_type
	insert into  m_bike_ownership_type (key, label, is_active) values  ('PERSONAL-OWNED','PERSONAL-OWNED','TRUE');
	insert into  m_bike_ownership_type (key, label, is_active) values  ('PERSONAL-MORTGAGED','PERSONAL-MORTGAGED','TRUE');
	insert into  m_bike_ownership_type (key, label, is_active) values  ('COMPANY PROVIDED','COMPANY PROVIDED','TRUE');
	insert into  m_bike_ownership_type (key, label, is_active) values  ('NONE','NONE','TRUE');

	--m_car_fuel_type
	insert into  m_car_fuel_type (key, label, is_active) values  ('PETROL','PETROL','TRUE');
	insert into  m_car_fuel_type (key, label, is_active) values  ('DIESEL','DIESEL','TRUE');
	insert into  m_car_fuel_type (key, label, is_active) values  ('CNG','CNG','TRUE');

	--m_other_findings
	insert into  m_other_findings (key, label, is_active) values  ('UNREACHABLE ADDRESS','UNREACHABLE ADDRESS','TRUE');
	insert into  m_other_findings (key, label, is_active) values  ('POLITICIAN/HIGHER GOVT OFFICIAL','POLITICIAN/HIGHER GOVT OFFICIAL','TRUE');
	insert into  m_other_findings (key, label, is_active) values  ('OTHERS','OTHERS','TRUE');



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