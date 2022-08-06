package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_HomePageElements;
import org.example.pages.P07_WishlistElements;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SD10_WishList {
    P01_HomePageElements homeP = new P01_HomePageElements();
    P07_WishlistElements wishlistP = new P07_WishlistElements();
    SoftAssert softAssert = new SoftAssert();

    // click on wishlist icon
    @When("user clicks on add to wishlist icon")
    public void clickOnWishlist(){
        homeP.wishlistButton.click();
    }

    @Then("a success message is displayed on top of the page")
    public void assertSuccessMSG(){
        softAssert.assertTrue(homeP.successMSG.isDisplayed(),"success message is not displayed");
        softAssert.assertEquals(homeP.successMSG.getCssValue("background-color"),"rgba(75, 176, 122, 1)");
        softAssert.assertAll();
    }

    @And("user goes to wishlist page")
    public void goToWishlist(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        homeP.wishlistIcon.click();
    }

    @Then("the item is added to wishlist successfully")
    public void checkWishlist(){
        int quantity = Integer.parseInt(wishlistP.itemQuantity.getAttribute("value"));
        softAssert.assertTrue(quantity > 0,"item is not added to the wishlist");
        softAssert.assertAll();
    }
}
