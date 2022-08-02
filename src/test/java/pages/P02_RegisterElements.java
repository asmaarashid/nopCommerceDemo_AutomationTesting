package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.Hooks;

public class P02_RegisterElements {

    public WebElement registerPageLink()
    {
        return  Hooks.driver.findElement(By.className("ico-register"));
    }

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

    public WebElement firstNameTxt()
    {
        return  Hooks.driver.findElement(By.id("FirstName"));
    }

    public WebElement lastNameTxt()
    {
        return  Hooks.driver.findElement(By.id("LastName"));
    }

    public WebElement birthDayList()
    {
        return Hooks.driver.findElement(By.name("DateOfBirthDay"));
    }

    public WebElement birthMonthList()
    {
        return Hooks.driver.findElement(By.name("DateOfBirthMonth"));
    }

    public WebElement birthYearList()
    {
        return Hooks.driver.findElement(By.name("DateOfBirthYear"));
    }


    public WebElement emailElement()
    {
        return  Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement companyElement(){ return Hooks.driver.findElement(By.id("Company"));}

    public WebElement passwordElement()
    {
        return  Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement confirmPassElement()
    {
        return  Hooks.driver.findElement(By.id("ConfirmPassword"));
    }


    public WebElement registerButtonElement()
    {
        return  Hooks.driver.findElement(By.id("register-button"));
    }


    public WebElement registrationResult()
    {
        return  Hooks.driver.findElement(By.className("result"));
    }

}
