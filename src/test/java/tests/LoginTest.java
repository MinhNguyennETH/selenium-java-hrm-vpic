package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginTestData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"09152", "*******", true},     // Case of successful login
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
    public void testLogin(String username, String password, boolean expectedResult) {
        driver.get("http://115.74.225");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        if (expectedResult) {
            Assert.assertTrue(loginPage.isLoginSuccessful(), "Expected login to succeeded, but it failed.");

        } else {
            Assert.assertTrue(loginPage.isLoginFailed(), "Expected login to fail, but it succeeded.");
        }
    }
}
