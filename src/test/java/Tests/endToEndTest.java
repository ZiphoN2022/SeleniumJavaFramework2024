package Tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

@Test
public class endToEndTest extends Base {

    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String zipPostalCode = faker.address().zipCode();

    private String screenShortFolderPath = "/End to End Tests"; // screenshot folder name

    public void enterUsernameTests() {
        loginPage.enterUsername("standard_user");
    }

    @Test(dependsOnMethods = "enterUsernameTests")
    public void enterPasswordTests() {
        loginPage.enterPassword("secret_sauce");
    }

    @Test(dependsOnMethods = "enterPasswordTests")
    public void clickLoginButtonTests() {
        loginPage.clickLogin();
    }


    // adding product to the cart
    @Test(dependsOnMethods = "clickLoginButtonTests")
    public void clickAddToCartOnProductTest() {
        inventoryPage.addItemToCart("add-to-cart-sauce-labs-backpack");
        inventoryPage.addItemToCart("add-to-cart-sauce-labs-bike-light");
        inventoryPage.addItemToCart("add-to-cart-sauce-labs-bolt-t-shirt");
        inventoryPage.addItemToCart("add-to-cart-sauce-labs-fleece-jacket");
        inventoryPage.addItemToCart("add-to-cart-sauce-labs-onesie");
        inventoryPage.addItemToCart("add-to-cart-test.allthethings()-t-shirt-(red)");

        takesScreenshots.takesSnapShot(driver, "addingProductsToCart", screenShortFolderPath); // taking screenshot

    }

    // clicking the cart link to move to the cart page
    @Test(dependsOnMethods = "clickAddToCartOnProductTest")
    public void clickShoppingCartLinkTest() {
        inventoryPage.clickShoppingCartLink();
    }


    //Removing a product from the cart
    @Test(dependsOnMethods = "clickShoppingCartLinkTest")
    public void removeProductFromShoppingCartTest() {
        cartPage.removeProductFromShoppingCart("remove-sauce-labs-fleece-jacket");

        takesScreenshots.takesSnapShot(driver, "removingProductFromCart", screenShortFolderPath);// taking screenshot of the cart
    }


    //Click checkout to move to the checkout page
    @Test(dependsOnMethods = "removeProductFromShoppingCartTest")
    public void clickCheckoutTest() {
        cartPage.clickCheckoutButton();
        takesScreenshots.takesSnapShot(driver, "verifyCheckoutPage", screenShortFolderPath); // taking screenshot of the checkout page
    }


    // Verify the checkout page.
    @Test(dependsOnMethods = "clickCheckoutTest")
    public  void verifyCheckoutPageTest(){
        checkoutPage.verifyCheckoutTitle();
    }

    @Test(dependsOnMethods = "verifyCheckoutPageTest")
    public void enterFirstNameTest() {
        checkoutPage.enterFirstName(firstName);
    }

    @Test(dependsOnMethods = "enterFirstNameTest")
    public void enterLastNameTest() {
        checkoutPage.enterLastName(lastName);
    }

    @Test(dependsOnMethods = "enterLastNameTest")
    public void enterPostalCodeTest() {
        checkoutPage.enterPostalCode(zipPostalCode);
    }

    @Test(dependsOnMethods = "enterPostalCodeTest")
    public void clickContinueTest() {
        checkoutPage.clickContinueButton();
    }

}
