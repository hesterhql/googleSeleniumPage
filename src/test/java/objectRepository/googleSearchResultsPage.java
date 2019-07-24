package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class googleSearchResultsPage {
	WebDriver driver;

	@FindBy(xpath = "//input[@title=\"Search\"]")
	public WebElement searchBox;
	
	@FindBy(xpath = "//*[@id=\"iSeekSearchButton\"]")
	public WebElement searchButton;
	
	@FindBy(css = "#nav > tbody")
	public WebElement pageGroup;

    public WebElement chooseTab(String tabName) {
    	if(tabName=="All")
    		return this.driver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[contains(text(),\""+tabName+"\")]"));
    	else 
    		return this.driver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]//a[contains(text(),\""+tabName+"\")]"));
     }
    
	
	public googleSearchResultsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    
    
}
