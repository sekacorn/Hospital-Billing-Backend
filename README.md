# Hospital_Billing


# Technologies Needed:

1) Java Development Kit (JDK) installed on your machine (version 8 or higher).
2) Maven build tool installed on your machine.
3) Eclipse IDE (or any other Java IDE of your choice e.g Intellij) make sure its installed on your computer.
4) Make Sure MySQL or any other compatible relational database management system installed and running.
5) Internet connection to download dependencies from Maven repositories.

# Setting Up 


1) Clone the Repository:
   - Clone the repository containing the Hospital Billing Spring Boot application code to your local machine.

2) Import the Project in Eclipse:
   - Launch Eclipse IDE or IntelliJ.
   - Go to "File" -> "Import" -> "Existing Maven Projects".
   - Browse to the cloned repository directory and select the root folder of the project.
   - Click "Finish" to import the project into Eclipse.
   

3) Configure the Database:
   - Open the "src/main/resources/application.properties" file.
   - Modify the database connection properties according to your MySQL configuration.
   - Set the appropriate values for "spring.datasource.url", "spring.datasource.username", and "spring.datasource.password".

4) Build the Project:
   - Right-click on the project in Eclipse and select "Run As" -> "Maven Build".
   - In the "Goals" field, enter "clean install" and click "Run".
   - Maven will download the project dependencies and build the application.

5) Run the Application:
   - After the build is successful, right-click on the project in Eclipse and select "Run As" -> "Spring Boot App".
   - The Spring Boot application will start running and deploy the necessary endpoints.

6) Access the Application:
   - Open a web browser and enter the following URL: "http://localhost:8080" (assuming the default port 8080).
   - The application's homepage or API documentation should be displayed, indicating that the application is running successfully.

7) Interact with the Application:
   - Use an API testing tool like Postman to send requests to the available endpoints.
   - Refer to the API documentation or explore the source code to understand the available endpoints and their functionality.
   - You can perform operations such as creating patients, managing billing records, generating reports, etc.

8) Customize and Extend:
   - Explore the project structure and source code to understand the implementation.
   - Customize the application as per your requirements by modifying the existing code or adding new features.

------------------------------------------------------------------------------------------------------------------------

C'est tout! You have successfully set up and run the Hospital Billing Backend Spring Boot application. Feel free to explore and use the application according to your needs.

