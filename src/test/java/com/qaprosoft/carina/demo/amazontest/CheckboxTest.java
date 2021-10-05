package com.qaprosoft.carina.demo.amazontest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.SectionPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckboxTest implements IAbstractTest {
    SectionPage sectionPage = new SectionPage(getDriver());
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
        sectionPage.validateCheckedAllCheckbox();
        /*SoftAssert softAssert = new SoftAssert();
        for(int i = 0; i<sectionPage.getBrandsCheckbox().size();i++){
            sectionPage.getBrandsCheckbox().get(i).click();
            pause(2);
            softAssert.assertTrue(sectionPage.getBrandsCheckbox().get(i).isChecked(),"Checkbox don't check");
        }
        softAssert.assertAll();*/
    }
    @Test()
    public void visibilityClearCheckboxButton(){
        sectionPage.getBrandsCheckbox().get(0).click(1);
        Assert.assertTrue(sectionPage.getClearCheckboxButton().isVisible()||sectionPage.getClearCheckboxButton().isElementPresent(),"Clear button don't visible!");
    }
    @Test
    public void clearingCheckboxes(){
       sectionPage.getBrandsCheckbox().get(0).click(1);
       sectionPage.getClearCheckboxButton().click();
       Assert.assertFalse(sectionPage.getBrandsCheckbox().get(0).isChecked(),"Checkbox don't clearing!");
    }


}
