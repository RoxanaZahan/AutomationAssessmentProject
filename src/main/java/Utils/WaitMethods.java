package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static java.util.concurrent.TimeUnit.SECONDS;

public class WaitMethods extends SeleniumDriver{

    public static void sleep(final int sleepSeconds) {
        try {
            Thread.sleep(sleepSeconds * 1000);
        }
        catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForElementToBeClickableByPath() {
        final WebElement ha = driver.findElement(By.xpath("//button[@id='buttonwithclass']"));
        ha.click();
    }


    public WebElement waitForElementToBeClickable(final WebElement element) {
        final Wait<WebDriver> wait = new FluentWait<>(SeleniumDriver.driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(Exception.class);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isElementDisplayed(final WebElement element, final int timeout) {
        final long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - startTime) < SECONDS.toMillis(timeout)) {
            try {
                return element.isDisplayed();
            }
            catch (final Exception ignored) {
                WaitMethods.sleep(1);
            }
        }
        return false;
    }

    public WebElement waitForElement(final WebElement webElement) {
        final WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public boolean isTextOfElementVisible(final WebElement webElement, String expectedText ) {
        final WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(webElement)).getText().contains(expectedText);
    }

    public WebElement waitInAWhileLoop(WebElement element){
        final WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement myStuffElement =  wait.until(ExpectedConditions.visibilityOf(element));
        int safetyMeasure = 30;
        while(true){
                try{
                    if(!myStuffElement.getText().contains("My Stuff")){
                        try {
                            myStuffElement = wait.until(ExpectedConditions.visibilityOf(element));
                        }catch (Exception ignored){}
                }  else {
                        break;
                    }
                }catch (Exception ignored){}
                safetyMeasure--;
                if(safetyMeasure == 0){
                    break;
                }
            }
        return myStuffElement;
    }

}
