package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DashboardPage {
    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "span.mat-button-wrapper")
    public WebElement createEventButton;

    @FindBy (xpath = "//mat-icon[text()='edit']")
    public WebElement editButton;

    @FindBy (xpath = "//mat-card-content")
    public WebElement noRegisteredEventMessageText;

    @FindBy (xpath = "//thead[@role='rowgroup']")
    public WebElement eventListHeader;

    @FindBy (xpath = "//mat-icon[text()='delete']")
    public List<WebElement> deleteButton;

    @FindBy (xpath = "//mat-icon[text()='supervised_user_circle']")
    public List<WebElement> participantsButton;

    @FindBy (css = "table.participant-table")
    public WebElement participantTable;
}
