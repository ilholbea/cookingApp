ALTER TABLE "myfirstmodule$contains" DROP CONSTRAINT "uniq_myfirstmodule$contains_myfirstmodule$recipeid";
DROP INDEX "idx_myfirstmodule$contains_myfirstmodule$recipelist_myfirstmodule$recipe";
ALTER TABLE "myfirstmodule$contains" RENAME TO "04d6d395bed74f44906c338c4cc13c3f";
DELETE FROM "mendixsystem$association" 
 WHERE "id" = 'c2d50158-0cc8-4a67-bafb-2b024944e300';
DELETE FROM "mendixsystem$unique_constraint" 
 WHERE "name" = 'uniq_myfirstmodule$contains_myfirstmodule$recipeid';
CREATE TABLE "myfirstmodule$contains" (
	"myfirstmodule$recipelistid" BIGINT NOT NULL,
	"myfirstmodule$recipeid" BIGINT NOT NULL,
	PRIMARY KEY("myfirstmodule$recipelistid","myfirstmodule$recipeid"));
CREATE INDEX "idx_myfirstmodule$contains_myfirstmodule$recipe_myfirstmodule$recipelist" ON "myfirstmodule$contains" ("myfirstmodule$recipeid" ASC,"myfirstmodule$recipelistid" ASC);
INSERT INTO "mendixsystem$association" ("id", 
"association_name", 
"table_name", 
"parent_entity_id", 
"child_entity_id", 
"parent_column_name", 
"child_column_name", 
"index_name")
 VALUES ('e57c1fad-39b4-4efc-8b55-d8187f3e224a', 
'MyFirstModule.Contains', 
'myfirstmodule$contains', 
'8457999a-d289-4153-96b9-c1bb6c27a25b', 
'1bca2a8e-931b-4cd2-8eb2-c5209655495c', 
'myfirstmodule$recipelistid', 
'myfirstmodule$recipeid', 
'idx_myfirstmodule$contains_myfirstmodule$recipe_myfirstmodule$recipelist');
DROP TABLE "04d6d395bed74f44906c338c4cc13c3f";
UPDATE "mendixsystem$version"
 SET "versionnumber" = '4.2', 
"lastsyncdate" = '20181007 23:39:27';
