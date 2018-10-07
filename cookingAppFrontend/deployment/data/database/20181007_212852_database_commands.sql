ALTER TABLE "myfirstmodule$search" RENAME TO "96967d9774184b1f8b573e238ef037a1";
DELETE FROM "mendixsystem$entity" 
 WHERE "id" = '0d852a1d-ca41-4aed-a7c6-3cfeadd88b7c';
DELETE FROM "mendixsystem$entityidentifier" 
 WHERE "id" = '0d852a1d-ca41-4aed-a7c6-3cfeadd88b7c';
DELETE FROM "mendixsystem$sequence" 
 WHERE "attribute_id" IN (SELECT "id"
 FROM "mendixsystem$attribute"
 WHERE "entity_id" = '0d852a1d-ca41-4aed-a7c6-3cfeadd88b7c');
DELETE FROM "mendixsystem$attribute" 
 WHERE "entity_id" = '0d852a1d-ca41-4aed-a7c6-3cfeadd88b7c';
DROP TABLE "96967d9774184b1f8b573e238ef037a1";
UPDATE "mendixsystem$version"
 SET "versionnumber" = '4.2', 
"lastsyncdate" = '20181007 21:28:46';
