
  @EventPageTest @E2ETest
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
      And user clicks the Create event button without fill the event form
      Then user sees validation errors messages on the create event page

    @EventPageTestCase3
    Scenario: Test Case 3 User should be able to add new participant
    when click the Add Participant button
      Given user goes to url
      When user enter valid username and valid password
      Then user clicks create event button and sees create event form
      And user clicks the Add Participant button and sees new participant row

    @EventPageTestCase4
    Scenario: Test Case 4 User should view error message if removes all participants
      Given user goes to url
      When user enter valid username and valid password
      Then user clicks create event button and sees create event form
      And user clicks the Add Participant button and sees new participant row
      Then user removes all participants and views "Please add participant!" message

    @EventPageTestCase5
    Scenario Outline: Test Case 5 User should be able to create new event if fills all required fields
    and redirect to dashboard page with create successful message
      Given user goes to url
      When user enter valid username and valid password
      Then user clicks create event button and sees create event form
      And user fills "<Event Name>" "<Event Description>" and Event Date fields
      Then user fills participants informations for 10 participants and click the Create New Event button
      Then user should be able to redirect to dashboard page and sees "Event created successfully" message
      Examples:
        | Event Name   |Event Description   |
        | Welcome 2023 |New Year Celebration|

    @EventPageTestCase6
    Scenario Outline: Test Case 6 User should be able to edit event. When user click
    the edit button all event fields must be filled according to editing event
      Given user goes to url
      When user enter valid username and valid password
      Then user clicks create event button and sees create event form
      And user fills "<Event Name>" "<Event Description>" and Event Date fields
      Then user fills participants informations for 5 participants and click the Create New Event button
      And user clicks edit event button and checks "<Event Name>" and "<Event Description>" whether according to editing event
      Examples:
        | Event Name   |Event Description   |
        | Welcome 2023 |New Year Celebration|
