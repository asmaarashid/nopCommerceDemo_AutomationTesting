package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.Hooks;

import java.util.ArrayList;
import java.util.List;

public class P01_HomePageElements {

    // currency element

    public WebElement currencyDropdown(){
        return Hooks.driver.findElement(By.id("customerCurrency"));
    }

    // featured products elements list
    public List<WebElement> featuredProducts(){
        List <WebElement> featuredProducts = Hooks.driver.findElements(By.xpath("//div[@class=\"item-grid\"]//div[@class=\"prices\"]//span"));
        return featuredProducts;
    }

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
}
