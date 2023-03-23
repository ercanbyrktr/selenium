package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandle {
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
    public void test1() throws InterruptedException {
        //https://the-internet.harekuapp.com/windows adresine gidin
        driver.get("https://the-internet.herokuapp.com/windows");
        //Sayfadaki textin "Opening a new window" oldugunu dogrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Opening a new window']")).isDisplayed());
        //sayfa baslıgının(title)"The Internet" oldugunun dogrulayın
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
        Thread.sleep(2000);
        //Click here butonuna basın
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        /*
        Bir web sitesine gittiginizde bir webelementi tıkladıgınızda yeni bir sekme yada pencere
        açılırsa bu yeni açılan sekmenin handle degerini bulabilmel için driver.getWindowHandles()
        methodunu bir ArrayList'e atıp bütün sayfaların listesine ulasabilirim. İlk actıgım pencerenin
        index'i 0 'dır. İkinci açılan sekmenin index'i 1'dir. Ve ikinci acılan pencerede sekmede islem
        yapabilmek icin driver.swicthTo().window(ListAdı.get(1)) methodunu kullanırız
         */
        List<String>windowList=new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Window Handle Degerleri = "+windowList);
        driver.switchTo().window(windowList.get(1));
        //Acılan yeni pencerenin sayfa baslıgının (title)"New Window" oldugunu dogrulayın
        Assert.assertEquals(driver.getTitle(),"New Window");
        //sayfadaki text'in "New Window" oldugunu dogrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
        //Bir onceki pencereye geri dondukten sonra sayfa baslıgının "The Internet" oldugunu dogrulayın
        Thread.sleep(2000);
        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals("The Internet",driver.getTitle());

    }
}
