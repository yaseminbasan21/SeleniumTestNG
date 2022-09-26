package tests.day16_notations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_DependsOnMethods  {

    /*
    DependsOnMethods test method'larının calısma sıralamasına karısmaz
    Sadece baglı olan test,baglandıgı testin sonucuna bakar
    baglandıgı test PASSED olmazsa, baglanan test hic calısmaz(ıgnore)
     */




    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }


    @Test
    public void test01(){
        //amazon anasayfaya gidelim

        driver.get("https://www.amazon.com");
    }

    @Test(dependsOnMethods = "test01")
    public void test02(){
        //Nutella aratalım
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
    }

    @Test(dependsOnMethods ="test02")
    public void test03(){
        //Sonuc yazısının Nutella icerdigini test edelim
        WebElement sonucYazıElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYazıElementi.getText().contains("Nutella"));
    }
    @Test(groups = {"grup1","grup2"})
    public void test04(){
        System.out.println("bak bu calıstı");
    }





}
