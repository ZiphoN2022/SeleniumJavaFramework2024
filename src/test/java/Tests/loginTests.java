package Tests;

import Utils.ReadData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class loginTests extends Base {
    //Login Page Test1//
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
    public void verifyProductIsDisplayed() {
        homePage.verifyProductTitleIsDisplayed();
        takesScreenshots.takesSnapShot(driver, "Home Page");
    }

    //ShoppingCart Page Test2//
    @Test(dependsOnMethods = "verifyProductIsDisplayed")
    public void addItemsBackPackToCart() {
        shoppingCartPage.addBackPack();
    }

    @Test(dependsOnMethods = "addItemsBackPackToCart")
    public void addItemsBoltTshirtToCart() {
        shoppingCartPage.addBoltTshirt();
        takesScreenshots.takesSnapShot(driver, "Added To Cart");
    }

    @Test(dependsOnMethods = "addItemsBoltTshirtToCart")
    public void navigateToCart() {
        shoppingCartPage.clickCart();
    }

    @Test(dependsOnMethods = "navigateToCart")
    public void verifyCartItemsCorrect() {
        shoppingCartPage.verifyCartItems();
        takesScreenshots.takesSnapShot(driver, "Verify Cart Items");
    }

    @Test(dependsOnMethods = "verifyCartItemsCorrect")
    public void navigateToCheckout() {
        shoppingCartPage.goToCheckout();
    }

    //Checkout Information Page Test3//
    @Test(dependsOnMethods = "navigateToCheckout")
    public void verifyCheckoutIsDisplayed() {
        checkOutInformationPage.verifyCheckOutTitleIsDisplayed();
    }

    @Test(dependsOnMethods = "verifyCheckoutIsDisplayed")
    public void enterFirstNameTests() throws InterruptedException {
        try {
            checkOutInformationPage.enterFirstname();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(dependsOnMethods = "enterFirstNameTests")
    public void enterLastNameTests() throws InterruptedException {
        try {
            checkOutInformationPage.enterLastName();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(dependsOnMethods = "enterLastNameTests")
    public void enterZipCode() throws InterruptedException {
        try {
            checkOutInformationPage.enterZipcode();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(dependsOnMethods = "enterZipCode")
    public void clickContinueButton() throws InterruptedException {
        takesScreenshots.takesSnapShot(driver, "Checkout Information Page");
        checkOutInformationPage.clickContinue();
    }

    //Checkout OverviewPage
    @Test(dependsOnMethods = "clickContinueButton")
    public void verifyCheckOutOverviewIsDisplayed() {
        try {
            checkOutOverviewPage.verifyCheckOutIsDisplayed();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test(dependsOnMethods = "verifyCheckOutOverviewIsDisplayed")
    public void verifyCartItemsOnCheckAreDisplayedOutOverviewPage() {
        checkOutOverviewPage.verifyCartItemsMatchOverviewItems();
        takesScreenshots.takesSnapShot(driver, "Verify Checkout Overview Items");
    }
 //   @Test (dependsOnMethods = "verifyCartItemsOnCheckAreDisplayedOutOverviewPage")
//    public void VerifyItemTotalPlusTaxEqualsTotal (){
//    }





















    //ToDo Question 18
    //ToDo Question 19
    //ToDo Question 20
    //ToDo Question 21

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}

