package Tests.Search;

import Pages.HomePagePackage.HomePage;
import Utils.SeleniumUtils;
import Utils.TestingURLS;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetawaysSearch extends SeleniumUtils {
    HomePage homePage;
    String getawaysUrl = "https://www.groupon.com/getaways";

    @BeforeMethod(alwaysRun=true)
    public void beforeTest() {
        this.homePage = PageFactory.initElements(driver, HomePage.class);
    }

    /**
     * Step 1 : go to URL https://www.groupon.com/
     * Step 2 : click "No Thanks" on start popup if present
     * Step 3 : go to Categories - Getaways - ShopAll
     * Step 4 : Assert url
     * */

    @Test(groups={"regression", "sanity"})
    public void testGetawaysSearch() {
        goToUrl(TestingURLS.GROUPON_PROD.getUrl());
        homePage.clickGetaways().clickShopAll();
        Assert.assertEquals(driver.getCurrentUrl(), getawaysUrl);
    }
}
