package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import pages.P03_LoginElements;

public class SD02_LogIn {

    P03_LoginElements loginP = new P03_LoginElements();
    SoftAssert softAssertion = new SoftAssert();


    // go to log in page
    @Given("user goes to log in page")
    public void goToLogin(){
        loginP.loginLinkElement().click();
    }

    // enter registered email
    @When("^user enters registered email \"(.*)\" and password \"(.*)\"$")
    public void enterEmailAndPass(String email , String password){
        loginP.enterLoginData(email , password);
    }

    // click on log in button
    @And("user clicks on log in button")
    public void clickLogin(){
        loginP.loginButtonElement().click();
    }

    // successful login assertion
    @Then("user is logged in successfully")
    public void signinAssert(){

        String expectedURL = "https://demo.nopcommerce.com/";
        String actualURL = Hooks.driver.getCurrentUrl();

        softAssertion.assertEquals(actualURL,expectedURL,"user is not logged in!");

        softAssertion.assertTrue(Hooks.driver.findElement(By.linkText("My account")).isDisplayed());

    }

    @When("^user enters invalid email \"(.*)\" and password \"(.*)\"$")
    public void enterInvData(String invEmail, String invPass){
        loginP.enterLoginData(invEmail,invPass);
    }

    @Then("user is not logged in successfully")
    public void loginErrorAssert(){
        Boolean actualErrorMsg = Hooks.driver.findElement(By.className("message-error")).getText().contains("Login was unsuccessful.");
        softAssertion.assertTrue(actualErrorMsg);

        softAssertion.assertEquals(Hooks.driver.findElement(By.className("message-error")).getCssValue("color = rgb(228, 67, 75)"),"rgb(228, 67, 75)");
    }

    // click on forgot password
    @And("user clicks on forgot password")
    public void forgotPassLink(){
        loginP.forgotPassLinkElement().click();
    }

    @When("user enters email for recovery")
    public void enterEmailforRecovery(){
        loginP.emailElement().sendKeys("nopdemoprojectasmaa@gmail.com");
    }

    @And("user clicks on recovery button")
    public void recoverButton(){
        loginP.recoverButtonElement().click();
    }

    @Then("recovery email is sent to the user")
    public void recoveryEmailAssert(){
        String expectedRcoveryMsg = "Email with instructions has been sent to you.";
        Boolean actualRecoveryMsg = loginP.recoveryMsg().getText().contains(expectedRcoveryMsg);
        softAssertion.assertTrue(actualRecoveryMsg);
        softAssertion.assertAll();
    }
}
