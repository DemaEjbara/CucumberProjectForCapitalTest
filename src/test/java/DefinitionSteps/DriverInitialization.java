package DefinitionSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;
public class DriverInitialization {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static WebDriver setUpWebDriver (){
        File driverFile = new File("src/test/Driver/chromedriver");
        if (!driverFile.exists()) {
            throw new RuntimeException("ChromeDriver not found at " + driverFile.getAbsolutePath());
        }
        System.setProperty("webdriver.chrome.driver", driverFile.getAbsolutePath());
        driver = new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        return driver;
    }
    @Before
    public void setUpScenario(){
        setUpWebDriver();
        open_the_capital_website();
    }
    @After
    public void tearDown(){
        if(driver!=null){
        driver.quit();
        }
    }
    public void open_the_capital_website(){
        driver.manage().window().maximize();
        driver.get("https://www.capitalbank.jo/en/personal");
    }
}
