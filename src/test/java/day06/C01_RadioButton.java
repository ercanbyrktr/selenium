package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class C01_RadioButton {
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

        driver.close();
    }

    @Test
    public void test1(){

        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //Cookies'i kabul edin
        //"Create an Account" button'una basın
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
        //"radio buttons" elementlerini locate edin
        WebElement femaleButton=driver.findElement(By.xpath("//input[@value='1']"));
        WebElement maleButton=driver.findElement(By.xpath("//input[@value='2']"));
        WebElement customButton=driver.findElement(By.xpath("//input[@value='-1']"));
        //secili degilse cinsiyet butonundan size uygun olani secin
        if (!maleButton.isSelected()){
            maleButton.click();
        }
    }
}
