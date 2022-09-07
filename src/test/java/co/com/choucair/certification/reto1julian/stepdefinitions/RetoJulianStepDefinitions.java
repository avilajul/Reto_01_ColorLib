package co.com.choucair.certification.reto1julian.stepdefinitions;

import co.com.choucair.certification.reto1julian.model.FormBlockValidationData;
import co.com.choucair.certification.reto1julian.model.UserData;
import co.com.choucair.certification.reto1julian.questions.*;
import co.com.choucair.certification.reto1julian.tasks.BlockValidationForm;
import co.com.choucair.certification.reto1julian.tasks.EnterBlockValidationForm;
import co.com.choucair.certification.reto1julian.tasks.LoginColorLib;
import co.com.choucair.certification.reto1julian.tasks.OpenUp;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.equalTo;

public class RetoJulianStepDefinitions {

    private final String HOME_LABEL;
    private final String BLOCK_VALIDATION_LABEL;
    private final String REQUIRED_FIELD;
    private final String VALID_EMAIL;
    private final String PASSWORD_LENGTH;
    private final String SAME_PASSWORD;
    private final String INVALID_URL;
    private final String ONLY_DIGITS;
    private final String INVALID_RANGE;


    public RetoJulianStepDefinitions() {
        HOME_LABEL = "Metis";
        BLOCK_VALIDATION_LABEL = "Block Validation";
        REQUIRED_FIELD = "This field is required.";
        VALID_EMAIL = "Please enter a valid email address.";
        PASSWORD_LENGTH = "Please enter at least 5 characters.";
        SAME_PASSWORD = "Please enter the same value again.";
        INVALID_URL = "Please enter a valid URL.";
        ONLY_DIGITS = "Please enter only digits.";
        INVALID_RANGE = "Please enter a value between 5 and 16.";
    }

    @Before
    public void initialConfiguration(){  setTheStage(new OnlineCast()); }

    @Given("^julian enters go to the page to verify the completion of the validation block$")
    public void julianEntersGoToThePageToVerifyTheCompletionOfTheValidationBlock(List<UserData> userData) {
        theActorCalled("Julian").wasAbleTo(OpenUp.thePage(), LoginColorLib.thePage(userData));
        theActorInTheSpotlight().should(seeThat(AnswerAuthentication.toThe(HOME_LABEL)));
    }

    @When("^julian enters the form validation option$")
    public void julianEntersTheFormValidationOption() {
        theActorInTheSpotlight().attemptsTo(EnterBlockValidationForm.enterForm());
        theActorInTheSpotlight().should(seeThat(AnswerBlockValidationLabel.toThe(BLOCK_VALIDATION_LABEL)));
    }

    @When("^julian fills out the Block Validation form$")
    public void julianFillsOutTheBlockValidationForm(List<FormBlockValidationData> formBlockValidationData) {
        theActorInTheSpotlight().attemptsTo(BlockValidationForm.fillOutForm(formBlockValidationData, true));
    }

    @When("^julian does not fills out the Block Validation form$")
    public void julian_does_not_fills_out_the_Block_Validation_form(List<FormBlockValidationData> formBlockValidationData) {
        theActorInTheSpotlight().attemptsTo(BlockValidationForm.fillOutForm(formBlockValidationData, false));
    }

    @Then("^verify that julian successfully filled out the form$")
    public void verifyThatJulianSuccessfullyFilledOutTheForm() {
        theActorInTheSpotlight().should(seeThat(AnswerSuccessfulBlockValidationForm.successfulValidation(), equalTo(true) ));
    }

    @Then("^verify that julian failure to fill out the form$")
    public void verifyThatJulianFailureToFillOutTheForm() {
        theActorInTheSpotlight().should(seeThat(AnswerEmptyForm.areEmptyFields(REQUIRED_FIELD)));
    }

    @Then("^verify that julian filled out the mail wrong$")
    public void verifyThatJulianFilledOutTheMailWrong() {
        theActorInTheSpotlight().should(seeThat(AnswerMailWrong.isEmailWrong(VALID_EMAIL)));
    }

    @Then("^verify that julian filled out less than five characters in the password field$")
    public void verifyThatJulianFilledOutLessThanFiveCharactersInThePasswordField() {
        theActorInTheSpotlight().should(seeThat(AnswerPasswordLenght.validLenghtPassword(PASSWORD_LENGTH)));
    }

    @Then("^verify that julian filled different passwords$")
    public void verifyThatJulianFilledDifferentPasswords() {
        theActorInTheSpotlight().should(seeThat(AnswerPasswords.validPasswords(SAME_PASSWORD)));
    }

    @Then("^verify that julian filled invalid url$")
    public void verifyThatJulianFilledInvalidUrl() {
        theActorInTheSpotlight().should(seeThat(AnswerInvalidUrl.validUrl(INVALID_URL)));
    }

    @Then("^verify that julian filled invalid digits$")
    public void verifyThatJulianFilledInvalidDigits() {
        theActorInTheSpotlight().should(seeThat(AnswerInvalidDigits.validDigits(ONLY_DIGITS)));
    }

    @Then("^verify that julian filled invalid range$")
    public void verifyThatJulianFilledInvalidRange() {
        theActorInTheSpotlight().should(seeThat(AnswerInvalidRange.validRange(INVALID_RANGE)));
    }
}

