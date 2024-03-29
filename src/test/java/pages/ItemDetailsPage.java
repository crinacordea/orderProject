package pages;

import HelperFunctions.ManipulateLocaters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.PageObject;

public class ItemDetailsPage extends PageObject {
    private final By sizeXSBy = By.xpath("//div[@class='swatch-option text'and @option-label='XS']");
    private final By orangeColourBy = By.xpath("//div[@class='swatch-option color'and @option-label='Orange']");

    private final By addToCardBtnBy = By.xpath("//*[@type='submit']/span[text()='Add to Cart']");
    private final By shoppingCartBtnBy = By.xpath("//a[contains(@class,'action showcart')]");
    private final By proceedToCheckoutBtnBy = By.id("top-cart-btn-checkout");

    private final By quantatyBy = By.id("qty");

    private final By totalPriceBeforeProceedToCheckoutBy = By.xpath("//*[@class='price-wrapper']/span");

    private final By sizeSelecteBy = By.xpath("//*[@attribute-code='size']/span[@class='swatch-attribute-selected-option']");
    private final By colourSelecteBy = By.xpath("//*[@attribute-code='color']/span[@class='swatch-attribute-selected-option']");



    public ItemDetailsPage(WebDriver driver) {
        super(driver);
    }

    ManipulateLocaters waitelement = new ManipulateLocaters(driver);

    public void selectXSSize() {
        waitelement.clickOnElement(sizeXSBy);
    }

    public void selectOrangeColour() {
        waitelement.clickOnElement(orangeColourBy);
    }



    public void clickAddToCard() {
        waitelement.clickOnElement(addToCardBtnBy);
        waitelement.waitVisibilityOfElement(addToCardBtnBy);
    }

    public void clickShoppingCard() {
        waitelement.clickOnElement(shoppingCartBtnBy);
    }

    public void clickProceedToCheckoutButton() {
        waitelement.clickOnElement(proceedToCheckoutBtnBy);
    }


    public void enterQuantityOfItemsToCard(Integer quantity) {
        driver.findElement(quantatyBy).clear();
        driver.findElement(quantatyBy).sendKeys(String.valueOf(quantity));
    }



    public void addItemsToCard(Integer numberOfItems) {
        selectXSSize();
        selectOrangeColour();
        enterQuantityOfItemsToCard(numberOfItems);
        clickAddToCard();

    }


    public String getSizeSelected(){
return driver.findElement(sizeSelecteBy).getText();

    }

    public String getColourSelected(){
        return driver.findElement(colourSelecteBy).getText();

    }
}


