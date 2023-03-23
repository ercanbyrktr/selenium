package day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C03_TekrarTesti {
    public static void main(String[] args) {
        System.setProperty("webdriver.choreme.driver","src/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp=new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //web sayfasina gidin
        driver.get("https://amazon.com");
        //Serach(ara) "city bike"
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("city bike", Keys.ENTER);
        //Amazon'da goruntulenen ilgili sonuclarin sayisini yazdirin
        List<WebElement> aramaSonucu = driver.findElements(By.className("sg-col-inner"));
        String sonucYazisi=aramaSonucu.get(0).getText();
        System.out.println(sonucYazisi);
        //Sadece sonuc sayisini yazdiriniz
        String [] sonucYazisiE=sonucYazisi.split(" ");
        System.out.println("city bike arama sonucu : "+sonucYazisiE[2]);

        // sonuc sayisini lambda ile yazdiriniz
        Arrays.stream(sonucYazisi.split(" ")).limit(3).skip(2).forEach(System.out::println);

        //Sonra karsimiza cikan ilk sonucun resmine tıklayın
        List<WebElement>ilkResim=driver.findElements(By.className("s-image"));
        WebElement ilkResimWE=ilkResim.get(0);
        ilkResimWE.click();
        //sayfayi kapatınız
        driver.close();


    }
}
