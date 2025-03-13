package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(String browser) {
        if (driver.get() == null) {
            WebDriver newDriver;
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    newDriver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    newDriver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    newDriver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Browser không hỗ trợ: " + browser);
            }

            newDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
            newDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            newDriver.manage().window().maximize();
            driver.set(newDriver);
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
