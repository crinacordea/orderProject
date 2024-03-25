package pages;

import HelperFunctions.ManipulateLocaters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.PageObject;

public class LoginSecondPage extends PageObject {
    private final By passwordBy = By.id("field_Password");
    private final By submitBtnBy= By.id("button_submit");
    private final By errorMessage = By.xpath("//*[@class='input-error-message' ]/p");
    public LoginSecondPage(WebDriver driver) {
        super(driver);
    }
    ManipulateLocaters waitelement = new ManipulateLocaters(driver);
    public void enterPassword(String Email){
        waitelement.waitVisibilityOfElement(passwordBy);
        driver.findElement(passwordBy).sendKeys(Email);
    }
    public  void pressSubmitButton(){
        waitelement.clickOnElement(submitBtnBy);
    }

    public boolean isErrorMessageDisplayed()  {
        return waitelement.isElementDisplayed(errorMessage);

    }
}

