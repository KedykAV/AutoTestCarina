package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class SectionPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(SectionPage.class);

    @FindBy(xpath = "//h2[contains(text(), 'Seagate')]")
    private ExtendedWebElement product;
    @FindBy(xpath = "//div[@id='nav-logo']")
    private ExtendedWebElement navLogo;
    @FindBy(xpath = "//*[@data-component-type = 's-search-result']")
    private List<ExtendedWebElement> productList;
    @FindBy(xpath ="//div[contains(@id,'brandsRefinements')]/descendant-or-self::*[@type='checkbox']")
    private List<ExtendedWebElement> brandsCheckbox;
    @FindBy(xpath = "//span[contains(text(),'Clear')]")
    private ExtendedWebElement clearCheckboxButton;



    public SectionPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getProduct() {
        return product;
    }

    public ExtendedWebElement getClearCheckboxButton() {
        return clearCheckboxButton;

    }

    public List<ExtendedWebElement> getBrandsCheckbox() {
        return brandsCheckbox;
    }

    public ExtendedWebElement getNavLogo() {
        return navLogo;
    }

    public List<ExtendedWebElement> getProductList() {
        return productList;
    }

    public void validateCheckedAllCheckbox() {
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < brandsCheckbox.size(); i++) {
            brandsCheckbox.get(i).click();
            pause(2);
            softAssert.assertTrue(brandsCheckbox.get(i).isChecked());
        }
        softAssert.assertAll();
    }


}
