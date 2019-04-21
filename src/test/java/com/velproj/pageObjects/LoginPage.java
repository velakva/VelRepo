package com.velproj.pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}

	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement logButton;
	
	public void login(String uName,String psw) throws InterruptedException{
		txtUserName.sendKeys(uName);
		txtPassword.sendKeys(psw);
		txtUserName.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		txtUserName.sendKeys(Keys.chord(Keys.CONTROL,"c"));
		txtPassword.sendKeys(Keys.chord(Keys.CONTROL,"v"));
		logButton.click();
		Thread.sleep(4000);
		/*WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id")));*/
		Wait<WebDriver> gWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
		        .pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		WebElement clickseleniumlink = gWait.until(new Function<WebDriver, WebElement>(){
			
			public WebElement apply(WebDriver driver ) {
				return driver.findElement(By.xpath("/html/body/div/a/i"));
			}
		});
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
}
