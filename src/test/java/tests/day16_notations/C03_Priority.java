package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_Priority extends TestBase {

    /*
        TestNG test method'larını isim sırasına gore calıstırır
        eger isim sıralamasının dısında bir sıralama ile calısmasını isterseniz
        o zaman test method'larına oncelik (priority) tanımlayabiliriz

        priority kucukten buyuge gore calısır
        eger bir test methodu'na priority degeri atanmamıssa
        default olarak priority=0 olarak kabul edilir
     */



    @Test(priority = -5)
    public void amazonTesti(){

        driver.get("https://www.amazon.com");
    }

    @Test(priority = -2)
    public void test02(){
        driver.get("https://www.bestbuy.com");
    }

    @Test(groups = "grup1")
    public void techproedTesti(){
        driver.get("https://techproeducation.com");
    }




}
