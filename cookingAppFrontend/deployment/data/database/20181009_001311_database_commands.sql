ALTER TABLE "myfirstmodule$recipe_image" ADD CONSTRAINT "uniq_myfirstmodule$recipe_image_myfirstmodule$imageid" UNIQUE ("myfirstmodule$imageid");
INSERT INTO "mendixsystem$unique_constraint" ("name", 
"table_id", 
"column_id")
 VALUES ('uniq_myfirstmodule$recipe_image_myfirstmodule$imageid', 
'35594930-4e55-4c69-972c-430ffd01b20a', 
'36d83874-b3d6-3b64-8783-0ade51afb77d');
UPDATE "mendixsystem$version"
 SET "versionnumber" = '4.2', 
"lastsyncdate" = '20181009 00:13:10';
