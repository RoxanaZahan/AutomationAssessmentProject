package Utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "search-keys")
    public static Object[][] dataProviderMethod() {
        return new Object[][] {
                {"pizza"}, {"coffee"}, {"amc"}
        };
    }
}
