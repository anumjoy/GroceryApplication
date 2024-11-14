package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	
	public void waitForAttributeWithFluentWait(WebDriver driver, WebElement element, String attribute, String attributeValue,
			int total) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
	}
	
	public void waitForAlertPresence(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitForAttributeWithExplicitWait(WebDriver driver,WebElement element,String attribute,String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}	
	
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeVisibleByXpath(WebDriver driver, String xpath) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void waitForElementToBeSelected(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public void waitForTitle(WebDriver driver,WebElement element,String attribute,String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleIs(value));
	}
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForLoadingToComplete(WebDriver driver) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	    
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading']")));//loadingWait
	}
	
}
