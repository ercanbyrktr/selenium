package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    @Test
    public void test1() throws IOException {
        //Adimlari takip ederek 1.satira kadar gidelim
        String dosyaYolu="C:\\Users\\ercan\\OneDrive\\Masaüstü\\ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        //5.hücreye yeni bir cell olusturalım
        //olusturdugumuz hucreye "Nufus" yazdıralım
        workbook.getSheet("Sayfa1").getRow(0).createCell(7).setCellValue("Nufus");
        //2.satır nufus kolonuna 1500000 yazdıralım
        workbook.getSheet("Sayfa1").getRow(1).createCell(7).setCellValue("1.500000");
        //10.satır nufus kolonuna 250000 yazdıralım
        workbook.getSheet("Sayfa1").getRow(9).createCell(7).setCellValue("250.000");
        //15.satir nufus kolonuna 54000 yazdıralım
        workbook.getSheet("Sayfa1").getRow(14).createCell(7).setCellValue("54.000");
        //dosyayı kaydedelim
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        //Excel dosyamıza veri girişi yaptıktan sonra dosyayı akışa aldıgımız gibi sonlandırmamız gerekir.
        //Sonrasında da workbook objemize kayıt etmemiz gerekir
        workbook.write(fos);// write methodu ile sonlandırdıgımız işlemi workbook'a yazdırdık
        //dosyayı kapatalım
        fis.close();
        fos.close();
        workbook.close();
    }
}
