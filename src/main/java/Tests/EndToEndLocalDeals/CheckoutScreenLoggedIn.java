package Tests.EndToEndLocalDeals;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePagePackage.CategoriesPackage.Local;
import Pages.DealPagePackage.LocalDealPage;
import Pages.HomePagePackage.HomePage;
import Pages.SearchResultsPage;
import Utils.SeleniumUtils;
import Utils.TestingURLS;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckoutScreenLoggedIn extends SeleniumUtils {
    HomePage homePage;
    Local local;
    SearchResultsPage searchResultsPage;
    LocalDealPage localDealPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun=true)
    public void beforeTest() {
        this.homePage = PageFactory.initElements(driver, HomePage.class);
        this.local = PageFactory.initElements(driver, Local.class);
        this.searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        this.localDealPage = PageFactory.initElements(driver, LocalDealPage.class);
        this.cartPage = PageFactory.initElements(driver, CartPage.class);
        this.checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
        this.softAssert = new SoftAssert();
    }

    /**
     * Step 1 : go to URL https://www.groupon.com/
     * Step 2 : click "No Thanks" if present
     * Step 3 : login with stored credentials
     * Step 4 : go to Categories - Local - Food & Drink
     * Step 5 : click on the first deal
     * Step 6 : assert card price vs deal page price
     * Step 7 : pick first option
     * Step 8 : click on Buy
     * Step 9 : assert current URL vs cart link
     * Step 10 : assert all
     * */

    @Test(priority = 1)
    public void signIn() {
        goToUrl(TestingURLS.GROUPON_PROD.getUrl());
        homePage.signInSavedCredentials();

    }

    @Test(dependsOnMethods = "signIn")
    public void reachCheckoutScreen() {
        homePage.clickLocal().clickFoodAndDrink();
        softAssert.assertEquals(driver.getCurrentUrl(), local.getFoodAndDrinkLink(), "CurrentUrl is not equal to Food And Drink url");
        String cardPrice = searchResultsPage.getCardPrice(1); // gets card number and not card index
        searchResultsPage.clickOnCard(1); //clicks on card number not on card index
        String dealOptionPrice = localDealPage.getOptionPrice(1);
        softAssert.assertEquals(dealOptionPrice, cardPrice, "dealOptionPrice is not equal to cardPrice");
        localDealPage.clickBuyButton();
        softAssert.assertTrue(checkoutPage.getCheckoutPageText().contains("Checkout"), "Page title is not \"Checkout\".");
        //softAssert.assertEquals(checkoutPage.getCheckoutPageText(), "Checkout", "Page title is not \"Checkout\".");
        softAssert.assertAll();
    }

}
