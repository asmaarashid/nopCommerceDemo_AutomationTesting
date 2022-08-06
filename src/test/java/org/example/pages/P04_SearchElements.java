package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P04_SearchElements {

    public P04_SearchElements(){
        PageFactory.initElements(Hooks.driver,this);
    }


    // search result elements list
    public List<WebElement> searchResultElement(){
        List <WebElement> resultList = Hooks.driver.findElements(By.className("product-item"));
        return resultList;
    }

    // get sku
    @FindBy(xpath = "//div[@class=\"sku\"]//span[2]")
    public WebElement itemSKUElement;

    // sku item image
    @FindBy(xpath = "//div[@class=\"picture\"]//img")
    public WebElement skuImgElement;
}
