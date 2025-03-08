package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PayslipPage {
    private WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Payslip')]")
    private WebElement payslipMenu;

    //Monthly payslip Page
    @FindBy(xpath = "//span[contains(text(),'Monthly payslip')]")
    private WebElement monthlyPayslip;
    //Tittle Monthly payslip
    @FindBy(xpath = "//span[contains(text(),'Monthly payslip')]")
    private WebElement TitlemonthlyPayslip;


    //Bonus payslip
    @FindBy(xpath = "//span[contains(text(),'Bonus payslip')]")
    private WebElement bonusPayslip;


    //13th payslip
    @FindBy(xpath = "//span[contains(text(),'13th payslip')]")
    private WebElement thirteenthPayslip;



    public PayslipPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Mở menu Payslip
    public void clickPayslipMenu() {
        payslipMenu.click();
    }

    // Click vào từng mục phiếu lương
    public void clickMonthlyPayslip() {
        monthlyPayslip.click();
    }

    public void clickBonusPayslip() {
        bonusPayslip.click();
    }

    public void click13thPayslip() {
        thirteenthPayslip.click();
    }

}
