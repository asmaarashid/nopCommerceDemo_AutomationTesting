package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_HomePageElements;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import org.example.pages.P02_RegisterElements;


public class SD01_Registration{

    // element pages objects
    P01_HomePageElements homeP = new P01_HomePageElements();
    P02_RegisterElements regP = new P02_RegisterElements();

    // soft assertion object
    SoftAssert softAssertion = new SoftAssert();


    // go to register page method
    @Given("user goes to register page")
    public void goToRegister(){
        homeP.registerPageLink.click();
    }

    // choose gender method
    @When("^user chooses a gender \"(.*)\"$")
    public void chooseGender(String gender){
        regP.genderRadioButton(gender);
    }

    // enter first and last name method
    @And("^user enters full name \"(.*)\" and \"(.*)\"$")
    public void enterFullName(String firstName, String lastName){
        regP.firstNameTxt.sendKeys(firstName);
        regP.lastNameTxt.sendKeys(lastName);

    }

    // select birthdate method
    @And("user chooses date of  birth")
    public void selectBD(){
        Select BDdate = new Select(regP.birthDayList);
        BDdate.selectByValue("26");
        Select BDmonth = new Select(regP.birthMonthList);
        BDmonth.selectByValue("2");
        Select BDyear = new Select(regP.birthYearList);
        BDyear.selectByVisibleText("1996");

    }

    // enter email method
    @And("^user enters email \"(.*)\"$")
    public void enterEmail(String email){
        regP.emailElement.sendKeys(email);
    }

    // enter company name method
    @And("user enters company name")
    public void enterCompany(){
        regP.companyElement.sendKeys("EGYFWD");
    }

    // enter password and password confirmation
    @And("^user enters password \"(.*)\" and confirmation \"(.*)\"$")
    public void password(String password, String confirmation){
        regP.passwordElement.sendKeys(password);
        regP.confirmPassElement.sendKeys(confirmation);
    }

    // click on registration button
    @And("user clicks on register button")
    public void pressRegister(){
        regP.registerButtonElement.click();
    }

    // assert successful registration
    @Then("webapp displays success message")
    public void confirmRegistration(){

        // 1- confirmation message assertion
        String expectedConfirmMsg = "Your registration completed";
        String actualMsg = regP.registrationResult.getText();
        softAssertion.assertEquals(actualMsg,expectedConfirmMsg,"Registration Failed!");

        // 2- confirm message color
        softAssertion.assertEquals(regP.registrationResult.getCssValue("color"),"rgba(76, 177, 124, 1)");

        // 3- directed URL assertion
        String expectedURL = "https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
        String actualURL = Hooks.driver.getCurrentUrl();
        softAssertion.assertEquals(actualURL,expectedURL,"Registration Failed!");

        // assert all
        softAssertion.assertAll();

    }

}
