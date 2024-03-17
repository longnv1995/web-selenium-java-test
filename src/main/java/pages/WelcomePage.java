package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import textResources.TextResource;

public class WelcomePage extends BasePage {
    @FindBy(id = "lblLoggedinSuccessfully")
    @CacheLookup
    private WebElement loggedInMsgElem;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }
    public void verifyLoginSuccessfully() {
        verifyTextIsPresented(loggedInMsgElem, TextResource.loggedInSuccessfully);
    }
}

