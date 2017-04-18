package com.zombiesurvival;

import org.junit.BeforeClass;
import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.RestAssured;

public class ZombiesurvivalTests {
	@BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }


        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/zombiesurvival/rest";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;
    }
	
	@Test
    public void basicPingTest() {
        given().when().get("/survivors").then().statusCode(200);
    }
}
