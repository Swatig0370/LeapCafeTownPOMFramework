# LeapCafeTownPOMFramework
Automation Framework of Anugularjs CafeTown Web Application  is based on Selenium Page Object Model framework in Java.
Using TestNG, Maven, Jenkins and git.

AUT URL: http://cafetownsend-angular-rails.herokuapp.com/login

Main Features:
1. Login Page
2. Home Page
3. Create Employee
4. Edit Employee
5. Delete Employee
6. Logout

In the POM framework every page of the application has a corresponding page repository class and test class. 
Page repository includes details of the web elements and methods on that particular page, it help in encapsulating 
the page methods from test methods. Whereas, test class are consist of test cases corresponding to the pages of the application. 

There are various advantages of implementing POM framework, Such as, easy to maintain, reusable, readable and easily understandable. 
It also supports various type of file format, such as, Excel, CSV, txt and Database, which can be used as external file for providing 
the Test data to the automated test cases. 

This framework is compatible with most of the continuous development and integration tools, such as Jenkins.

