package Tests;

import Pages.CartPage;
import Pages.InventoryPage;
import org.testng.annotations.Test;

public class startToEndTest extends Base {
    public void enterUsernameTests() {
        loginPage.enterUsername(readData.username);
    }

    @Test(dependsOnMethods = "enterUsernameTests")
    public void enterPasswordTests() {
        loginPage.enterPassword(readData.password);
    }

    @Test(dependsOnMethods = "enterPasswordTests")
    public void clickLoginButtonTests() {
        takesScreenshots.takesSnapShot(driver,"Login Page");
        loginPage.clickLogin();
    }

    @Test(dependsOnMethods = "clickLoginButtonTests")
    public void verifyProductIsDisplayed() {
        homePage.verifyProductTitleIsDisplayed();
        takesScreenshots.takesSnapShot(driver,"Home Page");
    }

    //adding product to the cart
    @Test(dependsOnMethods = "addItemOnCartTest")
    public void clickAddToCartButton() {
        InventoryPage.click();
    }

    }







