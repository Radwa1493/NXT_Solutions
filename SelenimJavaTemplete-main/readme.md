Selenuim Project based on TestNG run on Chrome and display the result in Allure report .

Prerequest: 

1- Please update Json file with ur own data at "/src/main/java/Utilities/testdata.json"
2- Java version 22
3- Download " allure-2.30.0.zip"  and add its bin path to "Environment Variables".
https://github.com/allure-framework/allure2/releases
4-Download "apache-maven-3.9.9-bin.zip" and add its bin path to "Environment Variables".
https://maven.apache.org/download.cgi
.........................................
Project structure 

    ├── src/main/java/
    			├──TestCases
    			 ├──AppTest.java
                             ├──@BeforeTest setUp()-> (Open chrome and navigate to the URL )
                             ├──@Test Login()-> (Enter Credentials from the json file )
                             ├──@Test CreateEvent()
                             ├──@Test EditEvent()
                             ├──@Test CreatePackage()
                             ├──@Test CreateUser()
                             ├──@Test CreateTrip()
                             ├──@Test DeleteEvent()
    			├──Pages
    			  ├──AttendesstPage.java
    			  ├──Base.java
    			  ├──CreateEventPage.java
			  ├──EditEventPage.java
			  ├──EventPage.java
			  ├──LoginPage.java
			  ├──MainPage.java
			  ├──PackagePage.java
    			├──Utilities
   			  ├──testdata.json 
   			  ├──readJson.java
   			  ├──Generator.java
    ├──test-screenShot (save screenshot after each testcase)
    ├──test-recordings (save video for the run)
    ├──allure-results
    ├── pom.xml   
    ├── testng.xml  

Run project from testng.xml 
or 
Run from Command line :
1- On CMD : cd path of the project
2- On CMD : mvn test

Reporting + screenshot + recording
3- Allure report -> On CMD on path  \SelenimJavaTemplete-main> > allure serve
4- run screenshot saved \SelenimJavaTemplete-main\test-screenShot
5- run video saved \SelenimJavaTemplete-main\test-recordings

