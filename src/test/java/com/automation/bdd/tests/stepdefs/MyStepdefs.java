package com.automation.bdd.tests.stepdefs;

import com.automation.bdd.tests.serenity.StepsForSerenity;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MyStepdefs {

    @Steps
    StepsForSerenity stepsForSerenity;

    @Given("^a user visits a home page$")
    public void userVisitHomePage() {
        stepsForSerenity.userVisitsPage();
    }

    @When("the user chooses category computer")
    public void theUserChoosesCategoryComputer() {
        stepsForSerenity.userChoosesComputerCategory();
    }

    @Then("the user can see subcategory 'IT услуги'")
    public void theUserCanSeeSubcategory() {
        stepsForSerenity.theUserCanSeeSubcategoryITService("IT услуги");
    }

    @And("user exit from the site")
    public void userExitFromTheSite() {
        stepsForSerenity.webDriverClose();
    }

    @When("the user visits Furniture page")
    public void theUserVisitsFurniturePage() {
        stepsForSerenity.userChoosesSofaCategory();
    }

    @And("the user goes to a Sofa page")
    public void theUserGoesToASofasCategoryPage() {
        stepsForSerenity.theUserChoosesSofaMaker();
    }

    @Then("the user can see all available sofas")
    public void theUserCanSeeChosenSofas() {
        stepsForSerenity.theUserCanSeeChosenSofas("AMF");
    }
}
