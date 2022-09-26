package tests.day21_reusableMethods_HtmlReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_WindowHandleReusableMethods {
    @Test
    public void test01(){
        //https://the-internet.herokuapp.com/windows adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWidowandle=Driver.getDriver().getWindowHandle();
        //Click here butonuna basın
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Set<String> windowHandleSeti=Driver.getDriver().getWindowHandles();
       
        String ikinciWindowHandle="";
        for (String each:windowHandleSeti
             ) {
            if (!each.equals(ilkSayfaWidowandle)){
                ikinciWindowHandle=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciWindowHandle);
        System.out.println(Driver.getDriver().getTitle());
        //acılan yeni tab'ın title'ının "New Window oldugunu test edin"
        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        Driver.closeDriver();
    }

    @Test
    public void test02(){
        //https://the-internet.herokuapp.com/windows adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        //Click here butonuna basın
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        //acılan yeni tab'ın title'ının "New Window oldugunu test edin"
        ReusableMethods.switchToWindow("New Window");

        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        Driver.closeDriver();
    }
}
