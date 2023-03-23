package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class C05_Locators {
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
        driver.get("https://amazon.com");
        //Amazonda nutella aratiniz
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);  //id unique oldugu icin sorunsuz calisti
        //WebElement aramaKutusu = driver.findElement(By.name("field-keywords"));
        //aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);  //id unique oldugu icin sorunsuz calisti
        //WebElement aramaKutusu = driver.findElement(By.className("nav-search-field "));
        /*
        Bu locatar calismadi
        Locatar alirken gozumuzden kacan detaylar olabilir
        aldigimiz bir locatar calismazsa alternatif locatarlar denemeliyiz
         */

        driver.findElement(By.partialLinkText("oducts on Amazon")).click();// a tag'ındaki link isminden istedigimiz bir parcayla locate edebiliriz
       // driver.findElement(By.linkText("Sell products on Amazon")).click();

    }
}
