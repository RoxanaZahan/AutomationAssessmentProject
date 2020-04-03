package Pages.CategoriesPackage;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class Local {
    SeleniumUtils seleniumUtils = new SeleniumUtils();

    private String automotive = "Automotive";
    private String beautySpa = "Beauty & Spa";
    private String foodDrink = "Food & Drink";
    private String healthFitness = "Health & Fitness";
    private String homeServices = "Home Services";
    private String mealPrep = "Meal Prep & Wine Delivery";
    private String onlineLearning = "Online Learning";
    private String personalServices = "Personal Services";
    private String personalizedItems = "Personalized Items";
    private String retail = "Retail";
    private String thingsToDo = "Things To Do";

    @FindBy(xpath = "//a[@data-bhc='category:automotive']")
    private WebElement automotiveCat;
    @FindBy(xpath = "//a[@data-bhc='category:beauty-and-spas']")
    private WebElement beautySpaCat;
    @FindBy(xpath = "//a[@data-bhc='category:food-and-drink]")
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

    private List<String> localSubcategoriesList;
    private List<WebElement> localSubcategoriesElementsList;
    private HashMap<String, WebElement> localSubCategMap;

    public Local() {
        this.localSubcategoriesList = new ArrayList<String>();
        localSubcategoriesList.add(getAutomotive());
        localSubcategoriesList.add(getBeautySpa());
        localSubcategoriesList.add(getFoodDrink());
        localSubcategoriesList.add(getHealthFitness());
        localSubcategoriesList.add(getHomeServices());
        localSubcategoriesList.add(getMealPrep());
        localSubcategoriesList.add(getOnlineLearning());
        localSubcategoriesList.add(getPersonalizedItems());
        localSubcategoriesList.add(getPersonalServices());
        localSubcategoriesList.add(getRetail());
        localSubcategoriesList.add(getThingsToDo());

        this.localSubcategoriesElementsList = new ArrayList<WebElement>();
        localSubcategoriesElementsList.add(automotiveCat);
        localSubcategoriesElementsList.add(beautySpaCat);
        localSubcategoriesElementsList.add(foodDrinkCat);
        localSubcategoriesElementsList.add(healthFitnessCat);
        localSubcategoriesElementsList.add(homeServicesCat);
        localSubcategoriesElementsList.add(mealPrepCat);
        localSubcategoriesElementsList.add(onlineLearningCat);
        localSubcategoriesElementsList.add(personalizedItemsCat);
        localSubcategoriesElementsList.add(personalServicesCat);
        localSubcategoriesElementsList.add(retailCat);
        localSubcategoriesElementsList.add(thingsToDoCat);

        this.localSubCategMap = new HashMap<>();
        for(int i = 0; i < localSubcategoriesList.size(); i++) {
            for(int e = 0; e < localSubcategoriesElementsList.size(); e++) {
                localSubCategMap.put(localSubcategoriesList.get(i), localSubcategoriesElementsList.get(e));
            }
        }
    }

    public List<WebElement> getLocalSubcategoriesElementsList() {
        return localSubcategoriesElementsList;
    }

    public List<String> getLocalSubcategoriesList() {
        return localSubcategoriesList;
    }

    public String getAutomotive() {
        return this.automotive;
    }

    public String getBeautySpa() {
        return this.beautySpa;
    }

    public String getFoodDrink() {
        return this.foodDrink;
    }

    public String getHealthFitness() {
        return this.healthFitness;
    }

    public String getHomeServices() {
        return homeServices;
    }

    public String getMealPrep() {
        return mealPrep;
    }

    public String getOnlineLearning() {
        return onlineLearning;
    }

    public String getPersonalizedItems() {
        return personalizedItems;
    }

    public String getPersonalServices() {
        return personalServices;
    }

    public String getRetail() {
        return retail;
    }

    public String getThingsToDo() {
        return thingsToDo;
    }

    public void clickSubCategory(String subCategory) {
        for(Map.Entry<String,WebElement> entry : localSubCategMap.entrySet()) {
            if(subCategory.equals(entry.getKey())) {
                seleniumUtils.click(entry.getValue());
            }
        }
    }

}
