package com.qaprosoft.carina.demo.amazontest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.utils.JCUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class WithJCExecutor implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(WithJCExecutor.class);
    @Test
    public void flashing(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        JCUtils.flash(homePage.getLangButton().getElement(),getDriver());
    }

}
