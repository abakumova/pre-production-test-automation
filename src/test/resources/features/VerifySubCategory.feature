Feature: Verify 2 features on the site

  Scenario: Verify computers
    Given a user visits a home page
    When the user chooses category computer
    Then the user can see subcategory 'IT услуги'
    And user exit from the site

  Scenario: Verify sofas
    Given a user visits a home page
    When the user visits Furniture page & chooses Sofa category
    And the user goes to a Sofa page & chooses Sofa maker
    Then the user can see all available sofas from the category
    And user exit from the site