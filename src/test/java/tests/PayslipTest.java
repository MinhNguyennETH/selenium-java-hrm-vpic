package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PayslipPage;

public class PayslipTest extends BaseTest {

    @Test
    public void testViewMonthlyPayslip() {
        // Bước 1: Đăng nhập
        driver.get("http://115.74.225");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("09152", "Vanbinh123");

        // Bước 2: Kiểm tra chức năng xem phiếu lương
        PayslipPage payslipPage = new PayslipPage(driver);

        // Mở menu Payslip
        payslipPage.clickPayslipMenu();

        // Click vào Monthly Payslip
        payslipPage.clickMonthlyPayslip();
        
    }
}

