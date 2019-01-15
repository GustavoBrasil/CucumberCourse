@functional
Feature: Account registration
  As a user
  I would like registered accounts
  So that I can distribute my money in a more organized way

  Background: 
    Given I'm accessing the application
    When the user "teste@selenium.com"
    And the password "teste123"
    And select enter
    Then view a home page
    When I select Accounts
    And select Add

  Scenario Outline: Must validation to accounts rules
    When I enter the account "<account>"
    And I select Save
    Then I get the message "<messages>"

    Examples: 
      | account          | messages                           |
      | test account     | Conta adicionada com sucesso!      |
      |                  | Informe o nome da conta            |
      | Conta mesmo nome | Já existe uma conta com esse nome! |
