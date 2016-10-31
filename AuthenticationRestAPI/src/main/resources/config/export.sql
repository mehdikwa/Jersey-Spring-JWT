--------------------------------------------------------
--  Fichier cr�� - mardi-juin-07-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table directory_pwd_policy
--------------------------------------------------------

  CREATE TABLE "directory_pwd_policy" 
   (	"policy_id" integer, 
	"min_length" integer, 
	"nb_digits" integer, 
	"nb_lower_cases" integer, 
	"nb_upper_cases" integer, 
	"nb_special_chars" integer, 
	"nb_distinct_chars" integer, 
	"max_tries" integer, 
	"periode_of_validity" integer, 
	"remember_me" integer, 
	"creation_date" timestamp without time zone DEFAULT '2000-01-01 00:00:00'::timestamp without time zone, 
	"created_by" character varying(256), 
	"last_update_date" timestamp without time zone DEFAULT '2000-01-01 00:00:00'::timestamp without time zone, 
	"last_updated_by" character varying(256)
   ) ;

   COMMENT ON COLUMN "directory_pwd_policy"."creation_date" IS 'Record''s creation date';
   COMMENT ON COLUMN "directory_pwd_policy"."created_by" IS 'Id of the user who inserted the record';
   COMMENT ON COLUMN "directory_pwd_policy"."last_update_date" IS 'Record''s last update date';
   COMMENT ON COLUMN "directory_pwd_policy"."last_updated_by" IS 'Id of the user who last updated the record';
--------------------------------------------------------
--  DDL for Table directory_user_infos
--------------------------------------------------------

  CREATE TABLE "directory_user_infos" 
   (	"info_id" integer, 
	"user_id" integer, 
	"key" character varying(64), 
	"value" character varying(256), 
	"creation_date" timestamp without time zone DEFAULT '2000-01-01 00:00:00'::timestamp without time zone, 
	"created_by" character varying(256), 
	"last_update_date" timestamp without time zone DEFAULT '2000-01-01 00:00:00'::timestamp without time zone, 
	"last_updated_by" character varying(256)
   ) ;

   COMMENT ON COLUMN "directory_user_infos"."creation_date" IS 'Record''s creation date';
   COMMENT ON COLUMN "directory_user_infos"."created_by" IS 'Id of the user who inserted the record';
   COMMENT ON COLUMN "directory_user_infos"."last_update_date" IS 'Record''s last update date';
   COMMENT ON COLUMN "directory_user_infos"."last_updated_by" IS 'Id of the user who last updated the record';
--------------------------------------------------------
--  DDL for Table directory_users
--------------------------------------------------------

  CREATE TABLE "directory_users" 
   (	"user_id" integer, 
	"username" character varying(128), 
	"password" character varying(128), 
	"auth_type" character varying(6), 
	"email" character varying(256), 
	"first_name" character varying(64), 
	"last_name" character varying(64), 
	"creation_date" timestamp without time zone DEFAULT '2000-01-01 00:00:00'::timestamp without time zone, 
	"created_by" character varying(256), 
	"last_update_date" timestamp without time zone DEFAULT '2000-01-01 00:00:00'::timestamp without time zone, 
	"last_updated_by" character varying(256), 
	"admin_flag" smallint DEFAULT 0, 
	"active_flag" smallint DEFAULT 1, 
	"last_password_reset_date" timestamp without time zone
   ) ;

   COMMENT ON COLUMN "directory_users"."user_id" IS 'User ID';
   COMMENT ON COLUMN "directory_users"."username" IS 'Unique login name';
   COMMENT ON COLUMN "directory_users"."password" IS 'Crypted password';
   COMMENT ON COLUMN "directory_users"."creation_date" IS 'Record''s creation date';
   COMMENT ON COLUMN "directory_users"."created_by" IS 'Id of the user who inserted the record';
   COMMENT ON COLUMN "directory_users"."last_update_date" IS 'Record''s last update date';
   COMMENT ON COLUMN "directory_users"."last_updated_by" IS 'Id of the user who last updated the record';
   COMMENT ON COLUMN "directory_users"."admin_flag" IS 'Admin or not
';

Insert into directory_pwd_policy (policy_id,min_length,nb_digits,nb_lower_cases,nb_upper_cases,nb_special_chars,nb_distinct_chars,max_tries,periode_of_validity,remember_me,creation_date,created_by,last_update_date,last_updated_by) values ('1','6','1','1','1','0','6','10','1000','1',to_date('20/05/16','DD/MM/RR'),'84',to_date('20/05/16','DD/MM/RR'),'84');

Insert into directory_user_infos (info_id,user_id,key,value,creation_date,created_by,last_update_date,last_updated_by) values ('1','1','Taille','1m80',to_date('20/05/16','DD/MM/RR'),'84',to_date('20/05/16','DD/MM/RR'),'84');
Insert into directory_user_infos (info_id,user_id,key,value,creation_date,created_by,last_update_date,last_updated_by) values ('2','2','Taille','2m05',to_date('20/05/16','DD/MM/RR'),'84',to_date('20/05/16','DD/MM/RR'),'84');
Insert into directory_user_infos (info_id,user_id,key,value,creation_date,created_by,last_update_date,last_updated_by) values ('3','1','Poids','70kg',to_date('20/05/16','DD/MM/RR'),'84',to_date('20/05/16','DD/MM/RR'),'84');
Insert into directory_user_infos (info_id,user_id,key,value,creation_date,created_by,last_update_date,last_updated_by) values ('4','2','Poids','96kg',to_date('20/05/16','DD/MM/RR'),'84',to_date('20/05/16','DD/MM/RR'),'84');

Insert into directory_users (user_id,username,password,auth_type,email,first_name,last_name,creation_date,created_by,last_update_date,last_updated_by,admin_flag,active_flag,last_password_reset_date) values ('1200','coco','toto','SIMPLE','toto@yaoo.de','momo','coco',to_date('31/05/16','DD/MM/RR'),'2',to_date('31/05/16','DD/MM/RR'),'2','1','1',null);
Insert into directory_users (user_id,username,password,auth_type,email,first_name,last_name,creation_date,created_by,last_update_date,last_updated_by,admin_flag,active_flag,last_password_reset_date) values ('1201','titi',null,'LDAP','toto@yaoo.de','titi','toto',to_date('31/05/16','DD/MM/RR'),'2',to_date('31/05/16','DD/MM/RR'),'2','1','1',null);
Insert into directory_users (user_id,username,password,auth_type,email,first_name,last_name,creation_date,created_by,last_update_date,last_updated_by,admin_flag,active_flag,last_password_reset_date) values ('1','mmerabti',null,'LDAP','utilisateur1@gmail.fr','Pr�nom1','Nom1',to_date('20/05/16','DD/MM/RR'),'84',to_date('20/05/16','DD/MM/RR'),'84','0','1',null);
Insert into directory_users (user_id,username,password,auth_type,email,first_name,last_name,creation_date,created_by,last_update_date,last_updated_by,admin_flag,active_flag,last_password_reset_date) values ('2','admin','$2a$11$ZV9pBZHKoonJWcEYvEzYk.lEUP/6uAxLMGT.2nKkx/6v9qkZyTPxG','SIMPLE','utilisateur2@gmail.fr','Pr�nom2','Nom2',to_date('20/05/16','DD/MM/RR'),'84',to_date('20/05/16','DD/MM/RR'),'84','1','1',null);
Insert into directory_users (user_id,username,password,auth_type,email,first_name,last_name,creation_date,created_by,last_update_date,last_updated_by,admin_flag,active_flag,last_password_reset_date) values ('3','user3','$2a$11$ZV9pBZHKoonJWcEYvEzYk.lEUP/6uAxLMGT.2nKkx/6v9qkZyTPxG','SIMPLE','utilisateur3@gmail.fr','Pr�nom3','Nom3',to_date('20/05/16','DD/MM/RR'),'84',to_date('20/05/16','DD/MM/RR'),'84','0','1',null);
--------------------------------------------------------
--  Constraints for Table directory_users
--------------------------------------------------------

  ALTER TABLE "directory_users" ADD CONSTRAINT "directory_users_pk" PRIMARY key ("user_id")
  ;
 
--------------------------------------------------------
--  Constraints for Table directory_pwd_policy
--------------------------------------------------------

  ALTER TABLE "directory_pwd_policy" ADD CONSTRAINT "directory_pwd_policy_pk" PRIMARY key ("policy_id")
  ;
--------------------------------------------------------
--  Constraints for Table directory_user_infos
--------------------------------------------------------

  ALTER TABLE "directory_user_infos" ADD CONSTRAINT "directory_user_infos_pk" PRIMARY key ("info_id")
  ;
--------------------------------------------------------
--  Ref Constraints for Table directory_user_infos
--------------------------------------------------------

  ALTER TABLE "directory_user_infos" ADD CONSTRAINT "directory_user_infos_f1" FOREIGN key ("user_id")
	  REFERENCES "directory_users" ("user_id");
