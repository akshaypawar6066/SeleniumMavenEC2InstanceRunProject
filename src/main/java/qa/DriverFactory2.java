package qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory2 {

	WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver initBrowser(String browsername) {
		if (browsername.equals("Chrome")) {
			tlDriver.set(new ChromeDriver());
		}

		else if (browsername.equals("edge")) {
			tlDriver.set(new FirefoxDriver());
		}
		return getDriver();

	}
	

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();

	}

}
