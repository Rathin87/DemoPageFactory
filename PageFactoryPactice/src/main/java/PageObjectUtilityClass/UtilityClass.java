package PageObjectUtilityClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PracticingPageObject.CartPage;
import PracticingPageObject.OrderPage;
import java.time.Duration;

public class UtilityClass {

	WebDriver driver;

	public UtilityClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement CartHeader;
	
	@FindBy(css = ".hero-primary")
	WebElement ConfirmationMessage;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement OrderHeader;


	public void waitForErrMsgToAppear(WebElement ErrorMessage ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ErrorMessage));
	
	}
// driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public OrderPage goToOrder() {
		OrderHeader.click();
		OrderPage OrderPage = new OrderPage(driver);
		return OrderPage;
	}


	public CartPage goToCart() {
		CartHeader.click();
		CartPage CartPage = new CartPage(driver);
		return CartPage;
	}

	public void waitForElementtoDisappear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void CountrySearch(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	

	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));

}
