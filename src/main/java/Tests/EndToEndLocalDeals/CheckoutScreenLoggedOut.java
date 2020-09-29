package Tests.EndToEndLocalDeals;

import Pages.CartPage;
import Pages.DealPagePackage.LocalDealPage;
import Pages.HomePagePackage.HomePage;
import Pages.SearchResultsPage;
import Utils.SeleniumUtils;
import Utils.TestingURLS;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckoutScreenLoggedOut extends SeleniumUtils {
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    LocalDealPage localDealPage;
    CartPage cartPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun=true)
    public void beforeTest() {
        this.homePage = PageFactory.initElements(driver, HomePage.class);
        this.searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        this.localDealPage = PageFactory.initElements(driver, LocalDealPage.class);
        this.cartPage = PageFactory.initElements(driver, CartPage.class);
        this.softAssert = new SoftAssert();
    }

    /**
     * Step 1 : go to URL https://www.groupon.com/
     * Step 2 : click "No Thanks" if present
     * Step 3 : go to Categories - Local - Food & Drink
     * Step 4 : click on the first deal
     * Step 5 : assert card price vs deal page price
     * Step 6 : pick first option
     * Step 7 : click on Buy
     * Step 8 : assert current URL vs cart link
     * Step 10 : click on Proceed To Checkout
     * Step 11 : assert current URL vs https://www.groupon.com/login?ref=%2Fcheckout%2Fcart%3F&guest=true
     * Step 12 : assert all
     * */

    @Test
    public void testCheckoutGuestScreen() {
        goToUrl(TestingURLS.GROUPON_PROD.getUrl());
        homePage.clickLocal().clickFoodAndDrink();
        String cardPrice = searchResultsPage.getCardPrice(1); // gets card number and not card index
        searchResultsPage.clickOnCard(1); //click on card number not on card index
        String dealOptionPrice = localDealPage.getOptionPrice(1);
        softAssert.assertEquals(dealOptionPrice, cardPrice, "dealOptionPrice is not equal to cardPrice");
        localDealPage.clickBuyButton();
        softAssert.assertTrue(driver.getCurrentUrl().contains("guest=true"), "Current URL does not contain \"guest=true\" parameter");
        softAssert.assertAll();
    }
}
