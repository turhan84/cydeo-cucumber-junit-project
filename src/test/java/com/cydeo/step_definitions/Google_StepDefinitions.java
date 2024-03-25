package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Google_StepDefinitions {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("user searches for {word}")
    public void user_searches_for_apple(String word) {

        googleSearchPage.searchBox.sendKeys(word + Keys.ENTER);

    }

    @Then("user should see {word} in the title")
    public void user_should_see_apple_in_the_title(String word) {

        wait.until(ExpectedConditions.titleIs(word+" - Google Search"));

        BrowserUtils.verifyTitle(word+" - Google Search");

    }




    @When("user is on the Google search page")
    public void user_is_on_the_google_search_page() {

        Driver.getDriver().get("https://www.google.com");

    //    WebElement closingButton = Driver.getDriver().findElement(By.id("W0wltc"));
     //   closingButton.click();


        googleSearchPage.pupupClose.click();




    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Google";

        Assert.assertEquals(expectedTitle,actualTitle );

        Driver.closeDriver();

    }


}
