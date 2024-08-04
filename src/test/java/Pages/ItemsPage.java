package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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

    public void verifySubTotalAmount(){
        String subTotal = subTotalAmount.getText();
        System.out.println(subTotal);
        String subTotalString = subTotal.substring(13);
        subTotalTrim = Double.parseDouble(subTotalString);
        System.out.println(subTotalTrim);
    }

    public void verifyTaxForPurchase(){
        String tax =taxForPurchase.getText();
        System.out.println(tax);
        String subTaxString = tax.substring(6);
        taxTrim = Double.parseDouble(subTaxString);
    }

    public void verifyTotalAmount() {
        String theTotalAmount = totalAmount.getText();
        totalCalculated = subTotalTrim + taxTrim;
        double AssertedTotal;
        Assert.assertEquals(theTotalAmount, "Total: $" + totalCalculated);

        if( totalCalculated == totalCalculated ){
            finishButton.click();

        }
    }
        public void clickFinishButton(){
            finishButton.click();
        }
        public void cancelTheOrder(){
            cancelTheOrder.click();
        }

        public void verifyConfirmationOrderText(){
            String successOrderMessage = confirmationOrderText.getText();
            assertEquals(successOrderMessage, "Thank you for your order!");
        }

    }


}
