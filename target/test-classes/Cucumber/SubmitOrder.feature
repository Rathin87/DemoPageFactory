#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Purchase the order from ecommerece

Background:
Given I landed on the Ecommerce page 

  @Smoke
  Scenario Outline: Positive test of purchasing the order
    Given Login  with UserName <name> and Password <password>
    And click on the Submit Buttton
    When I add the Product <productname > to cart
    And Check out the Product <productname> by clicking submit button and  by selecting the country <country>
    Then "THANK YOU FOR THE MESSAGE." message should be displayed in Confirmation Page 
    Examples: 
      | name             |           password | prouct name  | country |
      | shetty@gmail.com |Iamking@000         | ZARA COAT 3  | India |
      | POM24@gmail.com |Iamking@000          | ADIDAS ORIGINAL    | India|
