package utilities;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralUtility {
	
	public String selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	
	public String selectDropdownWithIndex(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public void selectDropdownWithVisibleText(WebElement element, String text) {
		Select object = new Select(element);
		object.selectByVisibleText(text);
		WebElement selectedElement = object.getFirstSelectedOption();
		selectedElement.click();
	}
	

	public void clickWithJavaScript(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
	}

	public void clickJavaScriptExecutorByScroll(WebDriver driver, List<WebElement> elements, int index) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", elements.get(index));
	}
	
	public void sendValueUsingJavaScriptAndBlur(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '" + value + "'", element);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].blur()", element);
	}
	public int randon(int limit) {
		Random random = new Random();
		// int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}
	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
	//Actions Class
	public void dragAndDropElement(WebDriver driver, WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }
	//Accept Alert
	public String acceptAlert(WebDriver driver) {
        String alertText = driver.switchTo().alert().getText(); 
        driver.switchTo().alert().accept(); 
        return alertText; 
    }
	//Dismiss Alert
		public String dismisstAlert(WebDriver driver) {
	        String alertText = driver.switchTo().alert().getText(); 
	        driver.switchTo().alert().dismiss(); 
	        return alertText; 
	    }
	//CheckBox
		public void selectCheckboxElement(WebElement checkBoxElement) {
	        checkBoxElement.click(); 
	        //boolean checkSelected = checkBoxElement.isSelected();
	        //System.out.println(checkSelected);
	    }
	//KeyBoardMouse
		public void KeyBoardMouseElement(WebDriver driver, WebElement element) {
	        Actions actions = new Actions(driver);
	        actions.doubleClick(element).perform();
	    }
	//Scroll
		public void scrollToElement(WebDriver driver, WebElement element) {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
	

}
