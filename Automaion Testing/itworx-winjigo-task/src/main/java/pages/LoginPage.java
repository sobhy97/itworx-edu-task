package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	private By email = By.id("Email");
	private By password = By.id("inputPassword");
	private By loginBttn = By.id("btnLogin");
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	
	}
	
	public void login(String mail , String pass)
	{
		driver.findElement(email).sendKeys(mail);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBttn).click();
		
	}


}
