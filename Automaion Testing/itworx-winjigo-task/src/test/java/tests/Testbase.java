package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CoursePage;
import pages.LoginPage;


public class Testbase {
	private WebDriver driver;

	private String url = "https://swinji.azurewebsites.net";
	protected LoginPage LoginPage;
	protected CoursePage CoursePage;
	
	@BeforeClass
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        LoginPage = new LoginPage(driver);
        CoursePage = new CoursePage(driver);
       
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		driver.quit();
	}
	
}
