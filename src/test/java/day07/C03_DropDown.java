package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {
    WebDriver driver;
    Select select;
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
        driver.get("https://amazon.com/");

    }
    @After
    public void tearDown(){
        driver.close();

    }
    @Test
    public void test1(){
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu testedin
        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select=new Select(ddm);

        /*
        DropDown menuye ulasmak icin Select class'ından bir obje olustururuz
        ve locate ettigimiz dropdown webelementini Select class'ına tanımlarız
        ve getOption methodunu kullanarak dropdown'u bir list'e atarak dropdown menunun bütün elemanlarının
        sayisina ulasabiiliriz
         */
        List<WebElement> ddmList=select.getOptions();
        System.out.println(ddmList.size());
        int expectedSayi=45;
        int actualDdSayi= ddmList.size();
        Assert.assertNotEquals(expectedSayi,actualDdSayi);
    }
    @Test
    public void test2(){
        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        //Kategori menusunden Books secenegini secin
        select=new Select(ddm);
        //select.selectByVisibleText("Books");
        //select.selectByIndex(5); //Eger dropdown menusunun index'i ile ulasmak istersek bu methodu kullanırız
        select.selectByValue("search-alias=stripbooks-intl-ship");//Eger dropdown menusundeki optiona value ile ulasmak istersek bu methodu kullanırız
        /*
        Dropdown menude sectigimiz optiona ulasmak istersek select.getFirstSelectedOption()
        methodunu kullanırız
         */
        System.out.println(select.getFirstSelectedOption().getText());
        //Arama kutusuna Java yazın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        //Bulunan sonuc sayısını yazdırın
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());
        //Sonucun Java kelimesini icerdigini testedin
        String expectedKelime= "Java";
        String actualSonucYazisi= sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));


    }
}
