package Tests;

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

    @Test(dependsOnMethods = "add-to-cart-sauce-labs-backpack")
    public void clickAddButton(){
        productsPage.clickAddProduct();
    }

    @Test(dependsOnMethods = "shopping_cart_container")
    public void clickCartButton(){
        productsPage.clickCart;
    }

}
