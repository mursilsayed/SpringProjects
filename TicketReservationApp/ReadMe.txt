--------------------------------------------------------
1-Instructions to install and configure prerequisites or dependencies
--------------------------------------------------------
-Internet connection is needed for building the application for the first time. 

	This application uses Gradle for building the application. It
	requires an internet connection for downloading all the project prerequisites or dependencies. 

	If you are behind a proxy then please uncomment the http_proxy settings in gradle.properties file and update it with your proxy server settings

-Give execute permissions to gradlew

-Run the following command to create an eclipse project 

    ./gradlew eclipse




--------------------------------------------------------
2. Instructions to create and initialize the database
--------------------------------------------------------

-For running this app, you will need to setup MySql Database server and
create a new database 'AirlineTicketReservation'. Also create a new user 'AirlineTicketManager' and assign schema rights for the newly created database. 

Update the datasource url and username, password in the 'application.properties' file that is placed under the resources folder. 


Open the console and go to the project folder. Use the following gradle command to build the application. 
	
	gradle build

building the application using gradle will trigger the unit tests which will 
test database connectivity and will throw error in case of any problem.


--------------------------------------------------------
3. Important Assumptions
--------------------------------------------------------
-Some Flight and Flight details records  are entered by the application at the launch time to showcase the functionality of the application. In production system, Flight information and Flight Details are entered into the system via backoffice interface. 


-Only Outgoing flights are displayed to the staff

-UI is developed for meeting the functional requirements only. Only primitive controls and navigation is used. Actual UI development involves a lot of work and iterations for ensuring optimal user experience. 

-Although typically Reservation and Booking are seperate terms, to keep the system simple, Ticket reservation and Booking in this application means that ticket has been purchased via credit Card. 








--------------------------------------------------------
4. Requirements that are not covered in the implementation
--------------------------------------------------------








--------------------------------------------------------
5. Instructions to configure and prepare the source code to build and run properly
--------------------------------------------------------







--------------------------------------------------------
6. Issues faced while completing the assignment
--------------------------------------------------------

Havent worked on a single Page application so took some time to setup the ui. 





--------------------------------------------------------
7. Feedback for improving the assignment 
--------------------------------------------------------
1- Seperate time should be given for Designing and Documentation.

