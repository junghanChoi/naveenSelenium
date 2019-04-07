package naveenSeleniumJunghan;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZooplaMainPage extends BasePage{
	private String url = "https://www.zoopla.co.uk/";
	
	
	@FindBy(css=".cookie-banner__button")
	private WebElement cookieBanner;
	
	@FindBy(css="#search-input-location")
	private WebElement forSaleInput;
	
	@FindBy(css="#search-submit")
	private WebElement searchButton;
	
	
	
	public ZooplaMainPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public SearchResultPage searchExactPlace(String location) {
		forSaleInput.sendKeys(location);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ui-menu-item'][1]/a")));
		WebElement exactLi = driver.findElement(By.xpath("//li[@class='ui-menu-item'][1]"));
		exactLi.click();
		searchButton.click();
		return new SearchResultPage(driver);
	}
	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		assertTrue(driver.getTitle().contains("Zoopla"));
	}

	
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.get(url);
		cookieBanner.click();
	}
	
	
}
