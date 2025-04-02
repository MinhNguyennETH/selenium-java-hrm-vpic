package pages;


import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KpiPage extends BasePage {



    @FindBy(xpath = "//span[contains(text(),'Quản lý KPI')]")
    private WebElement quanLyKPIButton;

    @FindBy(xpath = "//span[normalize-space()='KPI cá nhân']")
    private WebElement kpiCaNhanButton;

    @FindBy(xpath = "//span[contains(text(),'Tiến độ thực hiện KPI cá nhân')]")
    private WebElement tienDoKPIButton;

    @FindBy(xpath = "//span[normalize-space()='KPI cá nhân theo Month']")
    private WebElement kpiCaNhanTheoThangButton;

    @FindBy(xpath = "//div[contains(text(),'Tiến độ thực hiện KPI cá nhân')]")
    private WebElement tienDoKPITitle;

    @FindBy(xpath = "//div[contains(text(),'KPI cá nhân theo Month')]")
    private WebElement kpiCaNhanTheoThangTitle;

    public KpiPage(WebDriver driver) {
        super(driver);
    }
    public void navigateToTienDoKPI() {
        clickElement(quanLyKPIButton);
        clickElement(kpiCaNhanButton);
        clickElement(tienDoKPIButton);
    }

    public boolean isTienDoKPIDisplayed() {

        return isElementVisible(tienDoKPITitle);
    }

    public void navigateToKPICaNhanTheoThang() {
        clickElement(quanLyKPIButton);
        clickElement(kpiCaNhanButton);
        clickElement(kpiCaNhanTheoThangButton);
    }


    public boolean isKPICaNhanTheoThangDisplayed() {
        return isElementVisible(kpiCaNhanTheoThangTitle);
    }
}
