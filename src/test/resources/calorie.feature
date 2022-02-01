Feature: Calorie Tracker

	Scenario: Calorie Displays
		Given the user is on the tracker component
		And the user is logged in
		Then tracker displays info
		
	Scenario: Add Calories
		Given the user is on the tracker component
		And the user is logged in
		When the user enters calories
		Then the appropiate msg appears 