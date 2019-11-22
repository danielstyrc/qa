package com.jsystems.qa.qaapi.service;

import com.jsystems.qa.qaapi.model.User;
import com.jsystems.qa.qaapi.model.azure.AzureAuthor;
import com.jsystems.qa.qaapi.specification.Specification;
import io.restassured.RestAssured;

import java.util.List;

public class UserService {

    public static List<User> getUsers() {
        return RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("", User.class)
                ;
    }

    public static List<AzureAuthor> getAzureAuthors() {
        return RestAssured
                .given()
                .spec(Specification.fakeAzureSpecBuilder())
                .when()
                .get("/api/Authors")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("", AzureAuthor.class);

    }

}
