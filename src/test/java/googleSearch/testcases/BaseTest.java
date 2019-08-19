package googleSearch.testcases;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {


//    private static String HOMEPAGE = "http://www.google.com";
//    private static String HOMEPAGE_TITLE = "Google";

    protected static WebDriverWait wait;
    protected static WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
    	Properties prop = new Properties();
    	
    	FileInputStream fis = new FileInputStream("C:\\Users\\qhe\\eclipse-workspace\\googleSearch\\src\\test\\java\\globalParameters.properties");
    	prop.load(fis);
  	
    	
    	if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
    	WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    }else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
	    	WebDriverManager.firefoxdriver().setup();
    		driver = new FirefoxDriver();
    	}
    	else if(prop.getProperty("browser").equalsIgnoreCase("Edge")){
    		//set path to Edge.exe
	    	WebDriverManager.edgedriver().setup();

    		//create Edge instance
    		driver = new EdgeDriver();
    	}else{
    		//If no browser passed throw exception
    		throw new Exception("Browser is not correct");
    	}
	      
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.manage().window().maximize();
    	

    }

    @Test
    public void openGoogle() throws Exception {
    	
    	Properties prop = new Properties();
    	
    	FileInputStream fis = new FileInputStream("C:\\Users\\qhe\\eclipse-workspace\\googleSearch\\src\\test\\java\\globalParameters.properties");
    	prop.load(fis);
    	
        driver.get(prop.getProperty("startUrl"));
        
        //wait.until(ExpectedConditions.titleContains(HOMEPAGE_TITLE));

        final String windowTitle = driver.getTitle();
        Assert.assertEquals("Google", windowTitle);
    }
    
    public void pauseSecondTime(int second) throws Exception {
    	
		Thread.sleep(second*1000);

    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}