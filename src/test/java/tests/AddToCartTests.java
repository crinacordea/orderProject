package tests;


import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.util.concurrent.TimeUnit;

public class AddToCartTests {
    private static final WebDriver driver = new ChromeDriver();
    SoftAssert softAssert = new SoftAssert();

    @Test(
            description = "Test the happy flow of ordering items and place the order successfully and check that total amount is calculate correctly(minus discount and plus shipping cost) before placing the order "
    )
    public void placeOrderSuccessfully() throws Exception {

        driver.get(Utils.BASE_URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.searchItem("jacket");
        CatalogResultPage catalogResultPage = new CatalogResultPage(driver);
        catalogResultPage.selectItem("Adrienne Trek Jacket");
        ItemDetailsPage itemDetailsPage = new ItemDetailsPage(driver);
        Integer quantity = 5;
        itemDetailsPage.addItemsToCard(quantity);
        itemDetailsPage.clickShoppingCard();
        itemDetailsPage.clickProceedToCheckoutButton();
        ShippingDetailsPage shippingDetailsPage = new ShippingDetailsPage(driver);
        shippingDetailsPage.enterEmail("ffd@fvfd.com");
        shippingDetailsPage.enterFirstName("Adriane");
        shippingDetailsPage.enterLastName("Lauren");
        shippingDetailsPage.enterCompany("Philips");
        shippingDetailsPage.enterCity("sdfd");
        shippingDetailsPage.enterStreetAddress("Street Marte, No 5");
        shippingDetailsPage.enterZipCode("45566");
        shippingDetailsPage.selectRegionFomDropDownByIndex(1);
        shippingDetailsPage.selectCountryFomDropDownByIndex(1);
        shippingDetailsPage.enterCity("dsfsd");
        shippingDetailsPage.enterPhone("0044566666");
        shippingDetailsPage.clickNextButton();
        ReviewAndPaymentPage reviewAndPaymentPage = new ReviewAndPaymentPage(driver);
        softAssert.assertEquals(reviewAndPaymentPage.getTotalPrice(), reviewAndPaymentPage.calculateTotalPrice(), reviewAndPaymentPage.getTotalPrice() + "is not equal to " + reviewAndPaymentPage.calculateTotalPrice());
        reviewAndPaymentPage.clickPlaceOrderButton();
        ConfirmationOrderPage confirmationOrderPage = new ConfirmationOrderPage(driver);
        softAssert.assertEquals(confirmationOrderPage.getConfirmationMessage(), Constants.Order.CONFIRMATION_ORDER_MESSAGE, confirmationOrderPage.getConfirmationMessage() + " is not equal to " + Constants.Order.CONFIRMATION_ORDER_MESSAGE);
        softAssert.assertAll();


    }


    @Test(
            description = "Place and order:Test the shipping cost is selected 'ItemDetailsPage' and is applied in 'Order Summary' section in 'ReviewAndPaymentsPage' before submiting the order"
    )
    public void orderAndVerifyShippingCost() throws Exception {

        driver.get(Utils.BASE_URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.searchItem("jacket");
        CatalogResultPage catalogResultPage = new CatalogResultPage(driver);
        catalogResultPage.selectItem("Adrienne Trek Jacket");
        ItemDetailsPage itemDetailsPage = new ItemDetailsPage(driver);
        Integer quantity = 5;
        itemDetailsPage.addItemsToCard(quantity);
        itemDetailsPage.clickShoppingCard();
        itemDetailsPage.clickProceedToCheckoutButton();
        ShippingDetailsPage shippingDetailsPage = new ShippingDetailsPage(driver);
        shippingDetailsPage.enterEmail("test@test.com");
        shippingDetailsPage.enterFirstName("Adriane");
        shippingDetailsPage.enterLastName("Lauren");
        shippingDetailsPage.enterCompany("Philips");
        shippingDetailsPage.enterCity("Wien");
        shippingDetailsPage.enterStreetAddress("Street Marte, No 5");
        shippingDetailsPage.enterZipCode("45566");
        shippingDetailsPage.selectRegionFomDropDownByIndex(1);
        shippingDetailsPage.selectCountryFomDropDownByIndex(1);
        shippingDetailsPage.enterPhone("0044566666");
        softAssert.assertTrue(shippingDetailsPage.isShippingCostChecked());
        Float shippingCost = shippingDetailsPage.shippingCostSelected();
        shippingDetailsPage.clickNextButton();
        ReviewAndPaymentPage reviewAndPaymentPage = new ReviewAndPaymentPage(driver);
        softAssert.assertEquals(reviewAndPaymentPage.getShippingCost(), shippingCost, reviewAndPaymentPage.getShippingCost() + "is not equal to " + shippingCost);
        reviewAndPaymentPage.clickPlaceOrderButton();
        ConfirmationOrderPage confirmationOrderPage = new ConfirmationOrderPage(driver);
        softAssert.assertEquals(confirmationOrderPage.getConfirmationMessage(), Constants.Order.CONFIRMATION_ORDER_MESSAGE, confirmationOrderPage.getConfirmationMessage() + " is not equal to " + Constants.Order.CONFIRMATION_ORDER_MESSAGE);
        softAssert.assertAll();


    }

    @Test(
            description = "Place an order:Test the item name, size and colour selected when selecting an item, and check in OrderSummary section from 'ReviewAndPayments page' if displayed correctly "
    )
    public void orderItemsAndVerifyDetailsOfItems() throws Exception {

        driver.get(Utils.BASE_URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.searchItem("jacket");
        CatalogResultPage catalogResultPage = new CatalogResultPage(driver);
        catalogResultPage.selectItem("Adrienne Trek Jacket");
        ItemDetailsPage itemDetailsPage = new ItemDetailsPage(driver);
        Integer quantity = 5;
        itemDetailsPage.addItemsToCard(quantity);
        String itemSize = itemDetailsPage.getSizeSelected();
        String itemColour = itemDetailsPage.getColourSelected();
        itemDetailsPage.clickShoppingCard();
        itemDetailsPage.clickProceedToCheckoutButton();
        ShippingDetailsPage shippingDetailsPage = new ShippingDetailsPage(driver);
        shippingDetailsPage.enterEmail("test@test.com");
        shippingDetailsPage.enterFirstName("Adriane");
        shippingDetailsPage.enterLastName("Lauren");
        shippingDetailsPage.enterCompany("Philips");
        shippingDetailsPage.enterCity("Wien");
        shippingDetailsPage.enterStreetAddress("Street Marte, No 5");
        shippingDetailsPage.enterZipCode("45566");
        shippingDetailsPage.selectRegionFomDropDownByIndex(1);
        shippingDetailsPage.selectCountryFomDropDownByIndex(1);
        shippingDetailsPage.enterPhone("0044566666");
        softAssert.assertTrue(shippingDetailsPage.isShippingCostChecked());
        shippingDetailsPage.clickNextButton();
        ReviewAndPaymentPage reviewAndPaymentPage = new ReviewAndPaymentPage(driver);
        reviewAndPaymentPage.clickExpandItemDetail();
        softAssert.assertEquals(itemColour, reviewAndPaymentPage.getItemColour(), itemColour + " is not equal " + reviewAndPaymentPage.getItemColour());
        softAssert.assertEquals(itemSize, reviewAndPaymentPage.getItemSize(), itemSize + " is not equal " + reviewAndPaymentPage.getItemSize());
        reviewAndPaymentPage.clickPlaceOrderButton();
        softAssert.assertAll();


    }

    @AfterTest()
    public void closeBrowser() {

        driver.quit();


    }
}
