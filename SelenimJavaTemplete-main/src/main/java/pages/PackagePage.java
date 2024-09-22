package pages;

import Utilities.Generator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PackagePage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private static final By NEW_PACKAGE_BTN_LOCATOR = By.xpath("//span[contains(.,'New Package')]");
	private static final By SAVE_BTN_LOCATOR = By.xpath("//button[contains(.,'Save')]");
	private static final By TITLE_INPUT_LOCATOR = By.id("package_title");
	private static final By PRORITY_INTPUT_LOCATOR = By.id("package_priority");
	private static final By DELETE_BTN_LOCATOR = By.xpath("(//div[@class='flex justify-end space-x-4']/div/button)[1]");
	private static final By PACKAGE_TITLE_LOCATOR = By.xpath("(//h4[@class='font-bold hidden sm:block Heading_h4__xAIwp font-bold'])[1]");

	private static  String Packagetitle = null;



	public static String Name = null;


	public PackagePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 50);
	}
	public void clickNewPackage() {
		wait.until(ExpectedConditions.elementToBeClickable(NEW_PACKAGE_BTN_LOCATOR)).click();
	}


	public void typeTitle() {
		Packagetitle = Generator.generateRandomString();
		System.out.println(Packagetitle);
		wait.until(ExpectedConditions.elementToBeClickable(TITLE_INPUT_LOCATOR)).sendKeys(Packagetitle);
	}	public void typePrority() {
		scrollToElement(PRORITY_INTPUT_LOCATOR,driver);
		wait.until(ExpectedConditions.elementToBeClickable(PRORITY_INTPUT_LOCATOR)).sendKeys("1");
	}

	public void clickDeleteFeature() {
		scrollToElement(DELETE_BTN_LOCATOR,driver);
		wait.until(ExpectedConditions.elementToBeClickable(DELETE_BTN_LOCATOR)).click();
	}
	public void clickSave() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(SAVE_BTN_LOCATOR)).click();
		Thread.sleep(7000);

	}
	public boolean isPackageCreated() {
		try {

			WebElement element = driver.findElement(PACKAGE_TITLE_LOCATOR);
			System.out.println(element);


			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
