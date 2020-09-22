package Pages.HomePagePackage.CategoriesPackage;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Goods {
    SeleniumUtils seleniumUtils = new SeleniumUtils();

    //Used css locator
    @FindBy(css = "a[data-bhc = 'category:auto-and-home-improvement']")
    private WebElement autoHomeImprovElement;
    @FindBy(css = "a[data-bhc = 'category:baby-kids-and-toys']")
    private WebElement babyKidsElement;
    @FindBy(css = "a[data-bhc = 'category:electronics']")
    private WebElement electronicsElement;
    @FindBy(css = "a[data-bhc = 'category:entertainment-and-media']")
    private WebElement entertainmentMediaElement;
    @FindBy(css = "a[data-bhc = 'category:for-the-home']")
    private WebElement forTheHomeElement;
    @FindBy(css = "a[data-bhc = 'category:grocery-and-household']")
    private WebElement groceryAndHouseHoldElement;
    @FindBy(css = "a[data-bhc = 'category:health-and-beauty']")
    private WebElement healthAndBeautyElement;
    @FindBy(css = "a[data-bhc = 'category:jewelery-and-watches']")
    private WebElement jeweleryAndWatchesElement;
    @FindBy(css = "a[data-bhc = 'category:mens-clothing-shoes-and-accessories']")
    private WebElement menFashionElement;
    @FindBy(css = "a[data-bhc = 'category:v1-personalized-items']")
    private WebElement personalizedItemsElement;
    @FindBy(css = "a[data-bhc = 'category:pet-supplies']")
    private WebElement petSuppliesElement;
    @FindBy(css = "a[data-bhc = 'category:sports-and-outdoors']")
    private WebElement sportsOutdoorsElement;
    @FindBy(css = "a[data-bhc = 'category:toys']")
    private WebElement toysElement;
    @FindBy(css = "a[data-bhc = 'category:womens-clothing-shoes-and-accessories']")
    private WebElement womenFashionElement;

    public void clickAutoAndHomeImprovement() { seleniumUtils.click(autoHomeImprovElement); }
    public void clickBabyAndKids() { seleniumUtils.click(babyKidsElement); }
    public void clickElectronics() { seleniumUtils.click(electronicsElement); }
    public void clickEntertainmentAndMedia() { seleniumUtils.click(entertainmentMediaElement); }
    public void clickForTheHome() { seleniumUtils.click(forTheHomeElement); }
    public void clickGroceryAndHouseHold() { seleniumUtils.click(groceryAndHouseHoldElement); }
    public void clickHealthAndBeauty() { seleniumUtils.click(healthAndBeautyElement); }
    public void clickJeweleryAndWatchesElement() { seleniumUtils.click(jeweleryAndWatchesElement); }
    public void clickMenFashionElement() { seleniumUtils.click(menFashionElement); }
    public void clickPersonalizedItems() { seleniumUtils.click(personalizedItemsElement); }
    public void clickPerSupplies() { seleniumUtils.click(petSuppliesElement); }
    public void clickSportsAndOutdoors() { seleniumUtils.click(sportsOutdoorsElement); }
    public void clickToys() { seleniumUtils.click(toysElement); }
    public void clickWomenFashion() { seleniumUtils.click(womenFashionElement); }
}
