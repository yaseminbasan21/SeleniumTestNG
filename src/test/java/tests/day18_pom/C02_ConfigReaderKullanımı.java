package tests.day18_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanımı {

    @Test
    public void test01(){
        FacebookPage facebookPage=new FacebookPage();

        //facebook anasayfaya gidin
           Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        //cıkarsa cookies kabul edin
        //kullanıcı mail kutusuna yanlıs bir isim yazdırın
        facebookPage.mailKutusu.sendKeys(ConfigReader.getProperty("fbWrongUsername"));

        //kullanıcı sifre kutusuna yanlıs bir password yazdırın
         facebookPage.sifreKutusu.sendKeys(ConfigReader.getProperty("fbWrongPassword"));

        //login butonuna basın
          facebookPage.loginKutusu.click();

        //giris yapılamadıgını test edin
       Assert.assertTrue(facebookPage.girilemediYazıElementi.isDisplayed());

        //sayfayı kapatın
        Driver.closeDriver();
    }




}
