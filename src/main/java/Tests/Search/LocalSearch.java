package Tests.Search;

import Pages.HomePagePackage.CategoriesPackage.Local;
import Pages.HomePagePackage.HomePage;
import Utils.SeleniumUtils;
import Utils.TestingURLS;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocalSearch extends SeleniumUtils {

    HomePage homePage;
    Local local;

    @BeforeMethod(alwaysRun=true)
    public void beforeTest() {
        this.homePage = PageFactory.initElements(driver, HomePage.class);
        this.local = PageFactory.initElements(driver, Local.class);
    }

    /**
     * Step 1 : go to URL https://www.groupon.com/
     * Step 2 : click "No Thanks" if present
     * Step 3 : go to Categories - Local - Food And Drink
     * Step 4 : Assert current URL vs expected URL for Food And Drink subcategory
     * */

    @Test(groups={"regression", "sanity"})
    public void testLocalFoodAndDrink() {
        goToUrl(TestingURLS.GROUPON_PROD.getUrl());
        homePage.clickLocal().clickFoodAndDrink();
        Assert.assertEquals(driver.getCurrentUrl(), local.getFoodAndDrinkLink());
    }

    @Test(groups={"sanity"})
    public void testLocal() {
        goToUrl(TestingURLS.GROUPON_PROD.getUrl());
        homePage.clickLocal().clickBeautyAndSpa();
        Assert.assertEquals(driver.getCurrentUrl(), local.getBeautyAndSpaLink());
    }


}
