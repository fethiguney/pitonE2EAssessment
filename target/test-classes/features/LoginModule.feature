
  @loginPageTest @E2ETest
  Feature: Login Module UI Tests

    @loginPageTestCase1
    Scenario: Test Case 1 User should see login form if not authenticated.
    Login Form should contain username password and login button
      Given user goes to url
      When user sees Event Manager Login text
      Then verify form contains username password and login button

    @loginPageTestCase2
    Scenario: Test Case 2 User should see validation errors
    if click the login button without fill the login form
      Given user goes to url
      When user click the login button without fill the login form
      Then user sees validation errors messages

    @loginPageTestCase3
    Scenario: Test Case 3 User should navigate to the dashboard
    and see welcome message if authenticate successfully
      Given user goes to url
      When user enter valid username and valid password
      Then user sees welcome message