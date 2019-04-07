package naveenSeleniumJunghan;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NaveenTest {
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"driverPath"})
	public void setUp(String driverPath) {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void scenario() {
		ZooplaMainPage main = new ZooplaMainPage(driver);
		main.get();
		SearchResultPage result = main.searchExactPlace("London");
		result.get();
		result.printTrimedPrice();
		DetailPage detail = result.moveToResultByIndex(4);
		detail.get();
		HashMap agentInfo1 = detail.getAgentInfo();
		AgentPage agent = detail.moveToAgentPage();
		agent.get();
		HashMap agentInfo2 = agent.getAgentInfo();
		
		assertTrue(agentInfo1.equals(agentInfo2));
		
	}
}
