package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//input[contains(@id,'user-name')]")
    WebElement username_xpath;

    @FindBy(xpath = "//input[contains(@id,'password')]")
    WebElement password_xpath;

    @FindBy(id = "login-button")
    WebElement loginButton_id;

    //ToDo create code to enter password
    @FindBy(xpath = "//input[contains(@id,'password')]")
    WebElement password_xpath;

    //ToDo create code to click Login button
    @FindBy(xpath = "//input[contains(@id,'login')]")
    WebElement login_xpath;



    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void enterUsername(String username){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(username_xpath));
        username_xpath.sendKeys();
    }
    public void password(String password, WebElement password_xpath){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(password_xpath));
        password_xpath.sendKeys();
    }
    public void login(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(login_xpath));
        login_xpath.click();
    }

    public void enterPassword(String password){
        password_xpath.sendKeys(password);
    }

    public void clickLogin(){
        loginButton_id.click();
    }




}
