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

public class LeaveManagementPage extends BasePage {



    @FindBy(xpath = "//span[normalize-space()='Leave Management']")
     WebElement leaveManagement_Button;

    //-------------------Remaining annual leave--------------------------------------------------------------
    @FindBy(xpath = "//span[contains(text(),'Remaining annual leave')]")
     WebElement remainingAnnualLeave_Button;

    @FindBy(xpath = "//h1[contains(text(),'Phép tồn')]")
     WebElement remainingAnnualLeave_Title;

    @FindBy(xpath = "//span[@class='button-inner']")
     WebElement leaveRegistration_Button;


    //-------------------Register for annual leave-------------------------------------------------------------
    @FindBy(xpath = "//span[contains(text(),'Register for annual leave')]")
     WebElement registerForAnnualLeave_Button;

    @FindBy(xpath = " //div[text()='Register for annual leave']")
     WebElement registerForAnnualLeave_Title;



    public LeaveManagementPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void viewRemainingAnnualLeave(){
        clickElement(leaveManagement_Button);
        clickElement(remainingAnnualLeave_Button);
        WebElement RemainingLeave_Title = wait.until(ExpectedConditions.visibilityOf(remainingAnnualLeave_Title));
        Assert.assertTrue(RemainingLeave_Title.isDisplayed(), "Title not displayed! ");
        Assert.assertEquals(RemainingLeave_Title.getText(),"Phép tồn", "Incorrect title! ");

        clickElement(leaveRegistration_Button);
        WebElement RegisterLeave_Title = wait.until(ExpectedConditions.visibilityOf(registerForAnnualLeave_Title));
        Assert.assertTrue(RegisterLeave_Title.isDisplayed(), "Title not displayed! ");
        Assert.assertEquals(RegisterLeave_Title.getText(),"Register for annual leave", "Incorrect title! ");

    }
}
