package Tests;

import org.testng.annotations.Test;


public class ItemsOverviewPageTest extends Base {

    public void verifyOverviewPageTitle(){
        itemsOverviewPage.verifyOverviewPageTitle();
    }
    public void verifySubTotalAmount(){
        itemsOverviewPage.verifySubTotalAmount();
    }
    public void verifyTaxForPurchase(){
        itemsOverviewPage.verifyTaxForPurchase();
    }
    public void verifyTotalAmount(){
        itemsOverviewPage.verifyTotalAmount();
    }

}
