package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WT_LoginPage {
    public WT_LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "username")
    public WebElement inputUsername;

    @FindBy(name = "password")
    public WebElement inputPassword;


        @FindBy(xpath = "//button[.='Login']")
        public WebElement loginButton;

        @FindBy(xpath = "//button[.='Logout']")
        public WebElement logoutButton;




        /**
         * This method will log in with below credentials
         * @username : Test
         * @password : Tester
         */

        public void login(){
            inputUsername.sendKeys(ConfigurationReader.getProperty("web_table_username"));
            inputPassword.sendKeys(ConfigurationReader.getProperty("web_table_password"));
            loginButton.click();
        }

        public void login(String username,String password){

            inputUsername.sendKeys(username);
            inputPassword.sendKeys(password);
            loginButton.click();

        }



}
