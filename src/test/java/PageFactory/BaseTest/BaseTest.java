package PageFactory.BaseTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PracticingPageObject.LandingPage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {
	public WebDriver driver;
	public LandingPage LandingPage;

	public WebDriver initializeDrivers() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//java//PageFactory//Repository//Repository.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			// System.setProperty("", browserName)
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	@BeforeTest(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {
		driver = initializeDrivers();
		LandingPage = new LandingPage(driver);
		LandingPage.goTo();
		return LandingPage;
	}


	public String getScreenshot(WebDriver driver,String TestcaseName) throws IOException {
		TakesScreenshot TS = (TakesScreenshot) driver;
		File SOURCE = TS.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + TestcaseName + ".png");
		FileUtils.copyFile(SOURCE, file);
		return System.getProperty("user.dir") + "//reports//" + TestcaseName + ".png";
	}


	public List<HashMap<String, String>> getJsonDataToMap(String Filepath ) throws IOException {// json to String
		String JsonContent = FileUtils.readFileToString(
				new File(Filepath),StandardCharsets.UTF_8);
		// // string to Hashmap using jackson data bind

		ObjectMapper Mapper = new ObjectMapper();
		List<HashMap<String, String>> data = Mapper.readValue(JsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	@AfterTest(alwaysRun = true)
	public void closingAppliation() {
		driver.quit();
	}

}
