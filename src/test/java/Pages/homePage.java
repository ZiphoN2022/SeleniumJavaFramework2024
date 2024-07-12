package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage {

    WebDriver driver;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-backpack')]")
    WebElement sauceLabsBbackPack_addToCartBtn_xpath;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-bike-light')]")
    WebElement sauceLabsBikeLight_addToCartBtn_xpath;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-bolt-t-shirt')]")
    WebElement sauceLabsBoltTShirt_addToCartBtn_xpath;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-fleece-jacket')]")
    WebElement sauceLabsFleeceJacket_addToCartBtn_xpath;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-onesie')]")
    WebElement sauceLabsOnesie_addToCartBtn_xpath;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-test.allthethings()-t-shirt-(red)')]")
    WebElement sauceLabsTShirtRed_addToCartBtn_xpath;


    public homePage(WebDriver driver){this.driver = driver;}

    public void addToCart(String product, WebElement item){
        item.click();
    }
}
