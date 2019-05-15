# Springboot Starter

This project is intended to create a log in / sign up page using springMVC, mybatis and mysql database. 

## How to use this

1. Create a mysql database called loginSys locally and set up a table called login including 2 columns (email and password).
2. Fill the table with several rows for testing.
3. Change the applications.properties file to your local mysql information
4. Run the program, visit http://localhost:9095
5. There are two buttons showing on the screen, both of them are connected to controller. The first one will show all
users in the db, the second one will update the db.

## Principle

HttpRequest --> Controller --> Service Layer --> DAO(Mapper) --> Database

All html files are placed under templates folder, in the controller, the requestmapping("/") will direct to
index.html(main page) through thymeleaf.

