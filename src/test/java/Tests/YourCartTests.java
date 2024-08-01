package Tests;

import Pages.YourCartPage;
import org.testng.annotations.Test;

@Test
public class YourCartTests extends Base {

    public void enterUsernameTests() {
        loginPage.enterUsername(readData.username);
    }

    @Test(dependsOnMethods = "enterUsernameTests")
    public void enterPasswordTests() {
        loginPage.enterPassword(readData.password);
    }

    @Test(dependsOnMethods = "enterPasswordTests")
    public void clickLoginButtonTests() {
        takesScreenshots.takesSnapShot(driver, "Login Page");
        loginPage.clickLogin();
    }

    @Test(dependsOnMethods = "clickLoginButtonTests")
    public void verifyProductIsDisplayed() {
        homePage.verifyProductTitleIsDisplayed();
        takesScreenshots.takesSnapShot(driver, "Home Page");
    }

    @Test(dependsOnMethods = "verifyProductIsDisplayed")
    public void clickAddToCartButtonTests() {
        homePage.clickButtonAddToCart();
        takesScreenshots.takesSnapShot(driver, "Add To Cart");
    }

    @Test(dependsOnMethods = "clickAddToCartButtonTests")
    public void verifyCartIsNotEmpty() {
        homePage.verifyItemWasAddedToTheCart();

    }

    @Test(dependsOnMethods = "verifyCartIsNotEmpty")
    public void verifyTitleYourCartIsDisplayed() {
        yourcartpage.verifyYourCart();
        takesScreenshots.takesSnapShot(driver, "Your Cart");
    }

    @Test(dependsOnMethods = "verifyTitleYourCartIsDisplayed")
    public void clickTheButtonCheckout() {
        yourcartpage.clickButtonCheckout();
    }

    //ToDo read data from faker library

//    @AfterTest
//    public void closeBrowser() {
//        driver.quit();
//    }

}


