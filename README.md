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

Background 
The owner of café Townsend has needed a website created. The owner contacted a third-party developer and they created the following site (http://cafetownsend-angular-rails.herokuapp.com/login). The owner is a bit IT savvy and has realised that they need to make sure that the website works as it should and contacts yourself (a professional QA Engineer) to ensure that what they got from the third-party developer is what they want. The problem is, the owner isn’t as savvy as they think and when you ask them what they wanted, they weren’t sure and comes back with the old line of “you’re the expert, you tell me”. 

1.	Task 1 
After the quick meeting with the owner, you decide to work out – based off your experience – how the website should function. What would you need to do to assure quality for the website? Include recommendations. 
1.	Types of Testing:
  1.1.	Functional Testing
  1.2.	UI Testing
  1.3.	Cross browser Testing
2.	Test Specification:
  1)	Validate the User Interface of the application. 
  2)	Validate the functionality of the application on Firefox, Chrome and IE browsers.
  3)	Validate the Login Functionality, valid user name and password.
  4)	Validate the Home page.
    a)	Username should be displayed on the top left corner of the page.
    b)	Logout button should be displayed on the top right corner of the page.
    c)	“Create, Edit and Delete” buttons should be displayed in the middle of the page.
    d)	Create button should be enabled.
    e)	Edit and Delete button should be disabled at the time of page load.
    f)	Edit and Delete button should get enabled when a record is selected.
  5)	Validate the “Create” functionality, 
    a)	Validate that on the click of “Create” button a form should get open, with six web elements with below labels 
        i)	Cancel – Button at top left corner
        ii)	First name – Label and Textbox
        iii)	Last name – Label and Textbox
        iv)	Start date – Label and Textbox
        v)	Email – Label and Textbox
        vi)	Add – Button at the bottom
    b)	Validate the “First name” textbox;
        i)	It should accept only Alphabets, 
        ii)	It should not accept any Numeric and Special character.
        iii)	It should not be left blank.
        iv)	Error message should be provided respectively.
        v)	Max character length
    c)	Validate the “Last name” textbox
        i)	It should accept only Alphabets, 
        ii)	It should not accept any Numeric and Special character.
        iii)	It should not be left blank.
        iv)	Error message should be provided respectively.
        v)	Max character length
    d)	Validate the “Start Date” textbox; 
        i)	It should take the data in “YYYY-MM-DD” format.
        ii)	Tool tip should be displayed for the format.
        iii)	It should not be left blank. 
        iv)	Max character length
    e)	Validate the “Email” textbox;
        i)	It should take the data in Alpha-numeric characters 
        ii)	“@” special character should be mandatory.
        iii)	It should not accept any other special character.
        iv)	Tool tip should be given for the email format. Such as “Please include “@” in the email address….”
        v)	It should not be left blank.
        vi)	Max character length
        f)	Validate the “Add” functionality on the new employee form, after adding the details and clicking on the Add button, user    should be redirected to the home page and new record should be added record at the end of the page.
  6)	Validate the “Edit” functionality.
      a)	Edit button should get enable after selecting a name of the employee/record.
      b)	Validate that on the click of “Edit” button a form should get open, with seven web elements with below labels.
          i)	Back – Button at top left corner
          ii)	First name– Label and Textbox
          iii)	Last name– Label and Textbox
          iv)	Start date– Label and Textbox
          v)	Email– Label and Textbox
          vi)	Update -Button at the bottom
          vii)	Delete – Button at the bottom
      c)	Validate that on the click on “Back” button, user is redirected to the home page.
      d)	Validate the “First name” textbox is enabled;
          i)	It should accept only Alphabets, 
          ii)	It should not accept any Numeric and Special character.
          iii)	It should not be left blank.
          iv)	Error message should be provided respectively.
      e)	Validate the “Last name” textbox is enabled
          i)	It should accept only Alphabets, 
          ii)	It should not accept any Numeric and Special character.
          iii)	It should not be left blank.
          iv)	Error message should be provided respectively.
      f)	Validate the “Start Date” textbox is enabled 
          i)	It should take the data in “YYYY-MM-DD” format.
          ii)	Tool tip should be displayed for the format.
          iii)	It should not be left blank.
      g)	Validate the “Email” textbox is enabled;
          i)	It should take the data in Alpha-numeric characters 
          ii)	“@” special character should be mandatory.
          iii)	It should not accept any other special character.
          iv)	Tool tip should be given for the email format. Such as “Please include “@” in the email address….”
           v)	It should not be left blank.
      h)	Validate “Update” button functionality; on click of “Update” button user should be redirected to home page and updated record should be displayed at the end of the home page.
      i)	Validate that on the click on “Delete” button, confirmation pop-up should appear with message “Are you sure you want to delete <select record name>?” followed by “Ok” and “Cancel” buttons.
          i)	Validate that on click of “OK” button on the confirmation pop-up, the record should get deleted from the list on the home page.
          ii)	Validate that on click of “Cancel” button on the confirmation pop-up, the record should NOT get deleted from the list on the home page.
  
	7)	Validate the “Delete” functionality:
      a)	Validate that the “Delete” button get enabled after selecting the record.
      b)	Validate that on the click of delete button confirmation pop-up should appear with message “Are you sure you want to delete <select record name>?” followed by “Ok” and “Cancel” buttons.
      c)	Validate that on click of “OK” button on the confirmation pop-up, the record should get deleted from the list on the home page.
      d)	Validate that on click of “Cancel” button on the confirmation pop-up, the record should NOT get deleted from the list on the home page.
  
	8)	Validate the Logout functionality, on click of the Logout button user should be redirected to the Login page.

3.	Recommendations:
    
		1.	Home page should have heading. For instance, “Employee details” or “List of Employees”. So that it gives a clear picture about the displayed information.
    
		2.	There should be unique identity of the records such as, Employee ID. To make the records searchable and maintainable. As we can see that there are two different records of employee having same name, this will create an issue while updating or deleting the record.
    
		3.	Number of records should be displayed at the bottom of the page, to make it easy to traverse between the records.   
    
		4.	Search functionality should be added to make the application more user-friendly.
    
		5.	Heading should be provided on the Create, delete and edit pages, 
    
		6.	Create Page: 
        6.1.	Error messages need to be more meaning full. Such as, for invalid start date message should be “Invalid Date: Please enter a valid date in “YYYY-MM-DD” format.” as of now application is giving “Error trying to create a new employee: {"start_date":["can't be blank"]})” this error message, which is incorrect. 
        6.2.	Confirmation message should be provided for the add action.
    
		7.	Edit Page: 
        7.1.	Alert pop should appear for the back and Update action to get the confirmation. 
    
		8.	Confirmation message should be provided for the Edit and delete action, user should get the confirmation message for both the tasks.
    
		9.	Password functional can be added for the delete action to avoid the accidently mistakes of deleting records.
    
		10.	Logout message should be provided to make the application User-friendly.
 
2.	Task 2 
    Upon finishing the first task, you realise that this website is automate-able. Use open source frameworks to automate the website. Keep in mind, that you are a professional QA Engineer and you should be adhering to developing code using design pattern(s) and technique(s) to make your code maintainable (hint: think unit tests). You should also be developing code that can be tied to Continuous Delivery infrastructure.

Solution: As per the analysis of the Café Town application, Selenium Page Object Model framework has been implemented. In POM framework  every page of the application has a corresponding page repository class and test class. Page repository includes details of the web elements and methods on that particular page to encapsulate the page methods from test methods. Whereas, test class will be consist of test cases corresponding to the pages of the application. By implementing this framework, we get the advantages of the POM, which are easy to maintain, reusable, readable and easily understandable, for instance, if in future there are any changes in the web elements than only one page needs to be updated instead of all the page which are using that web element. POM also supports various type of file format, such as, Excel, CSV, txt and Database, which can be used as external file for providing the Test data to the test cases. This framework is compatible with most of the continuous development and integration tools, such as Jenkins.

Technology stacks:
  
	Automation Framework		: Selenium – Page Object Model

	Programming Language		: Java
  
	IDE				              : Eclipse
  
	Testing framework		    : TestNG
  
	Build Management 		    : Maven
  
	Subversion Tool			    : Git/GitHub
  
	CD/CI Tool			        : Jenkins
  
	Browser			            : Google Chrome and Firefox
 
 Github Location: https://github.com/Swatig0370/LeapCafeTownPOMFramework.git
 
 
