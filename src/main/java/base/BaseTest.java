package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import ultils.Config;

public class BaseTest {
    protected WebDriver driver;


    @BeforeClass
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.get(Config.url_Vpic);
    }

    @AfterClass
    public void teardown() {
        DriverFactory.quitDriver();
    }
}
