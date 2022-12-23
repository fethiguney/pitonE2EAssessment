package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EventPage {

    public EventPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (xpath = "//h1")
    public WebElement createEventFormTitle;

    @FindBy (css = "#name")
    public WebElement eventName;

    @FindBy (css = "#mat-error-0")
    public WebElement eventNameFieldIsRequiredText;

    @FindBy (css = "#description")
    public WebElement eventDescription;

    @FindBy (css = "#mat-input-2")
    public WebElement eventDate;

    @FindBy (css = "#mat-error-1")
    public WebElement chooseValidDateText;

    @FindBy (css = "#mat-input-3")
    public WebElement firstName;

    @FindBy (css = "#mat-error-2")
    public WebElement participantNameIsRequiredText;

    @FindBy (css = "#mat-input-4")
    public WebElement lastName;

    @FindBy (css = "#mat-error-3")
    public WebElement participantLastNameIsRequiredText;

    @FindBy (css = "#mat-input-5")
    public WebElement contact;

    @FindBy (css = "#mat-error-4")
    public WebElement enterEmailOrPhoneNumberText;

    @FindBy (xpath = "//span[text()='Create New Event']")
    public WebElement createNewEventButton;
}
