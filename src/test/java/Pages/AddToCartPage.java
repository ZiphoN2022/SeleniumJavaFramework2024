package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.AssertJUnit.assertTrue;

public class AddToCartPage {
    WebDriver driver;
    @FindBy(id = "add-to-cart-sauce-labs-backpac")
    WebElement AddToCartButton_Id;

    @FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
    WebElement CartTrolley_Xpath;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ClickButtonAddToCart() {
        AddToCartButton_Id.click();
    }

    public void verifyIfItemIsAdded() {
        WebElement cartItemCount = driver.findElement(By.xpath("//a[contains(.,'1')]"));
        String itemCountText = cartItemCount.getText();

        // Assert that the cart item count is greater than zero
        int NumOfItem = Integer.parseInt(itemCountText);
        assertTrue("Item count should be greater than zero", NumOfItem > 0);
    }

    public void ClickCartTrolley() {
        CartTrolley_Xpath.click();
    }


}
