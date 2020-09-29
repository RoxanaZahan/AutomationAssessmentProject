package Pages;

import Pages.HomePagePackage.HomePage;
import Utils.WaitMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignUpPage {
    WaitMethods waitMethods = new WaitMethods();
    HomePage homePage = new HomePage();

    @FindBy(xpath = "//input[@id='signup-fullName-input']")
    private WebElement signUpNameField;
    @FindBy(xpath = "//input[@id='signup-email-input']")
    private WebElement signUpEmailField;
    @FindBy(xpath = "//input[@id='signup-password-input']")
    private WebElement signUpPasswordField;
    @FindBy(xpath = "//button[@id='signup-button']")
    private WebElement signUpButton;

    @FindAll(
            {
                    @FindBy(className = "gig-selectable"), //selectable sections as: "Keep me signed in.." & "Yes, I want to save money.."
                    @FindBy(className = "gig-field"), //name, email & password fields
                    @FindBy(id = "signup-button") //green sign up button on Sign Up Page
            }
    )
    private List<WebElement> signUpPageElements;

    public void signUpUserCredentials(String fullName, String email, String password) {
        final WebElement enterName = this.waitMethods.waitForElementToBeClickable(this.signUpNameField);
        enterName.sendKeys(fullName);
        final WebElement enterEmail = this.waitMethods.waitForElementToBeClickable(this.signUpEmailField);
        enterEmail.sendKeys(email);
        final WebElement enterPassword = this.waitMethods.waitForElementToBeClickable(this.signUpPasswordField);
        enterPassword.sendKeys(password);
        this.signUpButton.sendKeys(Keys.ENTER);
    }

}
