package googleSearch.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import objectRepository.crossBrowserScript;
import objectRepository.googleSearchResultsPage;

public class testcase01 {

	WebDriver driver;
	//cb.setup("chrome");

	
	@Test(priority=0)
	public void lauchGoogleWeb() throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\qhe\\eclipse-workspace\\googleSearch\\src\\test\\java\\globalParameters.properties");
		prop.load(fis);

		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\qhe\\Downloads\\chromedriver.exe");
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get(prop.getProperty("startUrl"));
		
		//driver.get(prop.getProperty("startUrl"));
		
		
	}

	@Test(priority=1)	
	//@Parameters("browser")// use paramenter to set browser type, not work for @afterTest
	public void clickTabOnGooleSearchResultsPage() throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\qhe\\eclipse-workspace\\googleSearch\\src\\test\\java\\globalParameters.properties");
		prop.load(fis);

		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\qhe\\Downloads\\chromedriver.exe");
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get(prop.getProperty("startUrl"));

		//crossBrowserScript cb = new crossBrowserScript(driver);
		//cb.setup(browser);
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\qhe\\Downloads\\chromedriver.exe");
		//driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		driver.get(prop.getProperty("startUrl"));
		
		Thread.sleep(6000);
		googleSearchResultsPage gsrp = new googleSearchResultsPage(driver);
		gsrp.chooseTab("All").click();
		gsrp.chooseTab("News").click();
		gsrp.chooseTab("Images").click();

		//captureScreenShot(driver);

	}

	
	
	// screen shot function, not sure should be placed there
	public static void captureScreenShot(WebDriver ldriver) {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile method

			FileUtils.copyFile(src, new File("C:\\Users\\qhe\\Desktop\\" + System.currentTimeMillis() + ".png"));
		} catch (IOException e)

		{
			System.out.println(e.getMessage());
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		
	}

}
