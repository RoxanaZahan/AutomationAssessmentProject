package Tests;

import Pages.HomePage;
import Pages.LoginRegisterPage;
import Utils.SeleniumDriver;
import Utils.SeleniumUtils;
import Utils.TestingURLS;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpSignInUserCredentials extends SeleniumDriver {

    HomePage homePage;
    LoginRegisterPage loginRegisterPage;
    SeleniumUtils seleniumUtils = new SeleniumUtils();
    String fullName = "John Doe";
    String email;
    String password = "qaqaqaqa";
    String expectedSignedInButtonText = "My Stuff";

    @BeforeTest
    public void updateEmail() {
        this.email = seleniumUtils.getRandomString() + "@groupon.com";
    }

    @BeforeMethod
    public void beforeTest() {
        this.homePage = PageFactory.initElements(driver, HomePage.class);
        this.loginRegisterPage = PageFactory.initElements(driver, LoginRegisterPage.class);
    }

    @Test (priority = 1)
    public void testSignUpUserCredentials() {
        seleniumUtils.goToUrl(TestingURLS.GROUPON_STAGING.getUrl());
        homePage.clickNoThanks();
        homePage.clickSignUp();
        loginRegisterPage.signUpUserCredentials(fullName,email,password);
        Assert.assertEquals(homePage.getTextOfSignInButton(), expectedSignedInButtonText);
    }

    @Test (dependsOnMethods = "testSignUpUserCredentials")
    public void testSignInUserCredentials() {
        homePage.clickSignIn();
        homePage.clickSignOut();
        homePage.clickSignIn();
        loginRegisterPage.signInKnownCredentials(this.email, this.password);
        Assert.assertEquals(homePage.getTextOfMyStuffButton(), expectedSignedInButtonText);
    }
}
