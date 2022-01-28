Feature: Login

Scenario: Log in Success
		Given the user is on loginpage
		When the user enter correct info
		Then The user logs in
		
Scenario: Log out
		Given the user is on loginpage
		And the user is logged in
		When the user clicks logout
		Then the user logs out 
		