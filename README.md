#####Mendix Assignment
#Simple Cooking App
######Ionut-Laurentiu Holbea



##Overall application architecture
The application has multiple parts: 
1. `BACKEND` - developed using `Java` and `Spring Boot`
2. `FRONTEND` - developed using `Mendix Desktop Modeler`
3. `PERSISTANCY` - the database that I've used is a `PostgreSQL` database hosted on cloud using `AWS RDS`.
I first started the development with a `H2` in-memory database, but I wanted to add a bit more functionality to the app,
so I switched to a cloud DB.

###Folder Structure
The `BACKEND` of the application resides in the `cookingAppBackend` folder. 
It contains the src folder with the application and three `.bat` files that are explained in the `How to Run` section.

The `FRONTEND` of the application resides in the `cookingAppFrontend` folder. Given the fact that I didn't find the 
`Export Package` functionality of the Modeler until later in the development, I've added the entire working directory
of the `FRONTEND`. 

Besides these two folders in the root folder there is another one, `Generated Objects`. It contains, a .jar with the 
backend functionality, an application.properties used by Spring Boot to run the application, a .mpk file (the interface
developed in Mendix) and a `.bat` file. These are used to run the application. More info in the `How to Run` section.

##Prerequisites 
In order to run the application you need the following tools:
1. Latest JDK installed
2. JAVA_HOME Environment Variable set
3. Mendix Modeler

##How to Run
In the `Generated Objects` folder I've provided all the necessary objects in order to start the application.
Starting the `BACKEND` is easy, simply execute the run.bat script file. This calls `java -jar %JARNAME%` and uses the 
`application.properties` to connect to the database.

In order to start the `FRONTEND` you have to import the `.mpk` in the Mendix Modeler and simply `Run Locally`. After
the building is complete you can click the `View`(at the top of the application) to open the `FRONTEND`.


##How to Build
If you want to build the `BACKEND` `.jar` yourself, all you have to do is to go to `cookingAppBackend` folder. 
Here you will find the 3 `.bat` files that I've mentioned earlier. Let's take them one by one:
1. `run.bat` - it's similar to the `run.bat` from the `Generated Objects` folder, but with different paths.
2. `test.bat` - using the `mvnw` (Maven wrapper) it runs the `mvn test` command, to start testing the applications
3. `install.bat` - using the `mvnw` (Maven wrapper) it runs the `mvn clean install` command, that clears the `target`
folder, runs the tests and the builds the `.jar`. The generated `.jar` is gonna be in the `target` folder.


##How to Use
After everything was executed correctly and the application started, both `FRONTEND` and `BACKEND`, a login screen will
appear. The username is `MxAdmin` and the password is `1`. Using Mendix Security `Demo/Prototype` functionality I've added
two types of users `Chef` and `User` to help see the functionality of the pages.

Let's take the application page by page and explain what functionality each type of user has access to:
1. `Homepage` 
- it's a dashboard with all the recipes in the database. It contains a list of cards for each recipe. 
Each cards consists of title, description, a section for ingredients, a section with the steps and the categories for 
that recipe. 
    * For the `Chef`, three buttons will be available here :  `View Recipe`, `Edit Recipe`,`Delete`.
    * For the `User`, only the `View Recipe` button will be available. This will redirect us to the `Recipe Details` page.
- at the top of the `Homepage` there are two buttons, `Create Recipe` and `Search`
    * For the `Chef`, both buttons will be available
    * For the `User`, only the `Search` button will be available
- default number of shown elements is five, to load more, click on the `Load More` button at the bottom of the page.
     
2. `Create Recipe`
- it's a page that helps the `Chef` to add new recipes. It contains fields for every entity of the recipe.
- this page is only available to the `Chef`

3. `Recipe Details` 
- on this page you can get either using the `View Recipe` or the `Edit Recipe` button. The difference is that, when 
coming from the `View Recipe` button, the data is not editable. It's used for the `User`, but the `Chef` also has access
to it, to see how does the newly created recipe look to the `User`.

4. `Search Recipe`
- hitting the `Search` button or navigating from the top of the page to the 'Search' takes us to the `Search Recipe`.
- it contains as input for category, a `Search` button and a `Cancel` button, that redirects us to the `Homepage`. 
- when clicking `Search` an API call that returns a list of recipes filtered by category is returned and we're redirected
to the `Results Page`.
- if the list is empty a warning message will appear.


5. `Results Page`
- is similar to the `Homepage` but with the recipes list filtered by the selected category.


#####Functionalities by user type:
`Chef`:
*  Create recipe
*  Delete recipe
*  Edit recipe
*  View recipe
*  Search recipe by category
*  View recipe list

`User`:
*  View recipe
*  Search recipe by category
*  View recipe list


##Implementation

######BACKEND
The `BACKEND`, as said above, is developed using `Java` and `Spring Boot`.
It consists of `Controllers`, `Services`, `Entities`, `Exceptions`, `Repositories` and `Tests`.

The mapping for each `http` request is done in the controllers, then the information is sent to the service implementation.
In the service implementation I `@Autowire` the repository that extends `JpaRepository`. In the repository I've created some
custom querys to retrieve the data in the way that I needed it. 
When a recipe was not found I threw a `RecipeNotFoundException` with a specific message.

In the `test` folder of the `BACKEND` you can find the tests for `Controllers`, `Services` and `Repositories`. You can run them
either using the `mvn test`, provided you have the Maven installed, or using the `test.bat` script that I've provided.

The steps, ingredients and categories are stored not as list of strings, but as simple strings. Why I've decided to use them like these?
Because let's assume that the `CHEF` want to create a recipe really fast, copying some information from the internet. With the list, he would
have to click an `Add Ingredient/Step` for each new line of the recipe. With the elements stores as strings, he can simply copy-paste the recipe
and format it as he wants.

######FRONTEND
The `FRONTEND` was developed using the `Mendix Desktop Modeler`. I've created the needed pages.
In order to get that from the `BACKEND API` I've created microflows as needed.
The users are created using the Security module with `Demo/Prototype` option. That way you can login with a master password
and switch between the users to see how each page changes.




PS:
A visible API Documentation can be found at: 
https://documenter.getpostman.com/view/5293766/RWgp2KgW#ddc12663-cc71-4223-b7aa-c0721127a8f0 

I've generated it using POSTMAN. 








