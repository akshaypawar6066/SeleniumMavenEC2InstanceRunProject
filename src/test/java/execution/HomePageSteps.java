package execution;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.DriverFactory;
import qa.DriverFactory2;
import pages.HomePage;

public class HomePageSteps {
	WebDriver driver;
	HomePage homePage=new HomePage(DriverFactory.getDriver());
	
	@Given("User is at landing page")
	public void user_is_at_landing_page() throws InterruptedException {
	 driver= DriverFactory.getDriver();
	 driver.get("https://www.amazon.in/"); 
	}

	@Then("Page title should contains {string}")
	public void page_title_should_contains(String pageTitle) {
	 boolean titleOfString=  homePage.fetchTitleOfPage().contains(pageTitle);
	 Assert.assertTrue(titleOfString);
	}

	@Then("Cart icon should get displayed")
	public void cart_icon_should_get_displayed() {
		boolean isDisplyed=homePage.isCratIconDisplayed();
		Assert.assertTrue(isDisplyed);

	}

	@When("User click on smart phones deal")
	public void user_click_on_smart_phones_deal() {
	   homePage.enterDealsSection();
	}

	@Then("deal section should get open")
	public void deal_sectio_should_get_open() {
     boolean isVisible= homePage.carouselNavigation();
     Assert.assertEquals(isVisible, true);
	}

	@When("User enters the username as {string} and clicks on continue button")
	public void user_enters_the_username_as_and_clicks_on_continue_button(String uname) {
		homePage.clickOnSignInButton();
		homePage.enterUsername(uname);
		
	   
	}

	@When("User enters the password as {string} and clicks on signIn button")
	public void user_enters_the_password_as_and_clicks_on_sign_in_button(String password) {
	  homePage.enterPassword(password);
	}

	@Then("User should get SignedIn succesfully")
	public void user_should_get_signed_in_succesfully() {
	   homePage.checkUserIsAbleToSignIn();
	   Assert.assertTrue(driver.getPageSource().contains("Hello, Akshay"));	   
	}
	
}
