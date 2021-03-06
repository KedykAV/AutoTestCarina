package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractPage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'SAMSUNG')]")
    List<ExtendedWebElement> results;
    @FindBy(xpath = "//span[contains(text(),'No results for')]")
    private ExtendedWebElement noResultInfo;
    @FindBy(xpath = "//span[contains(text(),'results for')]")
    private ExtendedWebElement resultMessage;
    @FindBy(xpath = "//span[contains(@class,'a-size-medium a-color-base a-text-normal')]")
    List<ExtendedWebElement> items;

    public static int getRandomDiceNumber() {
        return (int) (Math.random()*10)+1;
    }


    public ExtendedWebElement getResultMessage() {
        return resultMessage;
    }

    public List<ExtendedWebElement> getItems() {
        return items;
    }
    public void validateActuallItem(){
        for(int i=0;i<=items.size();i++){
            items.get(i).click();
            ProductPage prd=new ProductPage(getDriver());
            if(prd.getAlternativeAddButton().isElementPresent()){
                prd.getAlternativeAddButton().click();
            }else{
                prd.getDriver().navigate().back();
            }

        }
    }

    public List<ExtendedWebElement> getResults(){
        return results;
    }

    public ExtendedWebElement getNoResultInfo() {
        return noResultInfo;
    }
   // public ExtendedWebElement clickRandomBut(){
     //   for(int i=getRandomDiceNumber();i<=10;){}
    //}
}
