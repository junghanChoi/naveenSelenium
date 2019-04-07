package naveenSeleniumJunghan;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AgentPage extends BasePage {

	@FindBy(xpath="//*[@class='bottom-half']/b[1]")
	WebElement name;
	
	@FindBy(xpath="//*[@class='agent_phone']/a")
	WebElement tel;
	
	@FindBy(css="img.agent_logo")
	WebElement logo;
	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(logo));	
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

	public AgentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public HashMap getAgentInfo() {
		HashMap<String, String> map = new HashMap<>();
		map.put("logo", this.logo.getAttribute("src"));
		map.put("name", this.name.getText());
		//Get only phone number
		map.put("tel", this.tel.getAttribute("href").split(":")[1].substring(3));
		return map;
	}
	
}
