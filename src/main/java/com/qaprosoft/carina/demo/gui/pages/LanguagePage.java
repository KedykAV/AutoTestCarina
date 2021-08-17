package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LanguagePage extends AbstractPage {
    @FindBy(xpath = "//span[contains(text(), ' Deutsch ')]")
    private ExtendedWebElement deutsch;
    public LanguagePage(WebDriver driver) {
        super(driver);
    }
    public ExtendedWebElement getDeutsch(){
        return deutsch;
    }
}
