package tests;

import base.BaseTest;
import helpers.CaptureHelpers;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.LogUtils;

public class LoginTest extends BaseTest {

    @BeforeClass
    public void setupRecord() throws Exception {
        CaptureHelpers.startRecord("Login Test");
        
    }

    // Nó sẽ thực thi sau mỗi lần thực thi testcase (@Test)
    @AfterMethod
    public void takeScreenshot(ITestResult result) throws InterruptedException {
        Thread.sleep(1000);
        //Khởi tạo đối tượng result thuộc ITestResult để lấy trạng thái và tên của từng Test Case
        //Ở đây sẽ so sánh điều kiện nếu testcase passed hoặc failed
        //passed = SUCCESS và failed = FAILURE

        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                CaptureHelpers.captureScreenshot(driver, result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(1000);
        driver.quit();

        CaptureHelpers.stopRecord();
    }
    

    @DataProvider(name = "loginTestData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"09152", "Vanbinh123", true},          // Case of successful login
                {"aa", "09152", false},                 // In case the login name is wrong
                {"09152", "hg", false},                 // In case the password name is wrong
                {"", "09152", false},                   // In case the login name is left blank, the correct password
                {"09152", "", false},                   // In case the password is left blank, the correct username
                {"", "", false},                        // In case both login name and password are left blank
                {"' OR '1'='1", "' OR '1'='1", false},  // Case of SQL injection for username and password
                {"admin' --", "admin", false},          // Case of SQL injection with comment
                {"' OR '1'='1' --", "Admin123", false}, // Case of SQL injection with OR condition
                {"' OR '1'='1' #", "Minhnguyen", false} // Another SQL injection variant

        };
    }

    @Test(dataProvider = "loginTestData")
    public void testLogin(String username, String password, boolean expectedResult)  {
        LogUtils.info("Chạy test case login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
 
        if (expectedResult) {
            Assert.assertTrue(loginPage.isLoginSuccessful(), "Expected login to succeeded, but it failed.");

        } else {
            Assert.assertTrue(loginPage.isLoginFailed(), "Expected login to fail, but it succeeded.");
        }
    }
}
