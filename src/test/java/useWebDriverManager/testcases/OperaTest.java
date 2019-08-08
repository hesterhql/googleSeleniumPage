package useWebDriverManager.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.junit.*;

public class OperaTest {
	private WebDriver driver;
	
	@BeforeClass
	public static void setupClass() {
        WebDriverManager.operadriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new OperaDriver();
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
