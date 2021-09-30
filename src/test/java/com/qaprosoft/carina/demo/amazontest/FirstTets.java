package com.qaprosoft.carina.demo.amazontest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FirstTets implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(FirstTets.class);

    @BeforeMethod
    public void openSite(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }
   // @AfterMethod
   // public void closeDriver(){
   //     getDriver().close();
   // }


    @Test()
    public  void singUP(){
        HomePage homePage = new HomePage(getDriver());
        homePage.getLoginButton().click();
        AuthorizationPage authorizationPage = new AuthorizationPage(getDriver());
        authorizationPage.authorization();
        Assert.assertEquals(homePage.getHelloText(), "Hello, TestLaba21", "User not authorised");


    }
    @Test()
    public void scrolling(){
        HomePage homePage = new HomePage(getDriver());
        homePage.scrollToFooter();
        homePage.pause(3);
        homePage.scrollToHeader();
        homePage.pause(3);
        Assert.assertTrue(homePage.scrollToHeader());


    }
    @Test()
    public void openSection(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickAllBtn();
        pause(2);
        homePage.clickCompBtn();
        pause(2);
        homePage.clickCcBtn();
        Assert.assertEquals(homePage.getSectText(), "Computer Components", "Section don't open!");

    }
    @Test()
    public void returnHome(){
        HomePage homePage = new HomePage(getDriver());
        homePage.getSection().click();
        SectionPage sectionPage = new SectionPage(getDriver());
        sectionPage.getNavLogo().click();
        homePage.getTitle();
        Assert.assertEquals(homePage.getTitle(), "Amazon.com. Spend less. Smile more.", "Don't return to Home Page");


    }
    @Test
    public void searchLoad() {
        HomePage homePage = new HomePage(getDriver());
        homePage.getSearchField().type("samsung");
        homePage.getSearchButton().click();
        SearchPage searchPage = new SearchPage(getDriver());
        Assert.assertTrue(searchPage.getResults().get(1).getText().contains("SAMSUNG"));
    }
    @Test()
    public void openProduct(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickAllBtn();
        pause(2);
        homePage.clickCompBtn();
        pause(2);
        homePage.clickCcBtn();
        SectionPage sectionPage = new SectionPage(getDriver());
        sectionPage.getProductList().get(2).click();
        ProductPage productPage = new ProductPage(getDriver());
        Assert.assertTrue(productPage.getAddButton().isElementPresent());
    }


    @Test()
    public void addToCart(){
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
        pause(2);
        productPage.getCartButton().click();
        CartPage cartPage = new CartPage(getDriver());
        Assert.assertTrue(cartPage.getProceedBtn().isElementPresent());
    }

}
