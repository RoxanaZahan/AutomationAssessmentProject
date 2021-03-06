package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.nio.file.Paths;
import java.util.*;

public class SeleniumUtils extends SeleniumDriver {
    WaitMethods waitMethods = new WaitMethods();

    public void goToUrl(final String host) {
        driver.get(host);
        driver.manage().window().maximize();
        try{
            WebElement noTx = driver.findElement(By.xpath("//*[@id='nothx']"));
            if(waitMethods.isElementDisplayed(noTx, 5)) {
                noTx.click();
            }
        }
        catch (Exception e){

        }

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

    //for simple WebElement click - waits for element to be clickable and the clicks on it
    public void  click(WebElement webElement) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitMethods.waitForElementToBeClickable(webElement);
        webElement.click();
    }

    //for WebElements that require a child choice - as filters.
    public void clickAndChoose(WebElement parentFilter, List<WebElement> webElementsList, String childFilterId) {
        waitMethods.waitForElementToBeClickable(parentFilter);
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

    //Read txt file line by line and search for the given key word
    public String searchInTxtFile(String string) {
        String text = "";
        try (Scanner scanner = new Scanner(Paths.get("/Users/roxana.zahan/AutomationProject/AutomationAssessmentProject/src/test/LoginRegisterData"))) {
            while(scanner.hasNextLine()) {
                String row = scanner.nextLine();
                text = row;
                if (text.contains(string)) {
                    break;
                }
            }
        } catch (Exception e) {
        }
        return text;
    }

    public String getvalue(String key) {
        String text = searchInTxtFile(key);
        String[] array = text.split(": ");
        return array[1];
    }

    public String getRandomString() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        char c = (char) (random.nextInt(26) + 'a');
        return Character.toString(c)+Character.toString(c)+Integer.toString(randomNumber);
    }

    public void clickElementViaActions(WebElement element){
        waitMethods.waitForElementToBeClickable(element);
        Actions actions = new Actions(driver);
        actions.click(element).perform();
    }

}
