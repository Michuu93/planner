# Meeting Planner

A simple web application in Java.

### Technical description

The application was built in IntelliJ IDEA with API Java EE. I used the MVC design pattern:

Model (Java Class), View (JSP), Controller (Java Servlet).

Views were created using:

- HTML (JSP)
- JSTL
- CSS (Bootstrap)
- JavaScripts (Bootstrap, jQuery, Transition, Moment)

The controller was created using a Java Servlet. I used the Hibernate framework to connect to the database.

### Instruction

1. What do you need:

	a) Apache Tomcat Server (I use Tomcat 9.0.0.M19)

	b) MySQL Database (I use MySQL Server 5.7)
    
    
2. Run the application:

3. Put the WAR folder in the directory „\webapps” on the server.

	e.g „C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\”
    

4. Create database from schema „databaseSchema.sql”.

5. Create a database user:

	Login: user

	Password: password

	Or change the login information in the file "hibernate.cfg.xml".
    

4. Run Tomcat Server.

5. Run MySQL Server.

6. Go to the website "http://localhost:8082/WarFolder/".

	Port "8082" may be different depending on your server configuration.