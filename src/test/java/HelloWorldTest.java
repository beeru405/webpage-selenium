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
        System.setProperty("webdriver.chrome.driver", "/home/devops/Downloads/chromedriver-linux64");
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

    // Additional Test Cases

    @Test
    public void testHelloWorldPageStructure() {
        // Check the basic structure of the HTML page
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("<!DOCTYPE html>"));
        assertTrue(pageSource.contains("<html lang=\"en\">"));
        assertTrue(pageSource.contains("<head>"));
        assertTrue(pageSource.contains("<title>Hello World Web Page</title>"));
        assertTrue(pageSource.contains("</head>"));
        assertTrue(pageSource.contains("<body>"));
        assertTrue(pageSource.contains("<h1>Hello, World!</h1>"));
        assertTrue(pageSource.contains("</body>"));
        assertTrue(pageSource.contains("</html>"));
    }

    @Test
    public void testHelloWorldMessageColor() {
        // Check the color of the HelloWorld message
        driver.get("url/to/HelloWorldWebPage.html");
        WebElement messageElement = driver.findElement(By.tagName("h1"));
        String color = messageElement.getCssValue("color");
        assertEquals("rgba(0, 0, 0, 1)", color); // Assuming the default color is black
    }

    @Test
    public void testHelloWorldMessageAlignment() {
        // Check the alignment of the HelloWorld message
        driver.get("url/to/HelloWorldWebPage.html");
        WebElement messageElement = driver.findElement(By.tagName("h1"));
        String textAlign = messageElement.getCssValue("text-align");
        assertEquals("center", textAlign); // Assuming the text is centered
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
