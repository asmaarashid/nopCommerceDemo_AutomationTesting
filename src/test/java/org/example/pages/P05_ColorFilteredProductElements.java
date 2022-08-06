package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.stepDefinitions.Hooks;

import java.util.List;

public class P05_ColorFilteredProductElements {

    public List<WebElement> displayedProducts(){
        List<WebElement> displayedProducts = Hooks.driver.findElements(By.className("product-item"));
        return displayedProducts;
    }

    public WebElement colorFilterCheckBox(){
        return Hooks.driver.findElement(By.xpath("//input[@id=\"attribute-option-15\"]"));
    }

}
