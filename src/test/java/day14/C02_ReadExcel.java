package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void ReadExcelTest1() throws IOException {
        //dosya yolunu bir String degiskene atayalım
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //FileInputStream objesi olusturup, parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);//oluşturmuş oldugumuz dosyayı sistemde işleme alır
        //Workbook objesi olusturalım, parameter olarak fileInputStream objesini girelim
        //WorkbookFactory.create (fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);//Workbook objesiyle fis objesi ile akışa aldıgımız dosyamızla bir excel dosyası create ettik
        //Sheet objesi olusturun workbook.getSheetAt(index)
        //Row objesi olusturun sheet.getRow(index)
        //Cell objesi olusturun row.getCell(index)
        String actualData=workbook.getSheet("Sayfa1").getRow(3).getCell(3).toString();
        System.out.println(actualData);


    }
}
