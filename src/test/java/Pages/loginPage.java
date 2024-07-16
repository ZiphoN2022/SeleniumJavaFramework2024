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

    //ToDo create code to enter password
    @FindBy(xpath = "//input[contains(@id,'user-name')]")
    WebElement password_xpath;
    //ToDo create code to click Login button
    @FindBy(xpath = "//input[contains(@id,'user-name')]")
    WebElement login_xpath;



    public loginPage(WebDriver driver){
        this.driver=driver;
    }

    public void enterUsername(String username){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(username_xpath));
        username_xpath.sendKeys(username);
    }
   public void password(String password){
       new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(password_xpath));
       password_xpath.sendKeys(password);
   }
   public void login(){
       new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(login_xpath));
       login_xpath.click();
   }

}
