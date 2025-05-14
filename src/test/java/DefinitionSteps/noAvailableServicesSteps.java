package DefinitionSteps;

import Pages.DisabledPages;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class noAvailableServicesSteps {
    DisabledPages disabledPages;
    WebDriverWait wait;
    public noAvailableServicesSteps(){
     disabledPages=new DisabledPages(DriverInitialization.driver);
     wait=new WebDriverWait(DriverInitialization.driver, Duration.ofSeconds(20));
    }
    @Then("redirect to page explains no available for Capital Online service")
    public void no_available_service_for_capital_online_option(){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(DisabledPages.textErrorLocator));
            String expectedTextError=" Internet Banking service will no longer be available. ";
            String actualTextError= disabledPages.textError();;
            Assert.assertEquals("does not match between expectedTextError and actual", expectedTextError,actualTextError);
        }
        catch(Exception e){
            System.out.println("the page should show message explains no available service for /''capital bank''/ option ");
        }
    }
}
