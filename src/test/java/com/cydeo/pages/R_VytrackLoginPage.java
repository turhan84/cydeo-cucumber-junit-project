package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class R_VytrackLoginPage {

    public R_VytrackLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;


    @FindBy(id = "_submit")
    public WebElement loginBtn;

    // this will be working for any user that you passed in step def class
    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
        // wait.until(ExpectedConditions.titleIs("Dashboard"));
    }

    // this will be working only for driver
    public void login() {
        usernameInput.sendKeys(ConfigurationReader.getProperty("driver_username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("driver_password"));
        loginBtn.click();
    }

    public void login(String userType) {

        userType = userType.replace(" ", "_");

        String username = ConfigurationReader.getProperty(userType + "_username");
        String password = ConfigurationReader.getProperty(userType + "_password");

        login(username,password);
    }

}


