package tests.day19_smokeTest;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelPage;
import utilities.ConfigReader;
import utilities.Driver;

public class SoruCozumu2 {

    @Test
    public void createHotel(){
        HotelPage hotelPage=new HotelPage();
        //https://www.hotelmycamp.com adresine git
        //Username textbox ve password metin kutularını locate edin ve asagıdaki verileri girin
        //Username:manager
        //Password:Manager1!
        //login butonuna tıklayın
        //Hotel Management/Hotel List menusunden ADD HOTEL butonuna tıklayın
        //Acılan sayfadaki tum metin kutularını istediginiz verileri girin
        //Save butonuna tıklayın
        //"Hotel was inserted successfully" textinin gorundugunu test edin
        //OK butonuna tıklayın

        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
        hotelPage.ılkLoginButonu.click();
        hotelPage.username.sendKeys(ConfigReader.getProperty("hotelUsername"));
        hotelPage.password.sendKeys(ConfigReader.getProperty("hotelPassword"));
        hotelPage.ikinciLoginButonu.click();
        hotelPage.addUser.click();





    }
}
