package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LanguagePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(LanguagePage.class);
    @FindBy(xpath = "//span[contains(text(), ' Deutsch ')]")
    private ExtendedWebElement deutsch;
    public LanguagePage(WebDriver driver) {
        super(driver);
    }
    public void clickDE(){
        deutsch.click();
    }
    public ExtendedWebElement getTextLang(){
        deutsch.getText();
        return deutsch;
    }
}
