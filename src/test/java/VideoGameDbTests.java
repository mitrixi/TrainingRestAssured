import config.EndPoint;
import config.TestConfig;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class VideoGameDbTests extends TestConfig {

    @Test
    public void getAllGames() {
        given()
                .when()
                .get(EndPoint.VIDEOGAMES)
                .then();
    }

    @Test
    public void createNewGameByJSON() {
        String gameBodyJson = "{\n" +
                "  \"id\": 11,\n" +
                "  \"name\": \"MyNewGame\",\n" +
                "  \"releaseDate\": \"2020-07-16T07:58:07.709Z\",\n" +
                "  \"reviewScore\": 50,\n" +
                "  \"category\": \"Driving\",\n" +
                "  \"rating\": \"Mature\"\n" +
                "}";
        given()
                .body(gameBodyJson)
                .when()
                .post(EndPoint.VIDEOGAMES)
                .then();
    }

    @Test
    public void createNewGameByXML() {
        String gameBodyXml = "<videoGame category=\"Shooter\"\n" +
                "rating=\"Universal\">\n" +
                "    <id>12</id>\n" +
                "    <name>Resident Evil 7</name>\n" +
                "    <releaseDate>2005-10-\n" +
                "01T00:00:00+01:00</releaseDate>\n" +
                "    <reviewScore>75</reviewScore>\n" +
                "  </videoGame>";

        given()
                .body(gameBodyXml)
                .when()
                .post(EndPoint.VIDEOGAMES)
                .then();
    }

    @Test
    public void updateGame() {
        String gameBodyJson = "{\n" +
                "  \"id\": 11,\n" +
                "  \"name\": \"MyNewUpdateGame\",\n" +
                "  \"releaseDate\": \"2020-07-16T07:58:07.709Z\",\n" +
                "  \"reviewScore\": 99,\n" +
                "  \"category\": \"Driving\",\n" +
                "  \"rating\": \"Mature\"\n" +
                "}";
        given()
                .body(gameBodyJson)
                .when()
                .put(EndPoint.VIDEOGAMES + "/11")
                .then();
    }

    @Test
    public void deleteGame() {
        given()
                .delete(EndPoint.VIDEOGAMES + "/11")
                .then();
    }

    @Test
    public void getSingleGame() {
        given()
                .pathParam("VideoGameId", 5)
                .when()
                .get(EndPoint.SINGLE_VIDEOGAME);
    }

    @Test
    public void testVideoGameSerializationByJSON() {
        VideoGame videoGame = new VideoGame("15", "shooter", "2014-06-06", "Halo 5", "Mature" , "89");
        given()
                .body(videoGame)
        .when()
                .post(EndPoint.VIDEOGAMES)
        .then();
    }
}
