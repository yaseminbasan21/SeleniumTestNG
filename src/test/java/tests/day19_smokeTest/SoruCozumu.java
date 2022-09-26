package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelPage;
import utilities.ConfigReader;
import utilities.Driver;

public class SoruCozumu {

    @Test
    public void pozitifTest(){

        HotelPage hotelPage=new HotelPage();

        //https://www.hotelmycamp.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));

        //login butonuna bas
        hotelPage.ılkLoginButonu.click();
        //test data username:manager
        hotelPage.username.sendKeys(ConfigReader.getProperty("hotelUsername"));
        //test data password:Manager1!
        hotelPage.password.sendKeys(ConfigReader.getProperty("hotelPassword"));
        hotelPage.ikinciLoginButonu.click();
        //Degerleri girildiginde sayfaya basarılı sekilde girilebildigini test et
        Assert.assertTrue(hotelPage.addUser.isDisplayed());

         Driver.closeDriver();


    }

    @Test
    public void negatifTest(){
        //yanlıs sifre
        HotelPage hotelPage=new HotelPage();

        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
        hotelPage.ılkLoginButonu.click();
        hotelPage.username.sendKeys(ConfigReader.getProperty("hotelUsername"));
        hotelPage.password.sendKeys(ConfigReader.getProperty("hotelWrongPassword"));
        hotelPage.ikinciLoginButonu.click();
        Assert.assertTrue(hotelPage.ikinciLoginButonu.isDisplayed());

        Driver.closeDriver();

    }




}
