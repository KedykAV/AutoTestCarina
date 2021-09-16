package com.qaprosoft.carina.demo.amazontest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecondTest.class);

    @Test
    public void openListSearch() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getButtonSearchList().click();
        homePage.getSerchBook().click();
        Assert.assertTrue(homePage.getSerchBook().isChecked(), "Button don't search");
    }

    @Test
    public void emptyLoginField() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getLoginButton().click();
        AuthorizationPage authorizationPage = new AuthorizationPage(getDriver());
        authorizationPage.getContButton().click();
        Assert.assertTrue(authorizationPage.getErrorMassege().isElementWithTextPresent("Enter your email or mobile phone number"), "The button was clicked with empty field! ");
    }

    @Test
    public void deleteFromCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
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
        cartPage.getDeleteBtn().click();
        Assert.assertTrue(cartPage.getEmptyCart().isElementWithTextPresent("Your Amazon Cart is empty."), "Cart is not empty");
    }

    @Test
    public void nonExSearch() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getSearchField().type("{фырфыр}");
        homePage.getSearchButton().click();
        SearchPage searchPage = new SearchPage(getDriver());
        Assert.assertTrue(searchPage.getNoResultInfo().isElementWithTextPresent("No results for"), "There is some products");
    }

    @Test
    public void viewCartNumber() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickAllBtn();
        pause(2);
        homePage.clickCompBtn();
        pause(2);
        homePage.clickCcBtn();
        SectionPage sectionPage = new SectionPage(getDriver());
        sectionPage.getProductList().get((int) (Math.random() * 10) + 1).click();
        ProductPage productPage = new ProductPage(getDriver());
        productPage.getAddButton().click();
        Assert.assertFalse(productPage.getCartButton().isElementWithTextPresent("0"), "Product score don't view");
    }
    @Test
    public void invalidEmail(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getLoginButton().click();
        AuthorizationPage authorizationPage = new AuthorizationPage(getDriver());
        authorizationPage.getEmailField().type("qwqew@qeqweqwe.com");
        authorizationPage.getContButton().click();
        authorizationPage.getEmailField().getSize();
        Assert.assertTrue(authorizationPage.getProblemMessage().isElementWithTextPresent("There was a problem"),"You continue with invalid email!");
    }
    @Test
    public void changingDeliverTo(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getChangingDeliverButton().click(2);
        homePage.getListOfCountriesButton().click();
        String selectedCountry = homePage.changeCountry();
        Assert.assertEquals(homePage.getCurrentCountryName(),selectedCountry,"Don't change current country");
        homePage.getDoneButton().click();
        Assert.assertEquals(homePage.getCountryToDelivery(),selectedCountry,"Don't change country to delivery");
    }

}