package Pages;

import Utils.SeleniumUtils;
import Utils.WaitMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends SeleniumUtils {

        WaitMethods waitMethods = new WaitMethods();

        @FindBy(xpath = "//div[@id='welcome-title-container']")
        private WebElement checkoutPageTitle;
        @FindBy(xpath = "//button[@class='btn complete-order']")
        private WebElement placeOrderButton;

        public String getCheckoutPageText() {
            waitMethods.waitForElement(checkoutPageTitle);
            return checkoutPageTitle.getText();
        }

        public void clickProceedToCheckout() {
            click(placeOrderButton);
        }
}
