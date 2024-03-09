package tests;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import pages.LoginPage;

public class TestBase {
	
//	CountryPage countryObject;
	LoginPage loginObject;
	static AppiumDriver driver;
	
	@BeforeClass
	public void startDriver() throws MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "HUAWEI Y7 Prime 2018");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.0.0");
		caps.setCapability("appPackage", "com.itworx.winjigoteacher");
		caps.setCapability("appActivity", "com.itworx.winjigoteachermoe.presention.ui.activities.SplashActivity");
//		URL url = new URL("http://localhost:4723/wd/hub");
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		loginObject = new LoginPage(driver);




		
	}
	

}
