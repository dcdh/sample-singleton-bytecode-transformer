package com.damdamdeo.sample.singleton.bytecode.transformer.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class SampleSingletonBytecodeTransformerResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/sample-singleton-bytecode-transformer")
                .then()
                .statusCode(200)
                .body(is("Hello sample-singleton-bytecode-transformer"));
    }
}
