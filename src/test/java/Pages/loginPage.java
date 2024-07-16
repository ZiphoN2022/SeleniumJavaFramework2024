package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage {

    WebDriver driver;

    @FindBy(xpath = "//input[contains(@id,'user-name')]")
    WebElement username_xpath;

    @FindBy(xpath = "//input[contains(@id,'password')]")
    WebElement password_xpath;

    @FindBy(xpath = "//input[contains(@id,'login-button')]")
    WebElement login_xpath;


    //ToDo create code to enter password
    //ToDo create code to click Login button


    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

   /* driver.get("https://www.saucedemo.com/");
    driver.manage().window().maximize();*/

    public void enterUsername(String username) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(username_xpath));
        username_xpath.sendKeys(username);
    }

    public void enterPassword(String password) {
        password_xpath.sendKeys(password);
    }

    public void clickLogin() {
        login_xpath.click();
    }


}
