package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class C02_DriverMethodlari {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp=new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        // Amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        //Kaynak kodların içinde "Gateway" kelimesini oldugunu test edin
        //System.out.println(driver.getPageSource()); // Sayfadaki kaynak kodlarını verir
        String istenenKelime = "Gateway";
        if (driver.getPageSource().contains(istenenKelime)){
            System.out.println("PageSource testi PASSED");
        }else System.out.println("PageSource testi FAILED");

        driver.close(); // sayfayı kapatır
        //driver.quit(); // birden fazla sayfa varsa hepsini kapatır

    }
}
