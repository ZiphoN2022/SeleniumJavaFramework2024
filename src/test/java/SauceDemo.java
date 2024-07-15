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

    // this is the testm ethod
    @Test
    public void loginTests() throws InterruptedException {
        double backItem;
        double lightItem;
        double subTotal;
        driver = new ChromeDriver();
//        driver= new FirefoxDriver();
//        driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/"); // This line start the browser
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String ActualResults = driver.findElement(By.xpath("//span[contains(.,'Products')]")).getText();
        Assert.assertEquals(ActualResults, "Products");

        Thread.sleep(1000);
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        String expectedbackPackvalue = driver.findElement(By.cssSelector(".inventory_item:nth-child(1) .inventory_item_price")).getText();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        String expectedbikeLightvalue = driver.findElement(By.cssSelector(".inventory_item:nth-child(2) .inventory_item_price")).getText();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a")).click();
        String MyItemvalue = driver.findElement(By.xpath("//div[@id='cart_contents_container']/div/div/div[4]/div[2]/div[2]/div")).getText();
        driver.findElement(By.id("checkout")).click();

        String shippingInfo  = driver.findElement(By.xpath("//span[contains(.,'Checkout: Your Information')]")).getText();
        driver.findElement(By.id("first-name")).sendKeys("Zinhle");
        Thread.sleep(1000);
        driver.findElement(By.id("last-name")).sendKeys("Inhle");
        Thread.sleep(1000);
        driver.findElement(By.id("postal-code")).sendKeys("2199");
        Assert.assertEquals(shippingInfo,"Checkout: Your Information");

        driver.findElement(By.id("continue")).click();
        Thread.sleep(1000);
        String actualbackPackvalue = driver.findElement(By.cssSelector(".cart_item:nth-child(3) .inventory_item_price")).getText();
        System.out.println("backpackitem: "+actualbackPackvalue);
        String backpackItem = actualbackPackvalue.substring(1);
        //System.out.println(backpackItem);
        backItem = Double.parseDouble(backpackItem);
        String actualbikeLightvalue = driver.findElement(By.cssSelector(".cart_item:nth-child(4) .inventory_item_price")).getText();
        System.out.println("bikelightitem: "+actualbikeLightvalue);
        String bikelightItem = actualbikeLightvalue.substring(1);
        //System.out.println(bikelightItem);
        lightItem = Double.parseDouble(bikelightItem);
        subTotal = backItem + lightItem;
        System.out.println("calculated items total: "+subTotal);
        String subTotalvalue = driver.findElement(By.xpath("//div[@id='checkout_summary_container']/div/div[2]/div[6]")).getText();

        Assert.assertEquals(expectedbackPackvalue,actualbackPackvalue);
        Assert.assertEquals(expectedbikeLightvalue,actualbikeLightvalue);

        String totalItemsValue = driver.findElement(By.cssSelector(".summary_total_label")).getText();
        Assert.assertEquals(subTotalvalue,"Item total: $"+subTotal);
        Assert.assertEquals(totalItemsValue,"Total: $43.18");
        Thread.sleep(500);

        driver.findElement(By.id("finish")).click();
        String completeOrder = driver.findElement(By.xpath("//span[contains(.,'Checkout: Complete!')]")).getText();
        Assert.assertEquals(completeOrder, "Checkout: Complete!");
        //driver.findElement(By.id("back-to-products")).click();


        //ToDo create the coe to cater for the rest of the journey

    }

   // @AfterTest
  //  public void closeBrowser(){
   //     driver.quit();
  //  }
}
