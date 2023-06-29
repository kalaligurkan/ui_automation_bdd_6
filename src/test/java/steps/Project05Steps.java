package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Project05Page;
import utils.Driver;

import java.util.List;

public class Project05Steps {
    WebDriver driver;
    Project05Page project05Page;

    @Before
    public void setDriver() {
        driver = Driver.getDriver();
        project05Page = new Project05Page();
    }

    @Given("the user is on {string}")
    public void theUserIsOn(String arg0) {
        driver.get(arg0);
    }

    //------------------------1

    @Then("the user sees the {string} heading")
    public void theUserShouldSeeThePaginationHeadingAndSubheading(String heading) {

        switch (heading) {
            case "Pagination":
                Assert.assertTrue(project05Page.paginationHeading.isDisplayed());
                Assert.assertEquals(project05Page.paginationHeading.getText(), heading);
                break;
            case "World City Populations 2022":
                Assert.assertTrue(project05Page.populationHeading.isDisplayed());
                Assert.assertEquals(project05Page.populationHeading.getText(), heading);
                break;
            default:

        }
    }

    @And("the user sees the {string} paragraph")
    public void theUserShouldSeeTheParagraph(String paragraph) {
        Assert.assertEquals(paragraph, project05Page.paragraphText.getText());
    }

    @And("the user should see the {string} sub header")
    public void theUserShouldSeeTheSubHeader(String arr) {
        Assert.assertEquals(arr, project05Page.populationHeading.getText());
    }

    //------------------------2

    @Then("the user should see the {string} button is disabled")
    public void the_user_should_see_the_button_is_disabled(String string) {
        switch (string) {
            case "Previous":
                Assert.assertFalse(project05Page.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertFalse(project05Page.nextButton.isEnabled());
                break;
            default:
        }
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheNextButton(String str) {
        if (str.equals("Next")) {
            project05Page.nextButton.click();
        }
    }

    @When("the user clicks on the {string} button till it becomes disabled")
    public void the_user_clicks_on_the_button_till_it_becomes_disabled(String str) {
        if (str.equals("Next")) {

            while (project05Page.nextButton.isEnabled()) {

                project05Page.nextButton.click();
            }
            Assert.assertFalse(project05Page.nextButton.isEnabled());
        }
    }

    @And("the user should see the {string} button is enabled")
    public void the_user_should_see_the_next_button_is_enabled(String button) {
        switch (button) {
            case "Previous":
                Assert.assertTrue(project05Page.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertTrue(project05Page.nextButton.isEnabled());
                break;
            default:
        }
    }


    //------------------------3

    @Then("the user should see {string} City with the info below and an image")
    public void theUserShouldSeeCityWithTheInfoBelowAndAnImage(DataTable dataTable, String str) {

        List<String> expectedText = dataTable.asList();
        for (int i = 0; i < dataTable.asList().size(); i++) {

            Assert.assertEquals(expectedText.get(i), project05Page.cityInfo.get(i).getText());
        }
    }
}
