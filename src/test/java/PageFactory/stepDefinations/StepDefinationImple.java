package PageFactory.stepDefinations;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageFactory.BaseTest.BaseTest;
import PracticingPageObject.CartPage;
import PracticingPageObject.ConfirmationPage;
import PracticingPageObject.FinalPayOut;
import PracticingPageObject.LandingPage;
import PracticingPageObject.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.util.List;

public class StepDefinationImple extends BaseTest {

	public LandingPage LandingPage;
	public ProductCatalogue productcatalogue;
	public ConfirmationPage Confirm ;
	@Given("Given I landed on the EcommercePage")

	public void I_landed_on_the_EcommercePage() throws IOException {
		LandingPage = launchApplication();
	}

	@Given("^Given Login  with  (.+) and  (.+)$")
	public void Given_Login_with_UserName_and_Password(String name, String password) {
		productcatalogue = LandingPage.LogInApplication(name, password);
	}

	@And("click on the Submit Buttton")
	public void click_on_the_Submit_Buttton() {

	}

	@When("^I add the  (.+) to the cart $")
	public void I_add_the_Product_to_the_cart(String productname) {
		List<WebElement> prods = productcatalogue.getListOfProducts();
		productcatalogue.addProductToCart(productname);
	}

	@And("^Check out the (.+) by clicking submit button and by selecting the (.+)")
	public void Checkout_the_product__by_clicking_submit_button_and_by_selecting_the_country(String productname,
			String Country) {
		CartPage CartPage = productcatalogue.goToCart();
		CartPage.VerifyProductDisplay(productname);
		Assert.assertTrue(true);
		FinalPayOut payOut = CartPage.chekOut();
		payOut.DropDownhandle(Country);
		 Confirm = payOut.OrderPlace();

	}
	
	//Then "THANK YOU FOR THE MESSAGE." should be displayed in Confirmation Page 
	@Then("{String} message_should_be_displayed_in_Confirmation_Page should be displayed in Confirmation Page")
	public void message_should_be_displayed_in_Confirmation_Page(String Message)
	{
		Assert.assertTrue(Confirm.VerifyConfirmation().equalsIgnoreCase(Message));
	}
}










