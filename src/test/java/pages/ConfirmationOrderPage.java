package pages;

import HelperFunctions.ManipulateLocaters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.PageObject;

public class ConfirmationOrderPage extends PageObject {
    private final By confirmationMessageBy = By.xpath("//*[@class= 'page-title']/span");

    public ConfirmationOrderPage(WebDriver driver) {
        super(driver);
    }

    ManipulateLocaters waitelement = new ManipulateLocaters(driver);


    public String getConfirmationMessage() {
        try {
            ManipulateLocaters manipulateLocaters = new ManipulateLocaters(driver);
            manipulateLocaters.waitAttributeContains("style", "display: none;");
        }
        catch(Exception e)
        {System.out.println("loading bar is not displayed");}
        waitelement.waitVisibilityOfElement(confirmationMessageBy);
        return driver.findElement(confirmationMessageBy).getText();
    }

}


