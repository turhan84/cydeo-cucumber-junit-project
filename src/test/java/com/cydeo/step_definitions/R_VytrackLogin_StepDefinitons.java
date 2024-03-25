package com.cydeo.step_definitions;

import com.cydeo.pages.R_VytrackLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class R_VytrackLogin_StepDefinitons {

    R_VytrackLoginPage loginPage = new R_VytrackLoginPage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackUrl"));
    }

    @When("user enters the driver information")
    public void user_enters_the_driver_information() {

        //      loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("driver_username"));
        //      loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("driver_password"));
        //      loginPage.loginBtn.click();

        loginPage.login(ConfigurationReader.getProperty("driver_username"), ConfigurationReader.getProperty("driver_password"));


    }

    @Then("user should be able to login")
    public void user_should_be_able_to_login() {

        wait.until(ExpectedConditions.titleIs("Dashboard"));

        Assert.assertEquals("Title verifications failed!","Dashboard", Driver.getDriver().getTitle());

      //  BrowserUtils.verifyTitle("Dashboard");

    }


    @When("user enters the sales manager information")
    public void user_enters_the_sales_manager_information() {

//        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("sales_manager_username"));

//        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("sales_manager_password"));

//        loginPage.loginBtn.click();

        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty("sales_manager_password"));



    }


    @When("user enters the store manager information")
    public void user_enters_the_store_manager_information() {
//        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("store_manager_username"));

//        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("store_manager_password"));

//        loginPage.loginBtn.click();

        loginPage.login(ConfigurationReader.getProperty("store_manager_username"), ConfigurationReader.getProperty("store_manager_password"));

    }


    @When("user enters the {string} information")
    public void user_enters_the_driver_information(String userType) {

        loginPage.login(userType);


    }


    @When("the user login with {string},{string}")
    public void the_user_login_with(String username, String password) {

        loginPage.login(username,password);
    }

    @Then("the user should not be able to log in")
    public void the_user_should_not_be_able_to_logIn() {

    BrowserUtils.verifyTitle("Login");
    }
}
