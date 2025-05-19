package Pages;
import DefinitionSteps.HomePageSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
public class HomePage {
    public WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public List<WebElement> listOfButtons(){
        return driver.findElements(By.xpath("//parent::div[@class='tools']//child::div[@class='row g-0']"));
    }

}
