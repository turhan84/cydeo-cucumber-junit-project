@NextBase
Feature: NextBaseCrm Poll Creation and Cancellation functionality
  Agile story: As a user, I should be able to create a poll
  1. User should be able to create a simple poll with a question and 2 answers.
  - Successfully created poll should be displayed in the feed.
  2. User should be able to cancel a poll.
  - Poll message area should collapse after clicking the “Cancel” button.

  Scenario: User creates a poll
    Given the user is on the home page
    When  the user clicks on the Create Poll button
    And   enters a question and two answers
    And   clicks the Submit button
    Then  the user should see the created poll in the feed

  Scenario: User cancels a poll creation
    Given the user is on the home page
    When   the user is on the poll creation tab
    When    the user clicks on the Cancel button
    Then    the poll message area should collapse