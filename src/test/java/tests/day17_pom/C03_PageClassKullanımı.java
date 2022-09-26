package tests.day17_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_PageClassKullanımı {

    @Test
    public void test01() {
        FacebookPage facebookPage=new FacebookPage();

        //facebook anasayfaya gidin
        Driver.getDriver().get("https://www.facebook.com");
        //cıkarsa cookies kabul edin
        //kullanıcı mail kutusuna rastgele bir isim yazdırın
        Faker faker=new Faker();
        facebookPage.mailKutusu.sendKeys(faker.internet().emailAddress());
        //kullanıcı sifre kutusuna rastgele bir password yazdırın
        facebookPage.mailKutusu.sendKeys(faker.internet().password());
        //login butonuna basın
        facebookPage.loginKutusu.click();
        //giris yapılamadıgını test edin
        Assert.assertTrue(facebookPage.girilemediYazıElementi.isDisplayed());

        Driver.closeDriver();

    }
}
