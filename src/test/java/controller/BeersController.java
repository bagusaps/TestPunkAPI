package controller;

import data.BeersData;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BeersController {
    private static final String BASE_URL = "https://api.punkapi.com/v2";
    private static ResponseBody responseBody;



    public ResponseBody getBeersWithParameter(int page, int perPage){
        try {
            RestAssured.baseURI = BASE_URL;
            RequestSpecification request = RestAssured.given();
            request.header("Content-Type", "application/json");
            responseBody = request
                    .queryParam("page", page)
                    .queryParam("per_page", perPage)
                    .get("/beers").body();
            responseBody.print();

        }catch (Exception e){
            throw e;
        }
        return responseBody;
    }

    public ResponseBody getBeers(){
        try {
            RestAssured.baseURI = BASE_URL;
            RequestSpecification request = RestAssured.given();
            request.header("Content-Type", "application/json");
            responseBody = request
                    .get("/beers").body();
            responseBody.print();

        }catch (Exception e){
            throw e;
        }
        return responseBody;
    }

    public void validateGetBeersSchema(){
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.get("/beers")
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("file/SchemaAuth.json"));
    }


}
