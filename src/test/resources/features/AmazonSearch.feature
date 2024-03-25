
@AmazonSearch
Feature: Amazon search functionality
  Agile Story: User should be able to type any keyword and see relevant information

  Scenario: Amazon Title Verification
    Given user is on the Amazon homepage
    Then user should see title is as expected
    #expectedTitle:  Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

  Scenario: Amazon Search Functionality Title Verification (without parameterization)
    Given user is on the Amazon homepage
    When user types Wooden Spoon in the search box
    And user click to Amazon search button
    Then user sees Wooden Spoon is in the title

  Scenario: Amazon Search Functionality Title Verification (with parameterization)
    Given user is on the Amazon homepage
    When user types "Metal Spoon" in the search box
    And user click to Amazon search button
    Then user sees "Metal Spoon" is in the title