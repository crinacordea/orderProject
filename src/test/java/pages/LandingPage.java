package pages;

import HelperFunctions.ManipulateLocaters;
import org.openqa.selenium.*;
import pageObject.PageObject;

public class LandingPage extends PageObject {
    private final By loginBtnBy = By.xpath("//*[@class='n-navigation__menu-nav']/li[5]");
    private final By acceptTermsBtnBy = By.id("onetrust-accept-btn-handler");
    private final By alertBy = By.id("batchsdk-ui-alert");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    ManipulateLocaters waitelement = new ManipulateLocaters(driver);

    public void clickLoginButton() {

        waitelement.waitVisibilityOfElement(loginBtnBy);
        driver.findElement(loginBtnBy).click();
    }

    public void clickAcceptTermsButton() {

        if (isAcceptTermsWindowDisplayed()) {
            driver.findElement(acceptTermsBtnBy).click();
        }
    }

    public boolean isLoginButtonDisplayed() {
        return waitelement.isElementDisplayed(loginBtnBy);

    }


    public Boolean isAcceptTermsWindowDisplayed() {
        boolean isDisplayed;
        try {
            isDisplayed = driver.findElement(acceptTermsBtnBy).isDisplayed();
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        // do something else here with isDisplayed
        if (isDisplayed) {
            System.out.println("Accept Terms is displayed");
        } else {
            System.out.println("Accept Terms is not displayed");
        }
        return isDisplayed;
    }


}
