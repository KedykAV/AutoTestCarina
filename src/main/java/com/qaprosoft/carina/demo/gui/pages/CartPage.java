package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartPage.class);
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input [@name='proceedToRetailCheckout']")
    private ExtendedWebElement proceedBtn;
    public ExtendedWebElement getProceedBtn(){return proceedBtn;}



}
