package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import day12.utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExists extends TestBaseBeforeAfter {

    @Test
    public void test1(){


        //https://the-internet.herokuapp/download adresine gidelim
        driver.get("https://the-internet.herokuapp/download");
        //test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='test.txt']")).click();
        //Ardından isExist() methodunda dosyanın başarıyla indirilip indirilmedigini test edelim
        String dosyaYolu="C:\\Users\\ercan\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)) );
        //İndirildigini konsolda göster
        System.out.println(Files.exists(Paths.get(dosyaYolu)));


    }
}
