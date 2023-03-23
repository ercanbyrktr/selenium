package day08;

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
import java.util.ArrayList;
import java.util.List;

public class C04_iframe {
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
        //https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        //youtube videosunu calistiriniz
        //WebElement youtubeFrame= driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        //driver.switchTo().frame(youtubeFrame);
        //driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();
        List<WebElement>iframeList= new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();
        /*
        Bir web sitesinde bir video(youtube vb) varsa <iframe> tag'ı içerisindeyse bu videoyu direk
        locate edip calistirmak dinamik olmaz cunku link degişebilir  ve locate' imiz çalışmaz
        Bunun için bütün frame'leri bir array liste atıp index ile frame'i seçip sonrasında play tusunu
        locate edip calıştırabiliriz
         */
    }
}
