package PracticingPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageObjectUtilityClass.UtilityClass;
import java.util.List;

public class ProductCatalogue extends UtilityClass {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

////////////// ELEMENTS//////////////////////////////////
	@FindBy(css = ".mb-3")
	List<WebElement> elements;

	By Productsby = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type") ;
	By ToastMessage = By.cssSelector("#toast-container") ;
	By disppear =  By.cssSelector(".ngx-spinner-overlay");


	//////// ACTIONS

	public List<WebElement> getListOfProducts()

	{
		waitForElementToAppear(Productsby);
		return elements;
	}

	public WebElement getProductByName(String Item) {
		WebElement Prod = getListOfProducts().stream()
				.filter(Product -> Product.findElement(By.cssSelector("b")).getText().equals(Item)).findFirst()
				.orElse(null);
		return Prod;
	}

	public void addProductToCart(String Item) {
		
		WebElement elem = getProductByName(Item);
		elem.findElement(addToCart).click();
		waitForElementToAppear(ToastMessage); 
		waitForElementtoDisappear(disppear);
	}

}
