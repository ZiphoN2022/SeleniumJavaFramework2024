package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Products')]")
    WebElement productTitle_xpath;

    public HomePage(WebDriver driver){this.driver=driver;}

    public  void verifyProductTitleIsDisplayed(){
        String productTitle =  productTitle_xpath.getText();
        Assert.assertEquals(productTitle_xpath,"Products");
    }
}
