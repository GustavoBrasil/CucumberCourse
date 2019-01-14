Feature: Learn cucumber
  As a student
  I want learn how to use cucumber
  So that I can automate acceptance criteria

  Scenario: Must perform specification
    Given I created the file correctly
    When run it
    Then the specification should finished it successfully

  Scenario: Must increment the counter
    Given that the counter value is 15
    When add up 3
    Then the counter value will be 18

  Scenario: Must increment the counter
    Given that the counter value is 123
    When add up 35
    Then the counter value will be 158

  Scenario: Must calculate the delay in delivery period
    Given that the deadline is 05/04/2018
    When the delivery delays in 2 days
    Then delivery will be effected on 07/04/2018

  Scenario: Must calculate the delay in delivery period in China
    Given that the deadline is 05/04/2018
    When the delivery delays in 2 months
    Then delivery will be effected on 05/06/2018

  Scenario: Must create generic steps for these steps
    Given that the ticket is AF345
    And that the ticket price is R$ 230,45
    And that the name of the passenger is "Fulano da Silva"
    And that the passenger's phone number is 9999-9999
    When creating the steps
    Then the test will work

  Scenario: Must reuse the "Given" steps from the previous scenario
    Given that the special ticket is AB167
    Given that the ticket price is R$ 1120,23
    Given that the name of the passenger is "Cicrano de Oliveira"
    Given that the passenger's phone number is 9888-8888

@ignore
  Scenario: Must deny all the "Given" steps in the previous scenarios
    Given that the ticket is CD123
    Given that the ticket is AG1234
    Given that the ticket price is R$ 11345,56
    Given that the name of the passenger is "Beltrano Souza Matos de Alcântara Azevedo"
    Given that the passenger's telephone number is 1234-5678
    Given that the passenger's phone number is 999-2223
