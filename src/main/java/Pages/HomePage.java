package Pages;

import Utils.SeleniumUtils;
import Utils.WaitMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage {
    SeleniumUtils seleniumUtils = new SeleniumUtils();
    WaitMethods waitMethods = new WaitMethods();
    LoginRegisterPage loginRegisterPage = new LoginRegisterPage();

    @FindBy(xpath = "//*[@id='nothx']") //"No thanks" for landing page popup
    private WebElement noThanks;
    @FindBy(xpath = "//*[@id='ls-search']") //Search bar web element
    private WebElement searchTab;
    @FindBy(xpath = "//div[@id='btn-categories']") //Categories button for opening Categories page
    private WebElement categories;
    @FindBy(xpath = "//li[@id]/a[@id]") //Categories listed in NavBar
    private List<WebElement> navBarCategories;
    @FindBy(xpath = "//div[@class='categories-column']/div[@id]") //Categories listed in Categories page
    private List<WebElement> categoriesChannels;
    @FindBy(xpath = "//div[@id='signin-container']")
    private WebElement signInButton;
    @FindBy(xpath = "//header[@id='ls-header']")
    private WebElement header;
    @FindBy(xpath = "//div[@id='main-feed']")
    private WebElement cardsFeed;
    @FindBy (xpath = "//a[@data-bhw='UserSignUp']")
    private WebElement signUpButton;
    @FindBy(xpath = "//span[@id='user-menu-description']")
    private WebElement myStuffButton;


    public void clickNoThanks() {
        seleniumUtils.click(noThanks);
    }
    public void waitForLandingPage() {
        this.waitMethods.waitForElement(this.cardsFeed);
    }
    public void clickSignIn() {
        waitMethods.waitForElement(signInButton);
        //waitMethods.waitForElementToBeClickable(signInButton);
        signInButton.click();
        //seleniumUtils.click(signInButton);
    }

    public void clickSignUp() {
        waitMethods.waitForElement(signUpButton);
        signUpButton.click();
    }


    public void freeTextSearch(String text) {
        seleniumUtils.click(searchTab);
        this.searchTab.sendKeys(text);
        this.searchTab.sendKeys(Keys.ENTER);
    }

    public void chooseCategoryFilter(String categoryName) {
        seleniumUtils.clickAndChoose(categories, categoryName);
    }

    public String getTextOfMyStuffButton() {
        waitMethods.isElementDisplayed(myStuffButton,10);
        return this.myStuffButton.getText();
    }

    public String getTextOfSignInButton() {
        waitMethods.isElementDisplayed(signInButton,10);
        return this.signInButton.getText();
    }

    public void clickSignOut() {
        seleniumUtils.clickAndChoose(signInButton, "Sign Out");
    }

}
