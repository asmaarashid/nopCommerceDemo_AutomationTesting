package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_HomePageElements;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.example.pages.P04_SearchElements;

public class SD03_Search {

    // elements pages objects
    P01_HomePageElements homeP = new P01_HomePageElements();
    P04_SearchElements searchP = new P04_SearchElements();

    // soft assertion
    SoftAssert softAssertion = new SoftAssert();


    //-------------------- search by name -----------------------
    // enter product name to search about
    @When("^user search for product using name \"([^\"]*)\"$")
    public void searchByName(String itemName){
        homeP.searchFieldElement.sendKeys(itemName);
        homeP.searchButtonElement.click();
    }

    // assert redirection to search result page
    @Then("user is directed to right page")
    public void rightPage(){
        String expectedURL = "https://demo.nopcommerce.com/search";
        String actualURL = Hooks.driver.getCurrentUrl();
        softAssertion.assertTrue(actualURL.contains(expectedURL));
        softAssertion.assertAll();
    }

    // assert items of the same name are all displayed in page
    @And("^all products with the same name should be displayed with the \"([^\"]*)\"$")
    public void searchResults(String itemName){
        int searchItemsCount = searchP.searchResultElement().size();
        int countActualResult = 0;
        for(int i = 0; i < searchItemsCount; i++){

            Boolean resultContainName = searchP.searchResultElement().get(i).getText().contains(itemName);
            if(resultContainName = true){
                countActualResult++;
            }
        }
        softAssertion.assertEquals(countActualResult,searchItemsCount);
        softAssertion.assertAll();
    }

    //----------------------------------------------------------
    //--------------------- search with SKU --------------------
    // enter SKU to search about
    @When("^user search for product using SKU \"([^\"]*)\"$")
    public void searchBySKU(String sku){
        homeP.searchFieldElement.sendKeys(sku);
        homeP.searchButtonElement.click();
    }

    // gp to item page
    @Then("user goes to the product page")
    public void goToItemPage(){
        searchP.skuImgElement.click();
    }

    // assert result item has the same SKU
    @Then("^the product with the same SKU should be displayed with the \"([^\"]*)\"$")
    public void skuSearchResult(String sku){
        String actualSKU = searchP.itemSKUElement.getText();
        Assert.assertEquals(actualSKU,sku);
    }
}
