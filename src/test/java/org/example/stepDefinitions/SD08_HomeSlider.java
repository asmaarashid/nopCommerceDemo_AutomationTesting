package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_HomePageElements;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SD08_HomeSlider {

    P01_HomePageElements homeP = new P01_HomePageElements();
    SoftAssert softAssert = new SoftAssert();

    // clicking on first slide
    @When("user click on first banner")
    public void clickFirstBanner(){
        homeP.banner1.click();
    }

    // assert the url in the first slide
    @Then("user is directed to nokia page")
    public void firstBannerNavigation(){
        String expectedURL = "https://demo.nopcommerce.com/nokia-lumia-1020";
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(3));
        String actualURL = Hooks.driver.getCurrentUrl();

        softAssert.assertEquals(actualURL,expectedURL,"first banner URL is wrong!");
        softAssert.assertAll();

    }


    // ----------------- scenarion 2 ------------------


    // clicking on first slide
    @When("user goes to second banner")
    public void goSecondbanner(){
        homeP.banner2icon.click();
    }

    @And("user clicks on second banner")
    public void clickSecondBanner(){
        homeP.banner2.click();
    }

    // assert the url in the first slide
    @Then("user is directed to iphone page")
    public void secondBannerNavigation(){
        String expectedURL = "https://demo.nopcommerce.com/iphone-6";
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(3));
        String actualURL = Hooks.driver.getCurrentUrl();
        softAssert.assertEquals(actualURL,expectedURL,"second banner URL wrong!!");
        softAssert.assertAll();
    }

}
