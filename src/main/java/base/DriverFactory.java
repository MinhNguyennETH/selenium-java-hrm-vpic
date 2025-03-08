package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverFactory {
    // Sử dụng ThreadLocal để mỗi thread có instance riêng
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            System.setProperty("webdriver.chrome.driver", "E:\\HRM_VPIC\\src\\test\\resources\\driver\\chromedriver.exe");
            WebDriver newDriver = new ChromeDriver();
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
            driver.remove(); // Xóa instance sau khi quit
        }
    }
}
