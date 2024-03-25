package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {

    public AmazonHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchBtn;


    @FindBy(xpath = "//a[@onclick='window.location.reload()']" )
    public WebElement popUpClose_1;

    @FindBy(xpath = "//button[@id='sp-cc-rejectall-link']")
    public WebElement popUpClose_2;


}
