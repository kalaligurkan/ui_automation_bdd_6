//package steps;
//
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import pages.Project04Page;
//import utils.Driver;
//import utils.TableHandler;
//
//import java.util.List;
//
//public class Project04Steps {
//
//    WebDriver driver;
//    Project04Page project04Page;
//
//    @Before
//    public void setDriver(){
//        driver = Driver.getDriver();
//        project04Page = new Project04Page();
//    }
//
//
//    @Then("the user should see the {string} heading")
//    public void the_user_should_see_the_heading(String headingText) {
//        Assert.assertEquals(headingText, project04Page.mainHeading.getText());
//    }
//    @Then("the user should see the table with the headers below")
//    public void the_user_should_see_the_table_with_the_headers_below(DataTable dataTable) {
//        List<String> headerText = dataTable.asList();
//
//        for (int i = 0; i < headerText.size(); i++) {
//            Assert.assertEquals(headerText.get(i), project04Page.tableHeading.get(i).getText());
//        }
//    }
//    @Then("the user should see the table with the rows below")
//    public void the_user_should_see_the_table_with_the_rows_below(DataTable dataTable) {
//        List<List<String>> expectedTable = dataTable.asLists();
//        List<List<WebElement>> actualTable = TableHandler.getTableData(project04Page.table);
//
//        for (int i = 0; i < expectedTable.size(); i++) {
//            for (int j = 0; j < expectedTable.get(i).size(); j++) {
//                Assert.assertEquals(expectedTable.get(i).get(j), actualTable.get(i).get(j).getText());
//            }
//        }
//
//    }
//    @Then("the user should see the {string} button is enabled")
//    public void the_user_should_see_the_button_is_enabled(String button) {
//        switch (button){
//            case "ADD PRODUCT":
//                Assert.assertTrue(project04Page.addProductButton.isEnabled());
//                break;
//            case "X":
//                Assert.assertTrue(project04Page.closeButton.isEnabled());
//                break;
//            case "SUBMIT":
//                Assert.assertTrue(project04Page.submitButton.isEnabled());
//                break;
//            default:
//        }
//    }
//    @Then("the user should see the {string} text displayed")
//    public void the_user_should_see_the_text_displayed(String total) {
//        Assert.assertEquals(total, project04Page.totalAmount.getText());
//    }
//
//    @When("the user clicks on the {string} button")
//    public void theUserClicksOnTheButton(String button) {
//        switch (button){
//            case "ADD PRODUCT":
//                project04Page.addProductButton.click();
//                break;
//            case "X":
//                project04Page.closeButton.click();
//                break;
//            case "SUBMIT":
//                project04Page.submitButton.click();
//                break;
//            default:
//        }
//    }
//
//    @Then("the user should see the {string} modal with its heading")
//    public void theUserShouldSeeTheModalWithItsHeading(String headingText) {
//        Assert.assertEquals(headingText, project04Page.modalCardTitle.getText());
//    }
//
//    @And("the user should see the {string} label")
//    public void theUserShouldSeeTheLabel(String label) {
//        switch (label){
//            case "Please select the quantity":
//                Assert.assertTrue(project04Page.labels.get(0).isDisplayed());
//                break;
//            case "Please enter the name of the product":
//                Assert.assertTrue(project04Page.labels.get(1).isDisplayed());
//                break;
//            case "Please enter the price of the product":
//                Assert.assertTrue(project04Page.labels.get(2).isDisplayed());
//                break;
//            default:
//        }
//    }
//
//    @And("the user should see the {string} input box is enabled")
//    public void theUserShouldSeeTheInputBoxIsEnabled(String inputBox) {
//        switch (inputBox) {
//            case "Quantity":
//                Assert.assertTrue(project04Page.productDetails.get(0).isEnabled());
//                break;
//            case "Product":
//                Assert.assertTrue(project04Page.productDetails.get(1).isEnabled());
//                break;
//            case "Price":
//                Assert.assertTrue(project04Page.productDetails.get(2).isEnabled());
//                break;
//            default:
//        }
//    }
//
//    @Then("the user should not see the Add New Product modal")
//    public void theUserShouldNotSeeTheModal() {
//        try {
//            Assert.assertFalse(project04Page.modalCardTitle.isDisplayed());
//        }
//        catch (NoSuchElementException e){
//            Assert.assertTrue(true);
//        }
//    }
//
//    @And("the user enters the {string} as {string}")
//    public void theUserEntersTheAs(String details, String input) {
//        switch (details){
//            case "Quantity":
//                project04Page.productDetails.get(0).sendKeys(input);
//                break;
//            case "Product":
//                project04Page.productDetails.get(1).sendKeys(input);
//                break;
//            case"Price":
//                project04Page.productDetails.get(2).sendKeys(input);
//                break;
//            default:
//        }
//
//    }
//
//    @Then("the user should see the table with the new row below")
//    public void theUserShouldSeeTheTableWithTheNewRowBelow(DataTable dataTable) {
//        List<String> expectedRow = dataTable.asList();
//
//        for (int i = 0; i < expectedRow.size(); i++) {
//            Assert.assertEquals(expectedRow.get(i), TableHandler.getTableRow(4).get(i).getText());
//        }
//    }
//}
//
//package steps;
//
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.NotFoundException;
//import org.openqa.selenium.WebDriver;
//import pages.Project04Page;
//import utils.Driver;
//
//import java.util.List;
//
//public class Project04Steps {
//
//    WebDriver driver;
//    Project04Page project04Page;
//
//    @Before
//    public void setDriver(){
//        driver = Driver.getDriver();
//        project04Page = new Project04Page();
//    }
//
//    //---------------------Task01--------------------
//
//    @Given("the user is on {string}")
//    public void the_user_is_on_https_techglobal_training_com_frontend_project(String url) {
//        driver.get(url);
//    }
//    @Then("the user should see the {string} heading")
//    public void the_user_should_see_the_inventory_heading(String header) {
//        Assert.assertEquals(header, project04Page.inventoryHeading.getText());
//    }
//    @And("the user should see the table with the headers below")
//    public void the_user_should_see_the_table_with_the_headers_below(DataTable dataTable) {
//        List<String> expectedHeaders = dataTable.asList();
//
//        for (int i = 0; i < expectedHeaders.size(); i++) {
//            Assert.assertEquals(expectedHeaders.get(i), project04Page.headers.get(i).getText());
//
//        }
//    }
//    @And("the user should see the table with the rows below")
//    public void the_user_should_see_the_table_with_the_rows_below(DataTable dataTable) {
//        List<String> expectedInventoryList = dataTable.asList();
//
//        for (int i = 0; i < expectedInventoryList.size(); i++) {
//            Assert.assertEquals(expectedInventoryList.get(i), project04Page.inventoryList.get(i).getText());
//
//        }
//    }
//    @And("the user should see the {string} button is enabled")
//    public void the_user_should_see_the_add_product_button_is_enabled(String addProductbutton) {
//
//        Assert.assertTrue(addProductbutton, project04Page.addProductButton.isEnabled());
//    }
//    @And("the user should see the {string} text displayed")
//    public void the_user_should_see_the_total_$_text_displayed(String totalAmount) {
//        Assert.assertEquals(totalAmount, project04Page.totalAmountText.getText());
//    }
//
//
//    //---------------------Task02--------------------
//
//
//
//    @When("the user clicks on the {string} button")
//    public void theUserClicksOnTheButton(String arg0) {
//        project04Page.addProductButton.click();
//    }
//
//    @Then("the user should see the {string} modal with its heading")
//    public void theUserShouldSeeTheModalWithItsHeading(String header) {
//        Assert.assertEquals(header,project04Page.modalHeader.getText());
//    }
//
//    @And("the user should see the {string} label")
//    public void theUserShouldSeeTheLabel(String arr) {
//        switch (arr) {
//            case "Please select the quantity":
//                Assert.assertEquals(arr, project04Page.productLabels.get(0).getText());
//                break;
//            case "Please enter the name of the product":
//                Assert.assertEquals(arr, project04Page.productLabels.get(1).getText());
//                break;
//            case "Please enter the price of the product":
//                Assert.assertEquals(arr, project04Page.productLabels.get(2).getText());
//                break;
//            default:
//                throw new NotFoundException("The error message is not defined properly in the feature file");
//        }
//
//    }
//
//
//    @And("the user should see the {string} input box is enabled")
//    public void the_user_should_see_the_price_input_box_is_enabled(String input) {
//        switch (input) {
//            case "Quantity":
//                Assert.assertTrue(input, project04Page.productInput.get(0).isEnabled());
//                break;
//            case "Product":
//                Assert.assertTrue(input, project04Page.productInput.get(1).isEnabled());
//                break;
//            case "Price":
//                Assert.assertTrue(input, project04Page.productInput.get(2).isEnabled());
//                break;
//
//            default:
//                throw new NotFoundException("The error message is not defined properly in the feature file");
//        }
//
//
//
//    }
//
//    @And("the user should see the SUBMIT button is enabled")
//    public void the_user_should_see_the_submit_button_is_enabled() {
//        Assert.assertTrue(project04Page.submitButton.isEnabled());
//    }
//
//    //---------------------Task03--------------------
//
//  // @When("the user clicks on the {string} button")
//  // public void the_user_clicks_on_the_add_product_button() {
//  //     project04Page.addProductButton.click();
//  // }
//  // @Then("the user should see the {string} modal with its heading")
//  // public void the_user_should_see_the_add_new_product_modal_with_its_heading(String header) {
//  //     Assert.assertEquals(header,project04Page.modalHeader.getText());
//  // }
//  // @When("the user clicks on the {string} button")
//  // public void the_user_clicks_on_the_x_button() {
//  //     project04Page.modalXHeader.click();
//  // }
//    @Then("the user should not see the Add New Product modal")
//    public void the_user_should_not_see_the_add_new_product_modal() {
//        try {
//            Assert.assertTrue(project04Page.modalHeader.isDisplayed());
//        } catch (NoSuchElementException e) {
//            Assert.assertTrue(true);
//        }
//    }
//
//
//
//    //---------------------Task04--------------------
//
//    @And("the user enters the quantity as {string}")
//    public void the_user_enters_the_quantity_as(String quantity) {
//        project04Page.productInput.get(0).sendKeys(quantity);
//    }
//
//    @And("the user enters the product as {string}")
//    public void the_user_enters_the_product_as(String product) {
//        project04Page.productInput.get(1).sendKeys(product);
//    }
//
//    @And("the user enters the price as {string}")
//    public void the_user_enters_the_price_as(String price) {
//        project04Page.productInput.get(2).sendKeys(price);
//    }
//
//    @Then("the user should see the table with the new row below")
//    public void the_user_should_see_the_table_with_the_new_row_below(DataTable dataTable) {
//        // project04Page.newAddedList.forEach(l -> Assert.assertTrue(l.isDisplayed()));
//
//        List<String> expectedResult = dataTable.asList();
//        for (int i = 0; i <expectedResult.size() ; i++) {
//            Assert.assertEquals(expectedResult.get(i),project04Page.newAddedList.get(i).getText());
//        }
//    }
//
//
//
//}
//
//







