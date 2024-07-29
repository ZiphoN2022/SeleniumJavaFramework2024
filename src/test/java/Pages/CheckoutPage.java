package Pages;

import Utils.generateTestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutPage extends generateTestData {

    WebDriver driver;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Your Information')]")
    WebElement checkoutInfo_xpath;

    @FindBy(xpath = "//input[contains(@id,'first-name')]")
    WebElement firtName_xpath;

    @FindBy(xpath = "//input[contains(@id,'last-name')]")
    WebElement lastName_xpath;

    @FindBy(xpath = "//input[contains(@id,'postal-code')]")
    WebElement postal_xpath;

    @FindBy(xpath = "//input[contains(@id,'continue')]")
    WebElement continue_xpath;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Overview')]")
    WebElement checkoutOverview_xpath;

    @FindBy(xpath = "//span[@class='shopping_cart_badge'][contains(.,'2')]")
    WebElement shoppingCart_xpath;



    public void verifyCheckoutInfo(){
        String checkoutInfo = checkoutInfo_xpath.getText();
        Assert.assertEquals(checkoutInfo, "Checkout: Your Information");
    }

    public void addCheckoutInfo(){
        firtName_xpath.sendKeys(firstName);
        lastName_xpath.sendKeys(lastname);
        postal_xpath.sendKeys(zipcode);
    }

    public void continueBtn(){
        continue_xpath.click();
    }

    public void verifyCheckoutOverview(){
        String checkoutOverview = checkoutOverview_xpath.getText();
        Assert.assertEquals(checkoutOverview, "Checkout: Overview");
    }

    public void verifyItemsInCheckout(){
        int numberOfItems = Integer.parseInt(shoppingCart_xpath.getText());
        Assert.assertNotEquals(numberOfItems,0);

    }




}
