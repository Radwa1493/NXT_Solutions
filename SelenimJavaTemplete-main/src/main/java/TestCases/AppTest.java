package TestCases;

import java.awt.*;
import java.io.File;
import java.io.IOException;

//import Utilities.ScreenRecorderUtil;
import Utilities.ScreenRecorderUtil;
import org.apache.commons.io.FileUtils;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utilities.readJson;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.*;

public class AppTest {
	SoftAssert softAssert = new SoftAssert();

	private static LoginPage Loginpage;
	private static MainPage Mainpage;
	private static EditEventPage EditEventpage;
	private static CreateEventPage CreateEventpage;
	private static EventPage Eventpage;
	private static AttendesstPage Attendesstpage;
	private static PackagePage Packagepage;
	private static readJson read_Json;
	public static WebDriver driver;
	public static SoftAssert softAssertion = new SoftAssert();
	private static TakesScreenshot ts;
	private static ScreenRecorder screenRecorder;

	@Parameters({ "browser" })
	@BeforeTest
	public void setUp(String browser) throws Exception {
		System.out.println("Starting..... ");
		if (browser.equals("Chrome")) {
			System.out.println("Open Local Chrome");
			ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
		} else if (browser.equals("Firefox")) {
			System.out.println("Open Local Firefox");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		System.out.println("Open URL");
		driver.get(readJson.ReadJson("URL"));
		Loginpage = new LoginPage(driver);
		Mainpage = new MainPage(driver);
		Eventpage= new EventPage(driver);
		Attendesstpage = new AttendesstPage(driver);
		CreateEventpage = new CreateEventPage(driver);
		EditEventpage = new EditEventPage(driver);
		Packagepage = new PackagePage(driver);

		ts = (TakesScreenshot) driver; // Initialize TakesScreenshot

		// Take Video
		ScreenRecorderUtil.startRecord("Run");
	}

	@Test(priority = 1)
	public void Login() throws Exception {
		System.out.println("Login");
		try {
			Loginpage.enterName();
			Loginpage.enterPassword();
			Loginpage.clickLogin();
			Loginpage.clickSkip();
			// Capture a screenshot after login action
			File screenshot = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("./test-screenShot/TC_Login.png"));
		} catch (Exception e) {
			// Capture a screenshot on failure
			if (ts != null) {
				File screenshot = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("./test-screenShot/TC_Login_Failure.png"));
			}
			throw e; // rethrow exception after taking screenshot
		}
	}

	@Test(priority = 2, dependsOnMethods = "Login")
	public void CreateEvent() throws Exception {
		System.out.println("CreateEvent");
		try {
			Mainpage.clickNewEvent();
			CreateEventpage.clickScratchButton();
			CreateEventpage.typeTitle();
			CreateEventpage.typeSlug();
		//	CreateEventpage.uploadImage("./src/main/java/Resources/img.png");
			CreateEventpage.selectRandomEvent();
			CreateEventpage.typeStartDate();
			CreateEventpage.typeStartTime();
			CreateEventpage.typeEndDate();
			CreateEventpage.typeEndTime();
			CreateEventpage.selectZoneEvent();
			CreateEventpage.clickCreateButton();
			//Assertions
			softAssert.assertTrue(Mainpage.isEventCreated(),"Event not added");
			// Capture a screenshot after login action
			File screenshot = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("./test-screenShot/TC_CreateEvent.png"));
		} catch (Exception e) {
			// Capture a screenshot on failure
			if (ts != null) {
				File screenshot = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("./test-screenShot/TC1_Login_Failure.png"));
			}
			throw e; // rethrow exception after taking screenshot
		}
	}

	@Test(priority = 3 , dependsOnMethods = "CreateEvent")
	public void EditEvent() throws Exception {
		System.out.println("UpdateEvent");
		try {
			Mainpage.clickEditEvent();
			CreateEventpage.typeTitle();
			CreateEventpage.selectRandomEvent();
			CreateEventpage.clickEditButton();
			softAssert.assertTrue(Mainpage.isEventCreated(),"Event not updated");

			// Capture a screenshot after login action
			File screenshot = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("./test-screenShot/TC_CreateEvent.png"));
		} catch (Exception e) {
			// Capture a screenshot on failure
			if (ts != null) {
				File screenshot = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("./test-screenShot/TC_CreateEvent.png"));
			}
			throw e; // rethrow exception after taking screenshot
		}
	}

@Test(priority = 4, dependsOnMethods = "EditEvent")
public void CreatePackage() throws Exception {
	System.out.println("CreatePackage");
	try {
		Mainpage.OpenCreatedEvent();
		Eventpage.clickPlanGEvent();
		Eventpage.clickPackageEvent();
		Packagepage.clickNewPackage();
		Packagepage.typeTitle();
		Packagepage.typePrority();
		Packagepage.clickDeleteFeature();
		Packagepage.clickSave();
		//Assertions
		softAssert.assertTrue(Packagepage.isPackageCreated()," Package not added");

		// Capture a screenshot after login action
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./test-screenShot/TC_CreatePackage.png"));
	} catch (Exception e) {
		// Capture a screenshot on failure
		if (ts != null) {
			File screenshot = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("./test-screenShot/TC_CreatePackage_Failure.png"));
		}
		throw e; // rethrow exception after taking screenshot
	}
}
	@Test(priority = 5, dependsOnMethods = "CreatePackage")
	public void CreateUser() throws Exception {
		System.out.println("CreateUser");
		try {
			Eventpage.clickRegistrationEvent();
			Eventpage.clickAttendeesEvent();
			Attendesstpage.clickAllUserEvent();
			Attendesstpage.clickAddUserEvent();
			Attendesstpage.addUserDetails();
			Attendesstpage.clickCreate();
			softAssert.assertTrue(Mainpage.isSuccessMessageDisplayed()," Success Message not Displayed");

			// Capture a screenshot after login action
			File screenshot = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("./test-screenShot/TC_CreateUser.png"));
		} catch (Exception e) {
			// Capture a screenshot on failure
			if (ts != null) {
				File screenshot = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("./test-screenShot/TC_CreateUser.png"));
			}
			throw e; // rethrow exception after taking screenshot
		}
	}
	@Test(priority = 6, dependsOnMethods = "CreateUser")
	public void CreateTrip() throws Exception {
		System.out.println("CreateTrip");
		try {
			Attendesstpage.clickTripInfo();
			Attendesstpage.clickAddTrip();
			Attendesstpage.selectPackage();
			Attendesstpage.clickCreate();
			softAssert.assertTrue(Mainpage.isSuccessMessageDisplayed()," Success Message not Displayed");

			softAssert.assertTrue(Attendesstpage.isTripCreated()," Trip not added");


			// Capture a screenshot after login action
			File screenshot = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("./test-screenShot/TC_CreateTrip.png"));
		} catch (Exception e) {
			// Capture a screenshot on failure
			if (ts != null) {
				File screenshot = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("./test-screenShot/TC_CreateTrip.png"));
			}
			throw e; // rethrow exception after taking screenshot
		}
	}

	@Test(priority = 7, dependsOnMethods = "EditEvent")
	public void DeleteEvent() throws Exception {
		System.out.println("DeleteEvent");
		try {
			driver.get(readJson.ReadJson("myEventurl"));
			Mainpage.clickEditEvent();
			EditEventpage.clickDotsInEvent();
			EditEventpage.clickDeletevent();
			EditEventpage.confirmDeletevent();
			//Assertions
			softAssert.assertTrue(Mainpage.isSuccessMessageDisplayed()," Success Message not Displayed");
			softAssert.assertFalse(Mainpage.isEventCreated(),"Event not deleted");

			// Capture a screenshot after login action
			File screenshot = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("./test-screenShot/TC_DeleteEvent.png"));
		} catch (Exception e) {
			// Capture a screenshot on failure
			if (ts != null) {
				File screenshot = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("./test-screenShot/TC_DeleteEvent.png"));
			}
			throw e; // rethrow exception after taking screenshot
		}
	}
	@AfterTest
	public void afterMethod() throws Exception {
		// stop recording
		ScreenRecorderUtil.stopRecord();

		softAssert.assertAll();

		if (driver != null) {
			driver.quit();
		}
	}

}
