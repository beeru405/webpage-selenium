import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testHelloWorldPage() {
        driver.get("url/to/HelloWorldWebPage.html");
        assertEquals("Hello World Web Page", driver.getTitle());
        assertEquals("Hello, World!", driver.findElement(By.tagName("h1")).getText());
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
