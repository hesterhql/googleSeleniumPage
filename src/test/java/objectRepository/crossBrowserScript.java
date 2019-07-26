package objectRepository;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserScript {
	
	public WebDriver driver;
	
	public CrossBrowserScript(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@BeforeTest 
	//@Parameters("browser")// use paramenter to set browser type
	public void  setup(String browser) throws Exception{
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox"))
		{
			//create firefox instance
			System.setProperty("webdriver.firefox.marionette", ".\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","C:\\Users\\qhe\\Downloads\\chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();
		}
		//Check if parameter passed as 'Edge'
				else if(browser.equalsIgnoreCase("Edge")){
					//set path to Edge.exe
					System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
					//create Edge instance
					driver = new EdgeDriver();
				}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
//	@Test
//	public void testParameterWithXML() throws InterruptedException{
//		
//
//		driver.get("http://demo.guru99.com/V4/");
//		//Find user name
//		WebElement userName = driver.findElement(By.name("uid"));
//		//Fill user name
//		userName.sendKeys("guru99");
//		//Find password
//		WebElement password = driver.findElement(By.name("password"));
//		//Fill password
//		password.sendKeys("guru99");
//	}
}