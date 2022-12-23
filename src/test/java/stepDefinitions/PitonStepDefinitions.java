package stepDefinitions;

import io.cucumber.java.en.*;
import pages.*;
import utilities.*;
import static org.junit.Assert.*;

public class PitonStepDefinitions {

    LoginPage loginPage=new LoginPage();
    EventPage eventPage=new EventPage();

    DashboardPage dashboardPage=new DashboardPage();


    @Given("user goes to url")
    public void userGoesToUrl() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("user sees Event Manager Login text")
    public void userSeesEventManagerLoginText() {
       assertTrue(loginPage.loginText.isDisplayed());
    }

    @Then("verify form contains username password and login button")
    public void verifyFormContainsUsernamePasswordAndLoginButton() {
        assertTrue(loginPage.username.isEnabled());
        assertTrue(loginPage.password.isEnabled());
        assertTrue(loginPage.loginButton.isEnabled());
    }

    @When("user click the login button without fill the login form")
    public void userClickTheLoginButtonWithoutFillTheLoginForm() {
        loginPage.loginButton.click();
    }

    @Then("user sees validation errors messages")
    public void userSeesValidationErrorsMessages() {
        assertTrue(loginPage.usernameFieldIsRequiredText.isDisplayed());
        assertTrue(loginPage.passwordFieldIsRequiredText.isDisplayed());
    }

    @When("user enter valid username and valid password")
    public void userEnterValidUsernameAndValidPassword() {
        loginPage.username.sendKeys(ConfigReader.getProperty("username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("password"));
        loginPage.loginButton.click();
    }

    @Then("user sees welcome message")
    public void userSeesWelcomeMessage() {
        assertTrue(loginPage.welcomeMessage.isDisplayed());
    }

    @Then("user clicks create event button and sees create event form")
    public void userClicksCreateEventButtonAndSeesCreateEventForm() {
        dashboardPage.createEventButton.click();
        assertTrue(eventPage.createEventFormTitle.isDisplayed());
    }
}
