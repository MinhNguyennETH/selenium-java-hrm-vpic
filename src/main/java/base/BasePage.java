package base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor để khởi tạo driver và wait
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Phương thức setText
    public void setText(WebElement element, String value, boolean pressEnter) {
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
            el.sendKeys(value);
            if (pressEnter) {
                el.sendKeys(Keys.ENTER);
            }
    }
                                             
    // Phương thức clickElement
    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

}
