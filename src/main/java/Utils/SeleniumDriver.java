package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SeleniumDriver {
    public static WebDriver driver;

    @BeforeTest
    public static void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterTest
    public static void afterMethod() {
        WaitMethods.sleep(3);
        driver.quit();
    }
}
