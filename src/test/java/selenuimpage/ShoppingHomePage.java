package selenuimpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingHomePage {
	
	public static final String URL="http://automationpractice.com/index.php";
	
	@FindBy(id = "search_query_top")
	private WebElement searchBar;
	
	
	@FindBy(name = "submit_search")
	private WebElement clickSearch;
	
	@FindBy(xpath = "//div[2]/h5/a")
	private WebElement searchedText;


	public WebElement getSearchBar() {
		return searchBar;
	}


	public WebElement getClickSearch() {
		return clickSearch;
	}


	public static String getUrl() {
		return URL;
	}


	public WebElement getSearchedText() {
		return searchedText;
	}


	public void setSearchedText(WebElement searchedText) {
		this.searchedText = searchedText;
	}
	
}


