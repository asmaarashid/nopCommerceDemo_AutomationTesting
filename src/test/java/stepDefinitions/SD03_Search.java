package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.P04_SearchElements;

public class SD03_Search {

    P04_SearchElements searchP = new P04_SearchElements();
    SoftAssert softAssertion = new SoftAssert();

    @When("^user search for product using name \"([^\"]*)\"$")
    public void searchByName(String itemName){
        searchP.searchFieldElement().sendKeys(itemName);
        searchP.searchButtonElement().click();
    }
    @Then("user is directed to right page")
    public void rightPage(){
        String expectedURL = "https://demo.nopcommerce.com/search";
        String actualURL = Hooks.driver.getCurrentUrl();
        softAssertion.assertTrue(actualURL.contains(expectedURL));
        softAssertion.assertAll();
    }

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


    @When("^user search for product using SKU \"([^\"]*)\"$")
    public void searchBySKU(String sku){
        searchP.searchFieldElement().sendKeys(sku);
        searchP.searchButtonElement().click();
    }

    @Then("user goes to the product page")
    public void goToItemPage(){
        searchP.skuImgElement().click();
    }

    @Then("^all products with the same SKU should be displayed with the \"([^\"]*)\"$")
    public void skuSearchResult(String sku){
        String actualSKU = searchP.itemSKUElement().getText();
        softAssertion.assertEquals(actualSKU,sku);
        softAssertion.assertAll();
    }
}
