package tests;

import org.testng.annotations.Test;

public class LoginTest extends Testbase{
	
	@Test
	public void openLoginScreen()
	{
		LoginPage.login("testregister@aaa.com", "Wakram_123");
	}

}
