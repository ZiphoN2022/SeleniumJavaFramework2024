package Tests;

import org.testng.annotations.Test;

@Test
public class CartPageTest extends Base {
    @Test
    public void verifyBackpackItemIsStillInCart(){
        cartPage.verifyBackpackItemIsStillInCart();
    }
    @Test(priority = 1)
    public void clickCheckoutButton(){
        cartPage.clickCheckoutButton();
    }

}
