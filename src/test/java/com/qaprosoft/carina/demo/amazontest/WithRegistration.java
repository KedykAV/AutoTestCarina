package com.qaprosoft.carina.demo.amazontest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class WithRegistration implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(WithRegistration.class);

    @BeforeClass
    public void singIn() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getLoginButton().click();
        AuthorizationPage authorizationPage = new AuthorizationPage(getDriver());
        authorizationPage.authorization();
        Assert.assertEquals(homePage.getHelloText(), "Hello, TestLaba21", "User not authorised");
    }



    @Test()
    public void buyingProduct() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickAllBtn();
        pause(2);
        homePage.clickCompBtn();
        pause(2);
        homePage.clickCcBtn();
        SectionPage sectionPage = new SectionPage(getDriver());
        sectionPage.getProductList().get(2).click();
        ProductPage productPage = new ProductPage(getDriver());
        productPage.getBuyButton().click();
        BuyPage buyPage = new BuyPage(getDriver());
        Assert.assertEquals(buyPage.selectAddressText(), "Select a shipping address", "Buying page not open");
    }

    @Test
    public void isProductSavedInCartAfterSingInOut(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickAllBtn();
        pause(2);
        homePage.clickCompBtn();
        pause(2);
        homePage.clickCcBtn();
        SectionPage sectionPage = new SectionPage(getDriver());
        sectionPage.getProductList().get(2).click();
        ProductPage productPage = new ProductPage(getDriver());
        productPage.getAddButton().click();
        productPage.getCloseButton().clickIfPresent();
    }


}
