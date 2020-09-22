package Tests.SignInSignUp;

import Pages.HomePagePackage.HomePage;
import Pages.SignUpPage;
import Utils.SeleniumUtils;
import Utils.TestingURLS;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInSavedCredentials extends SeleniumUtils {

    HomePage homePage;
    SignUpPage signUpPage;

    @BeforeMethod(alwaysRun=true)
    public void beforeTest() {
        this.homePage = PageFactory.initElements(driver, HomePage.class);
        this.signUpPage = PageFactory.initElements(driver, SignUpPage.class);
    }

     /**
     * Step 1 : go to URL https://www.groupon.com/
     * Step 2 : click "No Thanks" if present
     * Step 3 : login with stored credentials
     * Step 4 : assert "Sign in" button changes to "My Stuff"
     * */

    @Test
    public void testSignInSavedCredentials() {
        goToUrl(TestingURLS.GROUPON_PROD.getUrl());
        homePage.signInSavedCredentials(); //sign in with credentials stored in a txt file
    }
}
