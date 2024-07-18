package Tests;

import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import Pages.HomePage;


public class Base {

    BrowserFactory browserFactory = new BrowserFactory();

    final WebDriver driver = browserFactory.startBrowser("chrome","https://www.saucedemo.com");

    LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
    HomePage homePage =PageFactory.initElements(driver, HomePage.class);
    InventoryPage inventoryPage = PageFactory.initElements(driver, InventoryPage.class);
    CartPage cartPage = PageFactory.initElements(driver,CartPage.class);

}
