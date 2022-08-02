package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.Hooks;

public class P03_LoginElements {

    public WebElement loginLinkElement(){
        return Hooks.driver.findElement(By.className("ico-login"));
    }

    public WebElement emailElement(){
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement passwordElement(){
        return Hooks.driver.findElement(By.id("Password"));
    }

    public void enterLoginData(String email , String password){
        emailElement().sendKeys(email);
        passwordElement().sendKeys(password);
    }
    public WebElement loginButtonElement(){
        return Hooks.driver.findElement(By.xpath("//div[@class=\"returning-wrapper fieldset\"]//button"));
    }

    public WebElement forgotPassLinkElement(){
        return Hooks.driver.findElement(By.linkText("Forgot password?"));
    }


    public WebElement recoverButtonElement(){
        return Hooks.driver.findElement(By.name("send-email"));
    }

    public WebElement recoveryMsg(){
        return Hooks.driver.findElement(By.xpath("//div[@class=\"bar-notification success\"]//p"));
    }

}
