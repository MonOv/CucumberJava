Feature: Magento Login
  This feature is to validate the login scenarios which includes
  1.Negative login scenario(wrong username and password)
  2.Empty username and password
  3.Positive login scenario

  Scenario Outline: Negative login
    Given I am able to navigate onto Magento homepage
    And i click on sign in link
    When I update the username as "<email>"
    And I update the password as "<pwd>"
    And I click on the continue button
    Then I should see the error message "<error>"

    Examples: 
      | email             | pwd     | error                      |
      | mona898@gmail.com | Welcome | Invalid Login or Password. |
      |                   | Welcome | This is a required field.  |
      | test@123.com      |         | This is a required field.  |
#Scenario Outline: Empty username
#Given I am able to navigate onto Magento homepage
#And i click on sign in link
#When I update the username as ""
#And I update the password as "Welcome"
#And I click on the continue button
#Then I should see the error message "A login and a password are reqiured."
