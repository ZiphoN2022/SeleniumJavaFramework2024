package Tests;

import com.github.javafaker.Faker;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class loginTests extends Base {


    private String screenShortFolderPath = "/login Tests";

    public void enterUsernameTests() {
        loginPage.enterUsername("standard_user");
    }

    @Test(dependsOnMethods = "enterUsernameTests")
    public void enterPasswordTests() {
        loginPage.enterPassword("secret_sauce");
    }

    @Test(dependsOnMethods = "enterPasswordTests")
    public void clickLoginButtonTests() {
        takesScreenshots.takesSnapShot(driver, "Enter User Details", screenShortFolderPath);
        loginPage.clickLogin();
    }

    @Test(dependsOnMethods = "clickLoginButtonTests")
    public void verifyProductIsDisplayed() {
        homePage.verifyProductTitleIsDisplayed();
        takesScreenshots.takesSnapShot(driver, "product Title Verification", screenShortFolderPath);
    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
