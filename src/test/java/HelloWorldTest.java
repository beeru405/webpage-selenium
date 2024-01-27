import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloWorldTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testHelloWorldPageTitle() {
        driver.get("url/to/HelloWorldWebPage.html");
        assertEquals("Hello World Web Page", driver.getTitle());
    }

    @Test
    public void testHelloWorldMessage() {
        driver.get("url/to/HelloWorldWebPage.html");
        WebElement messageElement = driver.findElement(By.tagName("h1"));
        assertEquals("Hello, World!", messageElement.getText());
    }

    @Test
    public void testHelloWorldMessageIsDisplayed() {
        driver.get("url/to/HelloWorldWebPage.html");
        WebElement messageElement = driver.findElement(By.tagName("h1"));
        assertTrue(messageElement.isDisplayed());
    }

    @Test
    public void testHelloWorldMessageFontSize() {
        driver.get("url/to/HelloWorldWebPage.html");
        WebElement messageElement = driver.findElement(By.tagName("h1"));
        String fontSize = messageElement.getCssValue("font-size");
        assertEquals("24px", fontSize);
    }

    // Add more test cases if needed

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
