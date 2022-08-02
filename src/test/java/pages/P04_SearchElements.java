package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.Hooks;

import java.util.List;

public class P04_SearchElements {

    // search field element
    public WebElement searchFieldElement(){
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }

    // search button element
    public WebElement searchButtonElement(){
        return Hooks.driver.findElement(By.xpath("//div[@class=\"search-box store-search-box\"]//button"));
    }

    // search result elements list
    public List<WebElement> searchResultElement(){
        List <WebElement> resultList = Hooks.driver.findElements(By.className("product-item"));
        return resultList;
    }

    // get sku
    public WebElement itemSKUElement(){
        return Hooks.driver.findElement(By.xpath("//div[@class=\"sku\"]//span[2]"));
    }

    // sku item image
    public WebElement skuImgElement(){
        return Hooks.driver.findElement(By.xpath("//div[@class=\"picture\"]//img"));
    }

}
