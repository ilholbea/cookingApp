CREATE TABLE "myfirstmodule$search" (
	"id" BIGINT NOT NULL,
	"category" VARCHAR_IGNORECASE(200) NULL,
	PRIMARY KEY("id"));
INSERT INTO "mendixsystem$entity" ("id", 
"entity_name", 
"table_name")
 VALUES ('0d852a1d-ca41-4aed-a7c6-3cfeadd88b7c', 
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
 VALUES ('a62bb312-297e-4077-a386-f0986d9bd127', 
'0d852a1d-ca41-4aed-a7c6-3cfeadd88b7c', 
'Category', 
'category', 
30, 
200, 
'', 
false);
UPDATE "mendixsystem$version"
 SET "versionnumber" = '4.2', 
"lastsyncdate" = '20181007 20:28:03';
