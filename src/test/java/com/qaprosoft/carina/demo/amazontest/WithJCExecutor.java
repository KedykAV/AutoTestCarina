package com.qaprosoft.carina.demo.amazontest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.utils.JCUtils;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class WithJCExecutor implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(WithJCExecutor.class);
    @Test
    public void flashing() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        JCUtils.flash(homePage.getLangButton().getElement(),getDriver());
    }
    @Test
    public void display() throws IOException {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        JCUtils.drawBorder(homePage.getLangButton().getElement(),getDriver());
        File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtil.copyFile(src, new File("/Users/akedyk/first.png"));
    }

}
