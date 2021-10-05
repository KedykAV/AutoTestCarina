/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.gui.pages;

import java.util.List;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.testng.Assert;


public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    @FindBy(xpath = "//input[@type='email']")
    private ExtendedWebElement emailField;
    @FindBy(xpath = "//span[@class='icp-nav-flag icp-nav-flag-us']")
    private ExtendedWebElement langButton;

    @FindBy(id = "twotabsearchtextbox")
    private ExtendedWebElement searchField;
    @FindBy(id = "nav-search-submit-button")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//img[contains(@alt,'Computers')]//parent::div[contains(@class,'a-section')]")
    private ExtendedWebElement section;
    @FindBy(xpath = "//span[contains(text(),'Hello, ') ]")
    private ExtendedWebElement hello;
    @FindBy(xpath = "//span[contains(text(),'Hello, TestLaba21') ]")
    private ExtendedWebElement helloTest;
    @FindBy(xpath = "//div[contains(@class,'a-cardui fluid')]")
    private List<ExtendedWebElement> sectors;
    @FindBy(className = "news-column-index")
    private ExtendedWebElement openpage;
    @FindBy(xpath = "//a[contains(text( ),  'Conditions ')]")
    private ExtendedWebElement footer;
    @FindBy(xpath = "//i[@class='hm-icon nav-sprite']")
    private ExtendedWebElement allBtn;
    @FindBy(xpath = "//div[contains(text(),'Computers')]")
    private ExtendedWebElement compBtn;
    @FindBy(xpath = "//a[contains(text(),'Computer Components')]")
    private ExtendedWebElement ccBtn;
    @FindBy(xpath = "//span[contains(text(), 'Computer Components')]//parent::span[@class='a-list-item']")
    private ExtendedWebElement sectText;
    @FindBy(xpath = "//option[contains(text(),'Books')]")
    private ExtendedWebElement serchBook;
    @FindBy(xpath = "//span[@id='searchDropdownDescription']/parent::div")
    private ExtendedWebElement buttonSearchList;
    @FindBy(xpath = "//span[contains(text(),'Deliver to')]")
    private ExtendedWebElement changingDeliverButton;
    @FindBy(xpath = "//span[contains(@class,'a-dropdown-prompt')] ")
    private ExtendedWebElement listOfCountriesButton;
    @FindBy(xpath = "//a[contains(@href,'javascript:void(0)')]/parent::li")
    private List<ExtendedWebElement> countries;
    @FindBy(xpath = "//button[contains(text(),'Done')]")
    private ExtendedWebElement doneButton;
    @FindBy (xpath = "//span[contains(@class, 'nav-line-2 nav-progressive-content')]")
    private ExtendedWebElement countryToDelivery;
    @FindBy (xpath = "//a[@class='a-dropdown-link']/descendant-or-self::span[contains(text(),'%s')]")
    private ExtendedWebElement regions;
    @FindBy (xpath = "//a[@id='icp-touch-link-country']")
    private ExtendedWebElement changeRegionBtn;
    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    private ExtendedWebElement dropDownReg;


    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public String getCountryToDelivery() {
        return countryToDelivery.getText();
    }

    public ExtendedWebElement getDoneButton() {
        return doneButton;
    }

    public ExtendedWebElement getSerchBook() {
        return serchBook;
    }

    public ExtendedWebElement getButtonSearchList() {
        return buttonSearchList;
    }

    public ExtendedWebElement getLoginButton() {
        return hello;
    }

    public void clickAllBtn() {
        allBtn.click(3);
    }

    public void clickCompBtn() {
        compBtn.click();
    }

    public void clickCcBtn() {
        ccBtn.click();
    }

    public String getSectText() {
        return sectText.getText();
    }

    public ExtendedWebElement getChangingDeliverButton() {
        return changingDeliverButton;
    }

    public ExtendedWebElement getListOfCountriesButton() {
        return listOfCountriesButton;
    }

    public String getHelloText() {
        return helloTest.getText();
    }

    public ExtendedWebElement getFooter() {
        return footer;
    }

    public void scrollToFooter() {
        footer.scrollTo();
    }

    public boolean scrollToHeader() {
        hello.scrollTo();
        return true;
    }


    public ExtendedWebElement getSection() {
        return section;
    }

    public ExtendedWebElement getSearchField() {
        return searchField;
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public ExtendedWebElement getLangButton() {
        return langButton;
    }

    public List<ExtendedWebElement> getSectors() {
        return sectors;
    }

    public List<ExtendedWebElement> getCountries() {
        return countries;
    }

    public String getCurrentCountryName() {
        return listOfCountriesButton.getText();
    }

    public String changeCountry() {
        int countryIndex = (int) (Math.random() * 246);
        ExtendedWebElement currentCountry = countries.get(countryIndex);
        String nameCountry = currentCountry.getText();
        currentCountry.click();
        return nameCountry;
    }

    public ExtendedWebElement getChangeRegionBtn() {
        return changeRegionBtn;
    }
    public void  changeRegion(String reg){
        regions.format(reg).click();
    }

    public ExtendedWebElement getDropDownReg() {
        return dropDownReg;
    }

}

