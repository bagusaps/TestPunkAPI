package steps;

import controller.BeersController;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import data.BeersData;
import io.cucumber.java.en.Given;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ResponseBody;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class BeersSteps {

    BeersData beersData;
    BeersController beersController;

    public BeersSteps(){
        beersData = new BeersData();
        beersController = new BeersController();
    }

    @Given("prepare data to get beers with page {int}")
    public void prepareDataToGetBeersWithPagePage(int page) {
        beersData.setPage(page);
    }
    @Given("prepare data to get beers with per page {int}")
    public void prepareDataToGetBeersWithPerPage(int perPage) {
        beersData.setPerPage(perPage);
    }

    @When("get beers with paramater page and per page")
    public void getBeersWithParamaterPageAndPerPage() {
        ResponseBody responseBody =
                beersController.getBeersWithParameter(beersData.getPage(),beersData.getPerPage());
        beersData.setResponseBody(responseBody);
    }
    @Then("get beers response data is {int}")
    public void getBeersResponseDataIsPerPage(int dataCount) {
        List<String> listIdData = beersData.getResponseBody().jsonPath().getList("id");
        assertThat("data count not match", listIdData.size(), Matchers.is(dataCount));
    }

    @When("get beers")
    public void getBeers() {
        ResponseBody responseBody =
                beersController.getBeers();
        beersData.setResponseBody(responseBody);
    }

    @Then("get beers json schema is correct")
    public void getBeersJsonSchemaIsCorrect() {
        beersController.validateGetBeersSchema();
    }
}
