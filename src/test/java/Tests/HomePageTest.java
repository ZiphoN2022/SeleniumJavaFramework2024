package Tests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
@Test
public class HomePageTest extends Base {
    @Test
    public void verifyProductTitleIsDisplayedTest(){
        homePage.verifyProductTitleIsDisplayed();
    }
    @Test
    public void verifyBackpackItemIsAddedToCart(){
        homePage.verifyBackpackItemIsAddedToCart();
    }
    @Test
    public void getBackpackItemInformation(){
        homePage.getBackpackItemInformation();
    }
    @Test
    public void verifyBikeLightItemIsAddedToCart(){
        homePage.verifyBikeLightItemIsAddedToCart();
    }
    @Test
    public void verifyNumberOfItemsInCart(){
        homePage.verifyNumberOfItemsInCart();
    }

    public  void clickCartIcon(){
        homePage.clickCartIcon();
    }


}
