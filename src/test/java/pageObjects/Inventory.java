package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Inventory {
    private static WebDriver webDriver;
    private By linkFirstProduct = By.xpath("//a[@id='item_4_title_link']/div");
    private By cartProduct = By.cssSelector("path");
    private static String[] ProductList = {"Sauce Labs Backpack"};

    public Inventory(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static Inventory setWebDriver(WebDriver webDriver) {
        return new Inventory(webDriver);
    }

    public Inventory selectFirstItem() {
        webDriver.findElement(linkFirstProduct).click();
        return this;
    }

    public Inventory ProceedToShoppingCartPage() {
        webDriver.findElement(cartProduct).click();
        return this;

    }
    public static String[] getProductList() {
        return ProductList;
    }
}
