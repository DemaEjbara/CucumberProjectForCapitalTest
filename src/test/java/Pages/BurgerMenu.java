package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class BurgerMenu {
    WebDriver driver;
    public BurgerMenu(WebDriver driver){
        this.driver=driver;
    }
    public List<WebElement>  elementsOfMainMenu(){
        return driver.findElements(By.xpath("//div[@class='col-lg-4 col-xl-5 col-16 menu__left']//div[@class='menu__main']//child::a"));
    }
    public List<WebElement> listOfItemsOnTheTopLeftSideBar(){
        return driver.findElements(By.xpath("//div[@class='menu__top--left']//child::a"));
    }
}