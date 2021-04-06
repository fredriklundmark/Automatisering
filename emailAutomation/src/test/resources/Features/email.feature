Feature: Sign up testing
This feature outlines the testcases for different scenarios when attempting to sign up to the mailchimp webpage.
Successful creation. Long username(>100 characters). Taken username. Missing e-mail address.

  Background: 
    Given User is on Sign up page

  Scenario Outline: Sign up registration test
    When user enters "<EmailAddress>"
    And user selects a "<Username>"
    And user types a "<Password>"
    And user click on sign up button
    Then the "<Result>" will be shown

    Examples: 
    | EmailAddress  | Username        | Password | Result      |
    | successEmail  | successUsername | password | success     |
    | email2        | longUsername    | password | failLong    |
    | email3        | takenUsername   | password | failTaken   |
    | missingEmail  | username        | password | failMissing |
