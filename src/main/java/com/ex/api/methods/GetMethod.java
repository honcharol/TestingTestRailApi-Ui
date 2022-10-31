package com.ex.api.methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class GetMethod extends AbstractMethod{
    public Response witPrimitiveParameters(String queryParameters, int statusCode){
        RestAssured.baseURI = pr.prop("uri");
        Response response = given()
                .auth()
                .preemptive().basic(pr.prop("email"), pr.prop("password"))
                .queryParam(queryParameters)
                .when()
                .get("index.php")
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .response();
        return response;
    }

}
