package Tests;

import Pages.*;
import Utils.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import java.io.IOException;
import static Utils.ReadData.*;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver=browserFactory.startBrowser("chrome","https://www.saucedemo.com/");
    LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
    HomePage homePage =PageFactory.initElements(driver, HomePage.class);
    ShoppingCartPage shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class );
    CheckOutInformationPage checkOutInformationPage = PageFactory.initElements(driver, CheckOutInformationPage.class );
    CheckOutOverviewPage checkOutOverviewPage = PageFactory.initElements(driver, CheckOutOverviewPage.class );
    TakesScreenshots takesScreenshots = new TakesScreenshots();

    ReadData readData;

    {
        try {
            readData = new ReadData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test1 (){
        System.out.println(username);
        System.out.println(password);
    }

}