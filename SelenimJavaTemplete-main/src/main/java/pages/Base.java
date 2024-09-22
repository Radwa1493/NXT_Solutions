package pages;

import java.io.IOException;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
	public void Select_Random_Value_dropdown_Index(WebElement DDL) {
		
		Select objSelect = new Select(DDL);
		List<WebElement> options = objSelect.getOptions();

		if (options.size() <= 1) {
			System.out.println("Not enough options to select.");
			return;
		}

		Random random = new Random();
		int randomIndex = random.nextInt(options.size() - 1) + 1; // Avoiding the first disabled option
		objSelect.selectByIndex(randomIndex);


	}

	public Boolean  Check_Value_Table(By rows_locator , By cells_locator, String Value ,WebDriver driver) {
		Boolean exist = false;
		List<WebElement> rows = driver.findElements(rows_locator);
	    for (WebElement row : rows)
	    {
	    	List<WebElement> cells = row.findElements(cells_locator);
	    	for (WebElement cell : cells) {
	    		  if (cell.getText().equals(Value))
	  	        {
	    			  exist = true;	 
	  	        }
			}
	       
	    }
		return exist;
	}

	public boolean isElementPresent(By by,WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}
	
	public void MousClick(WebElement element,WebDriver driver) {

	  Actions action = new Actions(driver);
	  action.moveToElement(element).click().perform();
	}	
	
	//Waits
	public void ExplectWait_visibility(int sec, By Element,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element));		
	}

	public void implicitlyWait(int sec,WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS) ;	
	}
	//alarm
	public void DismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		
	}
	//scroll
	public void scrollToElement(By element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
	}
	public void scrollUp(int pixels,WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -" + pixels + ");");
	}
}