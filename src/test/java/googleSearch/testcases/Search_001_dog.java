package googleSearch.testcases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import objectRepository.GoogleSearchResultsPage;

public class Search_001_dog extends BaseTest {
	

	    @Test(testName = "search", dependsOnMethods="openGoogle")
	    public void search() throws Exception {
	    	GoogleSearchResultsPage gsr= new GoogleSearchResultsPage(driver);
	    	//gsr.searchBox.sendKeys("base test selenium");;
	    	Assert.assertEquals("Google", driver.getTitle() );
	    	
	    	gsr.sendSearchContent("dog");
	     	pauseSecondTime(10);
	    	System.out.println(this.getClass().getSimpleName()+" test cases is running");
	    	gsr.chooseTab("Images").click();
	    	
	    	// check image display 
	    	 Object result = ((JavascriptExecutor) driver).executeScript(
	    			   "return arguments[0].complete && "+
	    			   "typeof arguments[0].naturalWidth != \"undefined\" && "+
	    			   "arguments[0].naturalWidth > 0", gsr.theFirstImageElement("dog"));
	    	 
	    	 Boolean ImageLoaded = false;
	    	 if (result instanceof Boolean) {
	    		 ImageLoaded = (Boolean) result;
	    	      System.out.println(ImageLoaded);
	    	    }
		     pauseSecondTime(6);


	    }

	    

}
