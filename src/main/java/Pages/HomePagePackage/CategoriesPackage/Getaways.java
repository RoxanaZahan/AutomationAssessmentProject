package Pages.HomePagePackage.CategoriesPackage;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Getaways {
    SeleniumUtils seleniumUtils = new SeleniumUtils();

    //Used xpath locator
    @FindBy(xpath = "//div[@class='categories-subcolumn subnav-categories cards-column']")
    private List<WebElement> getawaysCards;

    @FindBy(xpath = "//a[@class='shop-all-link']")
    private WebElement shopAll;

    public void clickOnCard(int cardIndex) {
        seleniumUtils.click(getawaysCards.get(cardIndex));
    }

    public void clickShopAll() {
        seleniumUtils.click(shopAll);
    }
}
