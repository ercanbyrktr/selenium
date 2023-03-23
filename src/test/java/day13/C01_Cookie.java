package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import day12.utilities.TestBaseBeforeAfter;

import java.util.Set;

public class C01_Cookie extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Amazon sayfasına gidin
        driver.get("https://amazon.com");
        //tum cookieleri listeleyin
        Set<Cookie> tumCookie= driver.manage().getCookies();
        System.out.println(tumCookie);
        int sayac=1;
        for (Cookie w:tumCookie) {
            System.out.println(sayac+". cookie : "+ w);
            System.out.println(sayac+". name : " +w.getName());
            System.out.println(sayac+". value : "+w.getValue());
            sayac++;
        }
        //sayfadaki cookies sayisinin 5'den buyuk oldugunu test edin
        int cookieSayisi=tumCookie.size();
        Assert.assertTrue(cookieSayisi>5);
        //ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w:tumCookie) {
            if (w.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",w.getValue());
            }
        }
        //ismi "en sevdigim cookie " ve degeri "cikolatali" olan bir cookie olusturun ve sayfaya ekleyin
        Cookie yeniCookie=new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(yeniCookie);
        tumCookie= driver.manage().getCookies();

        sayac=1;
        for (Cookie w:tumCookie) {
            System.out.println(sayac+". cookie : "+ w);
            System.out.println(sayac+". name : " +w.getName());
            System.out.println(sayac+". value : "+w.getValue());
            sayac++;
        }
        //eklediginiz cookie'nin sayfaya eklendigini test edin
        Assert.assertTrue(tumCookie.contains(yeniCookie));
        //ismi skin olan cookie'yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        tumCookie= driver.manage().getCookies();

        sayac=1;
        for (Cookie w:tumCookie) {
            System.out.println(sayac+". cookie : "+ w);
            System.out.println(sayac+". name : " +w.getName());
            System.out.println(sayac+". value : "+w.getValue());
            sayac++;
        }
        Cookie isim=driver.manage().getCookieNamed("skin");
        Assert.assertFalse(tumCookie.contains(isim));

        //tum cookileri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCookie= driver.manage().getCookies();
        Assert.assertTrue(tumCookie.isEmpty());


    }
}
