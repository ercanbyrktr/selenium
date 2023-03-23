package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import day12.utilities.TestBaseBeforeAfter;

public class C01_ActionsKeyUpKeyDown extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        //https://amazon.com sayfasına gidelim
        driver.get("https://amazon.com");
        //Arama kutusuna actions method'larinı kullanarak samsung A71 yazdirin
        // ve Enter'a basarak arama yaptırın
        Actions actions=new Actions(driver);
        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(aramakutusu).
                sendKeys("samsung").
                sendKeys(" ").keyDown(Keys.SHIFT).//shift tusuna otomasyon ile bu sekilde kullanılır
                sendKeys("a").keyUp(Keys.SHIFT).//shift'ten cıkmak icin keyUp kullanılır
                sendKeys("7").sendKeys("1").sendKeys(Keys.ENTER).perform();
        //aramanın gerceklestigini test edin
        WebElement aramaSonucu=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(aramaSonucu.isDisplayed());

    }
}
