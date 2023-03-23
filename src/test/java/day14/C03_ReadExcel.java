package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void Test1() throws IOException {
        //Belirtilen satırNo ve sutunNo degerlerini parametre olarak alıp o cell'deki datayı konsola yazdıralım
        //Sonucun konsolda yazanla aynı oldugunu doğrulayın

        int satir=12;
        int sutun=2;

        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        String actualData=workbook.getSheet("Sayfa1").getRow(satir-1).getCell(sutun-1).toString();
        //ındex 0 dan başladıgı için bizden istenen satıra ulaşabilmek için bir eksigini aliriz
        System.out.println(actualData);

        String expectedData="Baku";
        Assert.assertEquals(expectedData,actualData);

    }
}
