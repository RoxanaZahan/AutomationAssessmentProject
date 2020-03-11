package Tests;

import Pages.HomePage;
import Pages.LoginRegisterPage;
import Utils.SeleniumDriver;
import Utils.SeleniumUtils;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInSavedCredentials extends SeleniumDriver {

    HomePage homePage;
    LoginRegisterPage loginRegisterPage;
    SeleniumUtils seleniumUtils = new SeleniumUtils();
    String expectedSignedInButtonText = "My Stuff";

    @BeforeMethod
    public void beforeTest() {
        this.homePage = PageFactory.initElements(driver, HomePage.class);
        this.loginRegisterPage = PageFactory.initElements(driver, LoginRegisterPage.class);
    }

    @Test (priority = 3)
    public void testSignInUserCredentials() {
        seleniumUtils.goToUrl("https://staging.groupon.com/");
        homePage.clickNoThanks();
        homePage.clickSignIn();
        loginRegisterPage.signInSavedCredentials(); //sign in with credentials stored in a txt file
        Assert.assertEquals(homePage.getTextOfMyStuffButton(), expectedSignedInButtonText);
    }
}