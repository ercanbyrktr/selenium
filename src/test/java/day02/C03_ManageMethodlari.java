package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class C03_ManageMethodlari {
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
        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanin konumu : "+driver.manage().window().getPosition());
        System.out.println("Sayfanin boyutlari : "+driver.manage().window().getSize());
        //Sayfanin konumunu ve boutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(20,20));// Sayfanin konumunu istedigimiz sekilde ayarlar
        driver.manage().window().setSize(new Dimension(600,300));//Sayfanin olculerini istedigimiz sekilde ayarlar
        //Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        System.out.println("Sayfanin Yeni konumu : "+driver.manage().window().getPosition());
        System.out.println("Sayfanin Yeni boyutlari : "+driver.manage().window().getSize());
        //8. sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
