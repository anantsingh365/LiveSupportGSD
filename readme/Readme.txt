
Problem Statement :  Live Support GSD 
Website           : "https://be.cognizant.com/"
---------------------------------------------------------------------

-> To Display the list under All the headers present in live support GSD application after choosing a country.

Steps:

1)  Launch any browser (In this code we have used Chrome browser and Firefox browser). 
2)  Goto “https://be.cognizant.com/”. 
3)  Enter your Cognizant Email and password .
4)  Choose the call option and accept the call. (It will take the user to 'be.cognizant' Page)
5)  Search text box type "GSD" then Press Enter Button.
6)  Choose the 'Live support GSD Global' option.(It will take the user to Live Support-GSD Page)
7)  Get the country name from user and the select that country from Drop-Down List at the Top-Right.
8)  Take the List under all the headers present  in the Live Support Page and Print it in the console along with the appropriate header name. 


Folders
----------------------------------------------------------------------

1) src/test/java
       i)   dataTables
            -GSDInputsOutputs.xlsx 
            -Config.properties
        
       ii)  testObjectRepository
            -GSDPage.java
            -HomePage.java
            -SignUpPage.java

       iii) testScenarios
            -LiveSupportGSD.java

       iv)  userDefinedLibraries
            -DriverSetup.java
            -ExcelReadWrite.java
            -ExplicitWait.java
            -ExtentReportManager.java
            -PropertiesLoad.java
            -PropertiesRead.java
            -ScreenShot.java

2) Drivers
   i)  chromedriver.exe
   ii) geckodriver.exe

3) Extent Reports- (extent report saved here)
      
     
4) Screenshots- (Screenshot saved here)



Data Driven Concepts
-----------------------------------------------------------------------
1) Properties File (Reading Data)

   * (Config.properties)- This properties file is present in        
   * This file consits of Browser name,URL value and Login credentials.


2) Excel File (Reading & Writing data)

   1. (GSDInputsOutputs.xlsx)- This Excel file is present in    

      * Sheet 1: The Search text , Frame Name and Country name are read from this file
      * Sheet 2: User Name and Designation are Written to this file.
      * Sheet 3: The GSD Header and list after applying appropriate Country are written to this file.




Key Automation Scope
-------------------------------------------------------------------------

-> Locating elements precisely.
-> Using appropriate synchronization technique.
-> Extracting Header & list in collections
-> Taking Screenshots for each steps.


Technology/Automation Tools Used
-------------------------------------------------------------------------
1) Selenium Webdriver and it's concepts.
2) TestNG framework and it's concepts.
3) Data Driven approach
4) Core Java Concepts
5) Page Object Model/Page Factory Concepts
6) Maven/Apache POI tools
7) Extent Report/ TestNG Report
8) Cross Browser testing concepts
9) Property file Concepts


                                  
 IMPORTANT NOTE:
                                                            
                                  

    -> For multiple browsers (chrome and Firefox), The browser name is read from 'Config.properties' file
    -> If you want to use chrome browser, please go to 'Config.properties' file and set browser name as 'chrome'.
    -> If you want to use firefox browser, please go to 'Config.properties' file and set browser name as 'firefox'.
    -> Go to property file , Enter your cognizant Email  for the "email"  value and Enter your Password for the "password" value.
    -> Then execute the Test.


 
     

   