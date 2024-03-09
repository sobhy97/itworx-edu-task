package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class LoginPage {
	
	protected AppiumDriver driver;
	
	private By getStartedBttn = By.id("com.itworx.winjigoteacher:id/buttonSignIn");
	private By mail = By.id("com.itworx.winjigoteacher:id/emailView");
	private By pass = By.id("com.itworx.winjigoteacher:id/passwordView");
	private By loginBttn = By.id("com.itworx.winjigoteacher:id/buttonLogin");


	public LoginPage(AppiumDriver driver)
	{
		this.driver=driver;
	}
	
	public void setData(String userName,String userPass)
	{
	    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(getStartedBttn));
		driver.findElement(getStartedBttn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(mail));
		driver.findElement(mail).sendKeys(userName);
		driver.findElement(pass).sendKeys(userPass);
		driver.findElement(loginBttn).click();


	}
	

}
