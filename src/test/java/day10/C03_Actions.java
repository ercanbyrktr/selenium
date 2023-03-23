package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import day12.utilities.TestBaseBeforeAfter;

public class C03_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Account menusunden create a list linkine tıklayalım
        WebElement accountList=driver.findElement(By.xpath("//*[text()='Hello, sign in']"));
        Actions actions =new Actions(driver);
        actions.moveToElement(accountList).perform();
        /*
        Bir web sitesinde bir mouse ile acılan bir web elementine ulasmak istersek
        actions.moveToElement() methodunu kullanmamız gerekir. Aksi takdirde html
        kodları arasında web elementi bulur ama ulasamadıgı icin exception fırlatır
         */
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

    }
}
