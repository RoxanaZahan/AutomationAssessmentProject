package Tests;

import Pages.CategoriesPackage.Categories;
import Pages.CategoriesPackage.Local;
import Pages.HomePage;
import Pages.LoginRegisterPage;
import Utils.SeleniumDriver;
import Utils.SeleniumUtils;
import Utils.TestingURLS;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClasses extends SeleniumDriver{

        HomePage homePage;
        LoginRegisterPage loginRegisterPage;
        Categories categories;
        Local local;
        SeleniumUtils seleniumUtils = new SeleniumUtils();

        @BeforeMethod
        public void beforeTest() {
            this.homePage = PageFactory.initElements(driver, HomePage.class);
            this.loginRegisterPage = PageFactory.initElements(driver, LoginRegisterPage.class);
            this.categories = PageFactory.initElements(driver, Categories.class);
            this.local = PageFactory.initElements(driver,Local.class);
        }

        @Test
        public void testSomething() {
            seleniumUtils.goToUrl(TestingURLS.GROUPON_PROD.getUrl());
            homePage.clickNoThanks();
            categories.clickCategoriesButton();
            categories.clickLocal();

        }
}
