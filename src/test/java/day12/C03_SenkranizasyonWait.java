package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import day12.utilities.TestBaseBeforeAfter;

public class C03_SenkranizasyonWait extends TestBaseBeforeAfter {
    @Test
    public void implicitlyWaitTest1(){
        //Bir class olusturun: Wait Test
        //iki tane method olusturun: implicitlyWait(), explicitWait()
            /*
            implicityWait kullandıgımız bu method'da sayfadaki bütün webelementler için
            max belirttigimiz süre altında bütün web elementler için bekler
             */

        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //remove butonuna basın
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //"It's gone!" mesajının görüntülendigini dogrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's gone!\"]")).isDisplayed());
        //add butonuna basın
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        //"It's back" mesajının gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());




    }

    @Test
    public void explicitWaitTest2() {
    }
    /*
        explicitWait itsgoneWe görünür olmasını beklerken o web elementinin locatini kullanarak assert yapmak
        sorun olur ve exception fırlatır. Henüz görülmeyen bir webelementin locate edilmesi de otomasyon için
        mümkün olmaz.Bu durumda bekleme işlemi için explicitWait'i locate ile birlikte kullanırız
     */





}
