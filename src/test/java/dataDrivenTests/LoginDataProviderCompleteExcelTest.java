package dataDrivenTests;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginDataProviderCompleteExcelTest {
	@DataProvider(name = "user-ids-passwords-excel-data-provider")
	public String[][] userIdsAndPasswordsDataProvider() {
		return ExcelReadUtil.readExcelIntoArrary("src/test/java/dataDrivenTests/login-data.xlsx", "Sheet1", 3);
	}

	// Use the data provider
	@Test(dataProvider = "user-ids-passwords-excel-data-provider")
	public void testLoginForAllScenarios(String userId, String password, String isLoginExpectedToBeSuccessfulString) throws Exception {
		Boolean isLoginExpectedToBeSuccessful = Boolean.valueOf(isLoginExpectedToBeSuccessfulString);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signin/v2/sl/pwd?hl=en");
		driver.findElement(By.cssSelector("#identifierId")).sendKeys(userId);
		driver.findElement(By.cssSelector("#identifierNext")).click();
		driver.manage().timeouts().implicitlyWait(10, SECONDS);
//		WebDriverWait wait1 = new WebDriverWait(driver, 10);
//		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#password input[type=\"password\"]")));
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("#password input[type=\"password\"]")).sendKeys(password);
		// why explicity wait are not working???
//		WebDriverWait wait2 = new WebDriverWait(driver, 10);
//		wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#passwordNext")));
			
//		 WebElement ele = driver.findElement(By.cssSelector("#identifierNext"));
//		 JavascriptExecutor executor = (JavascriptExecutor)driver;
//		 executor.executeScript("arguments[0].click();", ele);
		
//		WebElement ele = driver.findElement(By.cssSelector("#passwordNext"));
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", ele);
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#passwordNext")).click();

		// passwordElement.submit();

		if (isLoginExpectedToBeSuccessful) {
			String welcomeMessageText = driver.findElement(By.cssSelector("div[role=\"main\"] header h1")).getText();
			assertTrue(welcomeMessageText.contains("Welcome" + userId));
		} else {
			String errorMessageText = driver.findElement(By.xpath("//span[contains(text(),\"Wrong password\")]")).getText();
			assertTrue(errorMessageText.contains("Wrong password. Try again or click Forgot password to reset"));
		}
		driver.quit();
	}

	@Test
	public void readFromExcel() {
		
		String[][] data = ExcelReadUtil.readExcelIntoArrary("src/test/java/dataDrivenTests/login-data.xlsx", "Sheet1",
				3);
		System.out.println(Arrays.deepToString(data));

	}
}
