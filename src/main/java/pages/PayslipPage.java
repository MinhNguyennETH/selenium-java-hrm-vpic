package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.Set;

public class PayslipPage extends BasePage {

    // Payslip Menu
    @FindBy(xpath = "//span[contains(text(),'Payslip')]")
     WebElement payslipMenu;

    // General
    @FindBy(xpath = "//span[@id='select2-chosen-2']")
     WebElement clickMonth;

    @FindBy(xpath = "//span[@id='select2-chosen-1']")
     WebElement clickYear;

    @FindBy(xpath = "//input[@id='s2id_autogen2_search']")
     WebElement searchMonth;

    @FindBy(xpath = "//input[@id='s2id_autogen1_search']")
     WebElement searchYear;

    @FindBy(xpath = "//i[@class='fa fa-file-pdf-o text-red']")
     WebElement clickViewFilePDF;

    //------------------------Monthly Payslip------------------------------------------------------------------------

    // Monthly payslip Page
    @FindBy(xpath = "//span[contains(text(),'Monthly payslip')]")
     WebElement monthlyPayslip;

    @FindBy(xpath = "//div[contains(text(),'Monthly payslip')]")
     WebElement Title_MonthlyPayslip;

    //------------------------Bonus Payslip------------------------------------------------------------------------
    @FindBy(xpath = "//span[contains(text(),'Bonus payslip')]")
     WebElement bonusPayslip;

    @FindBy(xpath = "//div[contains(text(),'Bonus')]")
     WebElement Title_Bonus;

    //------------------------13th Payslip------------------------------------------------------------------------
    @FindBy(xpath = "//span[contains(text(),'13th payslip')]")
     WebElement thirteenthPayslip;

    @FindBy(xpath = "//div[contains(text(),'13th payslip')]")
     WebElement Title_13thPayslip;

    public PayslipPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //  Check url file PDF
    public boolean isPDFOpened() {
        String expectedURL = "http://115.74.225.99:8082/Services/HRM_VPIC/TblPayroll/ExPayrollMonthly";
        Set<String> allTabs = driver.getWindowHandles();

        for (String tab : allTabs) {
            driver.switchTo().window(tab);
            String currentURL = driver.getCurrentUrl();
            if (currentURL.contains(expectedURL)) {
                return true; // PDF opened
            }
        }
        return false; // PDF not displayed
    }

    // Xem phiếu lương tháng
    public void viewMonthlyPayslip() throws InterruptedException {
        clickElement(payslipMenu);
        clickElement(monthlyPayslip);
        WebElement titleMonthlyPayslip = wait.until(ExpectedConditions.visibilityOf(Title_MonthlyPayslip));
        Assert.assertTrue(titleMonthlyPayslip.isDisplayed(), "Tiêu đề không hiển thị!");
        Assert.assertEquals(titleMonthlyPayslip.getText(), "Monthly payslip", "Tiêu đề không đúng!");


        // Chọn tháng và năm
        clickElement(clickMonth);
        setText(searchMonth, "1", true);
        clickElement(clickYear);
        setText(searchYear, "2024", true);
        Thread.sleep(1000);

        // Click open file PDF
        clickElement(clickViewFilePDF);

        // Check file PDF isDisplayed
        Assert.assertTrue(isPDFOpened(), "File PDF không mở đúng trang!");

    }


    // Xem phiếu thưởng
    public void viewBonusPayslip() {
        clickElement(payslipMenu);
        clickElement(bonusPayslip);
        clickElement(Title_Bonus);

    }

    //  Xem phiếu lương tháng 13
    public void view13thPayslip() {
        clickElement(payslipMenu);
        clickElement(thirteenthPayslip);
        clickElement(Title_13thPayslip);
    }

}
