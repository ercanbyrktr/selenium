package day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class C01_SinifCalismasi {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp=new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // http://a.testaddressbook.com adresine gidiniz
              //driver.get("https://automationexercise.com/");
        // Sign in butonuna basin
              //driver.findElement(By.linkText("Login")).click();
        // email textbox, password textbox and signin button elementlerini locate ediniz
             //WebElement emailTextbox = driver.findElement(By.id("session_email"));
             //WebElement password = driver.findElement(By.id("sesion_password"));
             //WebElement signin = driver.findElement(By.name("commit"));
        // kullanici adini ve şifreyi aşagiya girin ve oturum aç (sign in) buttonunu tıklayın
        // usarname : ghosteagle@gmail.com
        // password : 12345678
             //emailTextbox.senKeys("ghosteagle@gmail.com");
             //password.sendKeys("12345678");
             //signin.click();
        // expected user id nin ghosteagle@gmail.com oldugunu dogrulayin (verify)
             //WebElement expectedUser = driver.findElement(By.className("navbar-text"));
               //if (expectedUser.isDisplayed()){
                  // System.out.println("ExpectedUser Testi PASSED");
               //}else System.out.println("ExpectedUser Testi FAILED");

            //--------
                //String istenenUserYazisi = "ghosteagle@gmail.com"
                //String actualUserYazisi = expectedUser.getText();
                //if(actualUserYazisi.equalss(istenenUserYazisi){
                    //System.out.println("TEST PASSED");
                //}esle System.out.println("TEST FAILED");
        /*
        Bir Webelement'in uzerindeki yaziyi konsolda yazdirabilmek icin getText() methodu kullanilir
         */

        // "Addresses" ve "Sign Out" textlerinin goruntulendigini (displayed) dogrulayin(verify)
                //WebElement addresses = driver.findElement(By.linkText("Addresses"));
                //WebElement signOut = driver.findElement(By.linkText("Sign out"));
                //if(addresses.isDisplayed()){
                //System.out.println("Adresses TESTI PASSED");
                //}else System.out.println("Adresses TESTI FAILED");

                //if(signOut.isDisplayed()){
                //System.out.println("signout TESTI PASSED");
                //}else System.out.println("signout TESTI FAILED");

        // sayfada kac tane link oldugunu bulun
                //List<WebElement> linklerlistesi = driver.findElements(By.tagName("a"));
                    //System.out.println("Linklerin sayisi = "+linklerlistesi.size());

        //Linkleri yazdiriniz
               // for (WebElement each:linklerlistesi) {
                 //   System.out.println("linkler :"+each.getText());
                //}
        //Linkleri Lambda ile yazdırın
                //linklerlistesi.forEach(t->System.out.println(t.getText()));
        //sayfayi kapatin
                //driver.close();

    }
}
