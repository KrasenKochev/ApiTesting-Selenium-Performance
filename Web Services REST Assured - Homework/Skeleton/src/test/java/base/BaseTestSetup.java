package base;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;

public class BaseTestSetup {
    private static String STORY_KEY;
    private static String BUG_KEY;

    @BeforeMethod
    public void Authentication(){
        PreemptiveBasicAuthScheme preemptiveBasicAuthScheme = new PreemptiveBasicAuthScheme();
        preemptiveBasicAuthScheme.setUserName(BASE_EMAIL);
        preemptiveBasicAuthScheme.setPassword(API_TOKEN);
        RestAssured.authentication = preemptiveBasicAuthScheme;
    }
    @Test
    public void CreateStory(){
        Response responseStory = RestAssured
                .given()
                .contentType("application/json")
                .body(STORY_PAYLOAD)
                .baseUri(BASE_URL)
                .post(ISSUE_URL);


        Assert.assertEquals(201,responseStory.getStatusCode());
        String responseBodyId = responseStory.getBody().jsonPath().get("id").toString();
        STORY_KEY = responseStory.path("key");

        Assertions.assertFalse(responseBodyId.isEmpty(),"The Id cannot be empty ");
        Assertions.assertFalse(STORY_KEY.isEmpty(),"The Project Key cannot be empty ");

    }

    @Test
    public void CreateBug(){
        Response responseBug =  RestAssured
                .given()
                .contentType("application/json")
                .body(BUG_PAYLOAD)
                .baseUri(BASE_URL)
                .post(ISSUE_URL);

        Assert.assertEquals(201, responseBug.getStatusCode());
        String responseBodyId = responseBug.getBody().jsonPath().get("id").toString();
        BUG_KEY = responseBug.path("key");
        Assertions.assertFalse(responseBodyId.isEmpty(),"The Id cannot be empty ");
        Assertions.assertFalse(BUG_KEY.isEmpty(),"The Project Key cannot be empty ");
    }
    @Test
    public void LinkStoryAndBug(){

        String Link = "{\"type\": " +
                "{\"id\": \"10000\"}, " +
                "\"inwardIssue\": {\"key\": \"" + STORY_KEY + "\"}, " +
                "\"outwardIssue\": {\"key\": \"" + BUG_KEY + "\"}}";

        Response responseLinkStoryBug = RestAssured
                .given()
                .contentType("application/json")
                .body(Link)
                .baseUri(BASE_URL)
                .post("/rest/api/2/issueLink");

        Assert.assertEquals(201, responseLinkStoryBug.getStatusCode());

    }

}

