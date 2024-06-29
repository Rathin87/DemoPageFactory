package PracticingPageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import PageObjectUtilityClass.UtilityClass;

public class FinalPayOut extends UtilityClass {

	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countryrDropDown;

	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	WebElement countryrSelection;

	@FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
	WebElement placeOrder;
	

	By searchedCountry = By.cssSelector(".ta-results");
	// driver.findElement(By.xpath("//a[@class='btnn action__submit
	// ng-star-inserted']")).click();

	public FinalPayOut(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void DropDownhandle(String Country) {
		Actions action = new Actions(driver);
		action.sendKeys(countryrDropDown, Country).build().perform();
		CountrySearch(searchedCountry);
		countryrSelection.click();
	}

	public ConfirmationPage OrderPlace() {
		
		placeOrder.click();
		return new ConfirmationPage(driver);

		
		// confirmation page ro verify if the text is dislayued
	}

	// driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
	// clicking on Place order

}
