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
    public WebElement branchesAndAtmButton(){
        return driver.findElement(By.className("atm-branches tools__item"));
    }
    public WebElement ibanGeneratorButton(){
        return driver.findElement(By.className("iban-generator tools__item"));
    }
    public WebElement waysToBankButton(){
        return driver.findElement(By.className("how-to tools__item"));
    }
    public WebElement customerSupportButton(){
        return driver.findElement(By.className("customer tools__item col-16"));
    }
    public WebElement calculatorsButton(){
        return driver.findElement(By.className("calculators tools__item"));
    }
    public WebElement productFinderButton(){
        return driver.findElement(By.className("product-finder tools__item"));
    }
    public List<WebElement> listOfButtons(){
        return driver.findElements(By.xpath("//parent::div[@class='tools']//child::div[@class='row g-0']"));
    }
}
