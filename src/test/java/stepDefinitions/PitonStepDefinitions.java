package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.*;
import utilities.*;

import javax.swing.*;

import static org.junit.Assert.*;

public class PitonStepDefinitions {

    LoginPage loginPage=new LoginPage();
    EventPage eventPage=new EventPage();
    DashboardPage dashboardPage=new DashboardPage();
    Actions actions=new Actions(Driver.getDriver());


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
    @And("user clicks the Create event button without fill the event form")
    public void userClicksTheCreateEventButtonWithoutFillTheEventForm() {
        eventPage.createNewEventButton.click();
    }
    @And("user sees validation errors messages on the create event page")
    public void userSeesValidationErrorsMessagesOnTheCreateEventPage() {
        assertTrue(eventPage.eventNameFieldIsRequiredText.isDisplayed());
        assertTrue(eventPage.chooseValidDateText.isDisplayed());
        assertTrue(eventPage.eventNameFieldIsRequiredText.isDisplayed());
        assertTrue(eventPage.participantLastNameIsRequiredText.isDisplayed());
        assertTrue(eventPage.enterEmailOrPhoneNumberText.isDisplayed());
    }


    @And("user clicks the Add Participant button and sees new participant row")
    public void userClicksTheAddParticipantButtonAndSeesNewParticipantRow() {
        eventPage.addParticipantButton.click();
        assertTrue(eventPage.firstName.get(eventPage.firstName.size()-1).isDisplayed());
        assertTrue(eventPage.lastName.get(eventPage.lastName.size()-1).isDisplayed());
        assertTrue(eventPage.contact.get(eventPage.contact.size()-1).isDisplayed());
    }

    @Then("user removes all participants and views {string} message")
    public void userRemovesAllParticipantsAndViewsMessage(String message) {
        eventPage.delete.forEach(WebElement::click);
        assertEquals(eventPage.addParticipantMessageText.getText(), message);
    }
    @And("user fills {string} {string} and Event Date fields")
    public void userFillsAndEventDateFields(String eventName, String eventDescription) {
        eventPage.eventName.sendKeys(eventName);
        eventPage.eventDescription.sendKeys(eventDescription);
        eventPage.eventDate.click();
        eventPage.chooseDay31.click();
    }

    @Then("user fills participants informations for {int} participants and click the Create New Event button")
    public void userFillsParticipantsInformationsForParticipantsAndClickTheCreateNewEventButton(int numParticipants) {
        int numberOfParticipants=numParticipants-1;
        for (int i = 0; i <numberOfParticipants ; i++) {
            eventPage.addParticipantButton.click();
        }

        for (int i = 0; i <eventPage.firstName.size() ; i++) {
            actions.click(eventPage.firstName.get(i)).sendKeys(Faker.instance().name().firstName()).perform();
        }
        for (int i = 0; i <eventPage.lastName.size() ; i++) {
            actions.click(eventPage.lastName.get(i)).sendKeys(Faker.instance().name().lastName()).perform();

        }
        for (int i = 0; i <eventPage.contact.size() ; i++) {
            actions.click(eventPage.contact.get(i)).sendKeys(Faker.instance().internet().emailAddress()).perform();
        }
        eventPage.createNewEventButton.click();
    }

    @Then("user should be able to redirect to dashboard page and sees {string} message")
    public void userShouldBeAbleToRedirectToDashboardPageAndSeesMessage(String message) {
        assertEquals(Driver.getDriver().getCurrentUrl(), ConfigReader.getProperty("dashboardPage"));
        assertEquals(eventPage.eventCreatedSuccessfullyText.getText(), message);

    }

    @And("user clicks edit event button and checks {string} and {string} whether according to editing event")
    public void userClicksEditEventButtonAndChecksAndWhetherAccordingToEditingEvent(String expectedEventName, String expectedEventDescription) {
        dashboardPage.editButton.click();
        String actualEventName=eventPage.eventName.getAttribute("value");
        String actualEventDescription=eventPage.eventDescription.getAttribute("value");
        assertEquals(actualEventName, expectedEventName);
        assertEquals(actualEventDescription, expectedEventDescription);


    }
}
