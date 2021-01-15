package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import pageObjects.*;

public class SuccessfulScenarioSteps {
    public WebDriver driver;
    public LoginPage lp;
    public Inventory inventory;


    @Given("User lunch chrome browser")
    public void user_lunch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        lp = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }

    @When("User enter email as {string} and {string}")
    public void user_enter_email_as_and(String username, String password) {
        lp.login(username,password);

    }

    @Then("Click on login")
    public void click_on_login() {
        lp.clickLogin();

    }

    @When("User click on first item")
    public void user_click_on_first_item() {
        inventory = Inventory.setWebDriver(driver)
                .selectFirstItem();
    }

    @Then("Add item to shopping cart")
    public void add_item_to_shopping_cart() {
        InventoryItemPage
                .setWebDriver(driver)
                .addToCart();
    }

    @Then("check item is correct")
    public void check_item_is_correct() {
        inventory.ProceedToShoppingCartPage();

        Boolean checkProducts = CartPage.setWebDriver(driver)
                                .verifyProductsAreCorrect(Inventory.getProductList());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkProducts.equals(true),
                "There should be only one product");
        softAssert.assertAll();

    }

    @Then("Proceed checkout")
    public void proceed_checkout() {
        CartPage.setWebDriver(driver)
                .clickCheckout();

    }

    @When("Complete form")
    public void complete_form() {
        CheckOut.setWebDriver(driver)
                .enterFistName("Mohamed")
                .enterLastName("El Alem")
                .enterPostalCode("219MCS8088")
                .clickContinueButton()
                .ClickOnFinish();
    }

    @When("Logout")
    public void logout() {
        Menue.setWebDriver(driver)
                .openMenu()
                .clickOnLogOut();
    }

    @Then("close the browser")
    public void close_the_browser() {
        driver.quit();

    }


}