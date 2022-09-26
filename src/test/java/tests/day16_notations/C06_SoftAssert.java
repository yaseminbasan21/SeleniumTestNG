package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_SoftAssert extends TestBase {
    @Test(groups = "grup2")
    public void test01(){


        /*
        Softassertion baslangıc ve bitis satırları arasındaki
        tum assertion'ları yapıp
        bitis satırına geldiginde bize buldugu tum hataları rapor eder

         */

        //softassert baslangıcı obje olusturmaktır
        SoftAssert softAssert=new SoftAssert();



        //1-amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2-title'ın Amazon icerdigini test edin
        String expectedTitle="amazon";
        String actualTitle=driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"title amazon icermiyor"); //Assert class'dır , static'tir , bize method'lar getirir

        //3-Arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled());

        //4-arama kutusuna nutella yazdırıp aratın
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //5-arama yapıldıgını test edin
        WebElement sonucYazıElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYazıElementi.isDisplayed());

        //6-arama sonucunun Nutella icerdigini test edin
        softAssert.assertTrue(sonucYazıElementi.getText().contains("kutella"),"sonuc yazısı kutella icermiyor");


        //softassert'e bitis satırını soylemek icin assertAll() kullanılır
        //bu satır yazılmazsa assertion gorevi yapılmamıs olur
        softAssert.assertAll();


        /*
        Softassert'in hata bulsa bile calısmaya devam etme ozelligi
        assertAll()'a kadardır.
        Eger assertAll()'da failed rapor edilirse calısma durur
        ve class'ın kalan kısmı calıstırılmaz
        (Yani assertAll hardAssert'teki her bir assert gibidir,hatayı yakalarsa calısma durur)
         */

        System.out.println("assertion'larda fail olan olursa burası calısmaz");





    }




}
