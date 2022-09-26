package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegatifLoginTest {
    BrcPage brcPage=new BrcPage();

    @Test
    public void yanlısSifre() throws InterruptedException {
        //  https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //  login butonuna bas
        Thread.sleep(2000);
        brcPage.IlkloginButonu.click();
        // test data user email: customer@bluerentalcars.com
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        // test data password : 54321
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        // login butonuna tıklayın
        brcPage.ikinciLoginButonu.click();
        // Degerleri girildiginde sayfaya basarılı sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());

        Driver.closeDriver();

    }

    //bu class'ta 2 test method'u daha olusturun
    //biri yanlısKullanıcı

    @Test
    public void yanlısKullanıcı(){
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        brcPage.IlkloginButonu.click();
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        brcPage.ikinciLoginButonu.click();
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());

        Driver.closeDriver();
    }

    //digeri de yanlıs sıfre ve kullanıcı adı
    @Test
    public void yanlısKullVeSifre(){
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        brcPage.IlkloginButonu.click();
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        brcPage.ikinciLoginButonu.click();
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());

        Driver.closeDriver();
    }
    //ders notlarındaki otelle ilgili olanları da yapın
}
