package tests;

import constants.Constants;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginFirstPage;
import java.util.concurrent.TimeUnit;
import pages.LoginSecondPage;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
public class LoginTests {
    private static final WebDriver driver = new ChromeDriver();

    @DataProvider(name = "badEmailCredentials")
    public Object[][] badEmailCredentials() {
        return new Object[][]{
                {"test.test",  Constants.Login.WRONG_EMAIL_ERROR_MESSAGE_2},
                {"hel0000000000", Constants.Login.WRONG_EMAIL_ERROR_MESSAGE_2},
                {"test@", Constants.Login.WRONG_EMAIL_ERROR_MESSAGE},
        };
    }

    @DataProvider(name = "badPasswordCredentials")
    public Object[][] badPasswordCredentials() {
        return new Object[][]{
                {" ",  Constants.Login.WRONG_PASSWORD_ERROR_MESSAGE, Constants.Login.SECURITY_PASSWORD_ERROR_MESSAGE},
                {"",  Constants.Login.EMPTY_PASSWORD_ERROR_MESSAGE, Constants.Login.SECURITY_PASSWORD_ERROR_MESSAGE},
                {"testtesf", Constants.Login.WRONG_PASSWORD_ERROR_MESSAGE,Constants.Login.SECURITY_PASSWORD_ERROR_MESSAGE}

        };
    }

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

}

@Test(
        dataProvider = "badEmailCredentials"
)
public void loginWithBadEmail(String emailAddress, String errorMessage) {
    driver.get(Utils.BASE_URL);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    LandingPage landingPage = new LandingPage(driver);
    landingPage.clickAcceptTermsButton();
    landingPage.clickLoginButton();
    LoginFirstPage loginFirstPage = new LoginFirstPage(driver);
    loginFirstPage.enterEmail(emailAddress);
    loginFirstPage.pressNextButton();
    Assert.assertEquals(loginFirstPage.getErrorMessage(), errorMessage, errorMessage + " is not equal to " + loginFirstPage.getErrorMessage());
}


    @Test(
            dataProvider = "badPasswordCredentials")

    public void loginWithBadPassword(String password, String errorMessage, String errorMessageSecurity)  {
        driver.get(Utils.BASE_URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickAcceptTermsButton();
        landingPage.clickLoginButton();
        LoginFirstPage loginFirstPage = new LoginFirstPage(driver);
        loginFirstPage.enterEmail(Utils.username);
        loginFirstPage.pressNextButton();
        LoginSecondPage loginSecondPage = new LoginSecondPage(driver);
        loginSecondPage.enterPassword(password);
        loginSecondPage.pressSubmitButton();
        MatcherAssert.assertThat(loginSecondPage.getErrorMessage(), anyOf( containsString(errorMessage),containsString(errorMessageSecurity)));

    }

    @AfterTest()
    public void closeBrowser(){

            driver.quit();


    }
}
