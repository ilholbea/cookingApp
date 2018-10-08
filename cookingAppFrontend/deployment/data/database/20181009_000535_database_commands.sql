ALTER TABLE "system$image" ADD "submetaobjectname" VARCHAR_IGNORECASE(255) NULL;
UPDATE "system$image"
 SET "submetaobjectname" = 'System.Image';
CREATE INDEX "idx_system$image_submetaobjectname_asc" ON "system$image" ("submetaobjectname" ASC,"id" ASC);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('272f49fe-6a64-3ede-a32d-344a34e57b9f', 
'37827192-315d-4ab6-85b8-f626f866ea76', 
'submetaobjectname', 
'submetaobjectname', 
30, 
255, 
'System.Image', 
false);
INSERT INTO "mendixsystem$index" ("id", 
"table_id", 
"index_name")
 VALUES ('00a9ec1c-4fab-368f-83d4-ffa8ff501c8c', 
'37827192-315d-4ab6-85b8-f626f866ea76', 
'idx_system$image_submetaobjectname_asc');
INSERT INTO "mendixsystem$index_column" ("index_id", 
"column_id", 
"sort_order", 
"ordinal")
 VALUES ('00a9ec1c-4fab-368f-83d4-ffa8ff501c8c', 
'272f49fe-6a64-3ede-a32d-344a34e57b9f', 
false, 
0);
CREATE TABLE "myfirstmodule$image" (
	"id" BIGINT NOT NULL,
	PRIMARY KEY("id"));
INSERT INTO "mendixsystem$entity" ("id", 
"entity_name", 
"table_name", 
"superentity_id")
 VALUES ('094ee9cd-314a-4ba2-bb8d-176175d67b52', 
'MyFirstModule.Image', 
'myfirstmodule$image', 
'37827192-315d-4ab6-85b8-f626f866ea76');
CREATE TABLE "myfirstmodule$recipe_image" (
	"myfirstmodule$recipeid" BIGINT NOT NULL,
	"myfirstmodule$imageid" BIGINT NOT NULL,
	PRIMARY KEY("myfirstmodule$recipeid","myfirstmodule$imageid"),
	CONSTRAINT "uniq_myfirstmodule$recipe_image_myfirstmodule$recipeid" UNIQUE ("myfirstmodule$recipeid"));
CREATE INDEX "idx_myfirstmodule$recipe_image_myfirstmodule$image_myfirstmodule$recipe" ON "myfirstmodule$recipe_image" ("myfirstmodule$imageid" ASC,"myfirstmodule$recipeid" ASC);
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name", 
"index_name")
 VALUES ('35594930-4e55-4c69-972c-430ffd01b20a', 
'MyFirstModule.Recipe_Image', 
'myfirstmodule$recipe_image', 
'1bca2a8e-931b-4cd2-8eb2-c5209655495c', 
'094ee9cd-314a-4ba2-bb8d-176175d67b52', 
'myfirstmodule$recipeid', 
'myfirstmodule$imageid', 
'idx_myfirstmodule$recipe_image_myfirstmodule$image_myfirstmodule$recipe');
INSERT INTO "mendixsystem$unique_constraint" ("name", 
"table_id", 
"column_id")
 VALUES ('uniq_myfirstmodule$recipe_image_myfirstmodule$recipeid', 
'35594930-4e55-4c69-972c-430ffd01b20a', 
'41061bc1-dea3-378a-b34a-b5d22c095380');
UPDATE "mendixsystem$version"
 SET "versionnumber" = '4.2', 
"lastsyncdate" = '20181009 00:05:17';
