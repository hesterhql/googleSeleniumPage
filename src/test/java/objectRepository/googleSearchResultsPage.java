package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class googleSearchResultsPage {
	WebDriver driver;

	@FindBy(xpath = "//*[@id='iSeekSearchBox']")
	WebElement searchBox;
	
	@FindBy(xpath = "//*[@id=\"iSeekSearchButton\"]")
	WebElement searchButton;
	
	@FindBy(css = "#nav > tbody")
	WebElement pageGroup;
	
	public googleSearchResultsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    public WebElement chooseTab(String tabName) {
    	if(tabName=="All")
    		return this.driver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[contains(text(),\""+tabName+"\")]"));
    	else 
    		return this.driver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]//a[contains(text(),\""+tabName+"\")]"));
     }
    
    
}
