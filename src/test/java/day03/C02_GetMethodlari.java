package day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class C02_GetMethodlari {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp=new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Amazon sayfasina gidiniz
        driver.get("https://amazon.com");
        //Arama kutusunu locate ediniz
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        //Arama kutusunun tagName'inin input oldugunu test ediniz
        String expectedTagName="input";
        String actualTagName= aramaKutusu.getTagName();
        if (actualTagName.equals(expectedTagName)){
            System.out.println("TagName TESTI PASSED : "+actualTagName);
        }else System.out.println("TagName TESTI FAILED"+actualTagName);
        //Arama kutusunu name attributu'nun degerinin field-keyword oldugunu test ediniz
        String expectedAtributuName="field-keywords";
        String actualAtributuName=aramaKutusu.getAttribute("name");
        if (actualAtributuName.equals(expectedAtributuName)){
            System.out.println("Atribute TESTI PASSED");
        }else System.out.println("Atribute TESTI FAILED");

        //arama kutusunun konumunu yazdiriniz
        System.out.println("arama kutusu konum : "+aramaKutusu.getLocation());

        //sayfayi kapatınız
        driver.close();


    }
}
