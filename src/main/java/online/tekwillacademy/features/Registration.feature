Feature: Registration Flow

  @Smoke
  Scenario: Access the Account page after successful registration
    Given The Home page is accessed
    And RegisterOption is selected from the header drop-down
    And the register fom is populated with Valid data
    And Privacy Toggle is enabled
    When the Continue Button is clicked
    Then tha page url contains the "success" keyword

  @Obsolete
  Scenario: User remains on Register Page when registering without accepting the privacy rules
    Given The Home page is accessed
    And RegisterOption is selected from the header drop-down
    And the register fom is populated with Valid data
    When the Continue Button is clicked
    Then tha page url contains the "route=account/register&language=en-gb" keyword

  @run1 @Regression
  Scenario: User remains on Register Page when registering without completing the mandatory fields
    Given The Home page is accessed
    And RegisterOption is selected from the header drop-down
    And Privacy Toggle is enabled
    When the Continue Button is clicked
    Then tha page url contains the "route=account/register&language=en-gb" keyword
