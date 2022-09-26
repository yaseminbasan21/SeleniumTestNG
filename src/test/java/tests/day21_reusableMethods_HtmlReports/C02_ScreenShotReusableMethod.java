package tests.day21_reusableMethods_HtmlReports;

import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C02_ScreenShotReusableMethod {

    @Test
    public void test01() throws IOException {
        //amazon sayfasına gidip fotografını cekelim
        Driver.getDriver().get("https:/www.amazon.com");
        ReusableMethods.getScreenshot("amazon");
        Driver.closeDriver();
    }
}
