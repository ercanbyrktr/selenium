package day09;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class C02_WindowHandle {
    WebDriver driver;
    @Before
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp=new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test1(){
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        String amazonWindowHandle=driver.getWindowHandle();
        /*
        eger bize verilen task'te sayfalar arası gecis varsa her driver.get() methodundan sonra
        driver'in window handle degerini string bir degiskene atarız
        sonrasında farklı bir sayfaya ya da sekmeye gittikten sonra tekrar ilk sayfaya dönmemiz istenirse
        string degiskene atadıgımız window handle degerleriyle sayfalar arası gecis yapabiliriz
         */
        //Url'nin amazon icerdigini test edelim
        String expectedUrl="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        //yeni bir pencere acıp bestbuy anasayfasına gidelim(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);//Yeni bir pencere acmak icin bu methodu kullanırız
        driver.get("https://www.bestbuy.com");
        String bestbuyWindowHandle= driver.getWindowHandle();
        //title'in BestBuy icerdigini test edelim
        String expectedTitle="Best Buy";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //ilk sayfaya donup sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);//sayfalar arası gecis icin bu method kullanılır
        WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("java", Keys.ENTER);
        //Arama sonuclarının java icerdigini test edelim
        WebElement aramaSonucu=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananKelime="java";
        String actualSonuc=aramaSonucu.getText();
        Assert.assertTrue(actualSonuc.contains(arananKelime));
        //yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestbuyWindowHandle);
        //logonun görünürlügünü test edelim ==> görünürlük .isDisplayed ile kontrol edilir
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed());

    }
}
