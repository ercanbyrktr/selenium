package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class C02_Allerts {
    /*
    Bir web sitesine girdigimizde karşımıza bir uyarı mesajı yada bir butona tıkladıgımızda bir uyarı(alert)
    cıkabilir. Eger bu uyarıya incele(mouse sag tık-inspect) yapabiliyorsak bu tür alertlere HTML alert denir
    ve istedigimiz locate'i alabiliriz. Ama gelen uyarı kutusuna müdahale(sag tık-incele) edemiyorsak bu tür
    alert'lere js alert denir. js alert'lere müdahale edebilmek icin
        - tamam yada ok icin driver.switchTo().alert().accept() kullanılır
        -iptal icin driver.switchTo().alert().dismiss()methodu kullanılır
        -Alert icindeki mesajı almak icin driver.switchTo().alert().getText() kullanılır
        -Alert bizden bir metin istiyorsa driver.switchTo().alert().sendKeys("")kullanılır
     */
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
        //driver.close();
    }
    @Test
    public void test1(){
       //https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //Bir method olusturun: AcceptAlert
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //"You successfully clicked an alert" oldugunu test edin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        WebElement mesaj=driver.findElement(By.xpath("//*[@id='result']"));
        String actualMesaj= mesaj.getText();
        String expectedMesaj="You successfully clicked an alert";
        Assert.assertEquals(expectedMesaj,actualMesaj);
    }
    @Test
    public void test2() throws InterruptedException {
        //2. butona tıklayın, uyarıdaki Cancel(iptal) butonuna tıklayın ve result mesajının
        //"successfully" icermedigini test edin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        //Alert uzerindeki mesajı yazdırın
        System.out.println("2. butonun alert mesajı :"+driver.switchTo().alert().getText());
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        String actualMesaj=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedMesaj="successfully";
        Assert.assertFalse(actualMesaj.contains(expectedMesaj));
    }
    @Test
    public void test3() throws InterruptedException {
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendigini dogrulayın
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        //Alert uzerindeki mesajı yazdırın
        Thread.sleep(3000);
        System.out.println("3. butonun alert mesaji : "+driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("selenyum");
        driver.switchTo().alert().accept();
        String actualMesaj=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedMesaj="selenyum";
        Assert.assertTrue(actualMesaj.contains(expectedMesaj));
    }
}
