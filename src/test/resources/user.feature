Feature: User information

	Scenario: User info displays
		Given the user is on the user component
		And the users is logged in
		Then user info displays
		
	Scenario: User updates profile
		Given the user is on the user component
		And the users is logged in
		When the user changes info
		Then the appropiate update msg appears 