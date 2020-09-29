package Pages.DealPagePackage;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LocalDealPage extends SeleniumUtils {
    //div[contains(@class, 'cui-price-discount c-txt-price')]
    @FindBy(xpath = "//div[contains(@class, 'breakout-option-price')]")
    private List<WebElement> optionPrices;  //WebElement list with option prices
    @FindBy(id = "buy")
    private WebElement buyButton;           //Buy button webElement

        //returns option price by option number and not by index
    public String getOptionPrice(int optionNumber) {
        return optionPrices.get(optionNumber-1).getText();
    }
        //clicks on buyButton once ths is clickable (customised SeleniumUtils method)
    public void clickBuyButton() {
        click(buyButton);
    }
}
