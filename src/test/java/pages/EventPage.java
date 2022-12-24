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

    @FindBy (css = "#mat-error-2")
    public WebElement eventNameFieldIsRequiredText;

    @FindBy (css = "#description")
    public WebElement eventDescription;

    @FindBy (css = "div#cdk-overlay-1")
    public WebElement eventDate;

    @FindBy (xpath = "//button[@aria-label='Choose month and year']")
    public WebElement chooseMonthYear;

    @FindBy (css = "#mat-error-3")
    public WebElement chooseValidDateText;

    @FindBy (xpath = "//tbody//td[2]")
    public List<WebElement> firstName;

    @FindBy (css = "#mat-error-4")
    public WebElement participantNameIsRequiredText;

    @FindBy (xpath = "//tbody//td[3]")
    public List<WebElement> lastName;

    @FindBy (css = "#mat-error-5")
    public WebElement participantLastNameIsRequiredText;

    @FindBy (xpath = "//tbody//td[4]")
    public List<WebElement> contact;

    @FindBy (css = "#mat-error-6")
    public WebElement enterEmailOrPhoneNumberText;

    @FindBy (xpath = "//tbody//td[5]")
    public List<WebElement> delete;

    @FindBy (xpath = "//span[text()='Create New Event']")
    public WebElement createNewEventButton;

    @FindBy (xpath = "//span[text()='Add Participant']")
    public WebElement addParticipantButton;

    @FindBy (css = "p.ng-star-inserted")
    public WebElement addParticipantMessageText;

    @FindBy (xpath = "//*[text()='Event created successfully']")
    public WebElement eventCreatedSuccessfullyText;
}
