package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class LanguagePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(LanguagePage.class);
    @FindBy(xpath = "//span[contains(text(), ' Deutsch ')]")
    private ExtendedWebElement deutsch;
    @FindBy(css = "input[type='radio']")
    private List<ExtendedWebElement> radioLangButtons;
    public LanguagePage(WebDriver driver) {
        super(driver);
    }
    public void clickDE(){
        deutsch.click();
    }
    public String getTextLang(){

        return deutsch.getText();
    }
    public boolean isAnyRadioButtonChecked() {
        for (ExtendedWebElement radBut : radioLangButtons) {
            if (radBut.isChecked()) {
                return true;
            }
        }
        return false;
    }
    public boolean clickableAllRadioButton(){
        for(ExtendedWebElement radBut: radioLangButtons){
            if(radBut.isClickable()){
                return true;
            }
        }
        return false;
    }
    public void clickAllRadioButtons(){
        SoftAssert softAssert = new SoftAssert();
        for(int i = 1; i < radioLangButtons.size(); i++){
             radioLangButtons.get(i).click();
             softAssert.assertTrue(radioLangButtons.get(i).isChecked());
        }
        softAssert.assertAll();
    }
    }
