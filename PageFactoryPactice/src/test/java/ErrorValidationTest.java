
import org.testng.Assert;
import org.testng.annotations.Test;

import PageFactory.BaseTest.BaseTest;
import java.io.IOException;

public class ErrorValidationTest extends BaseTest {

@Test(groups = {"Errorhandle" })
public void ErrorValidationTest() throws IOException
{
	
		 LandingPage.LogInApplication("anshika@gmail.com", "Iamking000");
			Assert.assertEquals("Incorrect email or password.",LandingPage.ErrorValidationTest() );
		 }


}
