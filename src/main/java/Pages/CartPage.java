package Pages;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends SeleniumUtils {

    @FindBy(xpath = "//span[@class='overview-cart-total columns five']")
    private WebElement totalPrice;
    @FindBy(xpath = "//a[@id='bottom-proceed-to-checkout']")
    private WebElement proceedToCheckoutButton;
    private String cartURL = "https://www.groupon.com/cart";

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public String getCartURL() {
        return cartURL;
    }

    public void clickProceedToCheckout() {
        click(proceedToCheckoutButton);
    }
}
