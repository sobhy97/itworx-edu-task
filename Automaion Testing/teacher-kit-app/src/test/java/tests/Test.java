package tests;
import java.util.concurrent.TimeUnit;
public class Test extends TestBase {
	
	String userName = "Test.teacher@mailinator.com";
	String userPasssword = "Abc_123";

	
		
	@org.testng.annotations.Test
	public void openApp()
	{	
		System.out.println("App is started");
		loginObject.setData(userName,userPasssword);
	}
	
	

}
