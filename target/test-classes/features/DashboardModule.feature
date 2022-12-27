
  @DashboardPageTest @E2ETest
  Feature: Dashboard Modul UI Test

    @DashboardPageTestCase1
    Scenario: Test Case 1 – User should view dashboard if authenticated
      Given user goes to url
      When user enters valid username and valid password
      Then user sees dashboard page

    @DashboardPageTestCase2
    Scenario: Test Case 2 – User should redirect to login page if not authenticated
      Given user goes to url
      When user enters invalid username and invalid password
      Then user sees login page header

    @DashboardPageTestCase3
    Scenario Outline: Test Case 3 – User should view list of events if any event created otherwise user should view
    notification message states no registered event found
      Given user goes to url
      When user enters valid username and valid password
      Then user views "No registered event has been found!!" notification message
      Then user clicks create event button and sees create event form
      And user fills "<Event Name>" "<Event Description>" and Event Date fields
      Then user fills participants informations for 3 participants and click the Create New Event button
      And user redirect to dashboard and views event list

      Examples:
        | Event Name     |Event Description   |
        | Happy New Year |Good Bye 2022 Celebration|

    @DashboardPageTestCase4
    Scenario Outline: Test Case 4 – User should be able navigate edit event when click the edit event button
      Given user goes to url
      When user enters valid username and valid password
      Then user clicks create event button and sees create event form
      And user fills "<Event Name>" "<Event Description>" and Event Date fields
      Then user fills participants informations for 3 participants and click the Create New Event button
      And user redirect to dashboard and views event list
      Then user clicks edit event button and views edit event header
      Examples:
        | Event Name     |Event Description   |
        | Happy New Year |Good Bye 2022 Celebration|

    @DashboardPageTestCase5
    Scenario Outline: Test Case 5 – User should be able to delete event when click the delete button
      Given user goes to url
      When user enters valid username and valid password
      Then user clicks create event button and sees create event form
      And user fills "<Event Name>" "<Event Description>" and Event Date fields
      Then user fills participants informations for 3 participants and click the Create New Event button
      And user redirect to dashboard and views event list
      Then user clicks the delete button to delete event
      And user views "No registered event has been found!!" notification message
      Examples:
        | Event Name     |Event Description   |
        | Happy New Year |Good Bye 2022 Celebration|

    @DashboardPageTestCase6
    Scenario Outline: Test Case 6 – User should be able to view event participants
      Given user goes to url
      When user enters valid username and valid password
      Then user clicks create event button and sees create event form
      And user fills "<Event Name>" "<Event Description>" and Event Date fields
      Then user fills participants informations for 3 participants and click the Create New Event button
      And user redirect to dashboard and views event list
      Then user clicks participants button and sees event participants table
      Examples:
        | Event Name     |Event Description   |
        | Happy New Year |Good Bye 2022 Celebration|