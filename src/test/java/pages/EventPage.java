package pages;

import io.cucumber.java.ja.前提;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class EventPage {

    public EventPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (xpath = "//h1")
    public WebElement createEventFormTitle;

    @FindBy (css = "#name")
    public WebElement eventName;

    @FindBy (xpath = "//*[text()='Event name field is required']")
    public WebElement eventNameFieldIsRequiredText;

    @FindBy (css = "#description")
    public WebElement eventDescription;

    @FindBy (xpath = "//button[@class='mat-focus-indicator mat-icon-button mat-button-base']")
    public WebElement eventDate;

    @FindBy (xpath = "//input[@formcontrolname='date']")
    public WebElement date;

    @FindBy (xpath = "//div[text()=' 31 ']")
    public WebElement chooseDay31;

    @FindBy (xpath = "//*[text()='Please choose a valid date']")
    public WebElement chooseValidDateText;

    @FindBy (xpath = "//tbody//td[2]")
    public List<WebElement> firstName;

    @FindBy (xpath = "//*[text()='Participant name is required']")
    public WebElement participantNameIsRequiredText;

    @FindBy (xpath = "//tbody//td[3]")
    public List<WebElement> lastName;

    @FindBy (xpath = "//*[text()='Participant last name is required']")
    public WebElement participantLastNameIsRequiredText;

    @FindBy (xpath = "//tbody//td[4]")
    public List<WebElement> contact;

    @FindBy (xpath = "//*[text()='Please enter email or phone number']")
    public WebElement enterEmailOrPhoneNumberText;

    @FindBy (xpath = "//tbody//td[5]")
    public List<WebElement> delete;

    @FindBy (xpath = "//span[text()='Create New Event']")
    public WebElement createNewEventButton;

    @FindBy (xpath = "//span[text()='Add Participant']")
    public WebElement addParticipantButton;

    @FindBy (xpath = "//*[text()='Please add participant!']")
    public WebElement addParticipantMessageText;

    @FindBy (xpath = "//*[text()='Event created successfully']")
    public WebElement eventCreatedSuccessfullyText;

    @FindBy (xpath = "//span[text()='Update Event']")
    public WebElement updateEventButton;

    @FindBy (xpath = "//*[text()='Event updated successfully']")
    public WebElement eventUpdatedMessage;

    @FindBy (xpath = "//h1[text()='Edit Event: #1']")
    public WebElement editEventHeaderText;


}
