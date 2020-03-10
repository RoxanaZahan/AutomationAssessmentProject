package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class SeleniumUtils extends SeleniumDriver {
    WaitMethods waitMethods = new WaitMethods();
    //WebElement testDropDown = driver.findElement(By.id("testingDropdown"));


    public void goToUrl(final String host) {
        driver.get(host);
        driver.manage().window().maximize();
    }

    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
    }

    public void switchToNewTab() {
        openNewTab();
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);
    }

    //for simple WebElement click
    public void  click(WebElement webElement) {
        waitMethods.waitForElementToBeVisible(webElement);
        webElement.click();
    }

    //for WebElements that require a child choice - as filters.
    public void clickAndChoose(WebElement parentFilter, List<WebElement> webElementsList, String childFilterId) {
        waitMethods.waitForElementToBeVisible(parentFilter);
        parentFilter.click();
        for (WebElement filter : webElementsList) {
            if (filter.getAttribute("id").contains(childFilterId)) {
                filter.click();
                break;
            }
        }
    }

    //Dropdown using Select
    public void clickAndChoose(WebElement dropdown, String filter) {
        Select dropdown1 = new Select(dropdown);
        dropdown1.selectByVisibleText(filter);
    }

    //Read txt file line by line
    public String readTxtFile() {
        String text = "";
        try (Scanner scanner = new Scanner(Paths.get(""))) {
            while(scanner.hasNextLine()) {
                String row = scanner.nextLine();
                text = text + row;
            }
        } catch (Exception e) {
        }
        return text;
    }

    public String getRandomString() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        char c = (char) (random.nextInt(26) + 'a');
        return Character.toString(c)+Character.toString(c)+Integer.toString(randomNumber);
    }
}
