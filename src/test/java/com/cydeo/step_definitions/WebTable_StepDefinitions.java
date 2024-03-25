package com.cydeo.step_definitions;

import com.cydeo.pages.WT_LoginPage;
import com.cydeo.pages.WT_OrderPage;
import com.cydeo.pages.WT_ViewAllOrdersPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebTable_StepDefinitions {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    WT_LoginPage loginPage = new WT_LoginPage();
    WT_OrderPage orderPage = new WT_OrderPage();

    WT_ViewAllOrdersPage viewAllOrdersPage = new WT_ViewAllOrdersPage();

    @Given("user is on the Web Table app login page")
    public void user_is_on_the_web_table_app_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web_table_login_URL"));
    }

    @When("user enters correct username")
    public void user_enters_correct_username() {

        loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("web_table_username"));

    }

    @When("user enters correct password")
    public void user_enters_correct_password() {
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("web_table_password"));
    }

    @When("user clicks to login button")
    public void user_clicks_to_login_button() {

        loginPage.loginButton.click();

    }

    @Then("user should see orders word in the URL")
    public void user_should_see_orders_word_in_the_url() {

        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedInURL = "orders";

        wait.until(ExpectedConditions.visibilityOf(loginPage.logoutButton));

        Assert.assertTrue(actualURL.contains(expectedInURL));

    }


    @When("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String username, String password) {

        loginPage.inputUsername.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
    }


    @When("user enters below correct credentials")
    public void user_enters_below_correct_credentials(Map<String, String> credentials) {

        loginPage.inputUsername.sendKeys(credentials.get("username"));
        loginPage.inputPassword.sendKeys(credentials.get("password"));

    }

    @Given("user is already logged in to The Web table app")
    public void user_is_already_logged_in_to_the_web_table_app() {

        user_is_on_the_web_table_app_login_page();

        loginPage.login();

    }

    @When("user is on the Order page")
    public void user_is_on_the_order_page() {
        orderPage.orderBtn.click();
    }

    @Then("user sees below options under product dropdown")
    public void user_sees_below_options_under_product_dropdown(List<String> expectedProducts) {


/*
        Select products = new Select(orderPage.product_dropDown);

        List<WebElement> actualProducts_as_WebElement = products.getOptions();

        List<String> actualProducts_as_String = new ArrayList<>();

        for (WebElement each : actualProducts_as_WebElement) {
            actualProducts_as_String.add(each.getText());
        }

        Assert.assertEquals(expectedProducts,actualProducts_as_String);
*/

        List<String> actualOptions = BrowserUtils.dropdownOptions_as_STRING(orderPage.product_dropDown);

        Assert.assertEquals(expectedProducts,actualOptions);

    }


    @Then("user sees Visa as enabled payment option")
    public void user_sees_visa_as_enabled_payment_option() {
        Assert.assertTrue(orderPage.visaRadioButton.isEnabled());
    }

    @Then("user sees MasterCard as enabled payment option")
    public void user_sees_master_card_as_enabled_payment_option() {
        Assert.assertTrue(orderPage.masterCardRadioButton.isEnabled());
    }

    @Then("user sees American Express as enabled payment option")
    public void user_sees_american_express_as_enabled_payment_option() {
        Assert.assertTrue(orderPage.americanExpressRadioButton.isEnabled());
    }


    @When("user enters quantity {string}")
    public void user_enters_quantity(String quantity) {

        orderPage.quantityInput.clear();

        orderPage.quantityInput.sendKeys(quantity);


    }

    @Then("user clicks to the calculate button")
    public void user_clicks_to_the_calculate_button() {

        orderPage.calculateBtn.click();

    }

    @Then("user enters customer name {string}")
    public void user_enters_customer_name(String name) {

        orderPage.nameInput.sendKeys(name);

    }

    @Then("user enters street {string}")
    public void user_enters_street(String street) {
        orderPage.streetInput.sendKeys(street);
    }

    @Then("user enters city {string}")
    public void user_enters_city(String city) {
        orderPage.cityInput.sendKeys(city);
    }

    @Then("user enters state {string}")
    public void user_enters_state(String state) {
        orderPage.stateInput.sendKeys(state);
    }

    @Then("user enters zip {string}")
    public void user_enters_zip(String zip) {
        orderPage.zipInput.sendKeys(zip);
    }

    @Then("user selects payment option {string}")
    public void user_selects_payment_option(String payment_option) {

        orderPage.paymentSelect(payment_option);

    }

    @Then("user enters credit card number {string}")
    public void user_enters_credit_card_number(String cardNumber) {
        orderPage.cardNoInput.sendKeys(cardNumber);
    }

    @Then("user enters expiration date {string}")
    public void user_enters_expiration_date(String expiryDate) {
        orderPage.cardExpInput.sendKeys(expiryDate);
    }

    @Then("user clicks to process order button")
    public void user_clicks_to_process_order_button() {
        orderPage.processOrderBtn.click();
    }

    @Then("user should see {string} in the first row of the web table")
    public void user_should_see_in_the_first_row_of_the_web_table(String expectedName) {

        //  String actualName = viewAllOrdersPage.newCostumeCell.getText();

        Assert.assertEquals(expectedName, viewAllOrdersPage.newCostumeCell.getText());

    }


}
