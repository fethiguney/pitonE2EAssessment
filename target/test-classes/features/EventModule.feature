
  Feature: Event Module UI Tests

    @EventPageTestCase1
    Scenario: Test Case 1 User should view create event
    form if click the Create Event button on dashboard
      Given user goes to url
      When user enter valid username and valid password
      Then user clicks create event button and sees create event form
