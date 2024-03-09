package pages;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CoursePage {
	
	private WebDriver driver;
	private By nav = By.id("btnMyCoursesList");
	private By addCourse = By.id("btnListAddCourse");
	private By courseName = By.id("txtCourseName");
	private By courseGrade = By.id("courseGrade");
	private By teachersList = By.xpath("//span[@class='ui-select-placeholder text-muted']");
	private By list1 = By.xpath("//div[@class='col-xs-9 col-sm-8 col-md-8']"); 
	private By createCourse = By.id("btnSaveAsDraftCourse"); 
	private By courseList = By.id("CoursesOrderBy");
	
	public CoursePage(WebDriver driver)
	{
		this.driver = driver;
	
	}
	
	public void courseData(String coursename)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(nav).click();
		driver.findElement(addCourse).click();
		driver.findElement(courseName).sendKeys(coursename);
		Select objSelect =new Select(driver.findElement(courseGrade));
		objSelect.selectByIndex(1);
		driver.findElement(teachersList).click();
		driver.findElement(list1).click();
		driver.findElement(createCourse).click();
		driver.findElement(nav).click();
		Select courseLists =new Select(driver.findElement(courseList));
		courseLists.selectByIndex(3);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		List<WebElement> elements = driver.findElements(By.xpath("//a[@class='lms-margin-top-10 lms-text-center lms-multiline-trunc']"));

		for (WebElement element : elements) {
		    System.out.println("Course Name:" + element.getText());
		    Assert.assertTrue(element.getText().contains(coursename),"Assertion is passed");
		   
		}
		  
		


		
	}
	
	

}
