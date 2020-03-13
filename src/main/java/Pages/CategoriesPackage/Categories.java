package Pages.CategoriesPackage;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Categories {
    HashMap<String, List<String>> categoriesSubcategories;
    Local local;
    SeleniumUtils seleniumUtils = new SeleniumUtils();

    public Categories() {
        this.categoriesSubcategories = new HashMap<String, List<String>>();
        local = new Local();
        this.categoriesSubcategories.put("Local", local.getLocalSubcategoriesList());
    }

    public WebElement getCategoryElement(String category, String subCategory) {
        WebElement element = null;
        for (Map.Entry<String, List<String>> entry : this.categoriesSubcategories.entrySet()) {
            if(entry.getKey() == category) {
                for(String subCat : entry.getValue()) {
                    if(subCat == subCategory) {
                        for (int i = 0; i<local.getLocalSubcategoriesElementsList().size(); i++) {
                            if (local.getLocalSubcategoriesElementsList().get(i).getText().contains(subCategory)) {
                                element = local.getLocalSubcategoriesElementsList().get(i);
                            }
                        }
                    }
                }
            }
        }
        return element;
    }

    public void chooseAnClickCategoryAndSubCategory(String category, String subCategory) {
        seleniumUtils.click(getCategoryElement(category,subCategory));
    }
}
