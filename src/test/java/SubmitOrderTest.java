
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageFactory.BaseTest.BaseTest;
import PracticingPageObject.CartPage;
import PracticingPageObject.ConfirmationPage;
import PracticingPageObject.FinalPayOut;
import PracticingPageObject.OrderPage;
import PracticingPageObject.ProductCatalogue;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {

	String Item = "ADIDAS ORIGINAL";
	String Country = "India";

	@Test(dataProvider = "getData", groups = "Purchase")
	public void SubmitOrderTest(HashMap<String, String> input) throws IOException {

		ProductCatalogue productcatalogue = LandingPage.LogInApplication(input.get("Email"), input.get("Password"));
		List<WebElement> prods = productcatalogue.getListOfProducts();
		productcatalogue.addProductToCart(input.get("ProductName"));
		CartPage CartPage = productcatalogue.goToCart();
		CartPage.VerifyProductDisplay(input.get("ProductName"));
		Assert.assertTrue(true);
		FinalPayOut payOut = CartPage.chekOut();
		payOut.DropDownhandle(input.get("Country"));
		ConfirmationPage Confirm = payOut.OrderPlace();
		Assert.assertTrue(Confirm.VerifyConfirmation().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		// VerifyOrderDisplay()
		OrderPage orderPage = Confirm.goToOrder();
		orderPage.VerifyOrderDisplay(input.get("ProductName"));

	}

// verify if  the Item is displaying in orders page 
	@Test(dependsOnMethods = { "SubmitOrderTest" })
	public void OrdersTest() {
		// ProductCatalogue productcatalogue =
		// LandingPage.LogInApplication("POM@gmail.com", "Pom@2024");
		OrderPage OrderPage = LandingPage.goToOrder();
		OrderPage.VerifyOrderDisplay(Item);

	}

// "POM@gmail.com", "Pom@2024", "ADIDAS ORIGINAL", "India"
	@DataProvider
	public Object[][] getData() throws IOException {
		
		/*
		 * HashMap<String, String> HM = new HashMap<String, String>(); HM.put("Email",
		 * "Dataprovider@Hashmap.com"); HM.put("Password", "Dataprovider@2024");
		 * HM.put("ProductName", "ADIDAS ORIGINAL"); HM.put("Countryname", "India");
		 * 
		 * HashMap<String, String> HM1 = new HashMap<String, String>(); HM1.put("Email",
		 * "POM@gmail.com"); HM1.put("Password", "Pom@2024"); HM1.put("ProductName",
		 * "ADIDAS ORIGINAL"); HM1.put("Countryname", "India");
		 */
		// 
		List<HashMap<String, String>> data  = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//DataHandlingRepo//Data.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}
}
