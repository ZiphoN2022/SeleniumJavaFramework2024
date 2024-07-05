import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SauceDemo {

    WebDriver driver;

    // this is the test method
    @Test
    public void loginTests() throws InterruptedException {
        int waiting_duration = 2000;

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
        Thread.sleep(waiting_duration);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(waiting_duration);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(waiting_duration);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(waiting_duration);

        //Check the Products landing page
        String ActualResultForProducts = driver.findElement(By.xpath("//span[@class='title'][contains(.,'Products')]")).getText();
        Assert.assertEquals(ActualResultForProducts, "Products");
        Thread.sleep(waiting_duration);

        //Add Product by Clicking the button
        driver.findElement(By.xpath("//button[contains(@id,'add-to-cart-sauce-labs-backpack')]")).click();
        Thread.sleep(waiting_duration);

        //Click cart icon button
        driver.findElement(By.xpath("//a[contains(@class,'shopping_cart_link')]")).click();

        //Check Your Cart landing page
        String ActualResultForYourCart = driver.findElement(By.xpath("//span[@class='title'][contains(.,'Your Cart')]")).getText();
        Assert.assertEquals(ActualResultForYourCart, "Your Cart");
        Thread.sleep(waiting_duration);

        //Click checkout button
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(waiting_duration);

        //Check Your Information page
        String ActualResultsForYourInformation = driver.findElement(By.xpath("//span[@class='title'][contains(.,'Checkout: Your Information')]")).getText();
        Assert.assertEquals(ActualResultsForYourInformation, "Checkout: Your Information");

        //Add details on the Your Information form
        driver.findElement(By.id("first-name")).sendKeys("Motlatso");
        driver.findElement(By.id("last-name")).sendKeys("Chaba");
        driver.findElement(By.id("postal-code")).sendKeys("0711");
        Thread.sleep(waiting_duration);

        driver.findElement(By.id("continue")).click();
        Thread.sleep(waiting_duration);

        //Check Overview landing page
        String ActualResultForCheckOutOverview = driver.findElement(By.xpath("//span[@class='title'][contains(.,'Checkout: Overview')]")).getText();
        Assert.assertEquals(ActualResultForCheckOutOverview, "Checkout: Overview");
        Thread.sleep(waiting_duration);

        //Check If Summary Total is not null
        String ActualSummary_total_label = driver.findElement(By.xpath("//div[contains(@class,'summary_total_label')]")).getText();
        Assert.assertNotEquals(ActualSummary_total_label, null);
        Thread.sleep(waiting_duration);

        //Click on finish button
        driver.findElement(By.id("finish")).click();
        Thread.sleep(waiting_duration);

        //Check Thank you landing page
        String ActualThankYouOrder = driver.findElement(By.xpath("//h2[@class='complete-header'][contains(.,'Thank you for your order!')]")).getText();
        Assert.assertEquals(ActualThankYouOrder, "Thank you for your order!");
        Thread.sleep(waiting_duration);

        //Click 'Back to products' button
        driver.findElement(By.id("back-to-products")).click();
        Thread.sleep(waiting_duration);

        //Click 'Burger menu button'
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(waiting_duration);

        //Logout
        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(waiting_duration);

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
