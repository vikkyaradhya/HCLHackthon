package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import stepDefinitions.BasePage;
import stepDefinitions.LoginPage;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty","html:target/cucumber"},
		features = {"src/test/resources/features"},
		glue = {"stepDefinitions/"},
		tags = {"@Login_user"},
		monochrome = true,
		dryRun = false
		)

public class TestRunner extends AbstractTestNGCucumberTests {
		
	@BeforeSuite
	public static void setUp() throws Throwable {
		new LoginPage().user_opens_browser("chrome");
		BasePage.init_extentReport();
	}
	
	@AfterSuite
	public static void tearDown() {
        //BasePage.driver.quit();
        BasePage.generateExtentReport();
	}
	

}