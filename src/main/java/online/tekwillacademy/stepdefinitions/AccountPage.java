package online.tekwillacademy.stepdefinitions;

import io.cucumber.java.en.Then;
import online.tekwillacademy.managers.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("tha page url contains the {string} keyword")
    public void thaPageUrlContainsTheKeyword(String collectedStringValue) throws InterruptedException {
        Thread.sleep(1000);
        boolean theUrlContainsTheCollectedKeyWordFromTheStep = driver.getCurrentUrl().contains(collectedStringValue);
        System.out.println(driver.getCurrentUrl());
        Assertions.assertTrue(theUrlContainsTheCollectedKeyWordFromTheStep, "The url contains the wanted key word");
    }
}
