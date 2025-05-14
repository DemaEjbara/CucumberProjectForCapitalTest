package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class DisabledPages {
    WebDriver driver;
    public DisabledPages(WebDriver driver){
        this.driver=driver;
    }
    public  static By textErrorLocator = By.xpath("//div[@class='error']//child::h1");
    public String textError(){
        return driver.findElement(By.xpath("//div[@class='error']//child::h1")).getText();
    }
}
