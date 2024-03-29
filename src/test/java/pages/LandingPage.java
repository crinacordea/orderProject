package pages;

import HelperFunctions.ManipulateLocaters;
import org.openqa.selenium.*;
import pageObject.PageObject;

public class LandingPage extends PageObject {
    private final By searchBtnBy = By.id("search");
    public LandingPage(WebDriver driver) {
        super(driver);
    }

    ManipulateLocaters waitelement = new ManipulateLocaters(driver);

    public void searchItem(String itemName) {

        waitelement.waitVisibilityOfElement(searchBtnBy);
        driver.findElement(searchBtnBy).sendKeys(itemName);
        driver.findElement(searchBtnBy).sendKeys(Keys.ENTER);
    }

}
