package day09;

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

import java.nio.file.WatchKey;
import java.time.Duration;

public class C01_Iframe {
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
    public void test1() throws InterruptedException {
        //https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        //"An IFrame containing..." textinin erisilebilir oldugunu test edin ve konsolda yazdırın
        WebElement iframeYazisi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());
        System.out.println(iframeYazisi.getText());
        //Text Box'a "Merhaba Dunya!" yazin
        WebElement textBox=driver.findElement(By.id("mce_0_ifr"));//Frame'e gecis yapmadan once orayı id ile locate ederiz
        driver.switchTo().frame(textBox);//Locate ettigimiz frame geçmek icin bu methodu kullanırız
        WebElement textBoxFrame=driver.findElement(By.xpath("//p"));
        Thread.sleep(3000);
        textBoxFrame.clear();//Clear methodu text box'ın icini temizler
        Thread.sleep(3000);
        textBoxFrame.sendKeys("Merhaba Dunya!");
        //Text Box'in altında bulunan "Elemental Selenium" linkini textinin gorunur oldugunu
        // dogrulayın ve konsolda yazdırın
        driver.switchTo().defaultContent();// Iframe'den cıkıp ana sayfaya gecmek icin bu method kullanılır
        WebElement elemental=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elemental.isDisplayed());
        System.out.println(elemental.getText());
    }
}
