package useWebDriverManager.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.junit.*;

public class ChromeTest {
	private WebDriver driver;
	
	@BeforeClass
	public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        // Your test code here
        driver.manage().timeouts().implicitlyWait(20, SECONDS);
    	driver.get("http://www.google.com");
    	System.out.println(driver.getTitle());
    }



}
