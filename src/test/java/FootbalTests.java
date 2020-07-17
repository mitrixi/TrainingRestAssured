import config.TestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class FootbalTests extends TestConfig {

    @Test
    public void getAllCompetitionsOneSeason() {
        given()
                .spec(football_requestSpec)
                .queryParam("season", 2016)
                .when()
                .get("competitions/");
    }
}
