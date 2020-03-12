package Pages;

import Utils.SeleniumUtils;
import Utils.WaitMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegisterPage {
    WaitMethods waitMethods = new WaitMethods();
    SeleniumUtils seleniumUtils = new SeleniumUtils();

    @FindBy(xpath = "//input[@id='sf-email']")
    private WebElement signInEmailField;
    @FindBy(xpath = "//input[@id='sf-pw']")
    private WebElement signInPasswordField;
    @FindBy(xpath = "//button[@class='btn btn-signin']")
    private WebElement signInButton;
    @FindBy(xpath = "//input[@id='signup-fullName-input']")
    private WebElement signUpNameField;
    @FindBy(xpath = "//input[@id='signup-email-input']")
    private WebElement signUpEmailField;
    @FindBy(xpath = "//input[@id='signup-password-input']")
    private WebElement signUpPasswordField;
    @FindBy(xpath = "//button[@id='signup-button']")
    private WebElement signUpButton;

    public void signInKnownCredentials(final String email, final String password) {
        final WebElement enterEmail = this.waitMethods.waitForElementToBeVisible(this.signInEmailField);
        enterEmail.sendKeys(email);
        final WebElement enterPassword = this.waitMethods.waitForElementToBeVisible(this.signInPasswordField);
        enterPassword.sendKeys(password);
        this.signInButton.click();
    }

    public void signInSavedCredentials() {
        final WebElement enterEmail = this.waitMethods.waitForElementToBeVisible(this.signInEmailField);
        enterEmail.sendKeys(seleniumUtils.getvalue("email"));
        final WebElement enterPassword = this.waitMethods.waitForElementToBeVisible(this.signInPasswordField);
        enterPassword.sendKeys(seleniumUtils.getvalue("password"));
        this.signInButton.click();
    }

    public void signUpUserCredentials(String fullName, String email, String password) {
        final WebElement enterName = this.waitMethods.waitForElementToBeVisible(this.signUpNameField);
        enterName.sendKeys(fullName);
        final WebElement enterEmail = this.waitMethods.waitForElementToBeVisible(this.signUpEmailField);
        enterEmail.sendKeys(email);
        final WebElement enterPassword = this.waitMethods.waitForElementToBeVisible(this.signUpPasswordField);
        enterPassword.sendKeys(password);
        this.signUpButton.click();
    }

}
