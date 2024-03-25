package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WT_OrderPage {
    public WT_OrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[text()='Order']")
    public WebElement orderBtn;

    @FindBy(name = "product")
    public WebElement product_dropDown;

    @FindBy(xpath = "//input[@value='Visa']")
    public WebElement visaRadioButton;

    @FindBy(xpath = "//input[@value='MasterCard']")
    public WebElement masterCardRadioButton;

    @FindBy(xpath = "//input[@value='American Express']")
    public WebElement americanExpressRadioButton;

    @FindBy(name = "quantity")
    public WebElement quantityInput;

    @FindBy(xpath = "//button[text()='Calculate']")
    public WebElement calculateBtn;

    //Address Information


    @FindBy(name = "name")
    public WebElement nameInput;

    @FindBy(name = "street")
    public WebElement streetInput;

    @FindBy(name = "city")
    public WebElement cityInput;

    @FindBy(name = "state")
    public WebElement stateInput;

    @FindBy(name = "zip")
    public WebElement zipInput;

   @FindBy(name = "cardNo")
   public WebElement cardNoInput;

   @FindBy(name = "cardExp")
   public WebElement cardExpInput;


   @FindBy(xpath = "//button[text()='Process Order']")
   public WebElement processOrderBtn;

    public void paymentSelect(String paymentOption) {

        if (paymentOption.equalsIgnoreCase("visa")) {
            visaRadioButton.click();
        } else if (paymentOption.equalsIgnoreCase("MasterCard")) {
            masterCardRadioButton.click();
        } else {
            americanExpressRadioButton.click();
        }

    }


}
