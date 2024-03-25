package tests;

import constants.Constants;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LandingPage;
import pages.LoginFirstPage;

import java.util.concurrent.TimeUnit;
import pages.LoginSecondPage;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;

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
    driver.quit();
}

@Test()

public void loginWithBadEmail()  {
    driver.get(Utils.BASE_URL);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    LandingPage landingPage = new LandingPage(driver);
    landingPage.clickAcceptTermsButton();
    landingPage.clickLoginButton();
    LoginFirstPage loginFirstPage = new LoginFirstPage(driver);
    String badEmail = "test@";
    loginFirstPage.enterEmail(badEmail);
    loginFirstPage.pressNextButton();
    Assert.assertEquals(loginFirstPage.getEmail(), Constants.Login.WRONG_EMAIL_ERROR_MESSAGE,Constants.Login.WRONG_EMAIL_ERROR_MESSAGE + " is not equal to " + loginFirstPage.getErrorMessage());
    driver.quit();
}
    @Test()

    public void loginWithBadPassword()  {
        driver.get(Utils.BASE_URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickAcceptTermsButton();
        landingPage.clickLoginButton();
        LoginFirstPage loginFirstPage = new LoginFirstPage(driver);
        loginFirstPage.enterEmail(Utils.username);
        loginFirstPage.pressNextButton();
        LoginSecondPage loginSecondPage = new LoginSecondPage(driver);
        String badPass= "test";
        loginSecondPage.enterPassword(badPass);
        loginSecondPage.pressSubmitButton();
        Assert.assertTrue(loginSecondPage.isErrorMessageDisplayed() );
        MatcherAssert.assertThat(loginSecondPage.getErrorMessage(), anyOf( containsString(Constants.Login.WRONG_EMAIL_ERROR_MESSAGE),containsString(Constants.Login.SECURITY_WRONG_ERROR_MESSAGE)));
        driver.quit();
    }
}
