package day07;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class C01_Assertions {
    WebDriver driver;

    @Before
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp=new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test1(){
        //https://automationpractice.com/index.php sayfasina gidelim
        driver.get("https://automationexercise.com/");
        //Sign in butonuna basalım
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        // email kutusuna @ isareti olmayan bir mail yazip enter'a
        WebElement name=driver.findElement(By.xpath("(//*[@name='email'][1])"));
        name.sendKeys("abcd.qwe.gmail.com");
        //bastigimizda "Invalid email adress" uyarisi ciktigini test edelim
        //Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid email adress.']")).isDisplayed());
    }
}
