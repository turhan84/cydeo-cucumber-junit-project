package com.cydeo.step_definitions;

import com.cydeo.pages.WikiResultPage;
import com.cydeo.pages.WikiSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wiki_StepDefinitons {
    WikiSearchPage wikiSearchPage = new WikiSearchPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org/");

    }
    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String searchValue) {
        wikiSearchPage.searchBox.sendKeys(searchValue);
    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiSearchPage.searchButton.click();
       // BrowserUtils.sleep(10);
    }
    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String expectedInTitle) {
      BrowserUtils.verifyTitle(expectedInTitle + " - Wikipedia");
    }

    WikiResultPage wikiResultPage = new WikiResultPage();

    @Then("User sees {string} is in the main header")
    public void user_sees_is_in_the_main_header(String expectedText) {

        String actualHeaderText = wikiResultPage.mainHeader.getText();

        Assert.assertEquals(expectedText,actualHeaderText );

    }

    @Then("User sees {string} is in the image header")
    public void user_sees_is_in_the_image_header(String expectedText) {

        //String actualText = wikiResultPage.imageHeader.getText();
        //Assert.assertEquals(actualText, expectedText);

        Assert.assertEquals(expectedText,wikiResultPage.imageHeader.getText());

    }
}
