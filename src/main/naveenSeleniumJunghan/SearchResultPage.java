package naveenSeleniumJunghan;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends BasePage{

	@FindBy(xpath="//ul[@data-role='listview']//a[contains(@class,'text-price')]")
	private List<WebElement> priceList;
	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.attributeContains(
				By.cssSelector("#mn-buy>a"), "data-ga-label","/tracking/for-sale/results/"));
		assertTrue(driver.getTitle().contains("Property for Sale"));
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
	}
	
	public void printTrimedPrice() {
		priceList.stream().forEach(e ->{
			String text = e.getText().split(" ")[0];
			System.out.println(text);
		});
	}

	public SearchResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement getResultByIndex(int index) {
		try {
			WebElement elem = priceList.get(index);
			return elem;
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Out of Index!");
			e.printStackTrace();
			
		}
		return null;
	}
	public DetailPage moveToResultByIndex(int index) {
		WebElement elem = this.getResultByIndex(index);
		Actions action = new Actions(driver);
		action.moveToElement(elem).perform();
		elem.click();
		return new DetailPage(driver);
	}

}
