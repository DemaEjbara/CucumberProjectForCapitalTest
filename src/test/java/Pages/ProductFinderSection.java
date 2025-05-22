package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.PublicKey;
import java.util.List;

public class ProductFinderSection {
    WebDriver driver;
    public ProductFinderSection(WebDriver driver){
        this.driver=driver;
    }
    public List<WebElement> productFinderElements(){
        return driver.findElements(By.className("selectize-input"));
    }
}
