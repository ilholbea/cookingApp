CREATE TABLE "myfirstmodule$recipelist" (
	"id" BIGINT NOT NULL,
	PRIMARY KEY("id"));
INSERT INTO "mendixsystem$entity" ("id", 
"entity_name", 
"table_name")
 VALUES ('8c3032bf-9418-4dec-b248-89904ff82250', 
'MyFirstModule.RecipeList', 
'myfirstmodule$recipelist');
CREATE TABLE "myfirstmodule$recipe" (
	"id" BIGINT NOT NULL,
	"description" VARCHAR_IGNORECASE(2147483647) NULL,
	"categories" VARCHAR_IGNORECASE(2147483647) NULL,
	"ingredients" VARCHAR_IGNORECASE(2147483647) NULL,
	"name" VARCHAR_IGNORECASE(2147483647) NULL,
	PRIMARY KEY("id"));
INSERT INTO "mendixsystem$entity" ("id", 
"entity_name", 
"table_name")
 VALUES ('d1d3b4ea-2eb3-4e6c-a513-e56e7551ce83', 
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
 VALUES ('f8d08416-6efb-4c1f-a5e0-dc6fb9b9e47c', 
'd1d3b4ea-2eb3-4e6c-a513-e56e7551ce83', 
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
 VALUES ('bbcba38c-81cd-4c17-974c-109f2e03f490', 
'd1d3b4ea-2eb3-4e6c-a513-e56e7551ce83', 
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
 VALUES ('7c88cf34-95cd-496b-b453-7b2f7ae8b10b', 
'd1d3b4ea-2eb3-4e6c-a513-e56e7551ce83', 
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
 VALUES ('25c7ac18-e0b9-4b04-a4bb-e9c52a9dceeb', 
'd1d3b4ea-2eb3-4e6c-a513-e56e7551ce83', 
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
 VALUES ('28d59810-72d0-4ee7-83c4-9ce925589cff', 
'MyFirstModule.Contains', 
'myfirstmodule$contains', 
'd1d3b4ea-2eb3-4e6c-a513-e56e7551ce83', 
'8c3032bf-9418-4dec-b248-89904ff82250', 
'myfirstmodule$recipeid', 
'myfirstmodule$recipelistid', 
'idx_myfirstmodule$contains_myfirstmodule$recipelist_myfirstmodule$recipe');
INSERT INTO "mendixsystem$unique_constraint" ("name", 
"table_id", 
"column_id")
 VALUES ('uniq_myfirstmodule$contains_myfirstmodule$recipeid', 
'28d59810-72d0-4ee7-83c4-9ce925589cff', 
'8982c84e-ae01-3bcd-9edd-dff3a7ba3116');
UPDATE "mendixsystem$version"
 SET "versionnumber" = '4.2', 
"lastsyncdate" = '20181007 20:44:27';
