package online.tekwillacademy;

import online.tekwillacademy.managers.DataGeneratorManager;
import online.tekwillacademy.managers.DriverManager;
import online.tekwillacademy.managers.ScrollManager;
import online.tekwillacademy.pageobjects.AccountPage;
import online.tekwillacademy.pageobjects.HomePage;
import online.tekwillacademy.pageobjects.LoginPage;
import online.tekwillacademy.pageobjects.RegisterPage;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");
        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickOnContinueButton();
        String randomEmail = DataGeneratorManager.getRandomEmail();
        registerPage.completeTheRegisterForm("Alex", "Pascali", randomEmail, "Password1234!");
        registerPage.enablePrivacyToggle();
        registerPage.clickOnContinueButton();

        Thread.sleep(2000);

        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickOnLogOutButton();

        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.completeTheLoginForm(randomEmail, "Password1234!");
        loginPage.clickOnContinueButton();

        Thread.sleep(1000);

        AccountPage accountPage1 = new AccountPage(driver);
        accountPage1.clickOnLogOutButton();

        driver.quit();
        System.out.println("The test is finished and the driver is closed");
    }
}