package Tests;

import Pages.CheckoutPage;
import Pages.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class loginTests extends Base {

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
    public void verfyProductIsDisplayed() {
        homePage.verifyProductTitleIsDisplayed();
        takesScreenshots.takesSnapShot(driver,"Home Page");
    }

    @Test(dependsOnMethods = "verfyProductIsDisplayed")
    public void clickAddProducts(){
        homePage.addProducts();
        awaitMethod();
    }

    @Test(dependsOnMethods = "clickAddProducts")
    public void verifyProductAddedToCart(){
        homePage.verifyProductsAddToCart();
        awaitMethod();
        takesScreenshots.takesSnapShot(driver, "Products added to cart");
    }

    @Test(dependsOnMethods = "verifyProductAddedToCart")
    public void clickShoppingCart(){
        homePage.navigateToShoppingCart();
        awaitMethod();
    }

    @Test(dependsOnMethods = "clickShoppingCart")
    public void verityItemsInCart(){
        cartPage.verifyYourCart();
        awaitMethod();
        cartPage.verifyProductsAddToCart();
        awaitMethod();
        takesScreenshots.takesSnapShot(driver, "Verity Items added to Cart");
    }

    @Test(dependsOnMethods = "verityItemsInCart")
    public void clickCheckOut(){
        cartPage.checkOutBtn();
        awaitMethod();
    }

    @Test(dependsOnMethods = "clickCheckOut")
    public void verityCheckoutInformation(){
        checkOutPage.verifyCheckoputInfo();
        awaitMethod();
    }

    @Test(dependsOnMethods = "verityCheckoutInformation")
    public void addCheckoutInformation(){
        checkOutPage.addCheckoutInfo();
        awaitMethod();
        takesScreenshots.takesSnapShot(driver, "Check Out Information");
    }

    @Test(dependsOnMethods = "addCheckoutInformation")
    public void clickContinue(){
        checkOutPage.continueBtn();
        awaitMethod();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}