package execution;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		//features = {"src\\test\\resources\\execution"},
		features = {"@target/failedRun.txt"},
		glue= {"execution"},
		plugin = {"pretty","rerun:target/failedRun.txt"},
		publish = true
		
	    
		)
public class AmazonFailedRunner extends AbstractTestNGCucumberTests {

}
