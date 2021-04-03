Feature: Email Registration

  Background: 
    Given User is on Sign up page

  Scenario Outline: Sign up registration outline
    When user enters <EmailAddress>
    And user selects a <Username>
    And user types a <Password>
    And user click on sign up button
    Then the result will be shown

    Examples: 
      | EmailAddress | Username  | Password  |
      | email1       | username1 | password1 |
      | email2       | username2 | password2 |
      | email3       | username3 | password3 |
      | email4       | username4 | password4 |

