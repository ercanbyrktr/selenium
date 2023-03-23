package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C02_JSExecutor extends day12.utilities.TestBaseBeforeAfter {
    @Test
    public void test1() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Asagidaki careers butonunu görünceye kadar js ile scroll yapalım
        WebElement careers=driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",careers);
        //Carrers butonuna js ile click yapalım
        jse.executeScript("arguments[0].click();",careers);
    }
}
