package PracticingPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageObjectUtilityClass.UtilityClass;

public class LandingPage extends UtilityClass {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

////////////// ELEMENTS////////////////////
	@FindBy(xpath = "//input[@id='userEmail']")
	WebElement Userid;

	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement Passwordelem;

	@FindBy(xpath = "//input[@id='login']")
	WebElement Submit;

	// .ng-tns-c4-3.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	@FindBy(css = "[class*='flyInOut']")
	WebElement ErrorMessage;

	// to put it in simple words, @FindBys have AND conditional relationship among
	// the @FindBy whereas @FindAll has OR conditional relationship.

	//////// ACTIONS
	public ProductCatalogue LogInApplication(String email, String password) {
	
		Userid.sendKeys(email);
		Passwordelem.sendKeys(password);
		Submit.click();

		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue;

	}

	public String ErrorValidationTest() {

		return ErrorMessage.getText();

	}

	public void goTo() {
		 driver.get("https://rahulshettyacademy.com/client/");

	}
}
