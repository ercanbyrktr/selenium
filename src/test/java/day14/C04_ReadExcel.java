package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        //Dosya yolunu bir String degiskene atayalım
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //FileInputStream objesini olusturup, parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //Workbook objesi olusturalım, parameter olarak fileInputStream objesini girelim
        //WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);
        //Turkce baskentler sutununu yazdıralım
        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();
        //getLastRowNum(); methodu bize excel sayfasındaki tum satır numarasını verir
        System.out.println("Satır sayısı: "+sonSatir);

        String turkceBaskentler="";
        for (int i = 0; i <=sonSatir ; i++) {
            turkceBaskentler=workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(turkceBaskentler);
        }
    }
}
