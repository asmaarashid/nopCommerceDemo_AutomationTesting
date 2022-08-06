package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    // this class is dedicated to the before and after methods

    public static WebDriver driver = null;
    @Before
    public void openBrowser(){
        // getting the driver path
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

}
