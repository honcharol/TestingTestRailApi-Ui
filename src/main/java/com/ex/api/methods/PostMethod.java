package com.ex.api.methods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostMethod extends AbstractMethod{
    public Response withBasicParameters(String queryParameters, String body){
        RestAssured.baseURI = pr.prop("uri");
        return given()
                .auth().preemptive()
                .basic(pr.prop("email"), pr.prop("password"))
                .contentType(ContentType.JSON)
                .queryParam(queryParameters)
                .body(body)
                .when()
                .post("index.php")
                .then()
                .extract().response();


    }

}
