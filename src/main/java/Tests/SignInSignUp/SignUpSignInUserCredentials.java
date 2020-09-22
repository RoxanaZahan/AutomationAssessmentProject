package Tests.SignInSignUp;

import Pages.HomePagePackage.HomePage;
import Pages.SignUpPage;
import Utils.SeleniumUtils;
import Utils.TestingURLS;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpSignInUserCredentials extends SeleniumUtils {

    HomePage homePage;
    SignUpPage signUpPage;
    String fullName = "John Doe";
    String email;
    String password = "qaqaqaqa";

    @BeforeTest(alwaysRun=true)
    public void updateEmail() {
        this.email = getRandomString() + "@groupon.com";
    } //Creates random email before running the tests below

    @BeforeMethod(alwaysRun=true)
    public void beforeTest() {
        this.homePage = PageFactory.initElements(driver, HomePage.class);
        this.signUpPage = PageFactory.initElements(driver, SignUpPage.class);
    } //this runs before each test method below

     /**
     *    Test 1 :
     * Step 1 : go to URL https://www.groupon.com/
     * Step 2 : click "No Thanks" if present
     * Step 3 : sign up with given credentials
     * Step 4 : assert "Sign in" button changes to "My Stuff"
     * */

     // !!! DO NOT run this test in PRODUCTION - testSignUpUserCredentials() is currently disabled so it won't run
     // TODO : must review and fix it once I am able to test in Staging

    @Test (priority = 1, enabled = false)
    public void testSignUpUserCredentials() {
        goToUrl(TestingURLS.GROUPON_STAGING.getUrl());
        homePage.clickSignUp();
        signUpPage.signUpUserCredentials(fullName,email,password);
        Assert.assertTrue(homePage.isMyStuffInWhileLoop("My Stuff"), "My Stuff is not displayed");
    }

     /**
     *    Test 2 :
     * Step 1 : continue from previous test and sign out
     * Step 2 : sign in with the same credentials
     * Step 3 : assert "Sign in" button changes to "My Stuff"
     * */

    @Test (dependsOnMethods = "testSignUpUserCredentials") //test is currently failing, must review
    public void testSignInUserCredentials() {
        homePage.signOut();
        homePage.signInKnownCredentials(this.email, this.password);
    }
}
