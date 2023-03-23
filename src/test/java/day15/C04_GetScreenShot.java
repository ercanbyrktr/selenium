package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import day12.utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenShot extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        //Amazon sayfasına gidelim tum sayfanın resmini alalım
        driver.get("https://www.getir.com");
        /*
        Bir web sayfanın resmini alabilmek için TakesScreenshot class'ından obje olusturup
        Gecici bir File class'ından degiskene TakesScreenshot'dan oluşturdugum obje'den
        getScreenshotAs methodunu kullanarak geçici bir file oluştururuz
         */
        TakesScreenshot ts= (TakesScreenshot) driver;
        File tumSayfaResmi=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/allPage"+tarih+".jpeg"));
    }
}
