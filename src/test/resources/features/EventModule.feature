
  Feature: Event Module UI Tests

    @EventPageTestCase1
    Scenario: Test Case 1 User should view create event
    form if click the Create Event button on dashboard
      Given user goes to url
      When user enter valid username and valid password
      Then user clicks create event button and sees create event form

    @EventPageTestCase2
    Scenario: Test Case 2 User should view validation errors
    if click the Create Event button without fill the event form
      Given user goes to url
      When user enter valid username and valid password
      Then user clicks create event button and sees create event form
      And user sees validation errors messages on the create event page
