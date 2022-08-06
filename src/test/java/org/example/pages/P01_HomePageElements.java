package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class P01_HomePageElements {


    // page factory constructor
    public P01_HomePageElements(){
        PageFactory.initElements(Hooks.driver,this);
    }

    // ------------------------ register ------------------

    @FindBy(className = "ico-register")
    public WebElement registerPageLink;

    //-----------------------------------------------------
    //------------------------ log in ---------------------

    // login link
    @FindBy(className = "ico-login")
    public WebElement loginLinkElement;

    // my account tab eleemnt
    @FindBy(linkText = "My account")
    public WebElement myAccountTab;

    //-----------------------------------------------------
    //------------------ change currency ------------------

    // currency dropdown list
    @FindBy(id = "customerCurrency")
    public WebElement currencyDropdown;

    // featured products elements list
    public List<WebElement> featuredProducts(){
        List <WebElement> featuredProducts = Hooks.driver.findElements(By.xpath("//div[@class=\"item-grid\"]//div[@class=\"prices\"]//span"));
        return featuredProducts;
    }

    //------------------------------------------------------
    //---------------------- search ------------------------

    // search text field element
    @FindBy(id = "small-searchterms")
    public WebElement searchFieldElement;

    // search button element
    @FindBy(xpath = "//div[@class=\"search-box store-search-box\"]//button")
    public WebElement searchButtonElement;

    //------------------------------------------------------
    //------------------ categories hover ------------------

    // the main categories dynamic lists
    public List<WebElement> dynamicCategoriesLists(){
        List <WebElement> categoriesLists = new ArrayList<>();
        categoriesLists.add(Hooks.driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[text()='Computers ']")));
        categoriesLists.add(Hooks.driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[text()='Electronics ']")));
        categoriesLists.add(Hooks.driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[text()='Apparel ']")));
        return categoriesLists;
    }

    // computer sub-categories lis
    public List<WebElement> computersSubList(){
        List<WebElement> computerSub = new ArrayList<>();
        computerSub.add(Hooks.driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[text()='Desktops ']")));
        computerSub.add(Hooks.driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[text()='Notebooks ']")));
        computerSub.add(Hooks.driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[text()='Software ']")));
        return computerSub;
    }

    // electronics sub-categories lis
    public List<WebElement> electronicsSubList(){
        List<WebElement> electronicsSub = new ArrayList<>();
        electronicsSub.add(Hooks.driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[text()='Camera & photo ']")));
        electronicsSub.add(Hooks.driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[text()='Cell phones ']")));
        electronicsSub.add(Hooks.driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[text()='Others ']")));
        return electronicsSub;
    }

    // apparel sub-categories lis
    public List<WebElement> apparelSubList(){
        List<WebElement> apparelSub = new ArrayList<>();
        apparelSub.add(Hooks.driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[text()='Shoes ']")));
        apparelSub.add(Hooks.driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[text()='Clothing ']")));
        apparelSub.add(Hooks.driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[text()='Accessories ']")));
        return apparelSub;
    }

    //--------------------------------------------------------
    //-------------------- select tag ------------------------


    // all featured categories and products
    public List<WebElement> allFeatured(){
        List<WebElement> allFeatured = Hooks.driver.findElements(By.xpath("//div[@class=\"category-grid home-page-category-grid\"]//div[@class=\"item-box\"]"));
        return allFeatured;
    }

    //---------------------------------------------------------
    // -------------------- slider feature --------------------

    // first banner element
    @FindBy(xpath = "//a[@class=\"nivo-imageLink\"][1]")
    public WebElement banner1;
    // second banner icon
    @FindBy(xpath = "//a[text()=2]")
    public WebElement banner2icon;
    // second banner element
    @FindBy(xpath = "//a[@class=\"nivo-imageLink\"][2]")
    public WebElement banner2;

    //-------------------- follow us ------------------------

    // facebook icon
    @FindBy(xpath = "//li[@class=\"facebook\"]/a")
    public WebElement facebook;
    // twitter icon
    @FindBy(xpath = "//li[@class=\"twitter\"]/a")
    public WebElement twitter;
    // rss icon
    @FindBy(xpath = "//li[@class=\"rss\"]/a")
    public WebElement rss;
    // youtube icon
    @FindBy(xpath = "//li[@class=\"youtube\"]/a")
    public WebElement youtube;

    //--------------------- wish list -----------------------

    // add to wishlist icon
    @FindBy(xpath = "//div[@class=\"item-box\"][3]//button[@class=\"button-2 add-to-wishlist-button\"]")
    public WebElement wishlistButton;

    @FindBy(className = "bar-notification")
    public WebElement successMSG;

    @FindBy(className = "ico-wishlist")
    public WebElement wishlistIcon;
}
