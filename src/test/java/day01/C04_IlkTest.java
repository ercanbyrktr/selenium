package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class C04_IlkTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp=new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        /*
        1- Amazon sayfasına gidiniz
        2- Başlığın "Amazon" içerdigini test ediniz
        3- Url'nin amazon içerdigini tes edin
        4- Sonra da sayfayı kapatınız
         */

        //1- Amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        //2- Başlığın "Amazon" içerdigini test ediniz
        String actualTitle = driver.getTitle();
        String istenenKelime = "Amazon";
        if (actualTitle.contains(istenenKelime)){
            System.out.println("Title testi PASSED");
        }else System.out.println("Title testi FAILED");
        //3- Url'nin Amazon içerdigini tes edin
        String actualUrl = driver.getCurrentUrl();
        String arananKelime = "Amazon";
        if (actualTitle.contains(arananKelime)){
            System.out.println("Url testi PASSED");
        }else System.out.println("Url testi FAILED");
        //4- Sonra da sayfayı kapatınız

        driver.close();

    }
}
