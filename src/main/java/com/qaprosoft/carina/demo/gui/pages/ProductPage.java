package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductPage.class);

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private ExtendedWebElement addButton;

    @FindBy(xpath = "//a[@class='a-link-normal close-button']")
    private ExtendedWebElement closeButton;

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//input[contains(@id, 'buy')]")
    private ExtendedWebElement buyButton;



    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getAddButton(){
        return addButton;
    }
    public ExtendedWebElement getCloseButton(){
        return closeButton;
    }
    public ExtendedWebElement getCartButton() {
        return cartButton;
    }
    public ExtendedWebElement getBuyButton() {
        return buyButton;
    }

}
