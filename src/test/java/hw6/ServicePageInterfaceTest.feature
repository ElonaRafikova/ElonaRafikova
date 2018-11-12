Feature: Service Page tests

  Scenario: Service Page Interface Test
    Given I am on Home Page
    Then The browser title is "Home Page"
    When I login with login "epam" password "1234"
    Then Username now is "PITER CHAILOVSKII"
    And The following elements is displayed: 4 pictures, 4 texts under pictures, headline and description texts
    When I click on "Service" button in Header
    Then Dropdown of header contains options:
    | Support            |
    | Dates              |
    | Complex Table      |
    | Simple Table       |
    | User Table         |
    | Table With Pages   |
    | Different Elements |
    | Performance        |
    When I click on "Service" subcategory in the left section
    Then Dropdown of left section contains options:
    | Support            |
    | Dates              |
    | Complex Table      |
    | Simple Table       |
    | User Table         |
    | Table With Pages   |
    | Different Elements |
    | Performance        |
    When I open "Different elements" page by header menu "Service"
    Then "Different Elements" Page should be opened
    And The following elements is displayed: 4 checkboxes, 4 radios, dropdown, 2 buttons
    And There is right section
    And There is left section
    When I select checkboxes "Water" and "Wind"
    Then Log should have checkboxes "Water" and "Wind" "selected"
    When I select radiobutton "Selen"
    Then Log should have radio "Selen" selected
    When I select dropdown "Yellow"
    Then Log should have dropdown "Yellow" selected
    When I unselect checkboxes "Water" and "Wind"
    Then Log should have checkboxes "Water" and "Wind" "unselected"





