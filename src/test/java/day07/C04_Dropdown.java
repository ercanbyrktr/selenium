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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_Dropdown {
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
    public void test(){
        //https://the-internet.herokuapp.com/dropdown adresine gidin
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //Index kullanarak Secenek 1'i (Option 1) secin ve yazdırın
        WebElement ddmList=driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select =new Select(ddmList);
        select.selectByIndex(1);
        //ddmList.sendKeys("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("==========================================");
        //Value kullanarak Secenek 2'yi (Option 2) secin ve yazdirin
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("==========================================");
        //Visiable Text (Gorunen metin) kullanarak Secenek 1'i (Option 1) secin ve yazdirin
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("==========================================");
        //Tum dropdown degerlerini(value) yazdirin
        List<WebElement> tumDdm=select.getOptions();
        //tumDdm.forEach(t-> System.out.println(t.getText()));
        for (WebElement w:tumDdm) {
            System.out.println(w.getText());
        }
        //Dropdown'un boyutunu bulun, dropdown'da 4 öge varsa konsolda True,
        // degilse False yazdırın
        System.out.println("DropDown Boyutu :"+tumDdm.size());
        if (tumDdm.size()==4){
            System.out.println("True");
        }else System.out.println("False");
        Assert.assertNotEquals(tumDdm.size(),4);
    }
}
