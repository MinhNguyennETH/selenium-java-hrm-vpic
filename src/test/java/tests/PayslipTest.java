package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PayslipPage;

public class PayslipTest extends BaseTest {
    private PayslipPage payslipPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpPayslipTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("09152", "Vanbinh123");
        payslipPage = new PayslipPage(driver);
    }


    @Test
    public void testViewMonthlyPayslip() throws InterruptedException {
        payslipPage.viewMonthlyPayslip();
    }

    @Test
    public void testViewBonusPayslip() {
        payslipPage.viewBonusPayslip();
    }

    @Test
    public void testView13Payslip() {
        payslipPage.view13thPayslip();

    }
}

