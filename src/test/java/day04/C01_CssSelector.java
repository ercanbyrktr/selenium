package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class C01_CssSelector {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp=new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Verilen web sayfasına gidin https://automationexercise.com/login
        driver.get("https://automationexercise.com/login");
        //locate email textbox
        /*
        cssSelectorde sadece id atribute'u icin # isareti kullanilir
        cssSelectorde sadece class atribute'u icin . isareti kullanılır
         */
        WebElement email = driver.findElement(By.cssSelector("input[placeholder='Email Address']"));
        //Locate password textbox
        WebElement password = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        //Locate signin button
        WebElement Login=driver.findElement(By.cssSelector("input[name='csrfmiddlewaretoken']"));
        //Asagidaki kullanıcı adını ve sifreyi girin ve sign in dugmesini tıklayın
        //username: abcd@gmail.com
        //password: 12345678
        //sayfayi kapatın
        Thread.sleep(3000);
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("12345678");
        //Login.click();
        driver.close();


    }
}
