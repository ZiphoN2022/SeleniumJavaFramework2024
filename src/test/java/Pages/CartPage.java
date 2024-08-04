package Pages;

import org.openqa.selenium.By;
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
   WebElement checkoutButton;

   @FindBy(xpath = "//div[class='inventory_item_name')])[1]")
   WebElement cartItem;

   public void verifyBackpackItemIsStillInCart(){
       String ItemInfo = cartItem.getText();
       Assert.assertEquals(ItemInfo, "Sauce Labs Backpack");
   }
   public void clickCheckoutButton() { checkoutButton.click();}

    }

