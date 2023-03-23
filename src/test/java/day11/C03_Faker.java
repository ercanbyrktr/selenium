package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import day12.utilities.TestBaseBeforeAfter;

public class C03_Faker extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        //https://facebook.com adresine gidin
        driver.get("https://facebook.com");
        //"create new acoount" butonuna basın
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //"fisrtName" giris kutusuna bir isim yazin
        Faker faker=new Faker();
        WebElement isim=driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        Actions actions=new Actions(driver);
        String email=faker.internet().emailAddress();//aynı mail adresini girmesi icin String bir degiskene atama yaptık
        /*
        Faker classını kullanma amacımız form doldurmamız gereken web sitelerde kendi uretecegimiz veriler
        yerine bizim icin rondom veriler uretir ve isimizi kolaylastırır
        Faker classını mvnrepository.com adresinden java-faker kütüphanesini aratır ve encok kullanılanı
        pom.xml dosyamıza ekleriz ve faker class'ından bir obje olusturup;
        email icin faker.internet() methodunu kullanarak emailAddress() methodunu seceriz.
        password icinde aynı internet methodunu kullanırız.
        isim ve soyisimler icin faker.name() methodu ile firstname() ve lastname() methodunu kullanırız
         */
        actions.click(isim).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("1").sendKeys(Keys.TAB).
                sendKeys("Tem").
                sendKeys(Keys.TAB).sendKeys("1987").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

    }
}
