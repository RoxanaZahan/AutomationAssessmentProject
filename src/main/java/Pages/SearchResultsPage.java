package Pages;

import Pages.HomePagePackage.CategoriesPackage.Local;
import Utils.SeleniumUtils;
import Utils.WaitMethods;
import com.sun.org.apache.xerces.internal.dom.PSVIElementNSImpl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class SearchResultsPage extends SeleniumUtils {
    WaitMethods waitMethods = new WaitMethods();

    // I used @FindBys annotation here
    @FindBy(xpath = "//div[contains(@class, 'cui-price-discount c-txt-price')]")
    private List<WebElement> cardsPricesWithDiscount;
    @FindBys( {
            @FindBy(className = "cui-content"),
            @FindBy(xpath = "//figure[@data-pingdom-info='purchasable-deal']")
    } )
    private List<WebElement> cardsList;

    public void clickOnCard(int cardNumber) {
        click(cardsList.get(cardNumber-1));
    }

    public String getCardPrice(int cardNumber) {
        return cardsPricesWithDiscount.get(cardNumber-1).getText();
    }
}
