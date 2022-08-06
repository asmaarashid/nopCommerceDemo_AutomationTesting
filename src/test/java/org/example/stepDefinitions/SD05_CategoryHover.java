package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.example.pages.P01_HomePageElements;

import java.util.Random;

public class SD05_CategoryHover {

    P01_HomePageElements homeP = new P01_HomePageElements();
    Random randomX = new Random();
    int x = randomX.nextInt(3 - 0);
    Random randomY = new Random();

    int y = randomY.nextInt(3 - 0);


    String subName;



    // hovering on random category
    @When("user hovers on main category")
    public void hoverOnCategory(){

        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(homeP.dynamicCategoriesLists().get(x)).perform();

    }

    // click on sub-category
    @And("user selects a sub-category")
    public void selectSubCategory(){
        System.out.println(x);
        System.out.println(y);
        switch (x){
            case 0:
                subName = homeP.computersSubList().get(y).getText().toLowerCase().trim();
                homeP.computersSubList().get(y).click();
                break;
            case 1:
                subName = homeP.electronicsSubList().get(y).getText().toLowerCase().trim();
                homeP.electronicsSubList().get(y).click();
                break;
            case 2:
                subName = homeP.apparelSubList().get(y).getText().toLowerCase().trim();
                homeP.apparelSubList().get(y).click();
                break;
            default:
                System.out.println("error in hovering on main categories");
        }
    }

    // correct page is opened assertion
    @Then("this sub-category's page is opened")
    public void correctPage(){
        String actualSubCategory = Hooks.driver.findElement(By.xpath("//div[@class=\"page-title\"]/h1")).getText().toLowerCase().trim();
        Assert.assertTrue(actualSubCategory.contains(subName),"wrong page");
    }


}
