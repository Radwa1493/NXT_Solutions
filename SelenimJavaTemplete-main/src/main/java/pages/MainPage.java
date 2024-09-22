package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private static final By SUCCESS_MESSAGE =  By.xpath(("//*[contains(text(),'successfully')]"));
	private static final By NEW_EVENT_LOCATOR = By.xpath("//a[@href='/events/options']");
	private static final By Edit_EVENT_LOCATOR = By.xpath("(//button[@class='Button_root__0RbKd Button_ghost__tLrp+ Button_tiny__+g2s1 Button_circle__MofPb'])[2]");


	public MainPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}


	public void clickNewEvent() {
		wait.until(ExpectedConditions.elementToBeClickable(NEW_EVENT_LOCATOR)).click();
	}
	public void clickEditEvent() {
		wait.until(ExpectedConditions.elementToBeClickable(Edit_EVENT_LOCATOR)).click();
	}
	public void OpenCreatedEvent() {
		WebElement element = driver.findElement(By.xpath("//td/div[contains(text(), '" + CreateEventPage.title + "')]"));
		element.click();
	}

    public boolean isEventCreated() {
		try {
			WebElement element = driver.findElement(By.xpath("//td/div[contains(text(), '" + CreateEventPage.title + "')]"));
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	public boolean isSuccessMessageDisplayed() {
		try {

			WebElement element = driver.findElement(SUCCESS_MESSAGE);
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
