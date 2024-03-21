package HelperFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.PageObject;

public class ManipulateLocaters extends PageObject {

    public ManipulateLocaters(WebDriver driver) {
        super(driver);
    }
    public   WebDriverWait waitelement = new WebDriverWait(driver, 5, 500 );


    public  boolean isElementDisplayed(By locater){


        try
        {
            waitelement.until(ExpectedConditions.visibilityOfElementLocated(locater));
        }

        catch(Exception e) {

            return false;
        }
        return true;
    }

    public  void clickOnElement(By locater)
    {
       waitelement.until(ExpectedConditions.elementToBeClickable(locater));
        driver.findElement(locater).click();
    }

    public void waitVisibilityOfElement(By locater)
    {
      waitelement.until(ExpectedConditions.visibilityOfElementLocated(locater));

    }

}
