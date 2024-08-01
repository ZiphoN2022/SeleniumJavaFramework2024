package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.PersonalDetailsPage;
import Pages.YourCartPage;
import Utils.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();

    final WebDriver driver=browserFactory.startBrowser("chrome","https://www.saucedemo.com/");
    LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);

    HomePage homePage =PageFactory.initElements(driver, HomePage.class);
    YourCartPage yourcartpage =PageFactory.initElements(driver, YourCartPage.class);
    PersonalDetailsPage personaldetailspage =PageFactory.initElements(driver, PersonalDetailsPage.class);
    TakesScreenshots takesScreenshots = new TakesScreenshots();

    ReadData readData;

    {
        try {
            readData = new ReadData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}