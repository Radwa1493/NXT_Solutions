package pages;

import java.io.IOException;
import java.time.Duration;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.readJson;

public class LoginPage extends Base {
    private WebDriver driver;
    private WebDriverWait wait;


    private static final By NAME_TXT_FIELD_LOCATOR = By.id("username");
    private static final By PASSWORD_TXT_FIELD_LOCATOR = By.id("password");
    private static final By LOGIN_BTN_LOCATOR = By.xpath("//button[@type='submit']");
    private static final By SKIP_BTN_LOCATOR = By.xpath("//button[contains(text(),'Skip')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }


    private String getJsonValue(String key) throws IOException, ParseException {
        return readJson.ReadJson(key);
    }

    public void enterName() throws IOException, ParseException {
        String name = getJsonValue("name");
        wait.until(ExpectedConditions.visibilityOfElementLocated(NAME_TXT_FIELD_LOCATOR)).sendKeys(name);
    }

    public void enterPassword() throws IOException, ParseException {
        String password = getJsonValue("password");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_TXT_FIELD_LOCATOR)).sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN_LOCATOR)).click();
    }

    public void clickSkip() {
        wait.until(ExpectedConditions.elementToBeClickable(SKIP_BTN_LOCATOR)).click();
    }
}
