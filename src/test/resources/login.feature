Feature: logging in as a user

  Scenario Outline: logging in with correct credentials
    Given the user is on the login page
    And the user clicks the Log In Link
    When the user enters "<username>" and "<password>" to log in
    And the user clicks the submit button
    Then the navbar says "<username>"

    Examples: 
      | username | password  |
      | ricky23i | 123456789 |
      | user23   | 123456789 |
      | CDS      | 123456789 |
      | ponce    | 123456789 |
      | carlo    |  12345789 |
      | noob1    | noob2     |

  Scenario Outline: logging in with incorrect passwords
    Given the user is on the login page
    And the user clicks the Log In Link
    When the user enters "<username>" and "<password>" to log in
    And the user clicks the submit button
    Then the page says Incorrect Credentials

    Examples: 
      | username | password   |
      | ricky23i | 1234567899 |
      | ricky23i |   12345789 |
      | ricky23i |       1234 |

  Scenario Outline: logging in without filling fields
    Given the user is on the login page
    And the user clicks the Log In Link
    When the user enters "<username>" and "<password>" to log in
    And the user clicks the submit button
    Then the page says Incorrect Credentials

    Examples: 
      | username | password  |
      |          | 123456789 |
      | ricky23i |           |
      |          |           |
