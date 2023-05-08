#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
  create database scm_db;
  create database db_client1_vms;
  create database db_client2_vms;
  create database db_verification;
EOSQL

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "db_verification" <<-EOSQL
	create schema verification;
	alter database db_verification set search_path to verification;

  create user user_verification with password 'adept';
  create user flyway_user_verification with password 'adept1';

  grant connect on database db_verification to user_verification;
  grant usage, create on schema verification to user_verification;
  alter default privileges for role flyway_user_verification grant select, insert, update, delete on tables to user_verification;
  alter default privileges for role flyway_user_verification grant all on sequences to user_verification;

  grant connect on database db_verification to flyway_user_verification;
  grant usage, create on schema verification to flyway_user_verification;
  grant all on all tables in schema verification TO flyway_user_verification;
  grant all on all sequences in schema verification TO flyway_user_verification;
EOSQL

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "db_client1_vms" <<-EOSQL
	create schema schema_client1_vms;
	alter database db_client1_vms set search_path to schema_client1_vms;

  create user user_client1_vms with password 'adept';
  create user flyway_user_client1_vms with password 'adept1';

  grant connect on database db_client1_vms to user_client1_vms;
  grant usage, create on schema schema_client1_vms to user_client1_vms;
  alter default privileges for role flyway_user_client1_vms grant select, insert, update, delete on tables to user_client1_vms;
  alter default privileges for role flyway_user_client1_vms grant all on sequences to user_client1_vms;

  grant connect on database db_client1_vms to flyway_user_client1_vms;
  grant usage, create on schema schema_client1_vms to flyway_user_client1_vms;
  grant all on all tables in schema schema_client1_vms TO flyway_user_client1_vms;
  grant all on all sequences in schema schema_client1_vms TO flyway_user_client1_vms;
EOSQL

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "db_client2_vms" <<-EOSQL
	create schema schema_client2_vms;
	alter database db_client2_vms set search_path TO schema_client2_vms;

  create user user_client2_vms with password 'adept';
  create user flyway_user_client2_vms with password 'adept1';

  grant connect on database db_client2_vms to user_client2_vms;
  grant usage, create on schema schema_client2_vms to user_client2_vms;
  alter default privileges for role flyway_user_client2_vms grant select, insert, update, delete on tables to user_client2_vms;
  alter default privileges for role flyway_user_client2_vms grant all on sequences to user_client2_vms;

  grant connect on database db_client2_vms to flyway_user_client2_vms;
  grant usage, create on schema schema_client2_vms to flyway_user_client2_vms;
  grant all on all tables in  schema schema_client2_vms to flyway_user_client2_vms;
  grant all on all sequences in  schema schema_client2_vms to flyway_user_client2_vms;
EOSQL

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "scm_db" <<-EOSQL
	create schema scm_schema;
	alter database scm_db set search_path to scm_schema;

  create user scm_user with password 'adept';
  create user scm_flyway_user with password 'adept1';

  grant connect on database scm_db to scm_user;
  grant usage, create on schema scm_schema to scm_user;
  alter default privileges for role scm_flyway_user grant select, insert, update, delete on tables to scm_user;
  alter default privileges for role scm_flyway_user grant all on sequences to scm_user;

  grant connect on database scm_db to scm_flyway_user;
  grant usage, create on schema scm_schema to scm_flyway_user;
  grant all on all tables in  schema scm_schema to scm_flyway_user;
  grant all on all sequences in schema scm_schema to scm_flyway_user;
EOSQL

export PGPASSWORD='adept1';
psql -v ON_ERROR_STOP=1 --username "scm_flyway_user" --dbname "scm_db" <<-EOSQL

  create table tenants (
        id serial primary key,
        tenant_id numeric not null,
        name varchar(255) not null,
        service varchar(255) not null,
        db_host varchar(255) not null,
        db_port varchar(255) not null,
        db_name varchar(255) not null,
        schema_name varchar(255) not null,
        flyway_user varchar(255) not null,
        flyway_password varchar(255) not null,
        app_user varchar(255) not null,
        app_password varchar(255) not null
    );

  insert into tenants (tenant_id, name, service, db_host, db_port, db_name, schema_name, flyway_user, flyway_password, app_user, app_password)
    values (101, 'client1', 'vms', 'localhost', '5432', 'db_client1_vms', 'schema_client1_vms', 'flyway_user_client1_vms', 'adept1', 'user_client1_vms', 'adept');

  insert into tenants (tenant_id, name, service, db_host, db_port, db_name, schema_name, flyway_user, flyway_password, app_user, app_password)
    values (102, 'client2', 'vms', 'localhost', '5432', 'db_client2_vms', 'schema_client2_vms', 'flyway_user_client2_vms', 'adept1', 'user_client2_vms', 'adept');

	-- insert into tenants (tenant_id, name, service, db_host, db_port, db_name, schema_name, flyway_user, flyway_password, app_user, app_password)
  --  values (103, 'client3, 'vms', 'localhost', '5432', 'db_verification', 'verification', 'flyway_user_verification', 'adept1', 'user_verification, 'adept');

EOSQL