package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_RegisterElements {

    public P02_RegisterElements(){
        PageFactory.initElements(Hooks.driver,this);
    }

    // gender radio button element
    public WebElement genderRadioButton(String genderChoice)
    {
        WebElement gender = null;

        if (genderChoice.contains("male")) {
            gender = Hooks.driver.findElement(By.id("gender-male"));
        }
        else if(genderChoice.contains("female")) {
            gender = Hooks.driver.findElement(By.id("gender-female"));
        }
        return gender;
    }

    // first name text field element
    @FindBy(id = "FirstName")
    public WebElement firstNameTxt;

    // last name text field element
    @FindBy(id = "LastName")
    public WebElement lastNameTxt;

    // birthdate - days dropdown list element
    @FindBy(name = "DateOfBirthDay")
    public WebElement birthDayList;

    // birthdate - months dropdown list element
    @FindBy(name = "DateOfBirthMonth")
    public WebElement birthMonthList;

    // birthdate - years dropdown list element
    @FindBy(name = "DateOfBirthYear")
    public WebElement birthYearList;

    // email text field element
    @FindBy(id = "Email")
    public WebElement emailElement;

    // company text field element
    @FindBy(id = "Company")
    public WebElement companyElement;

    // password text field element
    @FindBy(id = "Password")
    public WebElement passwordElement;

    // confirm password text field element
    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPassElement;

    // register button element
    @FindBy(id = "register-button")
    public WebElement registerButtonElement;

    // registeration message bar element
    @FindBy(className = "result")
    public WebElement registrationResult;

}
