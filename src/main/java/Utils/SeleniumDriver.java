package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Iterator;
import java.util.Set;

public class SeleniumDriver {
    public static WebDriver driver;

    @BeforeMethod
    public static void initialiseDriver() {
        String path = System.getProperty("user.dir");
        //System.out.println(path); //use it if unsure of your local path
        //path+"/src/main/resources/chromedriver/chromedriver"
        //C:\Program Files\Automation Projects\AutomationPractice\src\main\resources\chromedriver\chromedriver.exe
        ///Users/roxana.zahan/AutomationProject/AutomationAssessmentProject/src/main/resources/chromedriver/chromedriver
        System.setProperty("webdriver.chrome.driver","/Users/roxana.zahan/AutomationProject/AutomationAssessmentProject/src/main/resources/chromedriver/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public static void afterMethod() {
        WaitMethods.sleep(3);
        driver.quit();
    }
}
