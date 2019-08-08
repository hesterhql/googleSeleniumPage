package googleSearch.testcases;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
/**
 *
 //this is use basic way to setup browser Property and location 
    	if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
    		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\qhe\\Downloads\\chromedriver.exe");
    		System.setProperty("webdriver.chrome.driver", "C:\\Users\\qhe\\.m2\\repository\\webdriver\\chromedriver\\win32\\76.0.3809.68\\chromedriver.exe");

    		driver = new ChromeDriver();

    	}else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
    		System.setProperty("webdriver.firefox.marionette", ".\\geckodriver.exe");
    		driver = new FirefoxDriver();
    	}
    	else if(prop.getProperty("browser").equalsIgnoreCase("Edge")){
    		//set path to Edge.exe
    		System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
    		//create Edge instance
    		driver = new EdgeDriver();
    	}else{
    		//If no browser passed throw exception
    		throw new Exception("Browser is not correct");
    	}
    	**/
    	
    	
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
    	
//        driver = new FirefoxDriver();
//        wait = new WebDriverWait(driver, 60);
    }

    @Test
    public void openGoogle() throws Exception {
    	
    	Properties prop = new Properties();
    	
    	FileInputStream fis = new FileInputStream("C:\\Users\\qhe\\eclipse-workspace\\googleSearch\\src\\test\\java\\globalParameters.properties");
    	prop.load(fis);
    	
        driver.get(prop.getProperty("startUrl"));
        
        //wait.until(ExpectedConditions.titleContains(HOMEPAGE_TITLE));

        final String windowTitle = driver.getTitle();
        System.out.println(windowTitle);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}