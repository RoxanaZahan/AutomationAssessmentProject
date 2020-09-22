package Pages.HomePagePackage.CategoriesPackage;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Local {
    SeleniumUtils seleniumUtils = new SeleniumUtils();

    //Used xpath locator
    @FindBy(xpath = "//a[@data-bhc='category:automotive']")
    private WebElement automotiveCat;
    @FindBy(xpath = "//a[@data-bhc='category:beauty-and-spas']")
    private WebElement beautySpaCat;
    @FindBy(xpath = "//a[contains(@href, 'category=food-and-drink')]")
    private WebElement foodDrinkCat;
    @FindBy(xpath = "//a[@data-bhc='category:health-and-fitness']")
    private WebElement healthFitnessCat;
    @FindBy(xpath = "//a[@data-bhc='category:home-improvement']")
    private WebElement homeServicesCat;
    @FindBy(xpath = "//a[@data-bhc='category:meal-prep']")
    private WebElement mealPrepCat;
    @FindBy(xpath = "//a[@data-bhc='category:online-learning']")
    private WebElement onlineLearningCat;
    @FindBy(xpath = "//a[@data-bhc='category:personal-services']")
    private WebElement personalServicesCat;
    @FindBy(xpath = "//a[@data-bhc='category:local-customizable']")
    private WebElement personalizedItemsCat;
    @FindBy(xpath = "//a[@data-bhc='category:retail']")
    private WebElement retailCat;
    @FindBy(xpath = "//a[@data-bhc='category:things-to-do']")
    private WebElement thingsToDoCat;
    @FindBy(className = "subcategories-link")
    private List<WebElement> listOfSubcategories;

    private String foodAndDrinkLink = "https://www.groupon.com/browse/chicago?category=food-and-drink";
    private String beautyAndSpaLink = "https://www.groupon.com/browse/chicago?category=beauty-and-spas";

    public void clickAutomotive() {
        seleniumUtils.click(automotiveCat);
    }
    public void clickBeautyAndSpa() {
        seleniumUtils.click(beautySpaCat);
    }
    public void clickFoodAndDrink() {
        seleniumUtils.clickElementViaActions(foodDrinkCat);
    }
    public void clickHealthAndFitness() {
        seleniumUtils.click(healthFitnessCat);
    }
    public void clickHomeServices() { seleniumUtils.click(homeServicesCat); }
    public void clickMealPrepAndWineDelivery() {
        seleniumUtils.click(mealPrepCat);
    }
    public void clickOnlineLearning() {
        seleniumUtils.click(onlineLearningCat);
    }
    public void clickPersonalServices() {
        seleniumUtils.click(personalServicesCat);
    }
    public void clickPersonalizedItems() {
        seleniumUtils.click(personalizedItemsCat);
    }
    public void clickRetail() {
        seleniumUtils.click(retailCat);
    }
    public void clickThingsToDo() {
        seleniumUtils.click(thingsToDoCat);
    }

    public String getFoodAndDrinkLink() {
        return foodAndDrinkLink;
    }
    public String getBeautyAndSpaLink() { return beautyAndSpaLink; }

    public void clickOnFoodAndDrinks(){
        for(WebElement subCateg : listOfSubcategories){
            if(subCateg.getAttribute("data-bhc").contains("food-and-drink")){
                seleniumUtils.click(subCateg);
            }
        }
    }

}
