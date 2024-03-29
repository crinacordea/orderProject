package interactions;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;

import pageObject.PageObject;

public class DropDownPage extends PageObject {

    public DropDownPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectByText(By locator, String text) throws Exception {
        Select objSelect = new Select(driver.findElement(locator));
        objSelect.selectByValue(text);

    }

    public void selectByText(By locator, Integer index) throws Exception {
        Select objSelect = new Select(driver.findElement(locator));
        objSelect.selectByIndex(index);

    }
}

