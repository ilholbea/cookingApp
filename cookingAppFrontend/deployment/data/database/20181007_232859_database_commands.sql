CREATE TABLE "myfirstmodule$search" (
	"id" BIGINT NOT NULL,
	"category" VARCHAR_IGNORECASE(200) NULL,
	PRIMARY KEY("id"));
INSERT INTO "mendixsystem$entity" ("id", 
"entity_name", 
"table_name")
 VALUES ('0f19ca30-3015-42ca-b74d-6e8c88c471b7', 
'MyFirstModule.Search', 
'myfirstmodule$search');
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('4285c846-d63f-4d6c-9fb5-2a4bd701ecc2', 
'0f19ca30-3015-42ca-b74d-6e8c88c471b7', 
'category', 
'category', 
30, 
200, 
'', 
false);
UPDATE "mendixsystem$version"
 SET "versionnumber" = '4.2', 
"lastsyncdate" = '20181007 23:28:57';
