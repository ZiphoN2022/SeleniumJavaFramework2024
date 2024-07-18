package Tests;

import org.testng.annotations.Test;

@Test
public class endToEndTest extends Base {


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

    @Test(dependsOnMethods = "clickLoginButtonTests")
    public void clickAddToCartOnProductTest() {
        inventoryPage.addItemToCart("add-to-cart-sauce-labs-backpack");
        inventoryPage.addItemToCart("add-to-cart-sauce-labs-bike-light");
        inventoryPage.addItemToCart("add-to-cart-sauce-labs-bolt-t-shirt");
        inventoryPage.addItemToCart("add-to-cart-sauce-labs-fleece-jacket");
        inventoryPage.addItemToCart("add-to-cart-sauce-labs-onesie");
        inventoryPage.addItemToCart("add-to-cart-test.allthethings()-t-shirt-(red)");
    }

    @Test(dependsOnMethods = "clickAddToCartOnProductTest")
    public void clickShoppingCartLinkTest() {
        inventoryPage.clickShoppingCartLink();
    }

    @Test(dependsOnMethods = "clickShoppingCartLinkTest")
    public void removeProductFromShoppingCartTest(){
        cartPage.removeProductFromShoppingCart("remove-sauce-labs-fleece-jacket");
    }

    @Test(dependsOnMethods = "removeProductFromShoppingCartTest")
    public void clickCheckoutTest(){
        cartPage.clickCheckoutButton();
    }

}
