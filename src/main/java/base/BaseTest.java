package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ultils.Config;

public class BaseTest {
    protected WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.get(Config.url_Vpic);
    }

    @AfterMethod
    public void teardown() {
        DriverFactory.quitDriver();
    }
}
