package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObject.PageObject;

public class CatalogResultPage extends PageObject {
    private String itemXpath = "//li[@class= 'item product product-item']";
    private String itemNameXpath = itemXpath + "/descendant::a[@class='product-item-link'and normalize-space(text())='%s']";
    private By getItemNameLocator(String itemName) {
        return By.xpath(String.format(itemNameXpath, itemName));
    }

    public CatalogResultPage(WebDriver driver) {
        super(driver);
    }

    public void selectItem(String itemName) {
        driver.findElement(getItemNameLocator(itemName)).click();
    }
}