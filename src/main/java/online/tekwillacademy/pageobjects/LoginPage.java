package online.tekwillacademy.pageobjects;

import online.tekwillacademy.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-email")
    private WebElement userNameInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButton;


    public void completeTheLoginForm(String email, String password) {
        userNameInput.sendKeys(email);
        passwordInput.sendKeys(password);
        System.out.println("The Login Form was populated with data");
    }

    public void clickOnContinueButton() {
        ScrollManager.scrollToElement(loginButton);
        loginButton.click();
        System.out.println("The Login Button was clicked");
    }


}
