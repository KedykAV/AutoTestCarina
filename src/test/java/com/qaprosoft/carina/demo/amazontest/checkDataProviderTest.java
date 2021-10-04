package com.qaprosoft.carina.demo.amazontest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.SectionPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class checkDataProviderTest implements IAbstractTest {
    @BeforeClass
    public void openSection(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.clickAllBtn();
        homePage.clickCompBtn();
        homePage.clickCcBtn();
    }
    @Test()
    public void switchCheckboxBrands(){
        SectionPage sectionPage = new SectionPage(getDriver());
        sectionPage.validateCheckedAllCheckbox();
        /*SoftAssert softAssert = new SoftAssert();
        for(int i = 0; i<sectionPage.getBrandsCheckbox().size();i++){
            sectionPage.getBrandsCheckbox().get(i).click();
            pause(2);
            softAssert.assertTrue(sectionPage.getBrandsCheckbox().get(i).isChecked(),"Checkbox don't check");
        }
        softAssert.assertAll();*/
    }
}
