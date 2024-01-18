package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	public WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//*[@id='nav-cart']")
	private WebElement cartIcon;

	@FindBy(xpath = "(//*[@class='a-carousel-card']//img[@alt = 'op'])[1]")
	private WebElement smartPhoneCarousel;

	@FindBy(xpath = "(//*[@role='presentation'])[1]")
	private WebElement smartPhones;

	@FindBy(xpath = "//*[@id='nav-link-accountList']")
	private WebElement signInHover;

	@FindBy(xpath = "//*[@id='nav-flyout-ya-signin']//a[@class = 'nav-action-signin-button']")
	private WebElement signInButton;

	@FindBy(xpath = "//input[@id='ap_email']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@id='ap_password']")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	private WebElement finalSignIn;
	
	
	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	private WebElement loggedInUser;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	public String fetchTitleOfPage() {
		String titleOfPage = driver.getTitle();
		return titleOfPage;
	}

	public boolean isCratIconDisplayed() {
		boolean isDisplyed = cartIcon.isDisplayed();
		return isDisplyed;
	}

	public void enterDealsSection() {
		wait.until(ExpectedConditions.visibilityOf(smartPhoneCarousel));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", smartPhoneCarousel);
	}

	public boolean carouselNavigation() {
		boolean isVisible = false;
		wait.until(ExpectedConditions.visibilityOf(smartPhones));
		isVisible = true;
		return isVisible;

	}
	
	public void clickOnSignInButton()
	{
		Actions act=new Actions(driver);
		act.moveToElement(signInHover).moveToElement(signInButton).click().build().perform();
	}
	
	public void enterUsername(String username)
	{
		wait.until(ExpectedConditions.visibilityOf(emailField));
		emailField.sendKeys(username);
		continueButton.click();
	}
	
	public void enterPassword(String password)
	{
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.sendKeys(password);
		finalSignIn.click();
	}
	
	public String checkUserIsAbleToSignIn()
	{
		wait.until(ExpectedConditions.visibilityOf(loggedInUser));
		return loggedInUser.getText();
	}

}
