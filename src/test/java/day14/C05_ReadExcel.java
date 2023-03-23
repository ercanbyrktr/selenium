package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        //dosya yolunu bir string degiskene atayalım
        String dosyaYolu="C:\\Users\\ercan\\OneDrive\\Masaüstü\\ulkeler.xlsx";
        //FileInputStream objesini olusturup,parametre olarak dosya yolunu gielim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //Workbook objesi olusturalim, parameter olarak fileInputStream objesini girelim
        //WorkbookFactory.create(fileInputStream)
        Workbook workbook=WorkbookFactory.create(fis);
        //sayfa 2'ye gidip satir sayisinin 6, kullanılan satır sayısının ise 3 oldugunu test edin
        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatir);
        int expectedLastRow=6;
        Assert.assertEquals(expectedLastRow,sonSatir+1);


        int kullanilanSatir=workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        //Excel tablosunda kullanılan satır sayısını bu method ile alırız
        System.out.println(kullanilanSatir);
        int expectedKullanilanSatir=4;
        Assert.assertEquals(expectedKullanilanSatir,kullanilanSatir);



    }
}
