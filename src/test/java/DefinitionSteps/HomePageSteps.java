package DefinitionSteps;
import HelpersUtils.locatorUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
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
        Assert.assertEquals("no found the this text",expText,actualText);
    }
    @Given("click on the {string}")
    public void click_on_the_burger_menu_on_the_left_side(String buttonName) {
        By locator= locatorUtil.GetLocator(buttonName);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(locator));
        button.click();
        //        WebElement burgerMenu=DriverInitialization.driver.findElement(By.id("Icon_ionic-ios-menu"));
//        wait.until(ExpectedConditions.visibilityOf(burgerMenu)).click();
    }
    @Then("the navigation sidebar is shown")
    public void the_navigation_sidebar_is_shown() {
        WebElement sideBarWindow=DriverInitialization.driver.findElement(By.xpath("//nav[contains(@class, 'menu--header')]"));
        wait.until(ExpectedConditions.visibilityOf(sideBarWindow)).isDisplayed();

    }

}
