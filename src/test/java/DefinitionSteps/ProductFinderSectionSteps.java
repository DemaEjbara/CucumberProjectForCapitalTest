package DefinitionSteps;
import Pages.ProductFinderSection;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static DefinitionSteps.DriverInitialization.driver;
public class ProductFinderSectionSteps {
    WebDriverWait wait;
    ProductFinderSection finderSection;

    public ProductFinderSectionSteps() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        finderSection = new ProductFinderSection(driver);

    }

    @Given("the user should be on the product finder section")
    public void product_finder_section() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='inquire']")));
    }

    @When("the user selects from the drop-down")
    public void drop_down_list() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".selectize-dropdown")
        ));
        WebElement optionToSelect = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'option') and normalize-space(text())='I want a card for spending']")
        ));
        optionToSelect.click();
    }
    @And("click on the {string} button")
    public void clickOnTheButton(String arg0) {
        WebElement dropdownDiv = driver.findElement(By.cssSelector("div.selectize-input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdownDiv);
    }
    }

