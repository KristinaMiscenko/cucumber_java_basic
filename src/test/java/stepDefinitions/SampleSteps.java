package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    //Task1

    @Given("^Navigate to url \"([^\"]*)\"$")
    public void navigateToUrl(String url) throws Throwable {
        driver.get(url);
    }



    @When("^Enter \"([^\"]*)\"$")
    public void enter(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement numberField = driver.findElement(By.id("numb"));
        numberField.click();
        numberField.sendKeys(arg0);
    }

    @And("^Click on the Submit button$")
    public void clickOnTheSubmitButton() {
        WebElement numberField = driver.findElement(By.tagName("button"));
        numberField.click();
    }

    @Then("^I see an error \"([^\"]*)\"$")
    public void iSeeAnError(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(arg0, driver.findElement(By.id("ch1_error")).getText());
    }


    @Then("^I will see message \"([^\"]*)\"$")
    public void iWillSeeMessage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 64 is 8.00", alert.getText());
        alert.accept();
    }

    @And("^Click on the Add person button$")
    public void clickOnTheAddPersonButton() {
        WebElement numberField = driver.findElement(By.tagName("button"));
        numberField.click();
    }

    @And("^Enter name: \"([^\"]*)\"$")
    public void enterName(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^Enter surname: \"([^\"]*)\"$")
    public void enterSurname(String surname) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys(surname);
    }

    @And("^Enter Date of Birth: \"([^\"]*)\"$")
    public void enterDateOfBirth(String dob) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("dob")).clear();
        driver.findElement(By.id("dob")).sendKeys(dob);
    }

    @And("^Enter job: \"([^\"]*)\"$")
    public void enterJob(String job) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);

    }


    @And("^Click on the Add button$")
    public void clickOnTheAddButton() {
        WebElement numberField = driver.findElement(By.id("modal_button"));
        numberField.click();
    }

    @And("^Click Edit button$")
    public void clickEditButton() {
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[2]/i")).click();
    }

    @Then("^Click on the Edit button$")
    public void clickOnTheEditButton() {
        WebElement numberField = driver.findElement(By.id("modal_button"));
        numberField.click();
    }

    @Then("^Click Delete button$")
    public void clickDeleteButton() {
        driver.findElement(By.xpath("//*[@id=\"person1\"]/span[1]")).click();
    }

    @Then("^Click Reset list button$")
    public void clickResetListButton() {
        driver.findElement(By.xpath("//body/div[4]/button[2]")).click();
    }
}






