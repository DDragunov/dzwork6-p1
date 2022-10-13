package testApiPOST.StepApiPOST;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class StepAPI {

    public JSONObject body;
    public int statusCod;
    //public String responsAPI;

    @Дано("структурированные данные в файле")
    public void readJSON() throws IOException {
        body=new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/JSON/APItest.json"))));
    }
    @Тогда("изменяем и дополняем данные")
    public void putBody() {
        body.put("name","Tomato");
        body.put("job","Eat market");
    }
    @Затем("отправляем запрос c данными на сервер и проверяем статус запроса и полученные данные")
    public void requestBody() {
        RequestSpecification request = given();
        request
                .baseUri(Utils.Configuration.getConfigurationValue("baseUrl"))
                .header("Content-type","application/json")
        ;
        Response response = request
                .body(body.toString())
                .when()
                .post("/users")
                .then()
                .extract()
                .response();

        statusCod = response.statusCode();
        //responsAPI = new JSONObject(response.getBody().asString());

        //Статус код будет 201 - что объект новый создан
        Assertions.assertEquals(statusCod, 201, "Полученный статус код не 201!");
        Assertions.assertEquals((new JSONObject(response.getBody().asString()).get("name")),(body.get("name")),"Ошибка! НЕ совпадает");
        Assertions.assertEquals((new JSONObject(response.getBody().asString()).get("job")),(body.get("job")),"Ошибка! НЕ совпадает");
    }

    /*
    public void AssertStatusCode(){
        Assertions.assertEquals(statusCod, 201, "Полученный статус код не 201!");
    }
    public void AssertValidData(){
        Assertions.assertEquals(responsAPI.get("name")),(body.get("name")),"Ошибка! НЕ совпадает");
        Assertions.assertEquals((new JSONObject(response.getBody().asString()).get("job")),(body.get("job")),"Ошибка! НЕ совпадает");
    }

     */
}
