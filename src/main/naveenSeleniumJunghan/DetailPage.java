package naveenSeleniumJunghan;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailPage extends BasePage{

	@FindBy(css=".ui-agent__logo>img")
	WebElement logo;
	@FindBy(css=".ui-agent__text>h4")
	WebElement name;
	@FindBy(css=".ui-agent__tel>a")
	WebElement tel;
	
	public DetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		assertTrue(isElementPresent(By.xpath("//span[@data-bts-text='Back to search results']")));
	}

	public HashMap getAgentInfo() {
		Map<String, String> data = new HashMap<>();
		data.put("logo", this.logo.getAttribute("src"));
		data.put("name", this.name.getText());
		//Get only phone number
		data.put("tel", this.tel.getAttribute("href").split(":")[1].substring(1));
		return (HashMap) data;
	}
	
	public AgentPage moveToAgentPage() {
		this.name.click();
		return new AgentPage(driver);
	}
	
	@Override
	protected void load() {
		// TODO Auto-generated method stub
	}

}
