package googleSearch.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import objectRepository.crossBrowserScript;
import objectRepository.googleSearchResultsPage;

public class testcase01 {

	WebDriver driver;
	//cb.setup("chrome");

	@Test
	@Parameters("browser")// use paramenter to set browser type
	public void clickTabOnGooleSearchResultsPage(String browser) throws Exception {
		crossBrowserScript cb = new crossBrowserScript(driver);
		cb.setup(browser);
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\qhe\\Downloads\\chromedriver.exe");
		//driver = new ChromeDriver();
		cb.driver.manage().window().maximize();
		
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\qhe\\eclipse-workspace\\Test01\\src\\test\\java\\globalParameters.properties");
		prop.load(fis);
		cb.driver.get(prop.getProperty("startUrl"));
		
		Thread.sleep(6000);
		googleSearchResultsPage gsrp = new googleSearchResultsPage(cb.driver);
		gsrp.chooseTab("All").click();
		gsrp.chooseTab("News").click();
		gsrp.chooseTab("Images").click();

		//captureScreenShot(driver);

	}

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

//	@AfterTest
//	public void tearDown() {
//		driver.close();
//	}

}
