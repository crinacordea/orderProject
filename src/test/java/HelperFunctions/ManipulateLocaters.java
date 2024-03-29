package HelperFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.PageObject;

import java.time.Duration;

public class ManipulateLocaters extends PageObject {
    private final By loadingBarBy = By.xpath("//*[@class='loading-mask']");

    public ManipulateLocaters(WebDriver driver) {
        super(driver);

    }

    public WebDriverWait waitelement = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(500));


    public boolean isElementDisplayed(By locater) {


        try {
            waitelement.until(ExpectedConditions.visibilityOfElementLocated(locater));
        } catch (Exception e) {

            return false;
        }
        return true;
    }

    public void clickOnElement(By locater) {
        waitelement.until(ExpectedConditions.elementToBeClickable(locater));
        driver.findElement(locater).click();
    }

    public void waitVisibilityOfElement(By locater) {
        waitelement.until(ExpectedConditions.visibilityOfElementLocated(locater));

    }

    public void waitAttributeContains(String attribute, String value) {
        waitelement.until(ExpectedConditions.attributeContains(driver.findElement(loadingBarBy), attribute, value));


    }
}
