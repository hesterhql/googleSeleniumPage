package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultsPage {
	WebDriver driver;

	@FindBy(xpath = "//input[@title=\"Search\"]")
	private WebElement searchBox;
	
	@FindBy(css = "#nav > tbody")
	private WebElement pageGroup;

    public WebElement chooseTab(String tabName) {
    	if(tabName=="All")
    		return this.driver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[contains(text(),\""+tabName+"\")]"));
    	else 
    		return this.driver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]//a[contains(text(),\""+tabName+"\")]"));
     }
    
    public void sendSearchContent(String keyword) {
    	if (keyword!=null)
    		searchBox.sendKeys(keyword); 
    		searchBox.sendKeys(Keys.ENTER);	
    }
    
    public WebElement theFirstImageElement(String keyword) {
    	WebElement image = driver.findElement(By.cssSelector("#rg_s div:nth-of-type(1) img[alt*='"+keyword+"']:nth-of-type(1)"));
    	return image;
    }
	
	
	public GoogleSearchResultsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    
    
}
