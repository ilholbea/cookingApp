ALTER TABLE "myfirstmodule$dsadqwxca" RENAME TO "581e8f4f336c45fc9f4ff3cc5dc6a711";
ALTER TABLE "myfirstmodule$recipe_image" DROP CONSTRAINT "uniq_myfirstmodule$recipe_image_myfirstmodule$dsadqwxcaid";
ALTER TABLE "myfirstmodule$recipe_image" DROP CONSTRAINT "uniq_myfirstmodule$recipe_image_myfirstmodule$recipeid";
DROP INDEX "idx_myfirstmodule$recipe_image_myfirstmodule$dsadqwxca_myfirstmodule$recipe";
ALTER TABLE "myfirstmodule$recipe_image" RENAME TO "29c40f26b0c9450eb6cd7c35a7beae8b";
DROP INDEX "idx_system$image_submetaobjectname_asc";
DELETE FROM "mendixsystem$entity" 
 WHERE "id" = '094ee9cd-314a-4ba2-bb8d-176175d67b52';
DELETE FROM "mendixsystem$entityidentifier" 
 WHERE "id" = '094ee9cd-314a-4ba2-bb8d-176175d67b52';
DELETE FROM "mendixsystem$sequence" 
 WHERE "attribute_id" IN (SELECT "id"
 FROM "mendixsystem$attribute"
 WHERE "entity_id" = '094ee9cd-314a-4ba2-bb8d-176175d67b52');
DELETE FROM "mendixsystem$attribute" 
 WHERE "entity_id" = '094ee9cd-314a-4ba2-bb8d-176175d67b52';
DELETE FROM "mendixsystem$association" 
 WHERE "id" = '35594930-4e55-4c69-972c-430ffd01b20a';
DELETE FROM "mendixsystem$unique_constraint" 
 WHERE "name" = 'uniq_myfirstmodule$recipe_image_myfirstmodule$dsadqwxcaid';
DELETE FROM "mendixsystem$unique_constraint" 
 WHERE "name" = 'uniq_myfirstmodule$recipe_image_myfirstmodule$recipeid';
ALTER TABLE "system$image" DROP COLUMN "submetaobjectname";
DELETE FROM "mendixsystem$attribute" 
 WHERE "id" = '272f49fe-6a64-3ede-a32d-344a34e57b9f';
DELETE FROM "mendixsystem$index" 
 WHERE "id" = '00a9ec1c-4fab-368f-83d4-ffa8ff501c8c';
DELETE FROM "mendixsystem$index_column" 
 WHERE "index_id" = '00a9ec1c-4fab-368f-83d4-ffa8ff501c8c';
DELETE FROM "system$image" 
 WHERE "id" IN (SELECT "id"
 FROM "581e8f4f336c45fc9f4ff3cc5dc6a711");
DELETE FROM "system$thumbnail_image" 
 WHERE "system$imageid" IN (SELECT "id"
 FROM "581e8f4f336c45fc9f4ff3cc5dc6a711");
DELETE FROM "system$filedocument" 
 WHERE "id" IN (SELECT "id"
 FROM "581e8f4f336c45fc9f4ff3cc5dc6a711");
DROP TABLE "581e8f4f336c45fc9f4ff3cc5dc6a711";
DROP TABLE "29c40f26b0c9450eb6cd7c35a7beae8b";
UPDATE "mendixsystem$version"
 SET "versionnumber" = '4.2', 
"lastsyncdate" = '20181009 00:17:25';
