package Tests;

import Pages.HomePage;
import Pages.LoginRegisterPage;
import Utils.SeleniumDriver;
import Utils.SeleniumUtils;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpUserCredentials extends SeleniumDriver {

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

    @Test (priority = 0)
    public void testSignUpUserCredentials() {
        seleniumUtils.goToUrl("https://staging.groupon.com/");
        homePage.clickNoThanks();
        homePage.clickSignUp();
        loginRegisterPage.signUpUserCredentials(fullName,email,password);
        Assert.assertEquals(homePage.getTextOfSignInButton(), expectedSignedInButtonText);
    }
}
