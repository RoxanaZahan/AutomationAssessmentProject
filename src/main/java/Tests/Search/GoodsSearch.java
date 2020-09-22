package Tests.Search;

import Pages.HomePagePackage.HomePage;
import Utils.SeleniumUtils;
import Utils.TestingURLS;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class GoodsSearch extends SeleniumUtils {

    HomePage homePage;
    String expectedForTheHome = "for-the-home";

    @BeforeClass()
    public void beforeTest() {
        this.homePage = PageFactory.initElements(driver, HomePage.class);
    }

    /**
     * Step 1 : go to URL https://www.groupon.com/
     * Step 2 : click "No Thanks" if present
     * Step 3 : go to Categories - Goods - For The Home
     * Step 4 : Assert current URL vs expected URL for For The Home subcategory
     * */

    @Test(groups={"regression", "sanity"})
    public void testGoodsSearch() {
        System.out.println(Thread.currentThread().getId());
        goToUrl(TestingURLS.GROUPON_PROD.getUrl());
        homePage.clickGoods().clickForTheHome();
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedForTheHome), "Current url does not contain \"for-the-home\"");
    }
}
