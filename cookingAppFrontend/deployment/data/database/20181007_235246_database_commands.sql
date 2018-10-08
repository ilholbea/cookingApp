DROP INDEX "idx_myfirstmodule$contains_myfirstmodule$recipe_myfirstmodule$recipelist";
ALTER TABLE "myfirstmodule$contains" RENAME TO "ac83bcfefd7146788700c2faf782ccfc";
DELETE FROM "mendixsystem$association" 
 WHERE "id" = 'e57c1fad-39b4-4efc-8b55-d8187f3e224a';
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
 VALUES ('26364c0c-8b74-4aa2-92d8-d7ae433d1829', 
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
'26364c0c-8b74-4aa2-92d8-d7ae433d1829', 
'8e83cd07-697f-3d77-9cf3-185778abbddc');
DROP TABLE "ac83bcfefd7146788700c2faf782ccfc";
UPDATE "mendixsystem$version"
 SET "versionnumber" = '4.2', 
"lastsyncdate" = '20181007 23:52:41';
