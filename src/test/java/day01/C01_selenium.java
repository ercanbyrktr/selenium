package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class C01_selenium {
    public static void main(String[] args) {
        /*
        En temel haliyle bir otomasyon yapmak icin
        Class'imiza otomasyon icin gerekli olan webdriver'in yerini gostermemiz gerekir
        bunun icin java kutuphanesinden System.setProperty() method'unu kullanırız
        ve method'un icine ilk olarak driver'i yazariz. ikinci olarak onun fiziki yolunu kopyalariz
         */
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp=new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);

        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");


        WebDriver driver=new ChromeDriver(options);
        driver.get("https://www.amazon.com/");
        System.out.println("Actual Title : "+ driver.getTitle()); // Gidilen sitenin basligini yazdirir
        System.out.println("Actual Url : "+ driver.getCurrentUrl()); // Gidilen sayfanın url'ini getirir

        System.out.println(driver.getPageSource()); //
    }
}
