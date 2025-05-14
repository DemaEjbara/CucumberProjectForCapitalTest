package Pages;
import DefinitionSteps.DriverInitialization;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HandleModalDialogTest {
    WebDriverWait wait;
    public WebDriver driver;
    public HandleModalDialogTest(WebDriver driver){
        wait=new WebDriverWait(DriverInitialization.driver, Duration.ofSeconds(20));
        this.driver=driver;
    }
    public void verifyModalDialogBox(){
        WebElement modalContainer=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal__content-box']")));
        WebElement modalContentBody=modalContainer.findElement(By.xpath("//div[@class='modal__caption-box']//child::h3"));
        String actualMessageDialog=modalContentBody.getText();
        String expectedMessageDialog="Download the Capital Bank app today and enjoy managing your accounts in a simple, secure and convenient way at any time and from anywhere!";
        Assert.assertEquals(expectedMessageDialog,actualMessageDialog);
//        WebElement modalCloseButton=modalContainer.findElement(By.xpath("//div[@class='modal__close']"));
//        modalCloseButton.click();
    }
}
