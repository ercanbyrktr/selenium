package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class C02_ManageMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp=new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        //Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //Sayfanin konunmunu ve boyutlarini yazdirin
        System.out.println("Pencere konumu : "+driver.manage().window().getPosition());// Açılan browser'in konumunu verir
        System.out.println("Pencere olculeri : "+driver.manage().window().getSize());// Açılan browser'in olculerinin verir
        //Sayfayi simge durumuna getirin
        driver.manage().window().minimize();// Pencereyi simge durumuna getir
        //Simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();
        //Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Yeni Pencere konumu : "+driver.manage().window().getPosition());
        System.out.println("Yeni Pencere olculeri : "+driver.manage().window().getSize());
        //Sayfayi fullscreen yapin
        Thread.sleep(3000);
        driver.manage().window().fullscreen();
        //Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Fullscreen Pencere konumu : "+driver.manage().window().getPosition());
        System.out.println("Fullscreen Pencere olculeri : "+driver.manage().window().getSize());
        //sayfayi kapatin
        Thread.sleep(3000);
        driver.close();

    }
}
