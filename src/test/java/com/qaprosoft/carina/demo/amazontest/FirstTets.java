package com.qaprosoft.carina.demo.amazontest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FirstTets implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(FirstTets.class);

    @Test()
    public void openPage(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getDriver().close();
    }
    @Test()
    public  void singUP(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getLoginButton().click();
        AuthorizationPage authorizationPage = new AuthorizationPage(getDriver());
        authorizationPage.authorization();
        Assert.assertEquals(homePage.getHelloText(), "Hello, TestLaba21", "User not authorised");
        homePage.getDriver().close();

    }
    @Test()
    public void scrolling(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.scrollToFooter();
        homePage.pause(3);
        homePage.scrollToHeader();
        homePage.pause(3);
        Assert.assertTrue(homePage.scrollToHeader());
        homePage.getDriver().close();

    }
    @Test()
    public void openSection(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.clickAllBtn();
        pause(2);
        homePage.clickCompBtn();
        pause(2);
        homePage.clickCcBtn();
        Assert.assertEquals(homePage.getSectText(), "Computer Components", "Section don't open!");
        getDriver().close();
    }
    @Test()
    public void returnHome(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getSection().click();
        SectionPage sectionPage = new SectionPage(getDriver());
        sectionPage.getNavLogo().click();
        getDriver().getTitle();
        Assert.assertEquals(getDriver().getTitle(), "Amazon.com. Spend less. Smile more.", "Don't return to Home Page");
        getDriver().close();

    }
    @Test
    public void searchLoad() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getSearchField().type("samsung");
        homePage.getSearchButton().click();
        SearchPage searchPage = new SearchPage(getDriver());
        Assert.assertTrue(searchPage.getResults().get(1).getText().contains("SAMSUNG"));
        getDriver().close();
    }
    @Test()
    public void openProduct(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.clickAllBtn();
        pause(2);
        homePage.clickCompBtn();
        pause(2);
        homePage.clickCcBtn();
        SectionPage sectionPage = new SectionPage(getDriver());
        sectionPage.getProductList().get(1).click();
        ProductPage productPage = new ProductPage(getDriver());
        Assert.assertTrue(productPage.getAddButton().isElementPresent());
        getDriver().close();
    }
    @Test()
    public void changingLanguage(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getLangButton().click();
        LanguagePage languagePage = new LanguagePage(getDriver());
        languagePage.clickDE();
        Assert.assertEquals(languagePage.getTextLang(), "deutsch", "Don't change language");
        getDriver().close();
        //question!

    }
    @Test()
    public void addToCart(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.clickAllBtn();
        pause(2);
        homePage.clickCompBtn();
        pause(2);
        homePage.clickCcBtn();
        SectionPage sectionPage = new SectionPage(getDriver());
        sectionPage.getProductList().get(1).click();
        ProductPage productPage = new ProductPage(getDriver());
        productPage.getAddButton().click();
        pause(2);
        productPage.getCartButton().click();
        CartPage cartPage = new CartPage(getDriver());
        Assert.assertTrue(cartPage.getProceedBtn().isElementPresent());
        getDriver().close();

    }


    @Test()
    public void buyingProduct(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getLoginButton().click();
        AuthorizationPage authorizationPage = new AuthorizationPage(getDriver());
        authorizationPage.authorization();
        Assert.assertEquals(homePage.getHelloText(), "Hello, TestLaba21", "User not authorised");
        homePage.clickAllBtn();
        pause(2);
        homePage.clickCompBtn();
        pause(2);
        homePage.clickCcBtn();
        SectionPage sectionPage = new SectionPage(getDriver());
        sectionPage.getProductList().get(1).click();
        ProductPage productPage = new ProductPage(getDriver());
        productPage.getBuyButton().click();
        BuyPage buyPage = new BuyPage(getDriver());
        Assert.assertEquals(buyPage.selectAddressText(),"Select a shipping address", "Buying page not open");
        getDriver().close();

    }







}
