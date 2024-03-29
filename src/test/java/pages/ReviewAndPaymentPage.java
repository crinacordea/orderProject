package pages;

import HelperFunctions.ManipulateLocaters;
import interactions.DropDownPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.PageObject;

public class ReviewAndPaymentPage extends PageObject {
    private final By placeOrderBtnBy = By.xpath("//div[@class= 'actions-toolbar']//button[@type='submit']/span[text()='Place Order']");
    private final By totalAmountDiscountAndShippingBy = By.xpath("//*[@class='grand totals']//span");
    private final By discountBy = By.xpath("//*[@class='totals discount']//td[@class='amount']//span");
    private final By shippingCost = By.xpath("//*[@class='totals shipping excl']//td[@class='amount']//span");
    private final By totalAmountWithoutDiscountAndShippingBy = By.xpath("//*[@class='totals sub']//span");

    private final By itemSize = By.xpath("//*[@class='product-item']//dl[@class='item-options']//dt[text()='Size']/ancestor::dl//dd[1]");
    private final By itemColour = By.xpath("//*[@class='product-item']//dl[@class='item-options']//dt[text()='Color']/ancestor::dl//dd[2]");
    private final By expandItemListBy = By.xpath("//*[@class='opc-block-summary']//div[@class='block items-in-cart']");
    private final By detailsExpandBtnBy = By.xpath("    //*[@class='opc-block-summary']//div[@class='product options']");

    public ReviewAndPaymentPage(WebDriver driver) {
        super(driver);
    }

    ManipulateLocaters waitelement = new ManipulateLocaters(driver);


    public void clickPlaceOrderButton() {
        try {
            ManipulateLocaters manipulateLocaters = new ManipulateLocaters(driver);
            manipulateLocaters.waitAttributeContains("style", "display: none;");
        } catch (Exception e) {
            System.out.println("loading bar is not displayed");
        }
        waitelement.waitVisibilityOfElement(placeOrderBtnBy);

        driver.findElement(placeOrderBtnBy).click();
    }

    public Float getTotalPrice() {
        try {
            ManipulateLocaters manipulateLocaters = new ManipulateLocaters(driver);
            manipulateLocaters.waitAttributeContains("style", "display: none;");
        } catch (Exception e) {
            System.out.println("loading bar is not displayed");
        }
        String price = driver.findElement(totalAmountDiscountAndShippingBy).getText().toString();
        price = price.replaceAll("\\$", "");
        Float priceInt = Float.parseFloat(price);
        return priceInt;
    }


    public Float getDiscount() {
        String price = driver.findElement(discountBy).getText().toString();
        price = price.replaceAll("\\$", "");
        price = price.replaceAll("\\-", "");
        Float priceInt = Float.parseFloat(price);
        return priceInt;
    }


    public Float getShippingCost() {
        String price = driver.findElement(shippingCost).getText().toString();
        price = price.replaceAll("\\$", "");
        Float priceInt = Float.parseFloat(price);
        return priceInt;
    }

    public Float getTotalAmountWithoutShippingAndDiscount() {
        String price = driver.findElement(totalAmountWithoutDiscountAndShippingBy).getText().toString();
        price = price.replaceAll("\\$", "");
        Float priceInt = Float.parseFloat(price);
        return priceInt;
    }

    public Float calculateTotalPrice() {
        return (getTotalAmountWithoutShippingAndDiscount() - getDiscount()) + getShippingCost();
    }


    public String getItemSize() {
        return driver.findElement(itemSize).getText();

    }

    public String getItemColour() {
        return driver.findElement(itemColour).getText();

    }

    public void clickExpandItemDetail() {
        try {
            ManipulateLocaters manipulateLocaters = new ManipulateLocaters(driver);
            manipulateLocaters.waitAttributeContains("style", "display: none;");
        } catch (Exception e) {
            System.out.println("loading bar is not displayed");
        }
        waitelement.clickOnElement(expandItemListBy);
        waitelement.clickOnElement(detailsExpandBtnBy);

    }
}

