package Tests;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductsPage;
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
    ProductsPage productsPage =PageFactory.initElements(driver, ProductsPage.class);
    CartPage cartPage =PageFactory.initElements(driver,CartPage.class);


    ReadData readData;

    {
        try {
            readData = new ReadData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}