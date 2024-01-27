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
        System.setProperty("webdriver.chrome.driver", "/home/devops/Downloads/chromedriver-linux64/chromedriver");
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

    @Test
    public void testHelloWorldMessageFontColor() {
        driver.get("url/to/HelloWorldWebPage.html");
        WebElement messageElement = driver.findElement(By.tagName("h1"));
        String fontColor = messageElement.getCssValue("color");
        assertEquals("rgba(0, 0, 0, 1)", fontColor);
    }

    @Test
    public void testHelloWorldPageBackgroundColor() {
        driver.get("url/to/HelloWorldWebPage.html");
        WebElement bodyElement = driver.findElement(By.tagName("body"));
        String bgColor = bodyElement.getCssValue("background-color");
        assertEquals("rgba(255, 255, 255, 1)", bgColor);
    }

    // Failing test case
    @Test
    public void testNonexistentElement() {
        driver.get("url/to/HelloWorldWebPage.html");
        // Attempt to find an element that does not exist
        WebElement nonexistentElement = driver.findElement(By.id("nonexistent-id"));
        // This line will not be reached if the element is not found
        assertTrue(nonexistentElement.isDisplayed());
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
