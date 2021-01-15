package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut {
    private By inputFirstname = By.id("first-name");
    private By inputLastname = By.id("last-name");
    private By inputPostalcode = By.id("postal-code");
    private By buttonContinue = By.xpath("//input[@value='CONTINUE']");
    private By finishBtn = By.linkText("FINISH");

    WebDriver webDriver;

    CheckOut(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static CheckOut setWebDriver(WebDriver webDriver) {
        return new CheckOut(webDriver);
    }

    public CheckOut enterFistName(String firstname) {
        webDriver.findElement(inputFirstname).sendKeys(firstname);
        return this;
    }

    public CheckOut enterLastName(String lastname) {
        webDriver.findElement(inputLastname).sendKeys(lastname);
        return this;
    }

    public CheckOut enterPostalCode(String postalcode) {
        webDriver.findElement(inputPostalcode).sendKeys(postalcode);
        return this;
    }

    public CheckOut clickContinueButton() {
        webDriver.findElement(buttonContinue).click();
        return this;
    }
    public void ClickOnFinish() {
        webDriver.findElement(finishBtn).click();
    }
}
