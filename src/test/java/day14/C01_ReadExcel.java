package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        //dosya yolunu bir String degiskene atayalım
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //FileInputStream objesi olusturup, parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);//oluşturmuş oldugumuz dosyayı sistemde işleme alır
        //Workbook objesi olusturalım, parameter olarak fileInputStream objesini girelim
        //WorkbookFactory.create (fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);//Workbook objesiyle fis objesi ile akışa aldıgımız
                                                        // dosyamızla bir excel dosyası create ettik

        //Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet=workbook.getSheet("Sayfa1");//Excel dosyamızda çalışmak istedigimiz sayfayı bu şekilde seçeriz
        //Row objesi olusturun sheet.getRow(index)
        Row row= sheet.getRow(3);//Sayfa 1 deki 3.'üncü satırı bu şekilde seçeriz
        //Cell objesi olusturun row.getCell(index)
        Cell cell=row.getCell(3);//Satır seçimi yapıldıktan sonra hücre seçimi bu şekilde yapılır
        System.out.println(cell);
        //3.index'deki satirin 3. index'indeki datanın Cezayir oldugunu test edin
        String expectedData="Cezayir";
        String actualData=cell.toString();
        Assert.assertEquals(expectedData,actualData);

    }
}
