package qa;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	static WebDriver driver;
	Capabilities capabilities;

	public WebDriver initBrowser(String browsername) throws MalformedURLException {

		if (browsername.equalsIgnoreCase("Chrome")) {
			capabilities = new ChromeOptions();
		}

		else if (browsername.equalsIgnoreCase("Firefox")) {
			capabilities = new FirefoxOptions();
		}

		driver = new RemoteWebDriver(new URL("http://172.26.48.1:4444"), capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;

	}

	public static WebDriver getDriver() {
		return driver;

	}

}
