package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_HomePageElements;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class SD09_FollowUs {

    P01_HomePageElements homeP = new P01_HomePageElements();

    // facebook follow
    @When("user clicks on facebook icon")
    public void facebookClick(){
        homeP.facebook.click();
    }

    @Then("^user is directed to facebook \"(.*)\"$")
    public void goToFacebook(String facebookURL){
        WebDriverWait waitForTabs = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        waitForTabs.until(ExpectedConditions.numberOfWindowsToBe(2));


        ArrayList<String> tabsList = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabsList.get(1));

        String expectedURL = facebookURL;
        String actualURL = Hooks.driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL,"wrong facebook link");
    }

    // twitter follow
    @When("user clicks on twitter icon")
    public void twitterClick(){
        homeP.twitter.click();
    }

    @Then("^user is directed to twitter \"(.*)\"$")
    public void goToTwitter(String twitterURL){
        WebDriverWait waitForTabs = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        waitForTabs.until(ExpectedConditions.numberOfWindowsToBe(2));


        ArrayList<String> tabsList = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabsList.get(1));

        String expectedURL = twitterURL;
        String actualURL = Hooks.driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL,"wrong twitter link");
    }

    // rss follow
    @When("user clicks on rss icon")
    public void rssClick(){
        homeP.rss.click();
    }

    @Then("^user is directed to rss \"(.*)\"$")
    public void goToRSS(String rssURL){
        WebDriverWait waitForTabs = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        waitForTabs.until(ExpectedConditions.numberOfWindowsToBe(2));


        ArrayList<String> tabsList = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabsList.get(1));

        String expectedURL = rssURL;
        String actualURL = Hooks.driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL,"wrong rss link");
    }

    // youtube follow
    @When("user clicks on youtube icon")
    public void youtubeClick(){
        homeP.youtube.click();
    }

    @Then("^user is directed to youtube \"(.*)\"$")
    public void goToYoutube(String youtubeURL){
        WebDriverWait waitForTabs = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        waitForTabs.until(ExpectedConditions.numberOfWindowsToBe(2));


        ArrayList<String> tabsList = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabsList.get(1));

        String expectedURL = youtubeURL;
        String actualURL = Hooks.driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL,"wrong youtube link");
    }
}
