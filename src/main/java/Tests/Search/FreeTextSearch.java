package Tests.Search;

import Pages.HomePagePackage.HomePage;
import Utils.DataProviderClass;
import Utils.SeleniumUtils;
import Utils.TestingURLS;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeTextSearch extends SeleniumUtils {
    HomePage homePage;

    @BeforeMethod(alwaysRun=true)
    public void beforeTest() {
        this.homePage = PageFactory.initElements(driver, HomePage.class);
    }

    /**
     * Step 1 : go to URL https://www.groupon.com/
     * Step 2 : click "No Thanks" if present
     * Step 3 : click on Search bar
     * Step 4 : send keys using data provider "search-keys"
     * */

    @Test(groups = {"regression"}, dataProvider = "search-keys", dataProviderClass = DataProviderClass.class)
    public void testCouponsSearch(String keys) {
        goToUrl(TestingURLS.GROUPON_PROD.getUrl());
        homePage.freeTextSearch(keys);
    }
}
