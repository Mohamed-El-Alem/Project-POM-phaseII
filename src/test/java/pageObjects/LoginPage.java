package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.rmi.runtime.Log;

public class LoginPage {
    By username = By.name("user-name");
    By password = By.name("password");
    By loginBtn = By.xpath("//input[@type='submit']");
    private By buttonLogout = By.id("logout_sidebar_link");
    private static By logginErrorMessge = By.xpath("//*[contains(text(),'Epic sadface')]");

    private static WebDriver webDriver;

    public LoginPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public LoginPage login(String un, String pwd) {
        webDriver.findElement(username).sendKeys(un);
        webDriver.findElement(password).sendKeys(pwd);
        return this;
    }
    public LoginPage clickLogin(){
        webDriver.findElement(loginBtn).click();
        return this;

    }

    public LoginPage logout() {
        webDriver.findElement(buttonLogout).click();
        return this;

    }


    public static LoginPage setWebDriver(WebDriver driver) {
        return new LoginPage(driver);
    }
}