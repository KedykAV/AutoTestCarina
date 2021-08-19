package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BuyPage extends AbstractPage {
    public BuyPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1[contains(text(),'Select a shipping address')]")
    private ExtendedWebElement selectAddress;
    public String selectAddressText(){return selectAddress.getText();}
}
