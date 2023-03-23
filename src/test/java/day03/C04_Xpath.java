package day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class C04_Xpath {
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
        //https://automationexercise.com/ adresine gidiniz
        driver.get("https://automationexercise.com/");
        //test cases butonuna basin
        Thread.sleep(3000);
        //driver.findElement(By.xpath("//*[text()='Test Cases']")).click();
        driver.findElement(By.xpath("//*[text()='Test Cases']")).click();//x path'de text ile locate alma
        /*
         locate alirken sadece text kullanılacaksa //*[text()='Test Cases'] bu formatta kullanılır
         Attribute kullanıcaksak //*[@class='fa fa-home'] bu format kullanılır
         */
        //Home butonun gorunur oldugunu test edin
        WebElement homeButton = driver.findElement(By.xpath("//*[@class='fa fa-home']"));
        if (homeButton.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");
        //Home butonuna basin
        homeButton.click();
        //"Test Cases" yazisinin gorunur oldugunu test edin
        WebElement TestCases = driver.findElement(By.xpath("//h2"));
        if (TestCases.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");
        //sayfayı kapatınız
        driver.close();

    }
}
