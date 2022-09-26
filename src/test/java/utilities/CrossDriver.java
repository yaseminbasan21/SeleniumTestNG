package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CrossDriver {
    private  CrossDriver(){

    }

    static WebDriver driver;

    public static WebDriver getDriver(String browser){
        browser= browser==null ? ConfigReader.getProperty("browser"):browser;

        if (driver==null){ //her seferinde yeni bir sayfa acılsın istemedigimiz icin sadece en basta hic acılmamıs driver'ı olusturuyoruz
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(); //getDriver() method'u her seferinde driver'a yeni bir driver olusturur,yeni bir browser

            }

        }
        return driver; //eger daha once chromeDriver degeri olusturulmussa yukarısı calısmıcak, var olan driver geri donucek
    }

    public static void closeDriver(){
        if (driver!=null){  //driver'a deger atanmıs
            driver.close(); //atanmıssa kapat
            driver=null;
        }

    }
}
