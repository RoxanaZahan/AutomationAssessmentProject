package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class SeleniumDriver {
    public static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public static void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver/chromedriver");
        driver = new ChromeDriver();
        System.out.println("Driver initialised");
    }

    @AfterClass(alwaysRun = true)
    public static void closeBrowser() {
        WaitMethods.sleep(3);
        driver.quit();
        System.out.println("Browser closed");
    }
}
