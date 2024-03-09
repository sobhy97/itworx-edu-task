package tests;

import org.testng.annotations.Test;

public class CourseTest extends Testbase {
	
	@Test
	public void fillCoursePage()
	{
		LoginPage.login("testregister@aaa.com", "Wakram_123");
		CoursePage.courseData("Test14");
	}

}
