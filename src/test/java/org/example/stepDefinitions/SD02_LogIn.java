package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_HomePageElements;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import org.example.pages.P03_LoginElements;

public class SD02_LogIn {

    // elements pages objects
    P01_HomePageElements homeP = new P01_HomePageElements();
    P03_LoginElements loginP = new P03_LoginElements();

    // soft assertion object
    SoftAssert softAssertion = new SoftAssert();


    // go to log in page
    @Given("user goes to log in page")
    public void goToLogin(){
        homeP.loginLinkElement.click();
    }


    //---------------------- valid login -----------------------
    // enter registered email
    @When("^user enters registered email \"(.*)\" and password \"(.*)\"$")
    public void enterEmailAndPass(String email , String password){
        loginP.enterLoginData(email , password);
    }

    // click on log in button
    @And("user clicks on log in button")
    public void clickLogin(){
        loginP.loginButtonElement.click();
    }

    // successful login assertion
    @Then("user is logged in successfully")
    public void signinAssert(){
        // 1- right URL assertion
        String expectedURL = "https://demo.nopcommerce.com/";
        String actualURL = Hooks.driver.getCurrentUrl();
        softAssertion.assertEquals(actualURL,expectedURL,"user is not logged in!");

        // 2- my account tab is displayed assertion
        softAssertion.assertTrue(homeP.myAccountTab.isDisplayed());
        softAssertion.assertAll();

    }

    //---------------------------------------------------------
    //--------------------- invalid login ---------------------

    // enter unregistered email and password
    @When("^user enters invalid email \"(.*)\" and password \"(.*)\"$")
    public void enterInvData(String invEmail, String invPass){
        loginP.enterLoginData(invEmail,invPass);
    }

    // unsuccessful log in assertions
    @Then("user is not logged in successfully")
    public void loginErrorAssert(){
        // assert error message
        Boolean actualErrorMsg = loginP.loginErrorMsg.getText().contains("Login was unsuccessful.");
        softAssertion.assertTrue(actualErrorMsg);

        // assert color of error message
        softAssertion.assertEquals(loginP.loginErrorMsg.getCssValue("color"),"rgba(228, 67, 75, 1)");

        // assert all
        softAssertion.assertAll();
    }

    //---------------------------------------------------------
    //------------------- forgot password ---------------------

    // click on forgot password
    @And("user clicks on forgot password")
    public void forgotPassLink(){
        loginP.forgotPassLinkElement.click();
    }

    // enter email to reset
    @When("user enters email for recovery")
    public void enterEmailforRecovery(){
        loginP.emailElement.sendKeys("nopdemoprojectasmaa@gmail.com");
    }

    // click on recover
    @And("user clicks on recovery button")
    public void recoverButton(){
        loginP.recoverButtonElement.click();
    }

    // password recovery success message assertion
    @Then("recovery email is sent to the user")
    public void recoveryEmailAssert(){
        String expectedRcoveryMsg = "Email with instructions has been sent to you.";
        Boolean actualRecoveryMsg = loginP.recoveryMsg.getText().contains(expectedRcoveryMsg);
        softAssertion.assertTrue(actualRecoveryMsg);
        // assert all
        softAssertion.assertAll();
    }
}
