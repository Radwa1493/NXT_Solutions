package pages;

import Utilities.Generator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AttendesstPage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private static final By ALL_USERS_LOCATOR = By.xpath("//P[contains(.,'All Users')]");
	private static final By ADD_USER_LOCATOR = By.xpath("//span[contains(.,'Add User')]");
	private static final By FIRSTNAME_LOCATOR = By.id("firstName");
	private static final By LASTNAME_LOCATOR = By.id("lastName");
	private static final By TITLE_LOCATOR = By.id("title");
	private static final By EMAIL_LOCATOR =  By.xpath("//input[@type='email']");
	private static final By CREATE_LOCATOR =  By.xpath("//Button[contains(.,'Create')]");
	private static final By TRIP_INFO_Locator =  By.xpath("//p[contains(text(),'Trip Info')]/../../..");
	private static final By ADD_TRIP_Locator =  By.xpath("//a/div/p[contains(text(),'Add Trip')]");
	private static final By PRORITY_DDL_Locator =  By.id("entity");
	private static final By TRIP_STATUS_LOCATOR =  By.xpath(("//span[contains(text(), 'Pending')]"));

	public static String Name = null;


	public AttendesstPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}
	public void clickAllUserEvent() {
		wait.until(ExpectedConditions.elementToBeClickable(ALL_USERS_LOCATOR)).click();
	}
	public void clickAddUserEvent() {
		wait.until(ExpectedConditions.elementToBeClickable(ADD_USER_LOCATOR)).click();
	}

	public void addUserDetails() throws InterruptedException {
		Name = Generator.generateRandomString();
		wait.until(ExpectedConditions.elementToBeClickable(FIRSTNAME_LOCATOR)).sendKeys(Name);;
		wait.until(ExpectedConditions.elementToBeClickable(LASTNAME_LOCATOR)).sendKeys(Name);;
		wait.until(ExpectedConditions.elementToBeClickable(TITLE_LOCATOR)).sendKeys(Name);;
		wait.until(ExpectedConditions.elementToBeClickable(EMAIL_LOCATOR)).sendKeys(Name+"@test.com");

	}
	public void clickTripInfo() {
		scrollUp(1000,driver);
//		try{
//			MousClick(driver.findElement(TRIP_INFO_Locator),driver);
//
//		} catch (Exception e) {
			driver.navigate().refresh();
			wait.until(ExpectedConditions.elementToBeClickable(TRIP_INFO_Locator)).click();

	//	}

    }
	public void clickAddTrip() {
		wait.until(ExpectedConditions.elementToBeClickable(ADD_TRIP_Locator)).click();
	}
	public void selectPackage() {
		Select_Random_Value_dropdown_Index(driver.findElement(PRORITY_DDL_Locator));
	}
	public void clickCreate() throws InterruptedException {
		scrollUp(1000, driver);
		implicitlyWait(50,driver);
		wait.until(ExpectedConditions.elementToBeClickable(CREATE_LOCATOR)).click();
		Thread.sleep(2000);	}




	public boolean isTripCreated() {
		try {

			WebElement element = driver.findElement(TRIP_STATUS_LOCATOR);
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
