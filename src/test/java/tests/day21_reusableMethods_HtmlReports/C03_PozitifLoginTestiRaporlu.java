package tests.day21_reusableMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PozitifLoginTestiRaporlu extends TestBaseRapor {
    @Test
    public void positiveLoginTest() {
        extentTest=extentReports.createTest("Pozitif Login","Gecerli username ve sifre ile giris yapabilmeli");

        BrcPage brcPage=new BrcPage();
        //  https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayfaya gidildi");
        //  login butonuna bas
        brcPage.IlkloginButonu.click();
        extentTest.info("login butonuna tıklandı");
        // test data user email: customer@bluerentalcars.com
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("Gecerli email yazıldı");
        // test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("Gecerli password yazıldı");
        // login butonuna tıklayın
        brcPage.ikinciLoginButonu.click();
        extentTest.info("login butonuna basıldı");
        // Degerleri girildiginde sayfaya basarılı sekilde girilebildigini test et

        String actualUserName = brcPage.kullanıcıProfilIsmı.getText();
        String expectedUserName = ConfigReader.getProperty("brcValidUserName");
        Assert.assertEquals(actualUserName, expectedUserName);
        extentTest.pass("kullanıcı basarılı sekilde giris yaptı");

        Driver.closeDriver();
    }
}