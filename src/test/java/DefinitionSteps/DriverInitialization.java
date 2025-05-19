package DefinitionSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class DriverInitialization {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static WebDriver setUpWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return driver;
    }
    @Before
    public void setUpScenario() {
        setUpWebDriver();
        open_the_capital_website();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    public void open_the_capital_website() {
        driver.manage().window().maximize();
        driver.get("https://www.capitalbank.jo/en/personal");
    }
}

