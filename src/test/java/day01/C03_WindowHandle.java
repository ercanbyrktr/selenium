package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class C03_WindowHandle {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp=new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://amazon.com");
        driver.manage().window().maximize();
        System.out.println(driver.getWindowHandle()); // CDwindow-AD69CECC6B8A4303F90EECAFE1D9E4F5
        // farklı pencereler arasında gezinebilmek için getWindowHandle() methodunu kullanırız
    }
}
