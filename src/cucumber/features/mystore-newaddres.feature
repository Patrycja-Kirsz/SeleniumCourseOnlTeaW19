Feature: Adding new address to existing account on MyStore

  Scenario Outline: User can add a new address on https://mystore-testlab.coderslab.pl/


    Given Page https://mystore-testlab.coderslab.pl/index.php/ is opened


    When Sign in on the front page is clicked
    And The user has logged in by using e-mail address and password
    And The field Addresses is clicked
    And Create new address is clicked
    And Address information: <alias>, <address>, <city>, <postalCode>, <phone> are filled out
    Then Address information should be <expectedAlias>, <expectedAddress>, <expectedCity>, <expectedPostalCode>, <expectedPhone>

    Examples:
      |alias          | address | city  | postalCode | phone  | expectedAlias | expectedAddress | expectedCity | expectedPostalCode | expectedPhone |
      |Dr             | Długa   | Gdańsk| 80111      | 123456 | Dr            | Długa           | Gdańsk       | 80111              | 123456        |