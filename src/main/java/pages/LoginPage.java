package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "txtEmail")
    @CacheLookup
    private WebElement emailField;

    @FindBy(id="lblEmailErr")
    @CacheLookup
    private WebElement emailErrField;

    @FindBy(id = "txtPassword")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(id = "lblPasswordErr")
    @CacheLookup
    private WebElement passwordErrField;

    @FindBy(id = "btnLogin")
    @CacheLookup
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void loginAs(String username, String password) {
        enterText(emailField, username);
        enterText(passwordField, password);
        loginBtn.click();
    }
    public LoginPage loginInvalidUser(String username, String password) {
        this.loginAs(username, password);
        return this;
    }

    public WelcomePage loginValidUser(String username, String password) {
        this.loginAs(username, password);
        return new WelcomePage(driver);
    }

    public LoginPage verifyLoginFailedByEmail(String errMsg) {
        verifyTextIsPresented(emailErrField, errMsg);
        return this;
    }
}
