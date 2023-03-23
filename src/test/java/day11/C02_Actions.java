package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import day12.utilities.TestBaseBeforeAfter;

public class C02_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        //https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //Ad,soyad,mail ve sifre kutularına deger yazalim ve kaydol tusuna basalim
        Actions actions=new Actions(driver);
        WebElement isim=driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        isim.sendKeys("Ercan");
        actions.sendKeys(Keys.TAB).sendKeys("BAYRAKTAR").
                sendKeys(Keys.TAB).
                sendKeys("ercan@gmail.com").
                sendKeys(Keys.TAB).sendKeys("ercan@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("123456.").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("1").sendKeys(Keys.TAB).
                sendKeys("Tem").
                sendKeys(Keys.TAB).sendKeys("1987").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

    }
}
