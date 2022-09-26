package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifLoginTest {

    @Test
    public void positiveLoginTest() {
        BrcPage brcPage=new BrcPage();

      //  https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
      //  login butonuna bas
        brcPage.IlkloginButonu.click();
      // test data user email: customer@bluerentalcars.com
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
      // test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
      // login butonuna tıklayın
        brcPage.ikinciLoginButonu.click();
      // Degerleri girildiginde sayfaya basarılı sekilde girilebildigini test et

       String actualUserName= brcPage.kullanıcıProfilIsmı.getText();
       String expectedUserName=ConfigReader.getProperty("brcValidUserName");
        Assert.assertEquals(actualUserName,expectedUserName);


       Driver.closeDriver();



    }
}
