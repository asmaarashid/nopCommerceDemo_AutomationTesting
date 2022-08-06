package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P03_LoginElements {

    // page factory constructor
    public P03_LoginElements(){
        PageFactory.initElements(Hooks.driver,this);
    }

    //---------------------- log in ------------------------
    // email text field element
    @FindBy(id = "Email")
    public WebElement emailElement;

    // password text field element
    @FindBy(id = "Password")
    public WebElement passwordElement;

    // send keys custom method to send email and password
    public void enterLoginData(String email , String password){
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
    }

    // login button element
    @FindBy(xpath = "//div[@class=\"returning-wrapper fieldset\"]//button")
    public WebElement loginButtonElement;

    // failed log in message
    @FindBy(className = "message-error")
    public WebElement loginErrorMsg;

    //------------------------------------------------------
    //-------------------- reset password ------------------

    // forget password? link element
    @FindBy(linkText = "Forgot password?")
    public WebElement forgotPassLinkElement;

    // recover password button element
    @FindBy(name = "send-email")
    public WebElement recoverButtonElement;

    // recovery success message element
    @FindBy(xpath = "//div[@class=\"bar-notification success\"]//p")
    public WebElement recoveryMsg;


}
