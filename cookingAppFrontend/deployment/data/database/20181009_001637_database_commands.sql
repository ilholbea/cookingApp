ALTER TABLE "myfirstmodule$recipe_image" DROP CONSTRAINT "uniq_myfirstmodule$recipe_image_myfirstmodule$recipeid";
ALTER TABLE "myfirstmodule$recipe_image" DROP CONSTRAINT "uniq_myfirstmodule$recipe_image_myfirstmodule$imageid";
DROP INDEX "idx_myfirstmodule$recipe_image_myfirstmodule$image_myfirstmodule$recipe";
ALTER TABLE "myfirstmodule$image" RENAME TO "myfirstmodule$dsadqwxca";
UPDATE "system$image"
 SET "submetaobjectname" = 'MyFirstModule.dsadqwxca'
 WHERE "submetaobjectname" = 'MyFirstModule.Image';
UPDATE "system$filedocument"
 SET "submetaobjectname" = 'MyFirstModule.dsadqwxca'
 WHERE "submetaobjectname" = 'MyFirstModule.Image';
UPDATE "mendixsystem$entity"
 SET "entity_name" = 'MyFirstModule.dsadqwxca', 
"table_name" = 'myfirstmodule$dsadqwxca', 
"superentity_id" = '37827192-315d-4ab6-85b8-f626f866ea76'
 WHERE "id" = '094ee9cd-314a-4ba2-bb8d-176175d67b52';
ALTER TABLE "myfirstmodule$recipe_image" ALTER COLUMN "myfirstmodule$imageid" RENAME TO "myfirstmodule$dsadqwxcaid";
CREATE INDEX "idx_myfirstmodule$recipe_image_myfirstmodule$dsadqwxca_myfirstmodule$recipe" ON "myfirstmodule$recipe_image" ("myfirstmodule$dsadqwxcaid" ASC,"myfirstmodule$recipeid" ASC);
ALTER TABLE "myfirstmodule$recipe_image" ADD CONSTRAINT "uniq_myfirstmodule$recipe_image_myfirstmodule$recipeid" UNIQUE ("myfirstmodule$recipeid");
ALTER TABLE "myfirstmodule$recipe_image" ADD CONSTRAINT "uniq_myfirstmodule$recipe_image_myfirstmodule$dsadqwxcaid" UNIQUE ("myfirstmodule$dsadqwxcaid");
DELETE FROM "mendixsystem$unique_constraint" 
 WHERE "name" = 'uniq_myfirstmodule$recipe_image_myfirstmodule$imageid';
DELETE FROM "mendixsystem$unique_constraint" 
 WHERE "name" = 'uniq_myfirstmodule$recipe_image_myfirstmodule$recipeid';
INSERT INTO "mendixsystem$unique_constraint" ("name", 
"table_id", 
"column_id")
 VALUES ('uniq_myfirstmodule$recipe_image_myfirstmodule$dsadqwxcaid', 
'35594930-4e55-4c69-972c-430ffd01b20a', 
'36d83874-b3d6-3b64-8783-0ade51afb77d');
INSERT INTO "mendixsystem$unique_constraint" ("name", 
"table_id", 
"column_id")
 VALUES ('uniq_myfirstmodule$recipe_image_myfirstmodule$recipeid', 
'35594930-4e55-4c69-972c-430ffd01b20a', 
'41061bc1-dea3-378a-b34a-b5d22c095380');
UPDATE "mendixsystem$association"
 SET "association_name" = 'MyFirstModule.Recipe_Image', 
"table_name" = 'myfirstmodule$recipe_image', 
"parent_entity_id" = '1bca2a8e-931b-4cd2-8eb2-c5209655495c', 
"child_entity_id" = '094ee9cd-314a-4ba2-bb8d-176175d67b52', 
"parent_column_name" = 'myfirstmodule$recipeid', 
"child_column_name" = 'myfirstmodule$dsadqwxcaid', 
"pk_index_name" = NULL, 
"index_name" = 'idx_myfirstmodule$recipe_image_myfirstmodule$dsadqwxca_myfirstmodule$recipe'
 WHERE "id" = '35594930-4e55-4c69-972c-430ffd01b20a';
UPDATE "mendixsystem$version"
 SET "versionnumber" = '4.2', 
"lastsyncdate" = '20181009 00:16:36';
