package pages;

import HelperFunctions.ManipulateLocaters;
import interactions.DropDownPage;
import org.openqa.selenium.*;
import pageObject.PageObject;

public class ShippingDetailsPage extends PageObject {
    private final By emailAddressBy = By.id("customer-email");
    private final By firstNameBy = By.xpath("//*[@class= 'input-text'  and @name ='firstname']");
    private final By lastNameBy = By.xpath("//*[@class= 'input-text'  and @name ='lastname']");
    private final By companyBy = By.xpath("//*[@class= 'input-text'  and @name ='company']");
    private final By streetAddressBy = By.xpath("//*[@class= 'input-text'  and @name ='street[0]']");
    private final By cityBy = By.xpath("//*[@class= 'input-text'  and @name ='city']");
    private final By regionBy = By.xpath("//*[@class= 'select'  and @name ='region_id']");
    private final By zipCodeBy = By.xpath("//*[@class= 'input-text'  and @name ='postcode']");
    private final By countryBy = By.xpath("//*[@class= 'select'  and @name ='country_id']");
    private final By phoneNumberBy = By.xpath("//*[@class= 'input-text'  and @name ='telephone']");

    private final By firstSheepingMethodRadioButtonBy = By.xpath("//*[@class= 'table-checkout-shipping-method']//input[@class='radio'][1]");

    private final By nextBtnBy = By.xpath("//div[@id= 'shipping-method-buttons-container']//button");
    private final By radioButtonSheepingCheckedBy = By.xpath("//*[@type='radio' and @checked='true']");
private final By shippingCostSelectedBy = By.xpath("//*[@type='radio' and @checked='true']//ancestor::tr//span/span");


    public ShippingDetailsPage(WebDriver driver) {
        super(driver);
    }

    ManipulateLocaters waitelement = new ManipulateLocaters(driver);

    public void enterEmail(String emailAddress) {
        waitelement.waitVisibilityOfElement(emailAddressBy);
        driver.findElement(emailAddressBy).sendKeys(emailAddress);
    }

    public void enterFirstName(String firstName) {
        waitelement.waitVisibilityOfElement(firstNameBy);
        driver.findElement(firstNameBy).sendKeys(firstName);
    }

    public void enterCompany(String company) {
        waitelement.waitVisibilityOfElement(companyBy);
        driver.findElement(companyBy).sendKeys(company);
    }


    public void enterLastName(String lastName) {
        waitelement.waitVisibilityOfElement(lastNameBy);
        driver.findElement(lastNameBy).sendKeys(lastName);
    }

    public void enterStreetAddress(String streetAddress) {
        waitelement.waitVisibilityOfElement(streetAddressBy);
        driver.findElement(streetAddressBy).sendKeys(streetAddress);
    }

    public void enterCity(String city) {
        waitelement.waitVisibilityOfElement(cityBy);
        driver.findElement(cityBy).sendKeys(city);
    }

    public void selectRegionFomDropDownByIndex(Integer index) throws Exception {
        DropDownPage dropDownPage = new DropDownPage(driver);
        dropDownPage.selectByText(regionBy, index);
    }

    public void enterZipCode(String zipCode) {
        waitelement.waitVisibilityOfElement(zipCodeBy);
        driver.findElement(zipCodeBy).sendKeys(zipCode);
    }

    public void selectCountryFomDropDownByIndex(Integer index) throws Exception {
        DropDownPage dropDownPage = new DropDownPage(driver);
        dropDownPage.selectByText(countryBy, index);
    }


    public void enterPhone(String phone) {
        waitelement.waitVisibilityOfElement(phoneNumberBy);
        driver.findElement(phoneNumberBy).sendKeys(phone);
    }

    public void clickNextButton() throws InterruptedException {
        try {
            ManipulateLocaters manipulateLocaters = new ManipulateLocaters(driver);
            manipulateLocaters.waitAttributeContains("style", "display: none;");
        }
        catch(Exception e)
        {System.out.println("loading bar is not displayed");}
        waitelement.waitVisibilityOfElement(nextBtnBy);
        driver.findElement(nextBtnBy).click();
    }

    public Boolean isShippingCostChecked() {
        return waitelement.isElementDisplayed(radioButtonSheepingCheckedBy);
    }

    public Float shippingCostSelected(){
        String price = driver.findElement(shippingCostSelectedBy).getText().toString();
        price = price.replaceAll("\\$","");
        Float priceInt = Float.parseFloat(price);
        return priceInt;
    }
}

