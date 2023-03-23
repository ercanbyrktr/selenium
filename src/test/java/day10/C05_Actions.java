package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import day12.utilities.TestBaseBeforeAfter;

public class C05_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        //https://demoga.com/droppable adresine gidelim
        driver.get("https://demoga.com/droppable");
        //"Drag me" butonunu tutup "Drop here" kutusunun ustune bırakalım

        WebElement dragMe= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere=driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        Actions actions=new Actions(driver);
        Thread.sleep(2000);
        actions.dragAndDrop(dragMe,dropHere).perform();
        //""Drop here yazısı yerine "Dropped!" oldugunu test edin
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());



    }
}
