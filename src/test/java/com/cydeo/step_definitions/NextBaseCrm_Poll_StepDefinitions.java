package com.cydeo.step_definitions;

import com.cydeo.pages.NextBaseCrm_Poll_Page;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class NextBaseCrm_Poll_StepDefinitions {
    NextBaseCrm_Poll_Page pollPage = new NextBaseCrm_Poll_Page();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    int randomNumber = ThreadLocalRandom.current().nextInt(1, 999);

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("NextBaseCrm_URL"));

        pollPage.userName.sendKeys(ConfigurationReader.getProperty("NextBaseCrm_loginName"));
        pollPage.password.sendKeys(ConfigurationReader.getProperty("NextBaseCrm_loginPassword"));
        pollPage.loginBtn.click();

    }

    @When("the user clicks on the Create Poll button")
    public void the_user_clicks_on_the_create_poll_button() {
        wait.until(ExpectedConditions.titleIs("Portal"));
        pollPage.pollBtn.click();

    }

    @When("enters a question and two answers")
    public void enters_a_question_and_two_answers() {
        //int randomNumber = ThreadLocalRandom.current().nextInt(1,999);
        Driver.getDriver().switchTo().frame(pollPage.iframe);
        pollPage.messageBox.sendKeys("Practice " + randomNumber);
        String expectedTitle = "Practice " + randomNumber;
        Driver.getDriver().switchTo().defaultContent();


        pollPage.questionBox.sendKeys("Cydeo " + randomNumber);
        pollPage.getAnswer1Box.sendKeys("Java " + randomNumber);
        pollPage.getAnswer2Box.sendKeys("SDET " + randomNumber);

    }

    @When("clicks the Submit button")
    public void clicks_the_submit_button() {
        pollPage.sendBtn.click();
        wait.until(ExpectedConditions.titleIs("Portal"));
    }

    @Then("the user should see the created poll in the feed")
    public void the_user_should_see_the_created_poll_in_the_feed() {

        // JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        // WebElement element = (WebElement) js.executeScript("return document.getElementById('feed-loader-container');");

        wait.until(ExpectedConditions.titleIs("Portal"));

       // List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//div[starts-with(@id, 'blg-post')]"));

        List<WebElement> elements = Driver.getDriver().findElements(By.cssSelector("div[id^='blg-post']"));



        WebElement lastElementID = elements.get(0);

        String endOfWord = String.valueOf(randomNumber);


        WebElement messageBoxText = Driver.getDriver().findElement(By.xpath("(//div[starts-with(@id, 'blg-post')])[1]//div[@class='feed-post-text-block-inner-inner']"));

        String actualMessageText = messageBoxText.getText();

        System.out.println("actualMessageText = " + actualMessageText);

        Assert.assertTrue(actualMessageText.endsWith(endOfWord));

        // Assert.assertEquals(expectedTitle,);

        Assert.assertTrue(lastElementID.isDisplayed());
        System.out.println("elementID.isDisplayed() = " + lastElementID.isDisplayed());
        System.out.println("elementID.getAttribute(id) = " + lastElementID.getAttribute("id"));


        // wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.id(element1.getAttribute("id")))));


    }

    @Given("the user is on the poll creation tab")
    public void the_user_is_on_the_poll_creation_tab() {

        pollPage.pollBtn.click();

    }

    @When("the user clicks on the Cancel button")
    public void the_user_clicks_on_the_button() {
        pollPage.cancelBtn.click();

    }

    @Then("the poll message area should collapse")
    public void the_poll_message_area_should_collapse() {

        Assert.assertEquals(false, pollPage.sendBtn.isDisplayed());

        Assert.assertTrue(pollPage.sendMessageText.isDisplayed());


    }
}
