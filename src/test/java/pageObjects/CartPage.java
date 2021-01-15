package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    private By buttonCheckout = By.linkText("CHECKOUT");
    WebDriver webDriver;

    CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static CartPage setWebDriver(WebDriver webDriver) {
        return new CartPage(webDriver);
    }

    public Boolean verifyProductsAreCorrect(String products[]) {

        List<WebElement> findProduct = webDriver.findElements(By.className("inventory_item_name"));
        int productCheker = 0;

        for (WebElement product : findProduct) {
            for (String item : products) {
                if (item.equalsIgnoreCase(product.getText()))
                    productCheker++;
            }
            if (productCheker == 1)
                return true;
        }

        return false;
    }

    public CartPage clickCheckout() {
        webDriver.findElement(buttonCheckout).click();
        return this;
    }

}
