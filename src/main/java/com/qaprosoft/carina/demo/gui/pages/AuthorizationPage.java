package com.qaprosoft.carina.demo.gui.pages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;

public class AuthorizationPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "ap_email")
    private ExtendedWebElement emailField;
    @FindBy(id="continue")
    private ExtendedWebElement contButton;
    @FindBy(id="ap_password")
    private ExtendedWebElement passField;
    @FindBy(id="signInSubmit")
    private ExtendedWebElement signButton;

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }
    public ExtendedWebElement getEmailField(){
        return emailField;
    }
    public ExtendedWebElement getContButton(){
        return contButton;
    }
    public ExtendedWebElement getPassField(){
        return passField;
    }
    public ExtendedWebElement getSingButton(){
        return signButton;
    }


}
