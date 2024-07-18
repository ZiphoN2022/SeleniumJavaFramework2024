package Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class loginTests extends Base{


    public void enterUsernameTests(){
        loginPage.enterUsername("standard_user");
    }

    @Test(dependsOnMethods = "enterUsernameTests")
    public void enterPasswordTests(){
        loginPage.enterPassword("secret_sauce");
    }
    @Test(dependsOnMethods = "enterPasswordTests")
    public void clickLoginButtonTests(){
        loginPage.clickLogin();
    }
    @Test(dependsOnMethods = "clickLoginButtonTests")
    public void verifyProductIsDisplayed(){
        homePage.verifyProductTitleIsDisplayed();
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
