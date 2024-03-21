package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LandingPage;
import pages.LoginFirstPage;

import java.util.concurrent.TimeUnit;
import org.testng.asserts.SoftAssert;
import pages.LoginSecondPage;

public class LoginTests {
    private static final WebDriver driver = new ChromeDriver();
@Test()
public void logIn()  {

    driver.get(Utils.BASE_URL);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    LandingPage landingPage = new LandingPage(driver);
    landingPage.clickAcceptTermsButton();
    landingPage.clickLoginButton();
    LoginFirstPage loginFirstPage = new LoginFirstPage(driver);
    loginFirstPage.enterEmail(Utils.username);
    loginFirstPage.pressNextButton();
    LoginSecondPage loginSecondPage = new LoginSecondPage(driver);
    loginSecondPage.enterPassword(Utils.password);
    loginSecondPage.pressSubmitButton();
    Assert.assertTrue(landingPage.isLoginButtonDisplayed());
    driver.close();
}

@Test()

public void loginWithBadCredentials()  {
    SoftAssert softAssert = new SoftAssert();
    driver.get(Utils.BASE_URL);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    LandingPage landingPage = new LandingPage(driver);
    landingPage.clickAcceptTermsButton();
    landingPage.clickLoginButton();
    LoginFirstPage loginFirstPage = new LoginFirstPage(driver);
    String badEmail = "test@";
    loginFirstPage.enterEmail(badEmail);
    loginFirstPage.pressNextButton();
    softAssert.assertTrue(loginFirstPage.isErrorMessageDisplayed(),"Error message is not displayed");
    softAssert.assertEquals(badEmail,loginFirstPage.getEmail(),"The email address:"  + badEmail + "is not displayed in email input field.");
    softAssert.assertAll();
    driver.close();
}

}
