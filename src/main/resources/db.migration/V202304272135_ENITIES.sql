
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
     --DDL Statement for table - agencies

    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('agencies')) loop
    execute 'create table ' ||v_schema_name||'.agencies
                (
        key bigint NOT NULL,
        branch_id character varying(255),
        branch_name character varying(255),
        is_active boolean NOT NULL,
        label character varying(255),
        product character varying(255),
        user_type character varying(255)
                    )';

	end loop;

    --DDL Statement for table - applicant_details
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('applicant_details')) loop
    execute 'create table ' ||v_schema_name||'.applicant_details
                (
                    applicant_id bigint NOT NULL,
                    agency_name character varying(255),
                    app_role character varying(255),
                    applicant_name character varying(255),
                    applicant_type character varying(255),
                    assigned_by character varying(255),
                    assigned_to character varying(255),
                    branch_name character varying(255),
                    case_id bigint NOT NULL,
                    id character varying(255),
                    ins_id character varying(255),
                    inspected_by character varying(255),
                    inspected_by_id character varying(255),
                    inspected_date timestamp without time zone,
                    is_agency boolean NOT NULL,
                    loan_amount integer NOT NULL,
                    mobile_number bigint,
                    re_verification boolean NOT NULL,
                    retrigger boolean NOT NULL,
                    role_type character varying(255),
                    status character varying(255),
                    user_status character varying(255),
                    verifier_progress character varying(255),
                    commitments bigint,
                    contact_details bigint,
                    expenses bigint,
                    family_details bigint NOT NULL,
                    employment_details bigint,
                    personal_details bigint,
                    residence_details bigint,
                    summary bigint,
                    vehicle_details bigint,
                    application_details bigint

                )';

	end loop;

    --DDL Statement for table - applicants_address
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('applicants_address')) loop
    execute 'create table ' ||v_schema_name||'.applicants_address
                (
                    address_id bigint NOT NULL,
                        address character varying(255),
                        address_type character varying(255),
                        applicant_id bigint NOT NULL,
                        application_id character varying(255)
                )';

	end loop;

    --DDL Statement for table - application_details
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('application_details')) loop
    execute 'create table ' ||v_schema_name||'.application_details
                (
                 application_id bigint NOT NULL,
                    branch_code character varying(255),
                    branch_name character varying(255),
                    case_id bigint NOT NULL,
                    created_by character varying(255),
                    created_on timestamp without time zone,
                    ins_id character varying(255),
                    modified_by character varying(255),
                    modified_on timestamp without time zone,
                    product_type character varying(255),
                    verification_stage character varying(255),
                    verification_status character varying(255)
                )';

	end loop;

    --DDL Statement for table - application_raw_object
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('application_raw_object')) loop
    execute 'create table ' ||v_schema_name||'.application_raw_object
                (
                id bigint NOT NULL,
                    application_id bigint,
                    case_id character varying(255),
                    created_on timestamp without time zone,
                    raw_data bytea

                )';

	end loop;

    --DDL Statement for table - assignor
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('assignor')) loop
    execute 'create table ' ||v_schema_name||'.assignor
                (
                assigned_id bigint NOT NULL,
                    a_status character varying(255),
                    address character varying(255),
                    address_type character varying(255),
                    applicant_id character varying(255),
                    applicant_name character varying(255),
                    application_id character varying(255),
                    assigned_agency_code character varying(255),
                    assigned_agency_name character varying(255),
                    assigned_branch_code character varying(255),
                    assigned_branch_name character varying(255),
                    assigned_by character varying(255),
                    assigned_date_time character varying(255),
                    assigned_to character varying(255),
                    case_id character varying(255),
                    fi_id character varying(255),
                    ins_id character varying(255),
                    loan_amount bigint,
                    ref_fi_id character varying(255),
                    v_status character varying(255)
                )';

	end loop;

    --DDL Statement for table - commitment_details
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('commitment_details')) loop
    execute 'create table ' ||v_schema_name||'.commitment_details
                (
                    applicant_id bigint NOT NULL,
                    bank_name_loc character varying(255),
                    car_insurance_amt integer NOT NULL,
                    car_insurance_duration integer NOT NULL,
                    customer_id integer NOT NULL,
                    health_insurance_amt integer NOT NULL,
                    health_insurance_duration integer NOT NULL,
                    home_insurance_amt integer NOT NULL,
                    home_insurance_duration integer NOT NULL,
                    insurance_type character varying(255),
                    life_insurance_amt integer NOT NULL,
                    life_insurance_duration integer NOT NULL,
                    loc_amt integer NOT NULL,
                    loc_expiry_date character varying(255),
                    nps_amt integer NOT NULL,
                    nps_applicant_name character varying(255),
                    nps_duration integer NOT NULL,
                    term_insurance_amt integer NOT NULL,
                    term_insurance_duration integer NOT NULL,
                    two_wheeler_insurance_amt integer NOT NULL,
                    two_wheeler_insurance_duration integer NOT NULL
                )';

	end loop;

    --DDL Statement for table - contact_details
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('contact_details')) loop
    execute 'create table ' ||v_schema_name||'.contact_details
                (
                    applicant_id bigint NOT NULL,
                       cont_domain_check boolean NOT NULL,
                       mobile_number character varying(255),
                       mobile_number_verified boolean NOT NULL,
                       personal_email character varying(255),
                       personal_email_verified boolean NOT NULL,
                       phone_number character varying(255),
                       phone_number_verified boolean NOT NULL,
                       registered_with_bank boolean NOT NULL,
                       sim_type character varying(255)
                )';

	end loop;

    --DDL Statement for table - expenses
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('expenses')) loop
    execute 'create table ' ||v_schema_name||'.expenses
                (
                    applicant_id bigint NOT NULL,
                       avg_fuel_cost numeric(19,2),
                       broadband_bill_amt numeric(19,2),
                       cable_net_bill_amt numeric(19,2),
                       college_fees_amt numeric(19,2),
                       electric_bill_amt numeric(19,2),
                       office_transportation_cost numeric(19,2),
                       other_expenses character varying(255),
                       school_fees_amt numeric(19,2),
                       water_bill_amt numeric(19,2)
                )';

	end loop;

    --DDL Statement for table - family_details
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('family_details')) loop
    execute 'create table ' ||v_schema_name||'.family_details
                (
                 applicant_id bigint NOT NULL,
                     child_education_level character varying(255),
                     entity_confirmation_father boolean NOT NULL,
                     entity_confirmation_mother boolean NOT NULL,
                     entity_confirmation_spouse boolean NOT NULL,
                     father_age integer NOT NULL,
                     father_first_name character varying(255),
                     father_last_name character varying(255),
                     father_mid_name character varying(255),
                     father_religion character varying(255),
                     mother_age integer NOT NULL,
                     mother_first_name character varying(255),
                     mother_last_name character varying(255),
                     mother_mid_name character varying(255),
                     mother_religion character varying(255),
                     number_of_dependents integer NOT NULL,
                     number_of_minor integer NOT NULL,
                     spouse_age integer NOT NULL,
                     spouse_alias character varying(255),
                     spouse_birthdate character varying(255),
                     spouse_citizenship character varying(255),
                     spouse_first_name character varying(255),
                     spouse_last_name character varying(255),
                     spouse_mid_name character varying(255),
                     spouse_occupation character varying(255),
                     spouse_religion character varying(255),
                     spouse_suffix character varying(255),
                     spouse_working boolean NOT NULL
                )';

	end loop;

    --DDL Statement for table - fi_files
    for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('fi_files')) loop
    execute 'create table ' ||v_schema_name||'.fi_files
                (
                    id bigint NOT NULL,
                        applicant_id bigint NOT NULL,
                        content_type character varying(255),
                        data bytea,
                        filename character varying(255),
                        latitude character varying(255),
                        longitude character varying(255),
                        "timestamp" timestamp without time zone
                )';

	end loop;

	--DDL Statement for table - h_verification
        for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('h_verification')) loop
        execute 'create table ' ||v_schema_name||'.h_verification
                    (
                        vh_id character varying(255) NOT NULL,
                            a_status character varying(255),
                            accepted_date_time character varying(255),
                            address_type character varying(255),
                            applicant_address character varying(255),
                            applicant_id character varying(255),
                            applicant_name character varying(255),
                            applicant_type character varying(255),
                            application_id character varying(255),
                            assigned_by character varying(255),
                            assigned_date_time character varying(255),
                            assigned_to character varying(255),
                            case_id character varying(255),
                            com_key character varying(255),
                            fi_id character varying(255),
                            final_feedback character varying(255),
                            ins_id bigint NOT NULL,
                            loan_amount bigint NOT NULL,
                            mobile_number character varying(255),
                            pincode character varying(255),
                            ref_id character varying(255),
                            rejected_date_time character varying(255),
                            rejected_reason character varying(255),
                            update_date_time character varying(255),
                            v_mode character varying(255),
                            v_queries character varying(255),
                            v_query_date character varying(255),
                            v_reply_message character varying(255),
                            v_reply_message_date character varying(255),
                            verification_stage character varying(255),
                            verification_status character varying(255),
                            verifier_status character varying(255)
                    )';

    	end loop;
    	--DDL Statement for table - h_verifiers
            for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('h_verifiers')) loop
            execute 'create table ' ||v_schema_name||'.h_verifiers
                        (
                            verifier_history_id bigint NOT NULL,
                                res_negative_location boolean NOT NULL,
                                res_score numeric(19,2),
                                address_line1 character varying(255),
                                address_line2 character varying(255),
                                address_line3 character varying(255),
                                address_line4 character varying(255),
                                address_proof_id character varying(255),
                                address_type character varying(255),
                                age integer NOT NULL,
                                agency_name character varying(255),
                                alias character varying(255),
                                appliances character varying(255),
                                appliances_total_value numeric(19,2),
                                applicant_id character varying(255),
                                applicant_type character varying(255),
                                application_id character varying(255),
                                avg_fuel_cost numeric(19,2),
                                avg_monthly_turn_over integer,
                                bank_name_loc character varying(255),
                                birth_date character varying(255),
                                broadband_bill_amt numeric(19,2),
                                business_activity_sighted character varying(255),
                                business_board_sighted boolean NOT NULL,
                                cable_net_bill_amt numeric(19,2),
                                car_insurance_amt integer NOT NULL,
                                car_insurance_duration integer NOT NULL,
                                case_id character varying(255),
                                child_education_level character varying(255),
                                citizenship character varying(255),
                                city character varying(255),
                                civil_status character varying(255),
                                classification character varying(255),
                                college_fees_amt numeric(19,2),
                                com_key character varying(255),
                                community_dominated boolean NOT NULL,
                                commute_options character varying(255),
                                company_type character varying(255),
                                cont_domain_check boolean NOT NULL,
                                country character varying(255),
                                country_code bigint,
                                customer_id integer NOT NULL,
                                date_and_time_performed timestamp without time zone,
                                date_inspected character varying(255),
                                date_time_endorsed character varying(255),
                                designation character varying(255),
                                distance_from_address_to_actual_loaction bigint,
                                ease_of_office_location character varying(255),
                                education_level character varying(255),
                                electric_bill_amt numeric(19,2),
                                employee_code character varying(255),
                                employment_type character varying(255),
                                entity_confirmation_father boolean NOT NULL,
                                entity_confirmation_mother boolean NOT NULL,
                                entity_confirmation_spouse boolean NOT NULL,
                                entry_allowed_in_office boolean NOT NULL,
                                extension_no integer,
                                father_age integer NOT NULL,
                                father_first_name character varying(255),
                                father_last_name character varying(255),
                                father_mid_name character varying(255),
                                father_religion character varying(255),
                                fi_id character varying(255),
                                final_review_status character varying(255),
                                final_score integer,
                                first_name character varying(255),
                                health_insurance_amt integer NOT NULL,
                                health_insurance_duration integer NOT NULL,
                                home_insurance_amt integer NOT NULL,
                                home_insurance_duration integer NOT NULL,
                                house_condition character varying(255),
                                income numeric(19,2),
                                income_period numeric(19,2),
                                income_source character varying(255),
                                ins_id bigint NOT NULL,
                                insurance_type character varying(255),
                                items_sighted_in_office character varying(255),
                                job_domain character varying(255),
                                landline_num bigint,
                                last_name character varying(255),
                                last_month_salary integer,
                                lattitue bigint,
                                life_insurance_amt integer NOT NULL,
                                life_insurance_duration integer NOT NULL,
                                livingwith character varying(255),
                                loan_taken_earlier boolean NOT NULL,
                                loc_amt integer NOT NULL,
                                loc_expiry_date character varying(255),
                                longitude bigint,
                                mail_delivery_status boolean NOT NULL,
                                martial_status character varying(255),
                                metro_location boolean NOT NULL,
                                middle_name character varying(255),
                                mobile_number character varying(255),
                                mobile_number_verified boolean NOT NULL,
                                monthly_amortization numeric(19,2),
                                months_of_stay bigint,
                                mortagagor_name character varying(255),
                                mother_age integer NOT NULL,
                                mother_first_name character varying(255),
                                mother_last_name character varying(255),
                                mother_mid_name character varying(255),
                                mother_religion character varying(255),
                                name_plate_visible boolean NOT NULL,
                                nature_of_business character varying(255),
                                neighbourhood_type character varying(255),
                                no_of_emplyees integer,
                                nps_amt integer NOT NULL,
                                nps_applicant_name character varying(255),
                                nps_duration integer NOT NULL,
                                number_of_dependents integer NOT NULL,
                                number_of_minor integer NOT NULL,
                                off_domain_check boolean NOT NULL,
                                offc_negative_location boolean NOT NULL,
                                offc_no_of_storey character varying(255),
                                office_address_city character varying(255),
                                office_address_country character varying(255),
                                office_address_line1 character varying(255),
                                office_address_line2 character varying(255),
                                office_address_line3 character varying(255),
                                office_address_line4 character varying(255),
                                office_address_pincode character varying(255),
                                office_area integer,
                                office_city_code character varying(255),
                                office_construction character varying(255),
                                office_email character varying(255),
                                office_email_verified boolean NOT NULL,
                                office_exterior character varying(255),
                                office_interior character varying(255),
                                office_locality character varying(255),
                                office_name character varying(255),
                                office_telephone_no bigint,
                                office_transportation_cost numeric(19,2),
                                office_address_state character varying(255),
                                other_expenses character varying(255),
                                other_findings integer,
                                out_of_geo_limit boolean NOT NULL,
                                owned_by character varying(255),
                                ownership_type character varying(255),
                                pers_met character varying(255),
                                pers_ref_id integer NOT NULL,
                                personal_email character varying(255),
                                personal_email_verified boolean NOT NULL,
                                phone_number character varying(255),
                                phone_number_verified boolean NOT NULL,
                                pincode character varying(255),
                                politically_exposed boolean NOT NULL,
                                prefix character varying(255),
                                prepared_by character varying(255),
                                property_age character varying(255),
                                property_interior character varying(255),
                                property_make_type character varying(255),
                                ref_id character varying(255),
                                registered_with_bank boolean NOT NULL,
                                religion character varying(255),
                                remark character varying(255),
                                remark_date_time timestamp without time zone,
                                rent_per_month bigint,
                                rented_from timestamp without time zone,
                                res_no_of_storey character varying(255),
                                residence_category character varying(255),
                                residence_landmark character varying(255),
                                residence_type character varying(255),
                                residency character varying(255),
                                reviewed_by character varying(255),
                                school_fees_amt numeric(19,2),
                                sim_type character varying(255),
                                spouse_age integer NOT NULL,
                                spouse_alias character varying(255),
                                spouse_birthdate character varying(255),
                                spouse_citizenship character varying(255),
                                spouse_first_name character varying(255),
                                spouse_last_name character varying(255),
                                spouse_mid_name character varying(255),
                                spouse_occupation character varying(255),
                                spouse_religion character varying(255),
                                spouse_suffix character varying(255),
                                spouse_working boolean NOT NULL,
                                state character varying(255),
                                suffix character varying(255),
                                sum_ref_id integer,
                                sum_score integer,
                                term_insurance_amt integer NOT NULL,
                                term_insurance_duration integer NOT NULL,
                                two_wheeler_insurance_amt integer NOT NULL,
                                two_wheeler_insurance_duration integer NOT NULL,
                                v_mode character varying(255),
                                v_status character varying(255),
                                water_bill_amt numeric(19,2),
                                years_of_stay bigint
                        )';

        	end loop;



	--DDL Statement for table - m_branches
        for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('m_branches')) loop
        execute 'create table ' ||v_schema_name||'.m_branches
                    (

                 key bigint NOT NULL,
                     country character varying(255),
                     is_active boolean,
                     label character varying(255),
                     latitude character varying(255),
                     location character varying(255),
                     longitude character varying(255),
                     pincode character varying(255),
                     region character varying(255),
                     zone character varying(255)

                    )';

    	end loop;
    	--DDL Statement for table - notification
                for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('notification')) loop
                execute 'create table ' ||v_schema_name||'.notification
                            (

                             notification_id bigint NOT NULL,
                               notification_payload character varying(255),
                               "timestamp" timestamp without time zone,
                               username character varying(255)
                            )';

            	end loop;

               --DDL Statement for table - office_self_employment
                       for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('office_self_employment')) loop
                       execute 'create table ' ||v_schema_name||'.office_self_employment
                                   (

                                   applicant_id bigint NOT NULL,
                                     avg_monthly_turn_over integer,
                                     business_activity_sighted character varying(255),
                                     business_board_sighted boolean NOT NULL,
                                     company_type character varying(255),
                                     designation character varying(255),
                                     ease_of_office_location character varying(255),
                                     employee_code character varying(255),
                                     employment_type character varying(255),
                                     entry_allowed_in_office boolean NOT NULL,
                                     extension_no integer,
                                     items_sighted_in_office character varying(255),
                                     job_domain character varying(255),
                                     last_month_salary integer,
                                     metro_location boolean NOT NULL,
                                     nature_of_business character varying(255),
                                     no_of_emplyees integer,
                                     off_domain_check boolean NOT NULL,
                                     offc_negative_location boolean NOT NULL,
                                     offc_no_of_storey character varying(255),
                                     office_address_city character varying(255),
                                     office_address_country character varying(255),
                                     office_address_line1 character varying(255),
                                     office_address_line2 character varying(255),
                                     office_address_line3 character varying(255),
                                     office_address_line4 character varying(255),
                                     office_address_pincode character varying(255),
                                     office_area integer,
                                     office_city_code character varying(255),
                                     office_construction character varying(255),
                                     office_email character varying(255),
                                     office_email_verified boolean NOT NULL,
                                     office_exterior character varying(255),
                                     office_interior character varying(255),
                                     office_locality character varying(255),
                                     office_name character varying(255),
                                     office_telephone_no bigint,
                                     office_address_state character varying(255),
                                     out_of_geo_limit boolean NOT NULL
                                   )';

                   	end loop;

--DDL Statement for table - personal_details
        for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('personal_details')) loop
        execute 'create table ' ||v_schema_name||'.personal_details
                    (

                applicant_id bigint NOT NULL,
                    age integer NOT NULL,
                    alias character varying(255),
                    birth_date character varying(255),
                    citizenship character varying(255),
                    civil_status character varying(255),
                    date_inspected character varying(255),
                    date_time_endorsed character varying(255),
                    education_level character varying(255),
                    first_name character varying(255),
                    income numeric(19,2),
                    income_period numeric(19,2),
                    income_source character varying(255),
                    last_name character varying(255),
                    loan_taken_earlier boolean NOT NULL,
                    martial_status character varying(255),
                    middle_name character varying(255),
                    pers_ref_id integer NOT NULL,
                    politically_exposed boolean NOT NULL,
                    prefix character varying(255),
                    religion character varying(255),
                    suffix character varying(255)

                    )';

    	end loop;

    	--DDL Statement for table - residence_details
                for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('residence_details')) loop
                execute 'create table ' ||v_schema_name||'.residence_details
                            (

                            applicant_id bigint NOT NULL,
                              res_negative_location boolean NOT NULL,
                              res_score numeric(19,2),
                              address_line1 character varying(255),
                              address_line2 character varying(255),
                              address_line3 character varying(255),
                              address_line4 character varying(255),
                              address_proof_id character varying(255),
                              appliances character varying(255),
                              appliances_total_value numeric(19,2),
                              city character varying(255),
                              classification character varying(255),
                              community_dominated boolean NOT NULL,
                              commute_options character varying(255),
                              country character varying(255),
                              country_code bigint,
                              distance_from_address_to_actual_loaction bigint,
                              house_condition character varying(255),
                              landline_num bigint,
                              lattitue bigint,
                              livingwith character varying(255),
                              longitude bigint,
                              mail_delivery_status boolean NOT NULL,
                              monthly_amortization numeric(19,2),
                              months_of_stay bigint,
                              mortagagor_name character varying(255),
                              name_plate_visible boolean NOT NULL,
                              neighbourhood_type character varying(255),
                              owned_by character varying(255),
                              ownership_type character varying(255),
                              pers_met character varying(255),
                              pincode character varying(255),
                              property_age character varying(255),
                              property_interior character varying(255),
                              property_make_type character varying(255),
                              rent_per_month bigint,
                              rented_from timestamp without time zone,
                              res_no_of_storey character varying(255),
                              residence_category character varying(255),
                              residence_landmark character varying(255),
                              residence_type character varying(255),
                              residency character varying(255),
                              state character varying(255),
                              years_of_stay bigint

                            )';

            	end loop;

--DDL Statement for table - summary
        for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('summary')) loop
        execute 'create table ' ||v_schema_name||'.summary
                    (

                     applicant_id bigint NOT NULL,
                     agency_name character varying(255),
                     date_and_time_performed timestamp without time zone,
                     final_review_status character varying(255),
                     final_score integer,
                     other_findings integer,
                     prepared_by character varying(255),
                     remark character varying(255),
                     remark_date_time timestamp without time zone,
                     reviewed_by character varying(255),
                     sum_ref_id integer,
                     sum_score integer

                    )';

    	end loop;
--DDL Statement for table - user_role_details
        for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('user_role_details')) loop
        execute 'create table ' ||v_schema_name||'.user_role_details
                    (

                   id bigint NOT NULL,
                      institute_id bigint NOT NULL,
                      mail_id character varying(255),
                      mobile bigint NOT NULL,
                      role character varying(255),
                      username character varying(255)
                    )';

    	end loop;

    	--DDL Statement for table - vehicle_details
                for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('vehicle_details')) loop
                execute 'create table ' ||v_schema_name||'.vehicle_details
                            (

                           applicant_id bigint NOT NULL,
                               bike_hypothecated_to character varying(255),
                               bike_issuing_authority character varying(255),
                               bike_manufacture_name character varying(255),
                               bike_ownership_type character varying(255),
                               bike_registration_number integer,
                               car_fuel_type character varying(255),
                               car_hypothecated_to character varying(255),
                               car_issuing_authority character varying(255),
                               car_manufacture_name character varying(255),
                               car_model character varying(255),
                               car_ownership_type character varying(255),
                               car_registration_number integer,
                               car_seating_capacity integer,
                               financed_from_date_bike character varying(255),
                               financed_from_date_car character varying(255),
                               manufacture_year_car integer,
                               manufacture_year_two_wheeler integer,
                               number_of_vehicles_owned integer,
                               two_wheeler_model character varying(255),
                               vehicle_type character varying(255),
                               with_parking_space boolean

                            )';

            	end loop;

--DDL Statement for table - verification
        for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('verification')) loop
        execute 'create table ' ||v_schema_name||'.verification
                    (

                   fi_id character varying(255) NOT NULL,
                       a_reply_message character varying(255),
                       a_reply_message_date character varying(255),
                       a_status character varying(255),
                       accepted_date_time character varying(255),
                       address_type character varying(255),
                       agency_code character varying(255),
                       agency_name character varying(255),
                       applicant_address character varying(255),
                       applicant_id bigint,
                       applicant_name character varying(255),
                       applicant_pincode character varying(255),
                       applicant_type character varying(255),
                       application_id character varying(255),
                       approved_date character varying(255),
                       assigned_by character varying(255),
                       assigned_date_time character varying(255),
                       assigned_to character varying(255),
                       case_id character varying(255),
                       com_key character varying(255),
                       declined_date character varying(255),
                       declined_reason character varying(255),
                       final_feedback character varying(255),
                       ins_id character varying(255),
                       loan_amount bigint NOT NULL,
                       mobile_number character varying(255),
                       ref_fi_id character varying(255),
                       rejected_date_time character varying(255),
                       rejected_reason character varying(255),
                       remarks character varying(255),
                       v_mode character varying(255),
                       v_queries character varying(255),
                       v_query_date character varying(255),
                       v_status character varying(255),
                       verification_stage character varying(255),
                       verification_status character varying(255)
                    )';

    	end loop;

--DDL Statement for table - verifiers
        for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('verifiers')) loop
        execute 'create table ' ||v_schema_name||'.verifiers
                    (
fi_id character varying(255) NOT NULL,
    res_negative_location boolean NOT NULL,
    res_score numeric(19,2),
    a_status character varying(255),
    address_line1 character varying(255),
    address_line2 character varying(255),
    address_line3 character varying(255),
    address_line4 character varying(255),
    address_proof_id character varying(255),
    address_type character varying(255),
    age integer NOT NULL,
    agency_name character varying(255),
    alias character varying(255),
    appliances character varying(255),
    appliances_total_value numeric(19,2),
    applicant_id character varying(255),
    applicant_type character varying(255),
    application_id character varying(255),
    avg_fuel_cost numeric(19,2),
    avg_monthly_turn_over integer,
    bank_name_loc character varying(255),
    birth_date character varying(255),
    broadband_bill_amt numeric(19,2),
    business_activity_sighted character varying(255),
    business_board_sighted boolean NOT NULL,
    cable_net_bill_amt numeric(19,2),
    car_insurance_amt integer NOT NULL,
    car_insurance_duration integer NOT NULL,
    case_id character varying(255),
    child_education_level character varying(255),
    citizenship character varying(255),
    city character varying(255),
    civil_status character varying(255),
    classification character varying(255),
    college_fees_amt numeric(19,2),
    com_key character varying(255),
    community_dominated boolean NOT NULL,
    commute_options character varying(255),
    company_type character varying(255),
    cont_domain_check boolean NOT NULL,
    country character varying(255),
    country_code bigint,
    customer_id integer NOT NULL,
    date_and_time_performed timestamp without time zone,
    date_inspected character varying(255),
    date_time_endorsed character varying(255),
    designation character varying(255),
    distance_from_address_to_actual_loaction bigint,
    ease_of_office_location character varying(255),
    education_level character varying(255),
    electric_bill_amt numeric(19,2),
    employee_code character varying(255),
    employment_type character varying(255),
    entity_confirmation_father boolean NOT NULL,
    entity_confirmation_mother boolean NOT NULL,
    entity_confirmation_spouse boolean NOT NULL,
    entry_allowed_in_office boolean NOT NULL,
    extension_no integer,
    father_age integer NOT NULL,
    father_first_name character varying(255),
    father_last_name character varying(255),
    father_mid_name character varying(255),
    father_religion character varying(255),
    final_review_status character varying(255),
    final_score integer,
    first_name character varying(255),
    health_insurance_amt integer NOT NULL,
    health_insurance_duration integer NOT NULL,
    home_insurance_amt integer NOT NULL,
    home_insurance_duration integer NOT NULL,
    house_condition character varying(255),
    income numeric(19,2),
    income_period numeric(19,2),
    income_source character varying(255),
    ins_id character varying(255),
    insurance_type character varying(255),
    is_active boolean NOT NULL,
    items_sighted_in_office character varying(255),
    job_domain character varying(255),
    landline_num bigint,
    last_name character varying(255),
    last_month_salary integer,
    lattitue bigint,
    life_insurance_amt integer NOT NULL,
    life_insurance_duration integer NOT NULL,
    livingwith character varying(255),
    loan_taken_earlier boolean NOT NULL,
    loc_amt integer NOT NULL,
    loc_expiry_date character varying(255),
    longitude bigint,
    mail_delivery_status boolean NOT NULL,
    martial_status character varying(255),
    metro_location boolean NOT NULL,
    middle_name character varying(255),
    mobile_number character varying(255),
    mobile_number_verified boolean NOT NULL,
    monthly_amortization numeric(19,2),
    months_of_stay bigint,
    mortagagor_name character varying(255),
    mother_age integer NOT NULL,
    mother_first_name character varying(255),
    mother_last_name character varying(255),
    mother_mid_name character varying(255),
    mother_religion character varying(255),
    name_plate_visible boolean NOT NULL,
    nature_of_business character varying(255),
    neighbourhood_type character varying(255),
    no_of_emplyees integer,
    nps_amt integer NOT NULL,
    nps_applicant_name character varying(255),
    nps_duration integer NOT NULL,
    number_of_dependents integer NOT NULL,
    number_of_minor integer NOT NULL,
    off_domain_check boolean NOT NULL,
    offc_negative_location boolean NOT NULL,
    offc_no_of_storey character varying(255),
    office_address_city character varying(255),
    office_address_country character varying(255),
    office_address_line1 character varying(255),
    office_address_line2 character varying(255),
    office_address_line3 character varying(255),
    office_address_line4 character varying(255),
    office_address_pincode character varying(255),
    office_area integer,
    office_city_code character varying(255),
    office_construction character varying(255),
    office_email character varying(255),
    office_email_verified boolean NOT NULL,
    office_exterior character varying(255),
    office_interior character varying(255),
    office_locality character varying(255),
    office_name character varying(255),
    office_telephone_no bigint,
    office_transportation_cost numeric(19,2),
    office_address_state character varying(255),
    other_expenses character varying(255),
    other_findings integer,
    out_of_geo_limit boolean NOT NULL,
    owned_by character varying(255),
    ownership_type character varying(255),
    pers_met character varying(255),
    pers_ref_id integer NOT NULL,
    personal_email character varying(255),
    personal_email_verified boolean NOT NULL,
    phone_number character varying(255),
    phone_number_verified boolean NOT NULL,
    pincode character varying(255),
    politically_exposed boolean NOT NULL,
    prefix character varying(255),
    prepared_by character varying(255),
    property_age character varying(255),
    property_interior character varying(255),
    property_make_type character varying(255),
    ref_id character varying(255),
    registered_with_bank boolean NOT NULL,
    religion character varying(255),
    remark character varying(255),
    remark_date_time timestamp without time zone,
    rent_per_month bigint,
    rented_from timestamp without time zone,
    res_no_of_storey character varying(255),
    residence_category character varying(255),
    residence_landmark character varying(255),
    residence_type character varying(255),
    residency character varying(255),
    reviewed_by character varying(255),
    school_fees_amt numeric(19,2),
    sim_type character varying(255),
    spouse_age integer NOT NULL,
    spouse_alias character varying(255),
    spouse_birthdate character varying(255),
    spouse_citizenship character varying(255),
    spouse_first_name character varying(255),
    spouse_last_name character varying(255),
    spouse_mid_name character varying(255),
    spouse_occupation character varying(255),
    spouse_religion character varying(255),
    spouse_suffix character varying(255),
    spouse_working boolean NOT NULL,
    state character varying(255),
    suffix character varying(255),
    sum_ref_id integer,
    sum_score integer,
    term_insurance_amt integer NOT NULL,
    term_insurance_duration integer NOT NULL,
    two_wheeler_insurance_amt integer NOT NULL,
    two_wheeler_insurance_duration integer NOT NULL,
    v_mode character varying(255),
    v_status character varying(255),
    water_bill_amt numeric(19,2),
    years_of_stay bigint

                    )';

    	end loop;

--DDL Statement for table - vms_data_config
        for c  in select 1 where not exists (select 1 from pg_tables where schemaname = lower(v_schema_name) and tablename = lower('vms_data_config')) loop
        execute 'create table ' ||v_schema_name||'.vms_data_config
                    (

                  vms_config_data_id bigint NOT NULL,
                      branch_code character varying(255),
                      branch_name character varying(150),
                      res_negative_location boolean NOT NULL,
                      res_score numeric(19,2),
                      address_line1 character varying(255),
                      address_line2 character varying(255),
                      address_line3 character varying(255),
                      address_line4 character varying(255),
                      address_proof_id character varying(255),
                      age integer NOT NULL,
                      agency_name character varying(255),
                      alias character varying(255),
                      appliances character varying(255),
                      appliances_total_value numeric(19,2),
                      applicant_id character varying(255),
                      applicant_type character varying(255),
                      application_id character varying(255),
                      avg_fuel_cost numeric(19,2),
                      avg_monthly_turn_over integer,
                      bank_name_loc character varying(255),
                      birth_date character varying(255),
                      broadband_bill_amt numeric(19,2),
                      business_activity_sighted character varying(255),
                      business_board_sighted boolean NOT NULL,
                      cable_net_bill_amt numeric(19,2),
                      car_insurance_amt integer NOT NULL,
                      car_insurance_duration integer NOT NULL,
                      case_id character varying(255),
                      child_education_level character varying(255),
                      citizenship character varying(255),
                      city character varying(255),
                      civil_status character varying(255),
                      classification character varying(255),
                      college_fees_amt numeric(19,2),
                      community_dominated boolean NOT NULL,
                      commute_options character varying(255),
                      company_type character varying(255),
                      cont_domain_check boolean NOT NULL,
                      country character varying(255),
                      country_code bigint,
                      customer_id integer NOT NULL,
                      date_and_time_performed timestamp without time zone,
                      date_inspected character varying(255),
                      date_time_endorsed character varying(255),
                      designation character varying(255),
                      distance_from_address_to_actual_loaction bigint,
                      ease_of_office_location character varying(255),
                      education_level character varying(255),
                      electric_bill_amt numeric(19,2),
                      employee_code character varying(255),
                      employment_type character varying(255),
                      entity_confirmation_father boolean NOT NULL,
                      entity_confirmation_mother boolean NOT NULL,
                      entity_confirmation_spouse boolean NOT NULL,
                      entry_allowed_in_office boolean NOT NULL,
                      extension_no integer,
                      father_age integer NOT NULL,
                      father_first_name character varying(255),
                      father_last_name character varying(255),
                      father_mid_name character varying(255),
                      father_religion character varying(255),
                      final_review_status character varying(255),
                      final_score integer,
                      first_name character varying(255),
                      health_insurance_amt integer NOT NULL,
                      health_insurance_duration integer NOT NULL,
                      home_insurance_amt integer NOT NULL,
                      home_insurance_duration integer NOT NULL,
                      house_condition character varying(255),
                      income numeric(19,2),
                      income_period numeric(19,2),
                      income_source character varying(255),
                      ins_id character varying(255),
                      insurance_type character varying(255),
                      items_sighted_in_office character varying(255),
                      job_domain character varying(255),
                      landline_num bigint,
                      last_name character varying(255),
                      last_month_salary integer,
                      lattitue bigint,
                      life_insurance_amt integer NOT NULL,
                      life_insurance_duration integer NOT NULL,
                      livingwith character varying(255),
                      loan_taken_earlier boolean NOT NULL,
                      loc_amt integer NOT NULL,
                      loc_expiry_date character varying(255),
                      longitude bigint,
                      mail_delivery_status boolean NOT NULL,
                      martial_status character varying(255),
                      metro_location boolean NOT NULL,
                      middle_name character varying(255),
                      mobile_number character varying(255),
                      mobile_number_verified boolean NOT NULL,
                      monthly_amortization numeric(19,2),
                      months_of_stay bigint,
                      mortagagor_name character varying(255),
                      mother_age integer NOT NULL,
                      mother_first_name character varying(255),
                      mother_last_name character varying(255),
                      mother_mid_name character varying(255),
                      mother_religion character varying(255),
                      name_plate_visible boolean NOT NULL,
                      nature_of_business character varying(255),
                      neighbourhood_type character varying(255),
                      no_of_emplyees integer,
                      nps_amt integer NOT NULL,
                      nps_applicant_name character varying(255),
                      nps_duration integer NOT NULL,
                      number_of_dependents integer NOT NULL,
                      number_of_minor integer NOT NULL,
                      off_domain_check boolean NOT NULL,
                      offc_negative_location boolean NOT NULL,
                      offc_no_of_storey character varying(255),
                      office_address_city character varying(255),
                      office_address_country character varying(255),
                      office_address_line1 character varying(255),
                      office_address_line2 character varying(255),
                      office_address_line3 character varying(255),
                      office_address_line4 character varying(255),
                      office_address_pincode character varying(255),
                      office_area integer,
                      office_city_code character varying(255),
                      office_construction character varying(255),
                      office_email character varying(255),
                      office_email_verified boolean NOT NULL,
                      office_exterior character varying(255),
                      office_interior character varying(255),
                      office_locality character varying(255),
                      office_name character varying(255),
                      office_telephone_no bigint,
                      office_transportation_cost numeric(19,2),
                      office_address_state character varying(255),
                      other_expenses character varying(255),
                      other_findings integer,
                      out_of_geo_limit boolean NOT NULL,
                      owned_by character varying(255),
                      ownership_type character varying(255),
                      pers_met character varying(255),
                      pers_ref_id integer NOT NULL,
                      personal_email character varying(255),
                      personal_email_verified boolean NOT NULL,
                      phone_number character varying(255),
                      phone_number_verified boolean NOT NULL,
                      pincode character varying(255),
                      politically_exposed boolean NOT NULL,
                      prefix character varying(255),
                      prepared_by character varying(255),
                      property_age character varying(255),
                      property_interior character varying(255),
                      property_make_type character varying(255),
                      registered_with_bank boolean NOT NULL,
                      religion character varying(255),
                      remark character varying(255),
                      remark_date_time timestamp without time zone,
                      rent_per_month bigint,
                      rented_from timestamp without time zone,
                      res_no_of_storey character varying(255),
                      residence_category character varying(255),
                      residence_landmark character varying(255),
                      residence_type character varying(255),
                      residency character varying(255),
                      reviewed_by character varying(255),
                      school_fees_amt numeric(19,2),
                      sim_type character varying(255),
                      spouse_age integer NOT NULL,
                      spouse_alias character varying(255),
                      spouse_birthdate character varying(255),
                      spouse_citizenship character varying(255),
                      spouse_first_name character varying(255),
                      spouse_last_name character varying(255),
                      spouse_mid_name character varying(255),
                      spouse_occupation character varying(255),
                      spouse_religion character varying(255),
                      spouse_suffix character varying(255),
                      spouse_working boolean NOT NULL,
                      state character varying(255),
                      suffix character varying(255),
                      sum_ref_id integer,
                      sum_score integer,
                      term_insurance_amt integer NOT NULL,
                      term_insurance_duration integer NOT NULL,
                      two_wheeler_insurance_amt integer NOT NULL,
                      two_wheeler_insurance_duration integer NOT NULL,
                      verification_stage character varying(255),
                      water_bill_amt numeric(19,2),
                      years_of_stay bigint

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