package pages;

import HelperFunctions.ManipulateLocaters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.PageObject;

public class LoginFirstPage extends PageObject {
    private final By emailBy = By.id("field_EmailOrPhone");
    private final By nextBtnBy = By.id("button_btn_submit_email");
    private final By errorMessage = By.xpath("//*[@class='input-error-message' ]/p");

    public LoginFirstPage(WebDriver driver) {
        super(driver);
    }

    ManipulateLocaters waitelement = new ManipulateLocaters(driver);

    public void enterEmail(String Email) {
        waitelement.waitVisibilityOfElement(emailBy);
        driver.findElement(emailBy).sendKeys(Email);
    }

    public void pressNextButton() {
        waitelement.clickOnElement(nextBtnBy);
    }

    public boolean isErrorMessageDisplayed()  {
        return waitelement.isElementDisplayed(errorMessage);

    }

    public String getEmail() {
      return  driver.findElement(emailBy).getAttribute("value");


    }


}