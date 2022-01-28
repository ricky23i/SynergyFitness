Feature: Home feed

	Scenario: Post feed works
		Given the user is on the home component
		Then posts load
		
		Scenario: Submit Post
		Given the user is on the home component
		And the user is logged in
		When the user submits a valid post
		Then the post shows on the feed
		