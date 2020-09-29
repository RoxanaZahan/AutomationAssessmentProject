package Pages.HomePagePackage.CategoriesPackage;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Coupons {
    SeleniumUtils seleniumUtils = new SeleniumUtils();

    //Used class locator
    @FindBy(className = "subcategories-link")
    private List<WebElement> couponsSubCategList;   //WebElement list with all coupons subcategories

        //enum with coupons categories - Text displayed on element and category URL - in real life this occasionally
        //modifies so this enum needs to be updated
    public enum COUPONS_SUBCATEGORIES {
        DICKS_SPORTING("Dick's Sporting Goods Coupons", "https://www.groupon.com/coupons/dicks-sporting-goods"),
        EBAY_COUPONS("eBay Coupons", "https://www.groupon.com/coupons/ebay"),
        AMAZON_COUPONS("Amazon Coupons", "https://www.groupon.com/coupons/amazon"),
        THE_CONTAINER_STORE_COUPONS("The Container Store Coupons", "https://www.groupon.com/coupons/container-store"),
        BEST_BUY_COUPONS("Best Buy Coupons", "https://www.groupon.com/coupons/best-buy"),
        LOWES_COUPONS("Lowe's Coupons", "https://www.groupon.com/coupons/lowes"),
        FOREVER_21_COUPONS("Forever 21 Coupons", "https://www.groupon.com/coupons/forever-21"),
        SAMS_CLUB_COUPONS("Sam's Club Coupons", "https://www.groupon.com/coupons/sams-club");

        private String text;
        private String link;
        COUPONS_SUBCATEGORIES(String string, String link) { this.text = string; this.link = link; }
        public String getText() { return text; }
        public String getLink() { return link;}
    }

        //clicks on coupons subcategory by enum
    public void clickSubcategoryByEnum(COUPONS_SUBCATEGORIES subcategory) {
        for (WebElement elem : couponsSubCategList) {
            if (subcategory.getText().equals(elem.getText())) {
                seleniumUtils.click(elem);
                break;
            }
        }
    }

        //click on coupon subcategory by number (not index)
    public void clickSubcategoryByNumber(int subcategoryNumber) {
        seleniumUtils.click(couponsSubCategList.get(subcategoryNumber-1));
    }
}
