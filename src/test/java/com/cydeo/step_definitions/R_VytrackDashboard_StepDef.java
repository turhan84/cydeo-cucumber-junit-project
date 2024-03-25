package com.cydeo.step_definitions;

import com.cydeo.pages.R_VytrackDashboardPage;
import com.cydeo.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class R_VytrackDashboard_StepDef {
    
    R_VytrackDashboardPage dashboardPage = new R_VytrackDashboardPage();

    @Then("user should be able to see following modules")
    public void user_should_be_able_to_see_following_modules(List<String> expectedTopModules) {


        BrowserUtils.waitForTitleContains("Dashboard");

        BrowserUtils.sleep(3);

        List<String> actualTopModules = new ArrayList<>();

        for (WebElement eachTopModule : dashboardPage.allTopModules) {
            actualTopModules.add(eachTopModule.getText());
        }

        Assert.assertEquals(expectedTopModules,actualTopModules);
    }

}
