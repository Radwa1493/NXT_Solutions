package pages;

import Utilities.Generator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditEventPage extends Base {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final By SCRATCH_BTN_LOCATOR = By.xpath("(//div[@class='self-center text-center'])[1]");
    private static final By DOTS_BTN_LOCATOR = By.xpath("(//div[@class='h-full relative']/button)[2]");
    private static final By Edit_BTN_LOCATOR = By.xpath("//button[contains(text(), 'Edit')]");
    private static final By Delete_BTN_LOCATOR = By.xpath("//strong[contains(text(), 'Delete')]");
    private static final By Delete_INPUT_LOCATOR = By.id("delete-input");
    private static final By Confirm_Delete_BTN_LOCATOR = By.xpath("//button[contains(text(), 'Delete Forever')]");




    public EditEventPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void clickDotsInEvent() {
        wait.until(ExpectedConditions.elementToBeClickable(DOTS_BTN_LOCATOR)).click();
    }
    public void clickEditEvent() {
        wait.until(ExpectedConditions.elementToBeClickable(Edit_BTN_LOCATOR)).click();
    }
    public void clickDeletevent() {
        wait.until(ExpectedConditions.elementToBeClickable(Delete_BTN_LOCATOR)).click();
    }
    public void confirmDeletevent() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(Delete_INPUT_LOCATOR)).sendKeys("delete-event-permanently");
        wait.until(ExpectedConditions.elementToBeClickable(Confirm_Delete_BTN_LOCATOR)).click();
        Thread.sleep(2000);
    }

}
