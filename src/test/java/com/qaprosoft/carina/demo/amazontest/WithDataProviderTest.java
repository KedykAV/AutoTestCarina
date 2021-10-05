package com.qaprosoft.carina.demo.amazontest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WithDataProviderTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(WithDataProviderTest.class);
    @BeforeClass
    public void openSection(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getChangeRegionBtn().click();

    }
    @Test(dataProvider = "SingleDataProvider")
    @XlsDataSourceParameters(path = "xls/alx.xlsx", sheet = "Region", dsUid = "TestID", dsArgs = "Rgn")
    public void changeRegions(String region){
        HomePage homePage = new HomePage(getDriver());
        homePage.getDropDownReg().click();
        homePage.changeRegion(region);
       // homePage.getDropDownReg().format(region).getText();

    }
}
