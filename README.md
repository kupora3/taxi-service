# taxi-service
## Description
This project is simple implementation of a web app called taxis-services. An application requires a registration and authentication.
Main constration during development was from the backend side.
## What you can do
After registration / login you can: 
1. Create a new car
2. View all cars
3. View all drivers
4. View all manufacturers
5. Create a new manufacturer
6. Add driver to car
7. Show all our cars

## How to install a project
### Follow next steps:
1. Install and configure TomCat (supported version is 9.0.46 or earlier)
2. Install MySQL Workbench
3. Create a new schema in your workbench
   ```
   CREATE SCHEMA `new_schema` ;
   ```
4. Copy all from init_db.sql and paste to your Query

Example:

<img src="http://joxi.net/Dr8Y1B8TMGaazm.jpg" width="750">

5. Configure ConnectionUtil with your parameters
```
public static final String URL = "jdbc:mysql://localhost:3306/library_db?"
            + "useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USERNAME = "YOUR_USERNAME";
    public static final String PASSWORD = "YOUR_PASSWORD";
    public static final String JDBC_DRIVER = "YOUR_DRIVER";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find SQL Driver", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        Properties dbProperties = new Properties();
        dbProperties.setProperty("user", USERNAME);
        dbProperties.setProperty("password", PASSWORD);
        return DriverManager.getConnection(URL, dbProperties);
    }
```
6. Run the project
## How to use a project
When you run this project, you get to log in page.
First of all, you can register a new account, to do that tap the button ``` register ``` near the login form, fill the form, after you may log in with your account. In front of you will be the main page with the main menu. Just read the text and you will understand anything.
Good luck :)
## Used technologies
Project built:
1. JDBC
2. Servlets
3. JSP
4. JSTL
5. HTML, CSS
6. Tomcat

DB:
1. MySQL

Testing:
1. JUnit
2. Mockito

Logging:

1. Log4j2
