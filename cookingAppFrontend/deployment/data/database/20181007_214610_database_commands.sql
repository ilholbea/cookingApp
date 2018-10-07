ALTER TABLE "myfirstmodule$recipe" RENAME TO "ae6e6748906547c8a1da5a957b867ca5";
ALTER TABLE "myfirstmodule$contains" DROP CONSTRAINT "uniq_myfirstmodule$contains_myfirstmodule$recipeid";
DROP INDEX "idx_myfirstmodule$contains_myfirstmodule$recipelist_myfirstmodule$recipe";
ALTER TABLE "myfirstmodule$contains" RENAME TO "a6ec9d6584704afbb25f6509d960a509";
ALTER TABLE "myfirstmodule$recipelist" RENAME TO "acd27b00a6ae41abb479194ab3e9d324";
DELETE FROM "mendixsystem$entity" 
 WHERE "id" = 'd1d3b4ea-2eb3-4e6c-a513-e56e7551ce83';
DELETE FROM "mendixsystem$entityidentifier" 
 WHERE "id" = 'd1d3b4ea-2eb3-4e6c-a513-e56e7551ce83';
DELETE FROM "mendixsystem$sequence" 
 WHERE "attribute_id" IN (SELECT "id"
 FROM "mendixsystem$attribute"
 WHERE "entity_id" = 'd1d3b4ea-2eb3-4e6c-a513-e56e7551ce83');
DELETE FROM "mendixsystem$attribute" 
 WHERE "entity_id" = 'd1d3b4ea-2eb3-4e6c-a513-e56e7551ce83';
DELETE FROM "mendixsystem$association" 
 WHERE "id" = '28d59810-72d0-4ee7-83c4-9ce925589cff';
DELETE FROM "mendixsystem$unique_constraint" 
 WHERE "name" = 'uniq_myfirstmodule$contains_myfirstmodule$recipeid';
DELETE FROM "mendixsystem$entity" 
 WHERE "id" = '8c3032bf-9418-4dec-b248-89904ff82250';
DELETE FROM "mendixsystem$entityidentifier" 
 WHERE "id" = '8c3032bf-9418-4dec-b248-89904ff82250';
DELETE FROM "mendixsystem$sequence" 
 WHERE "attribute_id" IN (SELECT "id"
 FROM "mendixsystem$attribute"
 WHERE "entity_id" = '8c3032bf-9418-4dec-b248-89904ff82250');
DELETE FROM "mendixsystem$attribute" 
 WHERE "entity_id" = '8c3032bf-9418-4dec-b248-89904ff82250';
CREATE TABLE "myfirstmodule$recipelist" (
	"id" BIGINT NOT NULL,
	PRIMARY KEY("id"));
INSERT INTO "mendixsystem$entity" ("id", 
"entity_name", 
"table_name")
 VALUES ('8457999a-d289-4153-96b9-c1bb6c27a25b', 
'MyFirstModule.RecipeList', 
'myfirstmodule$recipelist');
CREATE TABLE "myfirstmodule$recipe" (
	"id" BIGINT NOT NULL,
	"steps" VARCHAR_IGNORECASE(2147483647) NULL,
	"description" VARCHAR_IGNORECASE(2147483647) NULL,
	"categories" VARCHAR_IGNORECASE(2147483647) NULL,
	"ingredients" VARCHAR_IGNORECASE(2147483647) NULL,
	"name" VARCHAR_IGNORECASE(2147483647) NULL,
	PRIMARY KEY("id"));
INSERT INTO "mendixsystem$entity" ("id", 
"entity_name", 
"table_name")
 VALUES ('1bca2a8e-931b-4cd2-8eb2-c5209655495c', 
'MyFirstModule.Recipe', 
'myfirstmodule$recipe');
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('baae2f52-cc2e-47bf-826e-dfe2f1f1fea6', 
'1bca2a8e-931b-4cd2-8eb2-c5209655495c', 
'Steps', 
'steps', 
30, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('0dd2cfb1-7dce-432c-8a6d-fe0b35d9890c', 
'1bca2a8e-931b-4cd2-8eb2-c5209655495c', 
'Description', 
'description', 
30, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('af521367-a769-42b3-96f7-3634b4bc08d3', 
'1bca2a8e-931b-4cd2-8eb2-c5209655495c', 
'Categories', 
'categories', 
30, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('a1535b18-0653-4c81-9479-cfb46805a436', 
'1bca2a8e-931b-4cd2-8eb2-c5209655495c', 
'Ingredients', 
'ingredients', 
30, 
0, 
'', 
false);
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('8f368a02-6e55-464b-bf12-89c4580ba6e3', 
'1bca2a8e-931b-4cd2-8eb2-c5209655495c', 
'Name', 
'name', 
30, 
0, 
'', 
false);
CREATE TABLE "myfirstmodule$contains" (
	"myfirstmodule$recipeid" BIGINT NOT NULL,
	"myfirstmodule$recipelistid" BIGINT NOT NULL,
	PRIMARY KEY("myfirstmodule$recipeid","myfirstmodule$recipelistid"),
	CONSTRAINT "uniq_myfirstmodule$contains_myfirstmodule$recipeid" UNIQUE ("myfirstmodule$recipeid"));
CREATE INDEX "idx_myfirstmodule$contains_myfirstmodule$recipelist_myfirstmodule$recipe" ON "myfirstmodule$contains" ("myfirstmodule$recipelistid" ASC,"myfirstmodule$recipeid" ASC);
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name", 
"index_name")
 VALUES ('c2d50158-0cc8-4a67-bafb-2b024944e300', 
'MyFirstModule.Contains', 
'myfirstmodule$contains', 
'1bca2a8e-931b-4cd2-8eb2-c5209655495c', 
'8457999a-d289-4153-96b9-c1bb6c27a25b', 
'myfirstmodule$recipeid', 
'myfirstmodule$recipelistid', 
'idx_myfirstmodule$contains_myfirstmodule$recipelist_myfirstmodule$recipe');
INSERT INTO "mendixsystem$unique_constraint" ("name", 
"table_id", 
"column_id")
 VALUES ('uniq_myfirstmodule$contains_myfirstmodule$recipeid', 
'c2d50158-0cc8-4a67-bafb-2b024944e300', 
'e4f4d8f9-d2c7-34c2-a12d-95ced9aa3495');
DROP TABLE "ae6e6748906547c8a1da5a957b867ca5";
DROP TABLE "a6ec9d6584704afbb25f6509d960a509";
DROP TABLE "acd27b00a6ae41abb479194ab3e9d324";
UPDATE "mendixsystem$version"
 SET "versionnumber" = '4.2', 
"lastsyncdate" = '20181007 21:46:08';
