package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LeaveManagementPage;
import pages.LoginPage;

public class LeaveManagementTest extends BaseTest {

    private LoginPage loginPage;
    private LeaveManagementPage leaveManagementPage;


    @BeforeMethod
    public void setUpLeaveManagementTest() throws InterruptedException {
        loginPage = new LoginPage(driver);
        leaveManagementPage = new LeaveManagementPage(driver);
        loginPage.login("09152", "Vanbinh123");
    }

    @Test
    public void testViewRemainingAnnualLeave() throws InterruptedException {
        leaveManagementPage.viewRemainingAnnualLeave();
    }

}
