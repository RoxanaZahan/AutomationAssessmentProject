package Pages.HomePagePackage;

import Pages.HomePagePackage.CategoriesPackage.Coupons;
import Pages.HomePagePackage.CategoriesPackage.Getaways;
import Pages.HomePagePackage.CategoriesPackage.Goods;
import Pages.HomePagePackage.CategoriesPackage.Local;
import Utils.SeleniumUtils;
import Utils.WaitMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage extends SeleniumUtils {
    WaitMethods waitMethods = new WaitMethods();

    @FindBy(xpath = "//*[@id='ls-search']") //Search bar web element
    private WebElement searchTab;
    @FindBy(xpath = "//div[@id='btn-categories']") //Categories dropdown button
    private WebElement categoriesButton;
    @FindBy(xpath = "//li[@id]/a[@id]") //List of categories from NavBar
    private List<WebElement> navBarCategories;
    @FindBy(xpath = "//div[@class='categories-column']/div[@id]") //List of categories from dropdown container
    private List<WebElement> dropdownCategories;
    @FindBy(xpath = "//div[@id='signin-container']") //Sign in and My Stuff dropdown button - it changes the state and text
    private WebElement signInMyStuffDropdownButton;
    @FindBy(xpath = "//div[@id='signin-container']")
    private List<WebElement> signInMyStuffAsList;
    @FindBy (xpath = "//a[@data-bhw='UserSignUp']") //Sign up button on home page
    private WebElement signUpButton;
    @FindBy(xpath = "//a[@id='sign-out']") //Sign out button from MyStuff dropdown container
    private WebElement signOutButton;
    @FindBy(xpath = "//input[@id='sf-email']") //Email field from Sign In dropdown container
    private WebElement signInEmailField;
    @FindBy(xpath = "//input[@id='sf-pw']") //Password field from Sign In dropdown container
    private WebElement signInPasswordField;
    @FindBy(xpath = "//button[@class='btn btn-signin']") //Sign In button from Sign In dropdown container
    private WebElement signInButton;

    //Used id locator
    @FindBy(id = "btn-categories")
    private WebElement categoriesWebElement; //Categories button
    @FindBy(id = "local")
    private WebElement localWebElement;
    @FindBy(id = "goods")
    private WebElement goodsWebElement;
    @FindBy(id = "getaways")
    private WebElement getawaysWebElement;
    @FindBy(id = "coupons")
    private WebElement couponsWebElement;

    private Local local;
    private Goods goods;
    private Getaways getaways;
    private Coupons coupons;
    private String getawaysLink;

    public HomePage() {
        this.local = PageFactory.initElements(driver,Local.class);
        this.goods = PageFactory.initElements(driver,Goods.class);
        this.getaways = PageFactory.initElements(driver,Getaways.class);
        this.coupons = PageFactory.initElements(driver,Coupons.class);
        this.getawaysLink = "https://www.groupon.com/getaways";
    }

    public void freeTextSearch(String text) {
        click(searchTab);
        this.searchTab.sendKeys(text);
        this.searchTab.sendKeys(Keys.ENTER);
    }

    // Below -> Methods for Sign in / Sign up
    // ---------------------------------------------------

        // Sign in with credentials given as params
    public void signInKnownCredentials(final String email, final String password) {
        waitMethods.waitForElement(signInMyStuffDropdownButton).click();
        final WebElement enterEmail = this.waitMethods.waitForElementToBeClickable(this.signInEmailField);
        enterEmail.sendKeys(email);
        final WebElement enterPassword = this.waitMethods.waitForElementToBeClickable(this.signInPasswordField);
        enterPassword.sendKeys(password);
        this.signInButton.sendKeys(Keys.ENTER);
        Assert.assertTrue(isMyStuffInWhileLoop("My Stuff"), "My Stuff is not displayed");
    }

        // Sign in with credentials that were stored here:  test.LoginRegisterData text document
    public void signInSavedCredentials() {
        waitMethods.waitForElement(signInMyStuffDropdownButton).click();
        final WebElement enterEmail = this.waitMethods.waitForElementToBeClickable(this.signInEmailField);
        enterEmail.sendKeys(getvalue("email"));
        final WebElement enterPassword = this.waitMethods.waitForElementToBeClickable(this.signInPasswordField);
        enterPassword.sendKeys(getvalue("password"));
        this.signInButton.sendKeys(Keys.ENTER);
        Assert.assertTrue(isMyStuffInWhileLoop("My Stuff"), "My Stuff is not displayed so the user is not yet logged.");
    }

    public void clickSignInDropdownButton() {
        waitMethods.waitForElement(signInMyStuffDropdownButton);
        signInButton.click();
    }

    public void clickSignUp() {
        waitMethods.waitForElement(signUpButton);
        signUpButton.click();
    }

    public void clickSignOutButton() {
        waitMethods.waitForElement(signOutButton);
        signOutButton.click();
    }

    public void signOut() {
        clickSignInDropdownButton();
        clickSignOutButton();
    }

    public boolean isMyStuffInWhileLoop(String expectedCondition){
        WebElement expectedElement =  waitMethods.waitInAWhileLoop(signInMyStuffDropdownButton);
        return expectedElement.getText().contains(expectedCondition);
    }

    public String getTextOfSignInButton() {
        waitMethods.isElementDisplayed(signInButton,10);
        return this.signInButton.getText();
    }


    // Below -> Methods for Categories browsing
    // ---------------------------------------------------

    public void chooseCategoryOptionByText(String categoryName) {
        clickAndChoose(categoriesButton, categoryName);
    }

    public void clickCategoriesButton() {
        click(categoriesWebElement);
    }

    public Local clickLocal() {
        clickCategoriesButton();
        click(localWebElement);
        return this.local;
    }

    public Goods clickGoods() {
        clickCategoriesButton();
        click(goodsWebElement);
        return this.goods;
    }

    public Getaways clickGetaways() {
        clickCategoriesButton();
        click(getawaysWebElement);
        return this.getaways;
    }

    public Coupons clickCoupons() {
        clickCategoriesButton();
        click(couponsWebElement);
        return this.coupons;
    }

    public String getGetawaysLink() {
        return getawaysLink;
    }

}
