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
    TakesScreenshots takesScreenshots = new TakesScreenshots();

    CartPage cartPage =PageFactory.initElements(driver, CartPage.class);
    TakesScreenshots takesScreenshot = new TakesScreenshots();

    CheckoutPage checkoutPage =PageFactory.initElements(driver, CheckoutPage.class);
    //TakesScreenshots takesScreenshots = new TakesScreenshots();

    ItemsOverviewPage itemsOverviewPage =PageFactory.initElements(driver, ItemsOverviewPage.class);
    //TakesScreenshots takesScreenshots = new TakesScreenshots();


    ReadData readData;

    {
        try {
            readData = new ReadData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}