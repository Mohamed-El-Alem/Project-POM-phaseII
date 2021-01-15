package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Menue {
    private By header = By.xpath("//div[@id='header_container']/div");
    private By menuButton = By.xpath("//div[@id='menu_button_container']/div/div[3]/div/button");
    private By buttonLogout = By.id("logout_sidebar_link");
    WebDriver webDriver;

    Menue(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static Menue setWebDriver(WebDriver webDriver) {
        return new Menue(webDriver);
    }

    public Menue openMenu() {
        webDriver.findElement(header).click();
        webDriver.findElement(menuButton).click();
        return this;
    }

    public void clickOnLogOut() {
        webDriver.findElement(buttonLogout).click();
    }
}
