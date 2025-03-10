package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name = "Username")
    WebElement usernameField;

    @FindBy(name = "Password")
    WebElement passwordField;

    @FindBy(id = "SerExtraNet5_Membership_LoginPanel0_LoginButton")
    WebElement loginButton;

    @FindBy(xpath = "//b[contains(text(),'SerExtraNet5')]")
    WebElement successMessage;

    @FindBy(xpath = "//h3[contains(text(),'Đăng nhập')]")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        setText(usernameField, username, false);
        setText(passwordField, password, false);
        clickElement(loginButton);

    }

    public boolean isLoginSuccessful() {
        try {
            wait.until(ExpectedConditions.visibilityOf(successMessage));
            return successMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginFailed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
