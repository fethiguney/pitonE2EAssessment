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
}
