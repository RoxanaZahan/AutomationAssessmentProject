package Tests.Search;

import Pages.HomePagePackage.HomePage;
import Utils.SeleniumUtils;
import Utils.TestingURLS;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class CouponsSearch extends SeleniumUtils {

    HomePage homePage;

    @BeforeClass()
    public void beforeTest() {
        this.homePage = PageFactory.initElements(driver, HomePage.class);
    }

    /**
     * Step 1 : go to URL https://www.groupon.com/
     * Step 2 : click "No Thanks" if present
     * Step 3 : go to Categories - Coupons - click on the third subcategory
     * Step 4 : Assert current URL vs expected URL for Coupons
     * */

    @Test(groups = {"regression"})
    public void testCouponsSearch() {
        System.out.println(Thread.currentThread().getId());
        goToUrl(TestingURLS.GROUPON_PROD.getUrl());
        homePage.clickCoupons().clickSubcategoryByNumber(3);
        Assert.assertTrue(driver.getCurrentUrl().contains("coupons/"), "Current url does not contain \"coupons\".");
    }
}
