Feature: Home feed

	Scenario: Post feed works
		Given the user is on the home component
		Then posts load
		
		Scenario: Submit Post
		Given the user is on the home component
		And the user is loggedin
		And the user clicks post button
		When the user types post
		And the user clicks submit
		Then the post shows on the feed
		