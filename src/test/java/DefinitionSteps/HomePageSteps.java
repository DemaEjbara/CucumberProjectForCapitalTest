package DefinitionSteps;
import HelpersUtils.locatorUtil;
import Pages.BurgerMenu;
import Pages.HandleModalDialogTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static DefinitionSteps.DriverInitialization.driver;
public class HomePageSteps {
    WebDriverWait wait;
    HandleModalDialogTest modalObj;
    BurgerMenu burgerMenu;
    public HomePageSteps(){
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        modalObj=new HandleModalDialogTest(driver);
        burgerMenu=new BurgerMenu(driver);
    }
    @When("show Modal Dialog on Home Page Screen")
    public void showModalDialogOnHomePageScreen() {
        modalObj.verifyModalDialogBox();
    }
    @And("wait for the accept cookies pop up to appear")
    public void waitForTheAcceptCookiesPopUpToAppear() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='cookies-overlay show']")));
    }
    @And("should contains the main menu items")
    public void verifyOfDisplayingMainMenuItems() {
        List<WebElement> elementsOfMainMenu=burgerMenu.elementsOfMainMenu();
        wait.until(ExpectedConditions.visibilityOfAllElements(elementsOfMainMenu));
        for (WebElement e : elementsOfMainMenu){
            Assert.assertTrue("this element is not located", e.isDisplayed());
        }
    }
    @And("it should contain menu items in the top left side of sidebar")
    public void itShouldContainMenuItemsInTheTopLeftSideOfSidebar() {
     List<WebElement> elementsOfMenuTop=burgerMenu.listOfItemsOnTheTopLeftSideBar();
     wait.until(ExpectedConditions.visibilityOfAllElements(elementsOfMenuTop));
        for (WebElement e : elementsOfMenuTop){
            Assert.assertTrue("this element is not located", e.isDisplayed());
        }
    }
}
