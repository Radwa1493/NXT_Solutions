package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventPage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private static final By ATTENDEES_TAB_LOCATOR = By.xpath("//P[contains(.,'Attendees')]");
	private static final By REGESTRATION_TAB_LOCATOR = By.xpath("//span[contains(.,'Registration')]");

	private static final By PLANNING_TAB_LOCATOR = By.xpath("//span[contains(.,'Planning')]");
	private static final By Package_TAB_LOCATOR = By.xpath("//li[1]/a[@href='/packages']");


	public EventPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 50);
	}
	public void clickRegistrationEvent() {
		wait.until(ExpectedConditions.elementToBeClickable(REGESTRATION_TAB_LOCATOR)).click();
	}
	public void clickAttendeesEvent() {
		wait.until(ExpectedConditions.elementToBeClickable(ATTENDEES_TAB_LOCATOR)).click();
	}
	public void clickPlanGEvent() {
		wait.until(ExpectedConditions.elementToBeClickable(PLANNING_TAB_LOCATOR)).click();
	}
	public void clickPackageEvent() {
		wait.until(ExpectedConditions.elementToBeClickable(Package_TAB_LOCATOR)).click();
	}


}
