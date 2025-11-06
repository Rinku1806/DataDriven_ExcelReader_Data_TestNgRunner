package testcases;
import org.testng.SkipException;
import org.testng.annotations.Test;

import utilities.DataUtil;
public class StoreEntryTest extends testbase.BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp")
	//@Test
	public void VerifySignInButtonPresence(String browserName, String runmode,String username, String pwd) throws InterruptedException {
		if (runmode.equals("N")) {
			test.info("Test Skipped");
			throw new SkipException("Skipping the test as the run mode is NO");
		} else {
			try {
				app.openBrowser(browserName);	
				app.navigate("TEST_URL");
				Thread.sleep(1000);
				app.click("ENTER_STORE_LINK_xpath");		
				app.softAssert.assertEquals(app.getText("SIGNIN_LINK_xpath"), app.envProp.getProperty("SIGNIN_LINK_TEXT"));
				test.info("Validated the home page title of Petstore");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//app.assertAll();
		}

	}

	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp")
	
	public void VerifyStoreEntryTitle(String browserName, String runmode, String username, String pwd) throws InterruptedException {

		if (runmode.equals("N")) {
			test.info("Test Skipped");
			throw new SkipException("Skipping the test as the run mode is NO");
		} else {
			try {
				app.openBrowser(browserName);	
				app.navigate("TEST_URL");
				app.wait(1);
				app.click("ENTER_STORE_LINK_xpath");
				app.wait(2);
				//app.assertEquals(app.getPageTitle(), app.envProp.getProperty("SIGNIN_PAGE_TITLE"));				
				test.info("Validated the home page title of Petstore Entry page");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//app.assertAll();
		}
	}

	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp")

	public void Verifylogin(String browserName, String runmode, String username, String pwd) {

		if (runmode.equals("N")) {
			test.info("Test Skipped");
			throw new SkipException("Skipping the test as the run mode is NO");

		} else {
			try {
				app.openBrowser(browserName);	
				app.navigate("TEST_URL");
				app.wait(2);
				app.click("ENTER_STORE_LINK_xpath");
				app.wait(2);
				app.click("SIGNIN_LINK_xpath");
				app.Login(username, pwd);
				app.softAssert.assertEquals(app.getText("SIGNOUT_LINK_xpath"), app.envProp.getProperty("SIGNOUT_TEXT"));
			} catch (Exception e) {
				e.printStackTrace();

			}
			//app.assertAll();

		}

	}

}
