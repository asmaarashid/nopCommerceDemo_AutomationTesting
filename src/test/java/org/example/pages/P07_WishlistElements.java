package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P07_WishlistElements {
    public P07_WishlistElements(){
        PageFactory.initElements(Hooks.driver,this);
    }

    // item quantity element
    @FindBy(xpath = "//td[@class=\"quantity\"]/input")
    public WebElement itemQuantity;
}
