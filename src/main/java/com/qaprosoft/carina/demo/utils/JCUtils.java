package com.qaprosoft.carina.demo.utils;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import io.cucumber.java.sl.In;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JCUtils {
    public static void flash(WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor = element.getCssValue("backgroundColor");
        for(int i =0; i<100;i++){
            changeColor("#FF0000",element,driver);
            changeColor(bgcolor,element,driver);
        }
    }
    public static void changeColor(String color, WebElement element,WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor= '"+ color +"'", element);
        try{
            Thread.sleep(20);
        }catch (InterruptedException e){}
    }
}
