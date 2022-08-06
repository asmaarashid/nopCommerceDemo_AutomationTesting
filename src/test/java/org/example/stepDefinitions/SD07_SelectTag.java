package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import org.example.pages.P01_HomePageElements;
import org.example.pages.P06_TagsElements;

import java.util.Random;

public class SD07_SelectTag {
    P01_HomePageElements homeP = new P01_HomePageElements();
    P06_TagsElements tagP = new P06_TagsElements();
    Random randomX = new Random();
    int x = randomX.nextInt(2 - 0);
    Random randomY = new Random();
    int y = randomY.nextInt(15 - 0);
    String tagName;

    SoftAssert softAssert = new SoftAssert();

    // go to category
    @When("user selects a category")
    public void goToCategory(){
        homeP.allFeatured().get(x).click();
    }

    // go to tags page
    @When("user goes to tags page")
    public void goToTags(){
        tagP.viewAllTags().click();

    }

    // select a tag
    @And("user selects a tag")
    public void selectTag(){
        tagName = tagP.allTagsList().get(y).getText().trim();
        tagP.allTagsList().get(y).click();
    }

    // assert right tag is opened
    @Then("all products with this tag are displayed")
    public void assertTagPage(){
        softAssert.assertTrue(tagP.tagPageTitle().getText().contains(tagName));
    }

}
