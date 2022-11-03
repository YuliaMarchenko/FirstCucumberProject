Feature: Login

  @openLoginPage
  Scenario: Open Login Page
    Given Navigate to Home Page
    When Click on Login tab
    Then Appear LoginRegistration form

  @validData
  Scenario: Login with valid date
    Given Navigate to Home Page
    When Click on Login tab
    And Enter valid data
    And Click on login Button
    Then SingOut button displayed

  @invalidPassword
  Scenario Outline: Login with invalid password
    Given Navigate to Home Page
    When Click on Login tab
    And Enter valid email and invalid password
      | email   | password  |
      | <email> | <password> |
    And Click on login Button
    Then Alert appeared
    Examples:
      | email   | password  |
      | test102@test.com | 123        |
      | test102@test.com | test12_TES |
