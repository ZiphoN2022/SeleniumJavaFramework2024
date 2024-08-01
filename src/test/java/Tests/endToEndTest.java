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

    @Test(dependsOnMethods = "shopping_cart_con")
    public void clickCartButton(){
        productsPage.clickCartButton;
    }

    @Test(dependsOnMethods = "checkout")
    public void clickCheckoutButton(){
        cartPage.clickCheckoutButton;
    }


}
