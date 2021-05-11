package seleniumtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenuimpage.ShoppingHomePage;

public class ShoppingWebTest {
	
	
	
	private WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1378,763));
	}
	
	
	@Test
	public void getTitle() {
		driver.get(ShoppingHomePage.URL);
		assertEquals("My Store", driver.getTitle());
	}
	
	@Test
	public void searchForFadedShirt() {
		driver.get(ShoppingHomePage.URL);
		
		ShoppingHomePage homePage = PageFactory.initElements(driver, ShoppingHomePage.class);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(homePage.getClickSearch()));
		homePage.getSearchBar().sendKeys("faded short");
		homePage.getClickSearch().click();
		
		assertTrue(homePage.getSearchedText().getText().contains("Faded Short Sleeve T-shirts"));
	}
	
	@After
	public void shutDown() {
		driver.close();		
	}
}
