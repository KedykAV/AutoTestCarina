package com.qaprosoft.carina.demo.gui.pages;


import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;

public class AuthorizationPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationPage.class);

    @FindBy(id = "ap_email")
    private ExtendedWebElement emailField;
    @FindBy(id="continue")
    private ExtendedWebElement contButton;
    @FindBy(id="ap_password")
    private ExtendedWebElement passField;
    @FindBy(id="signInSubmit")
    private ExtendedWebElement signButton;
    @FindBy(xpath = "//div[contains(text(),'Enter your email or mobile phone number')]")
    private ExtendedWebElement errorMassege;
    @FindBy(xpath = "//h4[contains(text(),'There was a problem')]")
    private ExtendedWebElement problemMessage;


    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getProblemMessage() {
        return problemMessage;
    }

    public ExtendedWebElement getErrorMassege() {
        return errorMassege;
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
    public void authorization(){
        getEmailField().type(R.TESTDATA.get("login"));
        getContButton().click();
        getPassField().type(R.TESTDATA.get("password"));
        pause(3);
        getSingButton().click();
    }


    }




