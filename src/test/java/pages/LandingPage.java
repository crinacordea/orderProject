package pages;

import HelperFunctions.ManipulateLocaters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.PageObject;
public class LandingPage extends PageObject {
    private final By  loginBtnBy = By.xpath("//*[@class='n-navigation__menu-nav']/li[5]");
    private final By acceptTermsBtnBy = By.id("onetrust-accept-btn-handler");
    public LandingPage(WebDriver driver) {
        super(driver);
    }
    ManipulateLocaters waitelement = new ManipulateLocaters(driver);
    public  void clickLoginButton(){

        waitelement.waitVisibilityOfElement(loginBtnBy);
        driver.findElement(loginBtnBy).click();
    }

    public  void clickAcceptTermsButton(){

        waitelement.waitVisibilityOfElement(acceptTermsBtnBy);
        driver.findElement(acceptTermsBtnBy).click();
    }

    public boolean isLoginButtonDisplayed()  {
        return waitelement.isElementDisplayed(loginBtnBy);

    }

}
