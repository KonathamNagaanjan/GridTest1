package Amazon;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class AmazonTest {
	WebDriver driver;
    String gridUrl = "http://localhost:4444/wd/hub";

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");  // Change to firefox or edge for different browsers
        driver = new RemoteWebDriver(new URL(gridUrl), capabilities);
    }

    @Test
    public void amazonSearchTest() {
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium WebDriver");
        driver.findElement(By.id("nav-search-submit-button")).click();
        assertTrue(driver.getTitle().contains("Selenium WebDriver"), "Title does not contain the search term");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
