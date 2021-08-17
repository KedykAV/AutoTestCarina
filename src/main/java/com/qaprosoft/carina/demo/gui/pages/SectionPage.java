package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.Items;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Random;


public class SectionPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//h2[contains(text(), ' Seagate ')]")
    private ExtendedWebElement product;
    @FindBy(xpath = "//div[@id='nav-logo']")
    private ExtendedWebElement navLogo;
    @FindBy(xpath = "//div[contains(@class, 'a-image-container')]")
    private List<ExtendedWebElement> productList;


    public SectionPage(WebDriver driver) {
        super(driver);
    }
    public  ExtendedWebElement getProduct(){
        return product;
    }
    public ExtendedWebElement getNavLogo(){
        return navLogo;
    }
    public List<ExtendedWebElement> getProductList(){
        return productList;
    }

}
