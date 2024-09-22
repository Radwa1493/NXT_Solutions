package pages;

import Utilities.Generator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateEventPage extends Base {
    private WebDriver driver;
    private WebDriverWait wait;
    public static String title = null;
    private static final By SCRATCH_BTN_LOCATOR = By.xpath("(//div[@class='self-center text-center'])[1]");
    private static final By TITLE_BTN_LOCATOR = By.xpath("(//input[@class='Input_root__fi0ZK'])[1]");
    private static final By SLUG_BTN_LOCATOR = By.xpath("(//input[@class='Input_root__fi0ZK'])[2]");
    private static final By START_DATE_INPUT_LOCATOR = By.xpath("(//input[@class='Input_root__fi0ZK'])[3]");
    private static final By START_TIME_INPUT_LOCATOR = By.xpath("(//input[@class='Input_root__fi0ZK'])[4]");
    private static final By END_DATE_INPUT_LOCATOR = By.xpath("(//input[@class='Input_root__fi0ZK'])[5]");
    private static final By END_TIME_INPUT_LOCATOR = By.xpath("(//input[@class='Input_root__fi0ZK'])[6]");

    private static final By FILE_INPUTBTN_LOCATOR = By.cssSelector("input[type='file']");
    private static final By EVENT_DDL_LOCATOR = By.xpath("(//select[@class='Input_root__fi0ZK Input_selectInput__aHlvF'])[1]");
    private static final By Zone_DDL_LOCATOR = By.xpath("(//select[@class='Input_root__fi0ZK Input_selectInput__aHlvF'])[2]");
    private static final By CREATE_BTN_LOCATOR = By.xpath("//button[contains(text(),'Create')]");
    private static final By EDIT_BTN_LOCATOR = By.xpath("//button[contains(text(),'Edit')]");


    public CreateEventPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void clickScratchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SCRATCH_BTN_LOCATOR)).click();
    }

    public void typeTitle() {
        title = Generator.generateRandomString();
        System.out.println("Event Created Name"+title);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(TITLE_BTN_LOCATOR));
        element.clear();
        element.sendKeys(title);
    }

    public void typeSlug() {
        wait.until(ExpectedConditions.elementToBeClickable(SLUG_BTN_LOCATOR)).sendKeys(Generator.generateRandomString());
    }

    public void uploadImage(String path) {
//		WebElement uploadText = driver.findElement(By.xpath("//span[@class='underline']"));
//		uploadText.click(); // Trigger the file dialog

        // Wait for the file input to be present and visible
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.elementToBeClickable(FILE_INPUTBTN_LOCATOR)).sendKeys(path);

    }

    public void selectRandomEvent() {

        Select_Random_Value_dropdown_Index(driver.findElement(EVENT_DDL_LOCATOR));
    }

    public void selectZoneEvent() {

        Select_Random_Value_dropdown_Index(driver.findElement(Zone_DDL_LOCATOR));
    }

    public void clickCreateButton() throws InterruptedException {
        scrollUp(1000, driver);
        wait.until(ExpectedConditions.elementToBeClickable(CREATE_BTN_LOCATOR)).click();
        Thread.sleep(10000);
    }
    public void typeStartDate() {
        wait.until(ExpectedConditions.elementToBeClickable(START_DATE_INPUT_LOCATOR)).sendKeys(Generator.getDatePlusDays(0));
    }
    public void typeStartTime() {
       wait.until(ExpectedConditions.elementToBeClickable(START_TIME_INPUT_LOCATOR)).sendKeys("11111");
    }
    public void typeEndDate() {
        wait.until(ExpectedConditions.elementToBeClickable(END_DATE_INPUT_LOCATOR)).sendKeys(Generator.getDatePlusDays(2));
    }
    public void typeEndTime() {
        wait.until(ExpectedConditions.elementToBeClickable(END_TIME_INPUT_LOCATOR)).sendKeys("11112");
    }
    public void clickEditButton() throws InterruptedException {
        scrollUp(1000, driver);
        wait.until(ExpectedConditions.elementToBeClickable(EDIT_BTN_LOCATOR)).click();
        Thread.sleep(10000);
    }

}
