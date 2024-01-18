package execution;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import qa.DriverFactory;
import qa.DriverFactory2;

public class MyAppHooks {
	DriverFactory df;
	WebDriver driver;
	
	@Before
	public void launchBrowser() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream filePath=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		prop.load(filePath);
		String browserName=prop.getProperty("browser");
		 
		 String mavenBrowser=System.getProperty("cliBrowser");		 
		 System.out.println(mavenBrowser);
		 
		 if(mavenBrowser!=null)
		 {
			 browserName=mavenBrowser;
		 }
		 
		 df=new DriverFactory();
		 driver=df.initBrowser(browserName);
		 driver.manage().window().maximize();
	}
	
	@After(order=2)
	public void tearDown(Scenario scenario)
	{
		boolean isFailed=scenario.isFailed();
		if(isFailed)
		{
			String scenarioName=scenario.getName();
			String screenshoName=scenarioName.replaceAll(" ", "-");
			TakesScreenshot ts=(TakesScreenshot) driver;
			byte [] source=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(source, "image/png", screenshoName);
		}
	}
	@After(order=1)
	public void quitBrowser()
	{
		driver.quit();
	}

}
