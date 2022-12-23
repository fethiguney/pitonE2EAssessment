package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = "div.login-header")
    public WebElement loginText;

    @FindBy (css = "input#username")
    public WebElement username;

    @FindBy (css = "input#password")
    public WebElement password;

    @FindBy (css = "span.mat-button-wrapper")
    public WebElement loginButton;

    @FindBy (css = "#mat-error-0")
    public WebElement usernameFieldIsRequiredText;

    @FindBy (css = "#mat-error-1")
    public WebElement passwordFieldIsRequiredText;

    @FindBy (css = "#welcomeUserMessage")
    public WebElement welcomeMessage;
}
