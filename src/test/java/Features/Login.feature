Feature: Login test cases

  Scenario: Login with valid credentials
    Given User launch browser and open Hudl main page
    And User clicks Login button link
    And User enters Email as "yuriilevytskyi@gmail.com" and Password as "aHVkbFByb2plY3QxIQ=="
    When User clicks Login button
    Then User see home page
    And User see first name "Yurii L" and email "yuriilevytskyi@gmail.com"

  Scenario Outline: Login with invalid credentials
    Given User launch browser and open Hudl main page
    And User clicks Login button link
    And User enters Email as "<email>" and Password as "<password>"
    When User clicks Login button
    Then User see error message
    Examples:
      |           email          |   password  |
      | yuriilevytskyi@gmail.com |   dGVzdA==  |
      | yuriilevytskyi@gmail.com |             |

  Scenario: User can navigate to "Log In with an Organization" and back
    Given User launch browser and open Hudl main page
    And User clicks Login button link
    When User clicks Log In With an Organization
    And User clicks Log In With Email and Password button

  Scenario: Sign Up link
    Given User launch browser and open Hudl main page
    And User clicks Login button link
    When User click Sign up link
    Then User landed in Sign up page

  Scenario: Password reset: Happy Path
    Given User launch browser and open Hudl main page
    And User clicks Login button link
    And User clicks Need help button
    And User enters email "test@test.com"
    When User clicks Send Password Button
    Then User see Check Your Email page

  Scenario Outline: Password reset: email doesn't exist
    Given User launch browser and open Hudl main page
    And User clicks Login button link
    And User clicks Need help button
    And User enters email "<email>"
    When User clicks Send Password Button
    Then User see password reset error message "<error message>"
    Examples:
      |   email                   |    error message   |
      | svsdfgdfgvsd@safas.adsfas | That email address doesn't exist in Hudl. Check with your coach to ensure they have the right email address for you. |
      | svsdfgdfgvsd              | That isn't a valid email address. Make sure to use the email@domain.com format.                                      |

  Scenario: User can navigate to Home page
    Given User launch browser and open Hudl main page
    And User clicks Login button link
    When User clicks Hudl logo
    Then User verifies home page is open