package io.kfj.ExerciseListService;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import javax.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class ExerciseResourceTest {


    @Test
    public void testWebRootPath() {
        given()
          .when().get("/")
          .then()
             .statusCode(200)
             .contentType(MediaType.APPLICATION_JSON);
    }

}
