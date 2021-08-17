package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1[contains(text(), 'Your')]")
    private ExtendedWebElement emptyCart;
    public String getEmptyCart(){
        return emptyCart.getText();
    }


}
