package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.P01_HomePageElements;

import java.util.concurrent.TimeUnit;

public class SD04_ChangeCurrency {

    P01_HomePageElements homeP = new P01_HomePageElements();

    // select euro
    @When("user selects Euro as the currency")
    public void usdToEuro(){
        Select currency = new Select(homeP.currencyDropdown());
        currency.selectByVisibleText("Euro");
        Hooks.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("all the below products' prices should be in euro")
    public void assertCurrencyChanged(){
        int products = homeP.featuredProducts().size();
        int productsInEuro = 0;
        for(int i = 0; i < products; i++){
            Boolean productContainEuro = homeP.featuredProducts().get(i).getText().contains("€");
            if(productContainEuro = true){
                productsInEuro++;
            }
        }
        Assert.assertEquals(productsInEuro,products);
    }
}
