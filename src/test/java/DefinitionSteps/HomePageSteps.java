package DefinitionSteps;
import HelpersUtils.locatorUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class HomePageSteps {
    WebDriverWait wait;
    public HomePageSteps(){
        wait=new WebDriverWait(DriverInitialization.driver, Duration.ofSeconds(10));
    }
    @Given("user should redirect to {string}")
    public void user_should_redirect_to(String expectedUrl) {
        try {
            wait.until(ExpectedConditions.urlToBe(expectedUrl));
        }
        catch (TimeoutException e)
        {
            String actualUrl=DriverInitialization.driver.getCurrentUrl();
            Assert.fail("Timeout waiting for URL to be '" + expectedUrl + "'. Actual URL: " + actualUrl);
        }
        String actualUrl=DriverInitialization.driver.getCurrentUrl();
        Assert.assertEquals("The Page URL is not displayed correctly", expectedUrl, actualUrl);
    }
    @And("contains as text {string} on the top header")
    public void for_check_page_whether_contains_special_text_or_not(String expectedText){
        By locator= locatorUtil.GetLocator(expectedText);
        String actualText=wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        String expText=locatorUtil.getText(expectedText);
    }
}
