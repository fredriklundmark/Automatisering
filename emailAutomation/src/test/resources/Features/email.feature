Feature: Email Registration

  Background: 
    Given User is on Sign up page

  Scenario Outline: Sign up registration outline
    When user enters "<EmailAddress>"
    And user selects a "<Username>"
    And user types a "<Password>"
    And user click on sign up button
    Then the "<Result>" will be shown

    Examples: 
      | EmailAddress  | Username        | Password | Result      |
      | successEmail  | successUsername | password | success     |
      | email2        | LongUsername    | password | failLong    |
      | email3        | TakenUsername   | password | failTaken   |
      | Missing email | username        | password | failMissing |
