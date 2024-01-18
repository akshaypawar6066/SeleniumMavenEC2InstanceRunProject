package execution;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"classpath:execution"},
		glue= {"execution"},
		plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		publish = true
		
		)
public class AmazonRunner extends AbstractTestNGCucumberTests {
  @DataProvider()
  public Object[][] scenarios()
  {
	 return super.scenarios();
  }
}
