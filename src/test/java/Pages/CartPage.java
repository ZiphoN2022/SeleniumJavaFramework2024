package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class CartPage {

    WebDriver driver;

   @FindBy(xpath = "//button[@id='checkout']")
   WebElement checkout_xpath;

   @FindBy(xpath = "//button[@id='continue-shopping']")
   WebElement continueShopping_xpath;

   @FindBy(xpath = "//div[class='inventory_item_name'][contains(.,'Sauce Labs Bile Light')]")
   WebElement inventoryItemName_xpath;

    public CartPage(WebDriver driver){
        this.driver=driver;

        public void deleteProductFromShoppingCart(String product){
            driver.findElement(By.id(product)).click();
        }

        public void clickCheckoutButton(){
            continueShopping_xpath.click();
        }

        public void clickContinueShoppingButton(){
            continueShopping_xpath.click();
        }


        public void verifyItemDisplaysOnCartPage() {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(inventoryItems_xpath));
            String InventoryItems=inventoryItemName_xpath.getText();
            Assert.assertEquals(productItemName, itemName);
        }


        }
    }
