package Tests;

import Utils.ReadData;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class EndToEndTests extends Base {


    public void enterUsernameTests() {
        loginPage.enterUsername(ReadData.username);
    }

    @Test(dependsOnMethods = "enterUsernameTests")
    public void enterPasswordTests() {
        loginPage.enterPassword(ReadData.password);
    }

    @Test(dependsOnMethods = "enterPasswordTests")
    public void clickLoginButtonTests() {
        takesScreenshots.takesSnapShot(driver, "Login Page");
        loginPage.clickLogin();
    }

    @Test(dependsOnMethods = "clickLoginButtonTests")
    public void verifyProductTitleIsDisplayedTest() {
        homePage.verifyProductTitleIsDisplayed();
    }

    @Test(dependsOnMethods = "verifyProductTitleIsDisplayedTest")
    public void verifyBackpackItemIsAddedToCart() {
        homePage.verifyBackpackItemIsAddedToCart();
    }

    @Test(dependsOnMethods = "verifyBackpackItemIsAddedToCart")
    public void getBackpackItemInformation() {
        homePage.getBackpackItemInformation();
    }

    @Test(dependsOnMethods = "getBackpackItemInformation")
    public void verifyBikeLightItemIsAddedToCart() {
        homePage.verifyBikeLightItemIsAddedToCart();
    }

    @Test(dependsOnMethods = "verifyBikeLightItemIsAddedToCart")
    public void verifyNumberOfItemsInCart() {
        homePage.verifyNumberOfItemsInCart();
    }

    @Test(dependsOnMethods = "verifyBikeLightItemIsAddedToCart")
    public  void clickCartIcon() {
        homePage.clickCartIcon();
    }


        @Test(dependsOnMethods = "verifyNumberOfItemsInCart")
        public void verifyBackpackItemIsStillInCart() {
            cartPage.verifyBackpackItemIsStillInCart();
        }

        @Test(dependsOnMethods = "verifyBackpackItemIsStillInCart")
        public void clickCheckoutButton() {
            cartPage.clickCheckoutButton();
        }
    @Test(dependsOnMethods = "clickCheckoutButton")
    public void verifyCheckoutPageTitle(){
        checkoutPage.verifyCheckoutPageTitle();
    }
    @Test(dependsOnMethods = "verifyCheckoutPageTitle")
    public void enterShippingName(){
        checkoutPage.enterShippingName();
    }
    @Test(dependsOnMethods = "enterShippingName")
    public void enterShippingSurname(){
        checkoutPage.enterShippingSurname();
    }
    @Test(dependsOnMethods = "enterShippingSurname")
    public void enterShippingAddress(){
        checkoutPage.enterShippingAddress();
    }
    @Test(dependsOnMethods = "enterShippingAddress")
    public void clickShippingContinueButton(){
        checkoutPage.clickShippingContinueButton();
    }

}
