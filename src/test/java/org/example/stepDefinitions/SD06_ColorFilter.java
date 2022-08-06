package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.example.pages.P05_ColorFilteredProductElements;

public class SD06_ColorFilter {

    P05_ColorFilteredProductElements colorP = new P05_ColorFilteredProductElements();
    int allProductsCount;


    @Given("user goes to shoes page")
    public void gotoShoesPage(){
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/shoes");

        allProductsCount = colorP.displayedProducts().size();
    }

    @When("user select a color filter")
    public void selectColor(){
        colorP.colorFilterCheckBox().click();
    }

    @Then("filter should be applied and only products of this color are displayed")
    public void assertFilterApplied(){
        Hooks.driver.navigate().refresh();
        int afterFilter = colorP.displayedProducts().size();
        Assert.assertTrue(afterFilter < allProductsCount,"page is not refreshed");
    }
}
