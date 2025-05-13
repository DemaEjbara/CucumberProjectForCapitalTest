package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    public WebDriver driver;
    public List<WebElement> listOfBankingServices (){
        return driver.findElements(By.className("spotlight__pagination swiper-pagination-clickable swiper-pagination-bullets swiper-pagination-horizontal"));
    }
}
