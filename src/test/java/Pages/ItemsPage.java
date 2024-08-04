package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.AssertJUnit.assertEquals;

public class ItemsPage {
    double subTotalTrim;
    double taxTrim;
    double totalCalculated;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Overview')]")
    WebElement overviewTitle;

    @FindBy(xpath = "//div[contains(@class,'summary_subtotal_label')]")
    WebElement subTotalAmount;

    @FindBy(xpath = "//div[contains(@class,'summary_tax_label')]")
    WebElement taxForPurchase;

    @FindBy(xpath = "//div[contains(@class,'summary_total_label')]")
    WebElement totalAmount;

    @FindBy(xpath = "//button[contains(@id,'cancel')]")
    WebElement cancelOrder;

    @FindBy(xpath = "//h2[contains(@class,'complete-header')]")
    WebElement confirmationOrderText;

    @FindBy(xpath = "//button[contains(@id,'finish')]")
    WebElement finishButton;

    public void verifyOverviewPageTitle(){
        String overviewPage = overviewTitle.getText();
        assertEquals(overviewPage,"checkout: Overview");
    }

    public void verifySubTotalAmount()


}
