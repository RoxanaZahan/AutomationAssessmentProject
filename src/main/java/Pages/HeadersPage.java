package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeadersPage {

    @FindBy(xpath = "//header[@id='ls-header']")
    private WebElement header;
}
