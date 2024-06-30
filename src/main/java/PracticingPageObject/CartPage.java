package PracticingPageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageObjectUtilityClass.UtilityClass;

public class CartPage extends UtilityClass {
	WebDriver driver;

	@FindBy(xpath = "//*[@class='cartSection']/h3")
	List<WebElement> productTitles;

	// driver.findElement(By.cssSelector("")).click();

	@FindBy(css = ".totalRow button")
	WebElement Checkout;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean VerifyProductDisplay(String item) {
		Boolean Match = productTitles.stream().anyMatch(element -> element.getText().equalsIgnoreCase(item));
		return Match;
	}

	public FinalPayOut chekOut() {
		Checkout.click() ;
		return new FinalPayOut(driver);	  	
	}
}
