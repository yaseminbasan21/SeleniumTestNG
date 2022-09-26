package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {

    @Test
    public void test01(){
        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //nutella icin arama yapalım
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramakutusu.sendKeys("Nutella" + Keys.ENTER);
        //sonucların nutella icerdigini test edelim
        String actualKelime=amazonPage.aramaSonucElementi.getText();
        String expectedKelime="Nutella";
        Assert.assertTrue(actualKelime.contains(expectedKelime));

        //sayfayı kapatalım
        Driver.closeDriver();
    }

    @DataProvider
    public static Object[][] AranacakKelimeler() {

        Object[][] arananKelimeArrayi={{"Nutella"},{"Java"},{"cigdem"},{"Netherlands"}};
        return arananKelimeArrayi;
    }

    @Test(dataProvider = "AranacakKelimeler")
    //arayacagımız kelimeleri bir liste gibi tutup
    //bana yollayacak bir veri saglayıcısı olusturacagız
    public void dataProviderTesti(String arananKelime){
        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //Nutella, Java, cigdem ve Netherlands icin arama yapalım
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramakutusu.sendKeys(arananKelime + Keys.ENTER);

        //sonucların aradıgımız kelime icerdigini test edelim
        String actualKelime=amazonPage.aramaSonucElementi.getText();
        String expectedKelime=arananKelime;
        Assert.assertTrue(actualKelime.contains(expectedKelime));

        //sayfayı kapatalım
        Driver.closeDriver();
    }
}
