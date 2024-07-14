package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginPage {

    WebDriver driver;

    @FindBy(xpath = "//input[contains(@id,'user-name')]")
    public WebElement username_xpath;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement password_xpath;
    @FindBy(xpath = "//input[contains(@id,'login-button')]")
    public WebElement loginButton_xpath;

    public loginPage(WebDriver driver){
        this.driver=driver;
    }

   @Test
    public void enterUsername(String username){
    new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(username_xpath));
    username_xpath.sendKeys(username);
    }

    @Test
    public void enterPassword(String password){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(password_xpath));
        password_xpath.sendKeys(password);
    }
    @Test
    public void clickloginButton () {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(loginButton_xpath));
        loginButton_xpath.click();
    }
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
