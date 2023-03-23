package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class C04_FileExists {
    @Test
    public void test1(){
        System.out.println(System.getProperty("user.dir"));//C:\Users\ercan\IdeaProjects\com.BireyselCalismalarimJUnit
        //Suanki icinde bulundugum yolu gösterir
        System.out.println(System.getProperty("user.home"));//C:\Users\ercan
        //Gecerli kullanıcının ana dizinini verir
        /*
        String farkliBolum=System.getProperty("user.home");
        //"C:\Users\ercan\OneDrive\Masaüstü\text.txt" --> masa üstündeki dosyanın yolu
        String ortakBolum="\\OneDrive\\Masaüstü\\text.txt";

        String masaUstuDosyaYolu=farkliBolum+ortakBolum;//Masaustundeki dosya yolunu gösterir

        System.out.println(masaUstuDosyaYolu);//C:\Users\ercan\OneDrive\Masaüstü\text.txt
        System.out.println(Files.exists(Path.of(masaUstuDosyaYolu)));
        Assert.assertTrue(Files.exists(Path.of(masaUstuDosyaYolu)));

        */

        String dosyaYolu="C:\\Users\\ercan\\OneDrive\\Masaüstü\\text.txt";
        //System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*
        Bir web sitesinden indirdigimiz ya da windows iicinde olusturdugumuz dosyanın indigini ya da orda
        oldugunu test edebilmem icin o dosyanın üzerine shift tusuna basılı olarak sag click yapıp dosyanın
        yolunu kopyalayıp bir string degiskene atarız ve dosyayı dogrulamak icin
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));   ---> bu methodu kullanırız
         */


    }
}
