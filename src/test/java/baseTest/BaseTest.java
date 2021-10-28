package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public static WebDriver driver;
    public String url = "https://www.n11.com/";
    public String email = "zbx7dfcjhk@upimagine.com";
    public String password = "123456a";
    public String searchText = "Bilgisayar";


    @Before
    public void driverConfig(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(options);
        Log.info("Driver setup.");
        driver.manage().window().maximize();
        driver.get(url);
        Log.info("Navigate N11 website.");
    }

    @After
    public void driverQuit(){
       driver.quit();
       Log.info("Driver quit.");
    }

}
