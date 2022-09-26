package tests.day22_crossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegatifLoginDataProvider {
    @DataProvider
    public static Object[][] kullanıcıListesi() {

        Object[][] kullanıcıBilgileri={{"firuze@nehaber.com","54678"},
                                        {"murat@benbuisibilirim.com","65487"},
                                        {"ilyas@hollandadanselam.com","85967"}};
        return kullanıcıBilgileri;
    }

    @Test(dataProvider="kullanıcıListesi")
    public void yanlısSifre(String userMail,String password) throws InterruptedException {
       BrcPage brcPage=new BrcPage();

        //  https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //  login butonuna bas
        Thread.sleep(2000);
        brcPage.IlkloginButonu.click();
        // test data user email: dataprovider'dan alalım
        brcPage.emailTextBox.sendKeys(userMail);
        // test data password : dataprovider'dan alalım
        brcPage.passwordTextBox.sendKeys(password);
        // login butonuna tıklayın
        brcPage.ikinciLoginButonu.click();
        // Degerleri girildiginde sayfaya basarılı sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());

        Driver.closeDriver();

    }
}
