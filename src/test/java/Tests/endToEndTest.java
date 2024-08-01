package Tests;

import Pages.CartPage;
import Pages.ProductsPage;
import org.testng.annotations.Test;

public class endToEndTest extends Base {
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
    @Test(dependsOnMethods = "clickLoginButtonTests")
    public void clickAddToCartOnProductTest(){
        ProductsPage.addItemToCart("add-to-cart-sauce-labs-backpack");
    }

    @Test(dependsOnMethods = "clickAddToCartOnProductTest")
    public void verifyItemsAddedToCartTest(){
        productsPage.validateItemIsAddedToCart("1");
        takesScreenshots.takesSnapShot(driver, "addingProductsToCart", screenShotFolderPath);
    }

    //clicking the cart link to move to the cart page
    @Test(dependsOnMethods = "clickAddToCartOnProductTest")
    public void clickShoppingCartLinkTest(){
        ProductsPage.clickShoppingCartLink();
    }

    //verify that the item added on the inventory page is on the cart page
    @Test(dependsOnMethods = "clickAddToCartOnProductTest")
    public void verifyItemAddedToTheCartPage(){
        cartPage.verifyProductItemIsOnTheCartPage("Sauce Labs Bike Light");
        takesScreenshots.takesSnapShot(driver, "itemOnCartPage", screenShotFolderPath);

    }


    }



}
