package PracticingPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageObjectUtilityClass.UtilityClass;

public class ConfirmationPage extends UtilityClass {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

////////////// ELEMENTS//////////////////////////////////
	@FindBy(css = ".hero-primary")
	WebElement ConfirmationMessage ;
			
	//button[@routerlink='/dashboard/myorders']	

	/*
	 * By Productsby = By.cssSelector(".mb-3"); By addToCart =
	 * By.cssSelector(".card-body button:last-of-type") ; By ToastMessage =
	 * By.cssSelector("#toast-container") ; By disppear =
	 * By.cssSelector(".ngx-spinner-overlay");
	 */
	//////// ACTIONS
	
/*	public void WaitingtoAppear( ) {
	
		waitForElementToAppear(ConfirmationMessage); 
		
	}*/

	public String VerifyConfirmation() {
		return ConfirmationMessage.getText();

	}

}
