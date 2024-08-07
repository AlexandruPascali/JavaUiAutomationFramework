Feature: Registration Flow

  Background:
    Given The Home page is accessed
    And RegisterOption is selected from the header drop-down

  @Smoke
  Scenario: Access the Account page after successful registration
    And the register form is populated with Valid data
    And Privacy Toggle is enabled
    When the Continue Button is clicked
    Then tha page url contains the "success" keyword

  @Obsolete
  Scenario: User remains on Register Page when registering without accepting the privacy rules
    And the register form is populated with Valid data
    When the Continue Button is clicked
    Then tha page url contains the "route=account/register&language=en-gb" keyword

  @run1 @Regression
  Scenario: User remains on Register Page when registering without completing the mandatory fields
    And Privacy Toggle is enabled
    When the Continue Button is clicked
    Then tha page url contains the "route=account/register&language=en-gb" keyword

  @Register
  Scenario Outline: Error message is displayed when firstName is too long
    And the register form is populated with the following data:
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | RanDom      |
      | password  | Random      |
    When the Continue Button is clicked
    Then the following error messages are displayed:
      | Warning: You must agree to the Privacy Policy!       |
      | <affectedField> must be between 1 and 32 characters! |
    Examples:
      | affectedField | firstName                                     | lastName                                      |
      | First Name    | qwertyuiopasdfghjklzxcvbnmasdfghjklqwertyuiop | random                                        |
      | Last Name     | random                                        | qwertyuiopasdfghjklzxcvbnmasdfghjklqwertyuiop |
