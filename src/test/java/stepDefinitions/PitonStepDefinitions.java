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

import java.sql.ResultSetMetaData;

import static org.junit.Assert.*;

public class PitonStepDefinitions {

    LoginPage loginPage=new LoginPage();
    EventPage eventPage=new EventPage();
    DashboardPage dashboardPage=new DashboardPage();
    Actions actions=new Actions(Driver.getDriver());

    int numberOfParticipants;

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

    @When("user enters valid username and valid password")
    public void userEntersValidUsernameAndValidPassword() {
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
    public void userFillsParticipantsInformationsForParticipantsAndClickTheCreateNewEventButton(int numParticipants) throws InterruptedException {
        numberOfParticipants=numParticipants-1;

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
        numberOfParticipants=numParticipants;
        eventPage.createNewEventButton.click();
        Thread.sleep(2000);
    }

    @Then("user should be able to redirect to dashboard page and sees {string} message")
    public void userShouldBeAbleToRedirectToDashboardPageAndSeesMessage(String message) {
        assertEquals(Driver.getDriver().getCurrentUrl(), ConfigReader.getProperty("dashboardPage"));
        assertEquals(eventPage.eventCreatedSuccessfullyText.getText(), message);

    }

    @And("user clicks edit event button")
    public void userClicksEditEventButton() {
       ReusableMethods.waitForClickablility(dashboardPage.editButton,2);
        dashboardPage.editButton.click();
    }

    @Then("user checks {string} {string} {string} and participants whether according to editing event")
    public void userChecksAndParticipantsWhetherAccordingToEditingEvent(String expectedEventName, String expectedEventDescription, String expectedEventDate) {
        String actualEventName=eventPage.eventName.getAttribute("value");
        String actualEventDescription=eventPage.eventDescription.getAttribute("value");
        String actualEventDate=eventPage.date.getAttribute("value");

        assertEquals(actualEventName, expectedEventName);
        assertEquals(actualEventDescription, expectedEventDescription);
        assertEquals(actualEventDate, expectedEventDate);

        assertEquals(numberOfParticipants, eventPage.firstName.size());
        assertEquals(numberOfParticipants, eventPage.lastName.size());
        assertEquals(numberOfParticipants, eventPage.contact.size());
    }

    @Then("user updates {string} and delete the third\\({int}) participant and add a new participant")
    public void userUpdatesAndDeleteTheThirdParticipantAndAddANewParticipant(String newEventDescription, int placeOfParticipant) throws InterruptedException {
        ReusableMethods.waitForVisibility(eventPage.eventDescription, 2);
        eventPage.eventDescription.clear();
        eventPage.eventDescription.sendKeys(newEventDescription);
        Thread.sleep(2000);

        eventPage.delete.get(placeOfParticipant-1).click();
        ReusableMethods.waitForClickablility(eventPage.addParticipantButton, 2);
        eventPage.addParticipantButton.click();
        Thread.sleep(1000);

        actions.click(eventPage.firstName.get(eventPage.firstName.size()-1)).
                sendKeys(Faker.instance().name().firstName()).perform();
        actions.click(eventPage.lastName.get(eventPage.lastName.size()-1)).
                sendKeys(Faker.instance().name().lastName()).perform();
        actions.click(eventPage.contact.get(eventPage.contact.size()-1)).
                sendKeys(Faker.instance().internet().emailAddress()).perform();

    }

    @And("user clicks update event button and redirect to dashboard page and sees {string} message")
    public void userClicksUpdateEventButtonAndRedirectToDashboardPageAndSeesMessage(String eventUpdatedMessage) {
        eventPage.updateEventButton.click();
        assertEquals(eventUpdatedMessage, eventPage.eventUpdatedMessage.getText());

    }

    @Then("user sees dashboard page")
    public void userSeesDashboardPage() {
        assertTrue(Driver.getDriver().getCurrentUrl().contains(ConfigReader.getProperty("dashboardPage")));
    }

    @When("user enters invalid username and invalid password")
    public void userEntersInvalidUsernameAndInvalidPassword() {
        loginPage.username.sendKeys(ConfigReader.getProperty("invalidUserName"));
        loginPage.password.sendKeys(ConfigReader.getProperty("invalidPassword"));
        loginPage.loginButton.click();
    }

    @Then("user sees login page header")
    public void userSeesLoginPageHeader() {
        assertTrue(loginPage.loginHeaderText.isDisplayed());
    }

    @Then("user views {string} notification message")
    public void userViewsNotificationMessage(String notificationMessage) {
        assertEquals(dashboardPage.noRegisteredEventMessageText.getText(), notificationMessage);
    }

    @And("user redirect to dashboard and views event list")
    public void userRedirectToDashboardAndViewsEventList() {
        assertTrue(dashboardPage.eventListHeader.isDisplayed());
    }

    @Then("user clicks edit event button and views edit event header")
    public void userClicksEditEventButtonAndViewsEditEventHeader() {
        dashboardPage.editButton.click();
        assertTrue(eventPage.editEventHeaderText.isDisplayed());
    }

    @Then("user clicks the delete button to delete event")
    public void userClicksTheDeleteButtonToDeleteEvent() {
        dashboardPage.deleteButton.get(0).click();
    }

    @Then("user clicks participants button and sees event participants table")
    public void userClicksParticipantsButtonAndSeesEventParticipantsTable() {
        dashboardPage.participantsButton.get(0).click();
        assertTrue(dashboardPage.participantTable.isDisplayed());
    }
}
