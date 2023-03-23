package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class C05_NavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp=new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://amazon.com");
        // driver.navigate().to() methodu sayfada ileri geri yapacaksak kullanılır
        // driver.get() methodu gibi bizi istedigimiz Url'e götürür
        driver.navigate().to("https://youtube.com");
        //Tekrar amazon sayfasına dönelim
        Thread.sleep(3000);
        driver.navigate().back();
        // Tekrar youtube'a geri gidelim
        Thread.sleep(3000);
        driver.navigate().forward();
        //youtube sayfasını yenileyelim
        Thread.sleep(3000);
        driver.navigate().refresh();
        //son olarak sayfayı kapatın
        driver.close();
    }
}
