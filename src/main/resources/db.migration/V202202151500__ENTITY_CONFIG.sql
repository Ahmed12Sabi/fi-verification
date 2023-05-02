/*
-- --------------------------------------------------------------------------
-- this program belongs to lentra ai. it is considered a trade secret and
-- is not to be divulged or used by parties who have not received written
-- authorization from lentra ai.
-- --------------------------------------------------------------p------------
-- database 	  : postgresql 
-- module         : leads service
-- author         : Shriniket Pimparkar
-- review date    : 09.02.2022
-- description    : Create data model for leads/contacts
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

	v_schema_name varchar(50) 	 := '${ph_schema}';
	--- you can changes the file name ----
	v_filename varchar(100)		 := 'V202202111522__CREATE_ENTITIES.sql';
	--- you can changes the file name ----
	c record;
	
	v_state   text;
    v_msg     text;
    v_detail  text;
    v_hint    text;
    v_context text;
	v_ea_is_required_true boolean = true; 
	v_ea_is_required_false boolean = false; 

--data type enum - Text: 1, Multi-line Text : 2, Number: 3, Date: 4,Date Time: 5, Currency: 6, Lookup: 7, Boolean:8
	
	v_text 			 int = 1;
	v_multiline_text int = 2;
	v_number 		 int = 3;
	v_date 			 int = 4;
	v_datetime 		 int = 5;
	v_currency 		 int = 6;
	v_lookup 		 int = 7;
	v_boolean 		 int = 8;


begin

--inserting business entities
insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id)
values ('lead', FALSE, FALSE, TRUE, null );



--inserting leads attributes
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard, 
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits, 
ea_max_char_length, ea_min_char_length)
values ('id', v_number, 1 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);


insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard, 
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits, 
ea_max_char_length, ea_min_char_length)
values( 'requested_amount', v_currency, 1 , v_ea_is_required_false, TRUE,
null, 'requested_amount', null, 2, 9,
null, null);




-- **************************       your sql code ends above this line       **************************

	 --raise notice 'exit for loop';
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
