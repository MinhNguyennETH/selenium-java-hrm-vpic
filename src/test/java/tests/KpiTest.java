package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.KpiPage;
import pages.LoginPage;

public class KpiTest extends BaseTest {

    private LoginPage loginPage;
    private KpiPage kpiPage;

    @BeforeMethod
    public void setUp() {
        driver.get("http://115.74.225");
        loginPage = new LoginPage(driver);
        kpiPage = new KpiPage(driver);
        loginPage.login("09152", "Vanbinh123");
    }

    @Test (priority = 1)
    public void testTienDoKpiCaNhan() {
        kpiPage.navigateToTienDoKPI();
        Assert.assertTrue(kpiPage.isTienDoKPIDisplayed(), "Tiến độ KPI cá nhân không hiển thị đúng!");
    }

    @Test
    public void testKPICaNhanTheoThang() {
        kpiPage.navigateToKPICaNhanTheoThang();
        Assert.assertTrue(kpiPage.VerifyKpiCaNhanTheoMonth(), "KPI cá nhân theo tháng không hiển thị đúng!");
    }
}
