Feature: Movie Rental
  
  How a user
  I want to register movie rentals
  So that to control prices and dates

  Scenario: Must rent a movie successfully
    Given a film 
    |stock|  2   |
    |price|  3   |
    |type |common|
    
    When to rent
    Then the rental price will be R$ 3
    And the delivery date will be in 1 day
    And the movie stock will be 1 unit

  Scenario: Not you must rent a movie without stock
    Given a film with stock of 0 units
    When to rent
    Then it will not be possible due to lack of stock
    And the movie stock will be 0 unit

Scenario Outline: Must have conditions according to the type of rent
		Given a film with stock of 2 units
    And that the rental price is R$ <price>
    And let the type of rent be <type>
    When to rent
    Then the rental price will be R$ <value>
    And the delivery date will be in <days> days
    And the score received will be <points> points
    
    Examples:
  |price|  type    |value|days|points|
  |  4  |  extended|  8  | 3  |  2   | 
  |  4  |  common  |  4  | 1  |  1   |
  | 10  | extended |  20 | 3  |  2   |
  | 5   | weekly   |  15 | 7  |  3   |
  
   
