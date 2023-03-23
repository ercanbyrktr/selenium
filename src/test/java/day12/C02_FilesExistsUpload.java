package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import day12.utilities.TestBaseBeforeAfter;

public class C02_FilesExistsUpload extends TestBaseBeforeAfter {


    @Test
    public void test1(){
        //https://the-internet.herokuapp/download adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //dosyasec butonuna basalım
        WebElement dosyaSec=driver.findElement(By.xpath("//*[@id='file-upload']"));
        /*
        Dosyasec butonuna direk click yapamayabiliriz çünkü windows'a müdahaleye izin vermeyebilir
        Bu yüzden Dosyasec butonunu direk locate edip sendKeys() methodu ile string degişkene atadıgımız
        dosya yolumuzu göndeririz
         */

        //Yuklemek istediginiz dosyayı secelim
        String dosyaYolu="C:\\Users\\ercan\\OneDrive\\Masaüstü\\text.txt";
        dosyaSec.sendKeys(dosyaYolu);
        //Upload butonuna basalım
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();
        //"File Uploaded!" textinin goruntulendigini test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());

    }
}
