/*
-- --------------------------------------------------------------------------
-- this program belongs to lentra ai. it is considered a trade secret and
-- is not to be divulged or used by parties who have not received written
-- authorization from lentra ai.
-- --------------------------------------------------------------p------------
-- database 	  : postgresql 
-- module         : vms service
-- author           : Afroze A
-- review date    : 02.05.2023
-- description    : Create data model for vms
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
	v_filename varchar(100)		 := 'V202304272235__ENTITY_CONFIG.sql';
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
	bytea	     	 int = 9;


begin

insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id) values ( 'application_details', FALSE, FALSE, TRUE, null );

insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id) values ( 'application_raw_object', FALSE, FALSE, TRUE, null );

insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id) values ( 'assignor',FALSE, FALSE, TRUE, null );

insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id) values ( 'commitment_details' ,FALSE, FALSE, TRUE, null );

insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id) values ( 'contact_details' ,FALSE, FALSE, TRUE, null );

insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id) values ( 'expenses' ,FALSE, FALSE, TRUE, null );

insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id) values ( 'family_details' ,FALSE, FALSE, TRUE, null );

insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id) values ( 'fi_files' ,FALSE, FALSE, TRUE, null );

insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id) values ( 'office_self_employment' ,FALSE, FALSE, TRUE, null );

insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id) values ( 'personal_details' ,FALSE, FALSE, TRUE, null );

insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id) values ( 'residence_details' ,FALSE, FALSE, TRUE, null );

insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id) values ( 'summary' ,FALSE, FALSE, TRUE, null );

insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id) values ( 'vehicle_details' ,FALSE, FALSE, TRUE, null );

insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id) values ( 'verification' ,FALSE, FALSE, TRUE, null );

insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id) values ( 'verifiers' ,FALSE, FALSE, TRUE, null );

insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id) values ( 'vms_data_config' ,FALSE, FALSE, TRUE, null );

insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id) values ( 'applicant_details' ,FALSE, FALSE, TRUE, null );

insert into business_entities (be_entity_id, be_is_array, be_is_nested_entity, be_is_root_entity, be_parent_entity_id) values ( 'applicants_address' ,FALSE, FALSE, TRUE, null );


insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'application_id',v_text, 1 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'branch_code',v_text, 1 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'branch_name',v_text, 1 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'case_id',v_text, 1 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'created_by',v_text, 1 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'created_on',v_datetime, 1 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'ins_id',v_text, 1 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'modified_by',v_text, 1 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'modified_on',v_datetime, 1 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'product_type',v_text, 1 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'verification_stage',v_text, 1 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'verification_status',v_text, 1 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);


insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'id',v_number, 2 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'application_id',v_text, 2 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'case_id',v_text, 2 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'created_on',v_datetime, 2 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'raw_data',bytea, 2 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);


insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'assigned_id',v_number, 3 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'a_status',v_text, 3 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address',v_text, 3 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_type',v_text, 3 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_id',v_text, 3 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_name',v_text, 3 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'application_id',v_text, 3 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'assigned_agency_code',v_text, 3 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'assigned_agency_name',v_text, 3 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'assigned_branch_code',v_text, 3 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'assigned_branch_name',v_text, 3 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'assigned_by',v_text, 3 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'assigned_date_time',v_datetime, 3 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'assigned_to',v_text, 3 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'case_id',v_text, 3 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'fi_id',v_text, 3 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'ins_id',v_text, 3 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'loan_amount',v_number, 3 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'ref_fi_id',v_text, 3 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'v_status',v_text, 3 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);


insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_id',v_text, 4 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'bank_name_loc',v_text, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'car_insurance_amt',v_number, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'car_insurance_duration',v_number, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'customer_id',v_number, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'health_insurance_amt',v_number, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'health_insurance_duration',v_number, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'home_insurance_amt',v_number, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'home_insurance_duration',v_number, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'insurance_type',v_text, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'life_insurance_amt',v_number, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'life_insurance_duration',v_number, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'loc_amt',v_number, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'loc_expiry_date',v_text, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'nps_amt',v_number, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'nps_applicant_name',v_number, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'nps_duration',v_number, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'term_insurance_amt',v_number, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'term_insurance_duration',v_number, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'two_wheeler_insurance_amt',v_number, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'two_wheeler_insurance_duration',v_number, 4 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);


insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_id',v_number, 5 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'cont_domain_check',v_boolean, 5 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mobile_number',v_text, 5 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mobile_number_verified',v_text, 5 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'personal_email',v_text, 5 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'personal_email_verified',v_boolean, 5 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'phone_number',v_text, 5 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'phone_number_verified',v_boolean, 5 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'registered_with_bank',v_boolean, 5 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'sim_type',v_text, 5 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);



insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_id',v_text, 6 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'avg_fuel_cost',v_currency, 6 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'broadband_bill_amt',v_currency, 6 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'cable_net_bill_amt',v_currency, 6 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'college_fees_amt',v_currency, 6 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'electric_bill_amt',v_currency, 6 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_transportation_cost',v_currency, 6 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'other_expenses',v_currency, 6 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'school_fees_amt',v_currency, 6 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'water_bill_amt',v_currency, 6 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);





insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_id',v_number, 7 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'child_education_level',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'entity_confirmation_father',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'entity_confirmation_mother',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'entity_confirmation_spouse',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'father_age',v_number, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'father_first_name',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'father_last_name',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'father_mid_name',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'father_religion',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mother_age',v_number, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mother_first_name',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mother_last_name',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mother_mid_name',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mother_religion',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'number_of_dependents',v_number, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'number_of_minor',v_number, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_age',v_number, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_alias',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_birthdate',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_citizenship',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_first_name',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_last_name',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_mid_name',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_occupation',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_religion',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_suffix',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_working',v_text, 7 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);






insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'id',v_number, 8 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_id',v_number, 8 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'content_type',v_number, 8 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'data',bytea, 8 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'filename',v_text, 8 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'latitude',v_text, 8 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'longitude',v_text, 8 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'timestamp',v_datetime, 8 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);


insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_id',v_number, 9 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'avg_monthly_turn_over',v_number, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'business_activity_sighted',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'business_board_sighted',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'company_type',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'designation',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'ease_of_office_location',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'employee_code',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'employment_type',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'entry_allowed_in_office',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'extension_no',v_number, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'items_sighted_in_office',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'job_domain',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'last_month_salary',v_number, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'metro_location',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'nature_of_business',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'no_of_emplyees',v_number, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'off_domain_check',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'offc_negative_location',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'offc_no_of_storey',v_number, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_city',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_country',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_line9',v_multiline_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_line2',v_multiline_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_line3',v_multiline_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_line4',v_multiline_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_pincode',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_area',v_number, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_city_code',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_construction',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_email',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_email_verified',v_boolean, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_exterior',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_interior',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_locality',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_name',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_telephone_no',v_number, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_state',v_text, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'out_of_geo_limit',v_boolean, 9 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);


insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_id',v_number, 10 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'age',v_number, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'alias',v_text, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'birth_date',v_text, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'citizenship',v_text, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'civil_status',v_text, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'date_inspected',v_text, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'date_time_endorsed',v_text, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'education_level',v_text, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'first_name',v_text, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'income',v_currency, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'income_period',v_number, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'income_source',v_text, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'last_name',v_text, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'loan_taken_earlier',v_boolean, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'martial_status',v_text, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'middle_name',v_text, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'pers_ref_id',v_number, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'politically_exposed',v_text, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'prefix',v_text, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'religion',v_text, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'suffix',v_text, 10 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);


insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_id',v_number, 11, v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'res_negative_location',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'res_score',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_line1',v_multiline_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_line2',v_multiline_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_line3',v_multiline_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_line4',v_multiline_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_proof_id',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'appliances',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'appliances_total_value',v_number, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'city',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'classification',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'community_dominated',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'commute_options',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'country',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'country_code',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'distance_from_address_to_actual_loaction',v_number, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'house_condition',v_number, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'landline_num',v_number, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'lattitue',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'livingwith',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'longitude',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mail_delivery_status',v_boolean, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'monthly_amortization',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'months_of_stay',v_number, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mortagagor_name',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'name_plate_visible',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'neighbourhood_type',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'owned_by',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'ownership_type',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'pers_met',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'pincode',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'property_age',v_number, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'property_interior',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'property_make_type',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'rent_per_month',v_number, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'rented_from',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'res_no_of_storey',v_number, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'residence_category',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'residence_landmark',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'residence_type',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'residency',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'state',v_text, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'years_of_stay',v_number, 11, v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);


insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_id',v_number, 12 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'agency_name',v_text, 12 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'date_and_time_performed',v_text, 12 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'final_review_status',v_text, 12 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'final_score',v_number, 12 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'other_findings',v_number, 12 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'prepared_by',v_text, 12 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'remark',v_text, 12 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'remark_date_time',v_datetime, 12 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'reviewed_by',v_text, 12 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'sum_ref_id',v_number, 12 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'sum_score',v_number, 12 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);




insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_id',v_number, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'bike_hypothecated_to',v_text, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'bike_issuing_authority',v_text, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'bike_manufacture_name',v_text, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'bike_ownership_type',v_text, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'bike_registration_number',v_number, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'car_fuel_type',v_text, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'car_hypothecated_to',v_text, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'car_issuing_authority',v_text, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'car_manufacture_name',v_text, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'car_model',v_text, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'car_ownership_type',v_text, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'car_registration_number',v_number, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'car_seating_capacity',v_number, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'financed_from_date_bike',v_text, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'financed_from_date_car',v_text, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'manufacture_year_car',v_number, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'manufacture_year_two_wheeler',v_number, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'number_of_vehicles_owned',v_number, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'two_wheeler_model',v_number, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'vehicle_type',v_text, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'with_parking_space',v_text, 13 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);


insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'fi_id',v_number, 14 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'a_reply_message',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'a_reply_message_date',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'a_status',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'accepted_date_time',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_type',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'agency_code',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'agency_name',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_address',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_id',v_number, 14 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_name',v_text, 14 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_pincode',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_type',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'application_id',v_text, 14 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'approved_date',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'assigned_by',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'assigned_date_time',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'assigned_to',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'case_id',v_text, 14 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'com_key',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'declined_date',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'declined_reason',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'final_feedback',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'ins_id',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'loan_amount',v_number, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mobile_number',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'ref_fi_id',v_number, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'rejected_date_time',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'rejected_reason',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'remarks',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'v_mode',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'v_queries',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'v_query_date',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'v_status',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'verification_stage',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'verification_status',v_text, 14 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);





insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'fi_id',v_number, 15 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'res_negative_location',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'res_score',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'a_status',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_line15',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_line2',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_line3',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_line4',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_proof_id',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_type',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'age',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'agency_name',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'alias',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'appliances',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'appliances_total_value',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_id',v_number, 15 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_type',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'application_id',v_text, 15 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'avg_fuel_cost',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'avg_monthly_turn_over',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'bank_name_loc',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'birth_date',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'broadband_bill_amt',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'business_activity_sighted',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'business_board_sighted',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'cable_net_bill_amt',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'car_insurance_amt',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'car_insurance_duration',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'case_id',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'child_education_level',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'citizenship',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'city',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'civil_status',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'classification',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'college_fees_amt',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'com_key',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'community_dominated',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'commute_options',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'company_type',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'cont_domain_check',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'country',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'country_code',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'customer_id',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'date_and_time_performed',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'date_inspected',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'date_time_endorsed',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'designation',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'distance_from_address_to_actual_loaction',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'ease_of_office_location',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'education_level',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'electric_bill_amt',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'employee_code',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'employment_type',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'entity_confirmation_father',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'entity_confirmation_mother',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'entity_confirmation_spouse',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'entry_allowed_in_office',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'extension_no',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'father_age',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'father_first_name',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'father_last_name',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'father_mid_name',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'father_religion',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'final_review_status',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'final_score',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'first_name',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'health_insurance_amt',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'health_insurance_duration',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'home_insurance_amt',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'home_insurance_duration',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'house_condition',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'income',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'income_period',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'income_source',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'ins_id',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'insurance_type',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'is_active',v_boolean, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'items_sighted_in_office',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'job_domain',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'landline_num',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'last_name',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'last_month_salary',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'lattitue',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'life_insurance_amt',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'life_insurance_duration',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'livingwith',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'loan_taken_earlier',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'loc_amt',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'loc_expiry_date',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'longitude',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mail_delivery_status',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'martial_status',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'metro_location',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'middle_name',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mobile_number',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mobile_number_verified',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'monthly_amortization',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'months_of_stay',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mortagagor_name',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mother_age',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mother_first_name',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mother_last_name',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mother_mid_name',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mother_religion',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'name_plate_visible',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'nature_of_business',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'neighbourhood_type',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'no_of_emplyees',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'nps_amt',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'nps_applicant_name',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'nps_duration',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'number_of_dependents',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'number_of_minor',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'off_domain_check',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'offc_negative_location',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'offc_no_of_storey',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_city',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_country',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_line15',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_line2',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_line3',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_line4',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_pincode',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_area',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_city_code',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_construction',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_email',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_email_verified',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_exterior',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_interior',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_locality',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_name',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_telephone_no',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_transportation_cost',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_state',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'other_expenses',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'other_findings',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'out_of_geo_limit',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'owned_by',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'ownership_type',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'pers_met',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'pers_ref_id',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'personal_email',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'personal_email_verified',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'phone_number',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'phone_number_verified',v_boolean, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'pincode',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'politically_exposed',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'prefix',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'prepared_by',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'property_age',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'property_interior',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'property_make_type',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'ref_id',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'registered_with_bank',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'religion',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'remark',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'remark_date_time',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'rent_per_month',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'rented_from',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'res_no_of_storey',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'residence_category',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'residence_landmark',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'residence_type',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'residency',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'reviewed_by',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'school_fees_amt',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'sim_type',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_age',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_alias',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_birthdate',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_citizenship',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_first_name',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_last_name',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_mid_name',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_occupation',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_religion',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_suffix',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_working',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'state',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'suffix',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'sum_ref_id',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'sum_score',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'term_insurance_amt',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'term_insurance_duration',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'two_wheeler_insurance_amt',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'two_wheeler_insurance_duration',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'v_mode',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'v_status',v_text, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'water_bill_amt',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'years_of_stay',v_number, 15 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);


insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'vms_config_data_id',v_text, 16 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'branch_code',v_text, 16 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'branch_name',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'res_negative_location',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'res_score',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_line16',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_line2',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_line3',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_line4',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_proof_id',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'age',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'agency_name',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'alias',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'appliances',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'appliances_total_value',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_id',v_number, 16 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_type',v_text, 16 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'application_id',v_text, 16 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'avg_fuel_cost',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'avg_monthly_turn_over',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'bank_name_loc',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'birth_date',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'broadband_bill_amt',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'business_activity_sighted',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'business_board_sighted',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'cable_net_bill_amt',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'car_insurance_amt',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'car_insurance_duration',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'case_id',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'child_education_level',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'citizenship',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'city',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'civil_status',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'classification',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'college_fees_amt',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'community_dominated',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'commute_options',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'company_type',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'cont_domain_check',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'country',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'country_code',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'customer_id',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'date_and_time_performed',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'date_inspected',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'date_time_endorsed',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'designation',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'distance_from_address_to_actual_loaction',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'ease_of_office_location',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'education_level',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'electric_bill_amt',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'employee_code',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'employment_type',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'entity_confirmation_father',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'entity_confirmation_mother',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'entity_confirmation_spouse',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'entry_allowed_in_office',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'extension_no',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'father_age',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'father_first_name',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'father_last_name',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'father_mid_name',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'father_religion',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'final_review_status',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'final_score',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'first_name',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'health_insurance_amt',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'health_insurance_duration',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'home_insurance_amt',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'home_insurance_duration',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'house_condition',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'income',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'income_period',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'income_source',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'ins_id',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'insurance_type',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'items_sighted_in_office',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'job_domain',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'landline_num',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'last_name',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'last_month_salary',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'lattitue',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'life_insurance_amt',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'life_insurance_duration',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'livingwith',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'loan_taken_earlier',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'loc_amt',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'loc_expiry_date',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'longitude',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mail_delivery_status',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'martial_status',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'metro_location',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'middle_name',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mobile_number',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mobile_number_verified',v_boolean, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'monthly_amortization',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'months_of_stay',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mortagagor_name',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mother_age',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mother_first_name',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mother_last_name',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mother_mid_name',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mother_religion',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'name_plate_visible',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'nature_of_business',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'neighbourhood_type',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'no_of_emplyees',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'nps_amt',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'nps_applicant_name',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'nps_duration',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'number_of_dependents',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'number_of_minor',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'off_domain_check',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'offc_negative_location',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'offc_no_of_storey',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_city',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_country',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_line16',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_line2',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_line3',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_line4',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_pincode',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_area',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_city_code',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_construction',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_email',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_email_verified',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_exterior',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_interior',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_locality',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_name',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_telephone_no',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_transportation_cost',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'office_address_state',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'other_expenses',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'other_findings',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'out_of_geo_limit',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'owned_by',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'ownership_type',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'pers_met',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'pers_ref_id',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'personal_email',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'personal_email_verified',v_boolean, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'phone_number',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'phone_number_verified',v_boolean, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'pincode',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'politically_exposed',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'prefix',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'prepared_by',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'property_age',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'property_interior',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'property_make_type',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'registered_with_bank',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'religion',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'remark',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'remark_date_time',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'rent_per_month',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'rented_from',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'res_no_of_storey',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'residence_category',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'residence_landmark',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'residence_type',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'residency',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'reviewed_by',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'school_fees_amt',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'sim_type',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_age',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_alias',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_birthdate',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_citizenship',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_first_name',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_last_name',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_mid_name',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_occupation',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_religion',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_suffix',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'spouse_working',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'state',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'suffix',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'sum_ref_id',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'sum_score',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'term_insurance_amt',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'term_insurance_duration',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'two_wheeler_insurance_amt',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'two_wheeler_insurance_duration',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'verification_stage',v_text, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'water_bill_amt',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'years_of_stay',v_number, 16 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);






insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_id',v_number, 17 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'agency_name',v_text, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'app_role',v_text, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_name',v_text, 17 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_type',v_text, 17 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'assigned_by',v_text, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'assigned_to',v_text, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'branch_name',v_text, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'case_id',v_text, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'id',v_number, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'ins_id',v_text, 17 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'inspected_by',v_text, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'inspected_by_id',v_number, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'inspected_date',v_text, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'is_agency',v_boolean, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'loan_amount',v_number, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'mobile_number',v_text, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 're_verification',v_text, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'retrigger',v_text, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'role_type',v_text, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'status',v_text, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'user_status',v_text, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'verifier_progress',v_text, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'commitments',v_number, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'contact_details',v_number, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'expenses',v_number, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'family_details',v_number, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'employment_details',v_number, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'personal_details',v_number, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'residence_details',v_number, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'summary',v_number, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'vehicle_details',v_number, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'application_details',v_number, 17 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);



insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_id',v_number, 18 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address',v_text, 18 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'address_type',v_text, 18 , v_ea_is_required_false, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'applicant_id',v_number, 18 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
null, null);
insert into entity_attributes (
ea_attribute_id, ea_data_type, ea_be_id, ea_is_required, ea_is_standard,
ea_java_reg_ex, ea_label, ea_lookup_id, ea_max_decimal_digits, ea_max_digits,
ea_max_char_length, ea_min_char_length) values ( 'application_id',v_text, 18 , v_ea_is_required_true, TRUE,
null, 'id', null, null, null,
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
