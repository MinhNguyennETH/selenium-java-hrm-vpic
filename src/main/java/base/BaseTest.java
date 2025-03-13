package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ultils.Config;

public class BaseTest {
    protected WebDriver driver;


    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
        driver = DriverFactory.getDriver(browser);
        driver.get(Config.url_Vpic);
    }

    @AfterMethod
    public void teardown() {
        DriverFactory.quitDriver();
    }
}