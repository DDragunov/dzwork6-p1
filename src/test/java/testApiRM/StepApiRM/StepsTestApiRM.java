package testApiRM.StepApiRM;

import static io.restassured.RestAssured.given;

import static Utils.Configuration.getConfigurationValue;

import io.cucumber.java.ru.*;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

public class StepsTestApiRM {
    public int IdPers;
    public int IdLastPers;
    public int IdlastEpisode;
    public String MortyLoc;
    public String MortyRace;
    public String LastPersRace;
    public String LastPersLoc;


    @Допустим("^вибираем персонажа Morty Smit")
    //public void getIdPers(String namePers){
    public void getIdPers(){

        RequestSpecification request = given();
        request
                .baseUri(Utils.Configuration.getConfigurationValue("url_RM"))
                .header("Content-type","application/json")
        ;
        Response response = request

                .when()
                .get("/character/?name=" +"Morty Smit")//namePers=Morty Smit
                .then()
                .assertThat().statusCode(200)
                .log().all()
                .extract()
                .response();

        IdPers = response.body().jsonPath().get("results[0].id");
    }
    @Тогда("^найдем местоположение и рассу этого персонажа")
    public void getInfoPers(){
        RequestSpecification request = given();
        request
                .baseUri(getConfigurationValue("url_RM"))
                .header("Content-type","application/json")
        ;
        Response response = request
                .when()
                .get("/character/" +IdPers)
                .then()
                .assertThat().statusCode(200)
                .log().all()
                .extract()
                .response();

        MortyLoc=new JSONObject(response.getBody().asString()).getJSONObject("location").get("name").toString();
        MortyRace=new JSONObject(response.getBody().asString()).get("species").toString();
    }
    @И("^найдем последний эпизод, в котором он встречается")
    public void getLastEpisodePers(){
        RequestSpecification request = given();
        request
                .baseUri(getConfigurationValue("url_RM"))
                .header("Content-type","application/json")
        ;
        Response response = request
                .when()
                .get("/character/" +IdPers)
                .then()
                .assertThat().statusCode(200)
                .log().all()
                .extract()
                .response();

        int episode = new JSONObject(response.getBody().asString()).getJSONArray("episode").length()-1;
        IdlastEpisode = Integer.parseInt(new JSONObject(response.getBody().asString()).getJSONArray("episode").get(episode).toString().replaceAll("[^0-9]",""));
    }
    @И("^определим последнего персонажа в послежнем эпизоде")
    public void getLastPers(){
        RequestSpecification request = given();
        request
                .baseUri(getConfigurationValue("url_RM"))
                .header("Content-type","application/json")
        ;
        Response response = request
                .when()
                .get("/episode/" +IdlastEpisode)
                .then()
                .assertThat().statusCode(200)
                .log().all()
                .extract()
                .response();
        int arrayIdlastPers = new JSONObject(response.getBody().asString()).getJSONArray("characters").length()-1;
        IdLastPers = Integer.parseInt(new JSONObject(response.getBody().asString()).getJSONArray("characters").get(arrayIdlastPers).toString().replaceAll("[^0-9]",""));
    }
    @Когда("^определим местоположение и рассу последнего персонажа последнего эпизода")
    public void getLastPersInfo(){
        RequestSpecification request = given();
        request
                .baseUri(getConfigurationValue("url_RM"))
                .header("Content-type","application/json")
        ;
        Response response = request
                .when()
                .get("/character/" +IdLastPers)
                .then()
                .assertThat().statusCode(200)
                .log().all()
                .extract()
                .response();
        LastPersRace=new JSONObject(response.getBody().asString()).get("species").toString();
        LastPersLoc=new JSONObject(response.getBody().asString()).getJSONObject("location").get("name").toString();
    }

    @Тогда("^сравниваем рассу персонажей")
    public void AssertRacePers()
    {
        Assertions.assertEquals(MortyRace,LastPersRace,"Расы персонажей не идентичны.");
    }
    @И("^сравниваем местоположение персонажей")
    public void AssertLocPers()
    {
        Assertions.assertEquals(MortyLoc,LastPersLoc,"Локации не совпадают.");
    }
}
