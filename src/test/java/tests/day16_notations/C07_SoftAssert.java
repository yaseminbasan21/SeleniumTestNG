package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C07_SoftAssert extends TestBase {

    @Test
    public void test01(){

        //1-https://zero.webappsecurity.com/ adresine gidin
        driver.get("https://zero.webappsecurity.com/");
        //2-Sign in butonuna basın
        driver.findElement(By.id("signin_button")).click();
        //3-Login kutusuna "username" yazın
        WebElement loginKutusu= driver.findElement(By.xpath("//input[@name='user_login']"));
        loginKutusu.sendKeys("username");
        //4-Password kutusuna "password" yazın
        WebElement passKutusu= driver.findElement(By.xpath("//input[@id='user_password']"));
        passKutusu.sendKeys("password");
        //5-Sign in tusuna basın
        driver.findElement(By.xpath("//input[@name='submit']"));
        //6-Online banking menusu icinde Pay Bills sayfasına gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']"));
        driver.findElement(By.xpath("//span[@id='pay_bills_link"));
        //7-"Purchase Foreign Currency" tusuna basın
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency")).click();
        //8-"Currency" drop down menusunden Eurozone'u secin
        WebElement ddo=driver.findElement(By.xpath("//select[@name='currency']"));
        Select select=new Select(ddo);
        select.selectByVisibleText("Eurozone (euro)");
        //9-soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String secilenOption=select.getFirstSelectedOption().getText();
        String expectedOption="Eurozone (Euro)";
        softAssert.assertEquals(secilenOption,expectedOption,"secilen option uygun degil ");
        //10-soft assert kullanarak Dropdown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar),"Canada" (dollar)
       // List<WebElement>optionList=select.getOptions();





    }


}
