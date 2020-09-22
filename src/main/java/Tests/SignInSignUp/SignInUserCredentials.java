package Tests.SignInSignUp;

import Pages.HomePagePackage.HomePage;
import Pages.SignUpPage;
import Utils.SeleniumUtils;
import Utils.TestingURLS;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignInUserCredentials extends SeleniumUtils {

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
     * Step 3 : login with credentials given as parameters
     * Step 4 : assert "Sign in" button changes to "My Stuff"
     * */

     @Parameters({"email", "password"})
    @Test
    public void testSignInUserCredentials(String email, String password) {
        goToUrl(TestingURLS.GROUPON_PROD.getUrl());
        homePage.signInKnownCredentials(email, password);
    }
}
