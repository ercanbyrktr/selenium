package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import day12.utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // cizili olan uzerinde sag click yapalım
        WebElement cizgiliAlan= driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();
        //Alert'te cıkan yazının "You selected a context menu" oldugunu test edelim
        String expectedAlertYazisi="You selected a context menu";
        String actualAlertYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        //Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        //Tamam diyerek alert'i kapatalim
        driver.switchTo().alert().accept();
        //Elemantel Selenium linkine tıklayalım
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        List<String> windowlist=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowlist.get(1));
        //Acılan sayfada h1 tagında "Elemental Selenium" yazdıgını test edelim
        Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());

    }
}
