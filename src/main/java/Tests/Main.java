package Tests;

import Utils.SeleniumDriver;
import Utils.SeleniumUtils;

public class Main {
    public static void main(String[] args) {
        SeleniumUtils seleniumUtils = new SeleniumUtils();

        System.out.println(seleniumUtils.getvalue("email"));
    }
}
