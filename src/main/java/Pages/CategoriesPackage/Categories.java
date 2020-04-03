package Pages.CategoriesPackage;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Categories {
    @FindBy(xpath = "//div[@id='btn-categories']")
    private WebElement categoriesWebElement;
    @FindBy(xpath = "//div[@id='local']")
    private WebElement localWebElement;

    private Local local = new Local();
    private SeleniumUtils seleniumUtils = new SeleniumUtils();

    public Categories() {
        //this.local = new Local();
    }

    public void clickCategoriesButton() {
        seleniumUtils.click(categoriesWebElement);
    }

    public Local clickLocal() {
        seleniumUtils.click(localWebElement);
        return this.local;
    }

}
