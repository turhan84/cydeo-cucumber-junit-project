package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NextBaseCrm_Poll_Page {

    public NextBaseCrm_Poll_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "USER_LOGIN")
    public WebElement userName;
    @FindBy(name = "USER_PASSWORD")
    public WebElement password;


    @FindBy(className = "login-btn")
    public WebElement loginBtn;



    @FindBy(id = "feed-add-post-form-tab-vote")
    public WebElement pollBtn;
    @FindBy(tagName = "body")
    public WebElement messageBox;
    @FindBy(id = "question_0")
    public WebElement questionBox;
    @FindBy(id = "answer_0__0_")
    public WebElement getAnswer1Box;
    @FindBy(id = "answer_0__1_")
    public WebElement getAnswer2Box;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendBtn;
    @FindBy(id = "blog-submit-button-cancel")
    public WebElement cancelBtn;


    @FindBy(className = "bx-editor-iframe")
    public WebElement iframe;

    @FindBy(id = "blogPostForm")
    public WebElement blogPostFormBox;

    @FindBy(xpath = "//span[text()='Send message …']")
    public WebElement sendMessageText;

    @FindBy(css = "div[id^='blg-post']")
    public WebElement pollFoundID;


}
