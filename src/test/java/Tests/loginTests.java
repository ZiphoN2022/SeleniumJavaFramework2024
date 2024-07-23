package Tests;

import Pages.HomePage;
import Utils.ReadData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class loginTests extends Base {


    public void enterUsernameTests() {
        loginPage.enterUsername(ReadData.username);
    }

    @Test(dependsOnMethods = "enterUsernameTests")
    public void enterPasswordTests() {
        loginPage.enterPassword(ReadData.password);
    }

    @Test(dependsOnMethods = "enterPasswordTests")
    public void clickLoginButtonTests() {
        loginPage.clickLogin();
    }

    @Test(dependsOnMethods = "clickLoginButtonTests")
    public void verfyProductIsDisolayed() {
        homePage.verifyProductTitleIsDisplayed();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
