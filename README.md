# Ahmed Sobhy
### This Challenge covers the following :
* Manual Testing.
* Api Testing.
* Automation Testing using [Cucumber - Selenium - Appium - Python].
* Code Assessment.

# Excel sheet task

This part is covering the valid data only according to the criteria.

## Installation
I used python to filter data with the expected criteria
### Preconditions for selenium: 
* python 3.
* pandas library.
* CMD to run the code and after this a new file will be generated with name Valid_data.xlsx containing the correct data only.

### Code Snippet

```
    import pandas as pd
def Count_Digits(num):
  count = 0
  while num != 0:
    num //= 10
    count += 1
  return count

def valid_ID(ID):
  valid = 'false'
  N_Digits = Count_Digits(ID)
  ID = str(ID)
  if (ID[0:4] == '1234') and (N_Digits == 10):
    valid = 'True'    
  return valid 


# Read excel file 
file_path = "Data Sheet.xlsx"
data = pd.read_excel(file_path, sheet_name=['Student', 'School'])

student = data['Student']
school  = data['School']

# School Table 
school.rename(columns = {'Gender (R)':'School_Gender (R)', 'Religion (R)':'School_Religion (R)', }, inplace = True) 
School_Valid_Data = school.copy()

        
        
```

# Automation Testing 

This part is covering a list of automated test cases for winjigo website.

## Installation
I used Selenium.
### Preconditions for REST Assured: 
* Java.
* Eclipse.
* Maven.
* TestNG.
************** Please Run this project from TestSuie.xml file ***********

### Maven Dependency
```
        <dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>3.141.59</version>
		</dependency>
		<dependency>
    	<groupId>io.github.bonigarcia</groupId>
    	<artifactId>webdrivermanager</artifactId>
    	<version>5.7.0</version>
		</dependency>
		        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.3.0</version>
            <scope>test</scope>
        </dependency>
```
Check the pom file.

### Code Snippet

```Java
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
```
# API Automation Testing 

This part is covering a list of automated test cases for https://www.boredapi.com/api/activity website.

## Installation
I used Cucumber [BDD] approach.
### Preconditions for REST Assured: 
* Eclipse.
* Maven.
* TestNG.
************** Please Run this project from run.feature file ***********

### Maven Dependency
```
         <dependency>
      <groupId>io.cucumber</groupId>
      <artifactId>cucumber-java</artifactId>
      <version>7.15.0</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
    <dependency>
      <groupId>io.cucumber</groupId>
      <artifactId>cucumber-junit</artifactId>
      <version>7.15.0</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
    <dependency>
      <groupId>io.rest-assured</groupId>
      <artifactId>rest-assured</artifactId>
      <version>5.4.0</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.testng/testng -->
    <dependency>
      <groupId>org.testng</groupId>
      <artifactId>testng</artifactId>
      <version>7.8.0</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/io.rest-assured/json-schema-validator -->
    <dependency>
      <groupId>io.rest-assured</groupId>
      <artifactId>json-schema-validator</artifactId>
      <version>5.4.0</version>
    </dependency>
```
Check the pom file.

### Code Snippet

    @Given("I call the activity API")
    public void i_call_the_activity_api() {
        RequestSpecification request = RestAssured.given();
        response = request.get("https://www.boredapi.com/api/activity");
    }

    @Then("the response code should be 200")
    public void the_response_code_should_be_200() {
        response.then().statusCode(200);
    }

    @Then("the response schema should match the expected schema")
    public void the_response_schema_should_match_the_expected_schema() {
        String expectedSchema = "{" +
                "\"type\":\"object\"," +
                "\"properties\":{" +
                "\"activity\":{\"type\":\"string\"}," +
                "\"type\":{\"type\":\"string\"}," +
                "\"participants\":{\"type\":\"integer\"}," +
                "\"price\":{\"type\":\"number\"}," +
                "\"link\":{\"type\":\"string\"}," +
                "\"key\":{\"type\":\"string\"}," +
                "\"accessibility\":{\"type\":\"number\"}" +
                "}," +
                "\"required\":[\"activity\",\"type\",\"participants\",\"price\",\"link\",\"key\",\"accessibility\"]" +
                "}";
        response.then().body(matchesJsonSchema(expectedSchema));
    }
