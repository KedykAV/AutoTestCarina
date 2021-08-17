package com.qaprosoft.carina.demo.amazontest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FirstTets implements IAbstractTest {
    @Test()
    public void openPage(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }
    @Test()
    public  void singUP(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getLoginButton().click();
        AuthorizationPage authorizationPage = new AuthorizationPage(getDriver());
        authorizationPage.getEmailField().type("alx.cyberskn@gmail.com");
        authorizationPage.getContButton().click();
        authorizationPage.getPassField().type("7T6-KNg-e5p-VSp");
        authorizationPage.pause(3);
        authorizationPage.getSingButton().click();
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
    }
    @Test()
    public void openSection(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getSectors().get(2).click();
    }
    @Test()
    public void returnHome(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getSection().click();
        SectionPage sectionPage = new SectionPage(getDriver());
        sectionPage.getNavLogo().click();
    }
    @Test
    public void searchLoad() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getSearchField().type("samsung");
        homePage.getSearchButton().click();
    }
    @Test()
    public void openProduct(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getSection().click();
        SectionPage sectionPage = new SectionPage(getDriver());
        sectionPage.getProduct().click();
    }
    @Test()
    public void changingLanguage(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getLangButton().click();
        LanguagePage languagePage = new LanguagePage(getDriver());
        languagePage.getDeutsch().click();
        languagePage.pause(5);
    }
    @Test()
    public void addToCart(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getSection().click();
        SectionPage sectionPage = new SectionPage(getDriver());
        sectionPage.getProductList().get(1).click();
        ProductPage productPage = new ProductPage(getDriver());
        productPage.getAddButton().click();
        productPage.pause(3);
        productPage.getCloseButton().click();
        productPage.pause(5);
        productPage.getCartButton().click();

    }
    @Test()
    public void selectProduct(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getSectors().get(1).click();
        SectionPage sectionPage = new SectionPage(getDriver());
        sectionPage.getProductList().get(1).click();
    }

    @Test()
    public void buyingProduct(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getLoginButton().click();
        AuthorizationPage authorizationPage = new AuthorizationPage(getDriver());
        authorizationPage.getEmailField().type("alx.cyberskn@gmail.com");
        authorizationPage.getContButton().click();
        authorizationPage.getPassField().type("7T6-KNg-e5p-VSp");
        authorizationPage.pause(3);
        authorizationPage.getSingButton().click();
        homePage.pause(6);
        homePage.getSection().click();
        SectionPage sectionPage = new SectionPage(getDriver());
        sectionPage.getProductList().get(1).click();
        ProductPage productPage = new ProductPage(getDriver());
        productPage.getBuyButton().click();
    }






}
