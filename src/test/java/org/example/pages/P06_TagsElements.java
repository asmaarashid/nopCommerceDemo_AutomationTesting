package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.stepDefinitions.Hooks;

import java.util.List;

public class P06_TagsElements {

    // go to all tags page element
    public WebElement viewAllTags(){
        return Hooks.driver.findElement(By.xpath("//a[@href=\"/producttag/all\"]"));
    }

    public List<WebElement> allTagsList(){
        List<WebElement> allTags = Hooks.driver.findElements(By.xpath("//ul[@class=\"product-tags-list\"]//a"));
        return allTags;
    }

    public WebElement tagPageTitle(){
        return Hooks.driver.findElement(By.xpath("//div[@class=\"page-title\"]/h1"));
    }

}
