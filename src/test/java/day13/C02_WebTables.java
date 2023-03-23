package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import day12.utilities.TestBaseBeforeAfter;

import java.util.List;

public class C02_WebTables extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //login() methodunu olusturun ve oturum açın

        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin

        login();
        //Username : manager
        //Password : Manager1!
        //table() methodu olusturun
        table();

    }

    private void table() {
        //Tüm table body'sinin boyutunu(sütun sayısı) bulun
        /*
        Tabloda <table> tag'ı altında tablonun başlıgını gösteren <thead> tagı bulunur. Eger baslıkta satır
        (row) varsa <thead> tag'ı altında <tr> (satır-row) tagı vardır. Ve başlıktaki sütunlara yani hücrelere(cell)
        de <th> tag'ı ile ulaşılır
        Başlıgın altındaki verilere <tbody> tag'ı ile altındaki satırlara(row) <tr> tag'ı ile sütunlara yani
        hücrelere <td> tag'ı ile ulaşırız
         */
        List<WebElement> sutunSayisi=driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun Sayisi = "+sutunSayisi.size());
        //Table'daki tüm body'i ve başlıkları(headers) konsolda yazdırın
        WebElement basliklar= driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar : "+basliklar.getText());
        WebElement body=driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum Body : "+body.getText());
        //printRows() methodu olusturun //tr
        //table body'sinde bulunan toplam satır(row) sayısını bulun
        List<WebElement> satirList=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tablodaki Satır sayisi : "+satirList.size());
        //table body'sinde bulunan satırları(rows) konsolda yazdırın
        satirList.forEach(t-> System.out.println(t.getText()));
        //4. satırdaki(row) elemntleri konsolda yazdırın
        System.out.println("Tablodaki 4. satır : "+driver.findElement(By.xpath("//tbody//tr[4]")).getText());
    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//[@id='UserName']")).click();
        Actions actions=new Actions(driver);
        WebElement userName= driver.findElement(By.xpath("//[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }

}
