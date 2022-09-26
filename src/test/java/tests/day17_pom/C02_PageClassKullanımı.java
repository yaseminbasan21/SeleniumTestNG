package tests.day17_pom;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanımı {
    @Test
    public void test01(){

        AmazonPage amazonPage=new AmazonPage();

        //amazon'a gidelim
        Driver.getDriver().get("https://www.amazon.com");

        //nutella aratalım
        amazonPage.aramakutusu.sendKeys("nutella" + Keys.ENTER);

        //sonuc yazısının nutella icerdigini test edelim
       String actualSonuc= amazonPage.aramaSonucElementi.getText();
       String expectedSonuc="nutella";
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));
    }
}
