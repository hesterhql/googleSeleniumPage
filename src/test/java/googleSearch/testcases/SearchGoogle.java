package googleSearch.testcases;

import org.testng.annotations.Test;

import objectRepository.GoogleSearchResultsPage;

public class SearchGoogle extends BaseTest {
	

	    @Test(testName = "search", dependsOnMethods="startUrl")
	    public void search() {
	    	GoogleSearchResultsPage gsr= new GoogleSearchResultsPage(driver);
	    	//gsr.searchBox.sendKeys("base test selenium");;
	    	gsr.sendSearchContent("base test selenium");
	    	System.out.println(this.getClass().getSimpleName()+" test cases is running");

	    }



}
