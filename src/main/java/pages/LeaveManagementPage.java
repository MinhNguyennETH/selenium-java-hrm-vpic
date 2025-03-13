package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class LeaveManagementPage extends BasePage {


    @FindBy(xpath = "//span[normalize-space()='Leave Management']")
    private WebElement leaveManagement_Button;


    //-------------------Remaining annual leave--------------------------------------------------------------
    @FindBy(xpath = "//span[contains(text(),'Remaining annual leave')]")
    private WebElement remainingAnnualLeave_Button;

    @FindBy(xpath = "//h1[contains(text(),'Phép tồn')]")
    private WebElement remainingAnnualLeave_Title;

    @FindBy(xpath = "//span[@class='button-inner']")
    private WebElement leaveRegistration_Button;


    //-------------------Register for annual leave-------------------------------------------------------------
    @FindBy(xpath = "//span[contains(text(),'Register for annual leave')]")
    private WebElement registerForAnnualLeave_Button;

    @FindBy(xpath = " //div[text()='Register for annual leave']")
    private WebElement registerForAnnualLeave_Title;


    public LeaveManagementPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void viewRemainingAnnualLeave() throws InterruptedException {
        clickElement(leaveManagement_Button);
        clickElement(remainingAnnualLeave_Button);

        // Verify
        WebElement RemainingLeave_Title = wait.until(ExpectedConditions.visibilityOf(remainingAnnualLeave_Title));
        Assert.assertTrue(RemainingLeave_Title.isDisplayed(), "Title not displayed! ");
        String remainingLeaveText = RemainingLeave_Title.getText();
        System.out.println("Remaining Leave Title: " + remainingLeaveText);

        // Lưu lại handle của tab hiện tại (tab cũ)
        String originalTab = driver.getWindowHandle();

        clickElement(leaveRegistration_Button);

        // Lấy tất cả các window handle (tab)
        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }

        clickElement(leaveRegistration_Button);

        // Verify
        WebElement RegisterLeave_Title = wait.until(ExpectedConditions.visibilityOf(registerForAnnualLeave_Title));
        Assert.assertTrue(RegisterLeave_Title.isDisplayed(), "Title not displayed! ");
        String registerLeaveText = RegisterLeave_Title.getText();
        System.out.println("Register Leave Title: " + registerLeaveText);
    }
}
