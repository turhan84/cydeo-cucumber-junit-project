package com.cydeo.step_definitions;

import com.cydeo.pages.AmazonHomePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class Amazon_StepDefinitions {

    AmazonHomePage homePage = new AmazonHomePage();

    @Given("user is on the Amazon homepage")
    public void user_is_on_the_amazon_homepage() {
        Driver.getDriver().get("https://www.amazon.co.uk/");
        BrowserUtils.sleep(1);
        homePage.popUpClose_1.click();
        BrowserUtils.sleep(1);
        homePage.popUpClose_2.click();

    }
    @Then("user should see title is as expected")
    public void user_should_see_title_is_as_expected() {

        String expectedTitle = "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more";
        BrowserUtils.verifyTitle(expectedTitle);

    }

    @When("user types Wooden Spoon in the search box")
    public void user_types_wooden_spoon_in_the_search_box() {

        homePage.searchBox.sendKeys("Wooden Spoon");

    }

    @When("user click to Amazon search button")
    public void user_click_to_amazon_search_button() {

        homePage.searchBtn.click();

    }

    @Then("user sees Wooden Spoon is in the title")
    public void user_sees_wooden_spoon_is_in_the_title() {
        BrowserUtils.verifyTitleContains("Wooden Spoon");
    }


    @When("user types {string} in the search box")
    public void user_types_in_the_search_box(String searchText) {
        homePage.searchBox.sendKeys(searchText);
    }

    @Then("user sees {string} is in the title")
    public void user_sees_is_in_the_title(String expectedTitle) {
        BrowserUtils.verifyTitleContains(expectedTitle);
    }

}
