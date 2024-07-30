package Tests;

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
        checkoutPage.verifyCheckoutInfo();
        awaitMethod();
    }

    @Test(dependsOnMethods = "verityCheckoutInformation")
    public void addCheckoutInformation(){
        checkoutPage.addCheckoutInfo();
        awaitMethod();
        takesScreenshots.takesSnapShot(driver, "Check Out Information");
    }

    @Test(dependsOnMethods = "addCheckoutInformation")
    public void clickContinue(){
        checkoutPage.continueBtn();
        awaitMethod();
    }

    @Test(dependsOnMethods = "clickContinue")
    public void verifyCheckoutOverView(){
        checkoutPage.verifyCheckoutOverview();
        awaitMethod();
    }
    @Test(dependsOnMethods = "verifyCheckoutOverView")
    public void verifyItemsInCheckout(){
        checkoutPage.verifyItemsInCheckout();
        awaitMethod();
        takesScreenshots.takesSnapShot(driver, "Verify Products in Checkout");
    }

    @Test(dependsOnMethods = "verifyItemsInCheckout")
    public void verifyItemTotalPlusTaxEqualsToTotal(){
        checkoutPage.verifyItemTotalPlusTaxEqualsToTotal();
    }

    @Test(dependsOnMethods = "verifyItemTotalPlusTaxEqualsToTotal")
    public void verifyCheckoutComplete(){
        checkoutPage.checkoutComplete();
    }

    @Test(dependsOnMethods = "verifyCheckoutComplete")
    public void loggingOut(){
        checkoutPage.clickBurgerMenu();
        awaitMethod();
        checkoutPage.clickLogout();
    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
