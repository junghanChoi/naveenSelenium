package naveenSeleniumJunghan;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage extends LoadableComponent<BasePage> {
	final static private long LOADTIME = 10l;
	
	protected WebDriver driver;
	WebDriverWait wait;
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, LOADTIME);
	}
	
	public boolean isElementPresent(By loc) {
		try {
			driver.findElement(loc);
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
	}
}
