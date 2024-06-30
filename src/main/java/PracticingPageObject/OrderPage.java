package PracticingPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageObjectUtilityClass.UtilityClass;
import java.util.List;

public class OrderPage extends UtilityClass {
	WebDriver driver;

 @FindBy(css = "tr td:nth-child(2)")
   List<WebElement> OrderTitles ;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean VerifyOrderDisplay(String item) {
		Boolean Match = OrderTitles.stream().anyMatch(element -> element.getText().equalsIgnoreCase(item));
		return Match;
	}
	
}
