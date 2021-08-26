package in.reqres.steps;

import in.reqres.users.User;
import in.reqres.users.UserRequest;
import in.reqres.users.UserResponse;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Steps {

    private static final String CREATE_NEW_USER = "/users";
    private static final String LIST_USERS = "/users?page=2";

    private static RequestSpecification reqSpec(String basePath) {
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api")
                .setBasePath(basePath)
                .setContentType(ContentType.JSON)
                .build();
    }

    @Step("Проверяем, что все поля пользователей заполнены")
    public static void checkUsersNotNull() {
        List<User> usersList = given().spec(reqSpec(LIST_USERS))
                .get()
                .jsonPath().getList("data", User.class);
        usersList.forEach(s -> Assert.assertTrue(s.isAllFieldsNotNull()));
    }

    @Step("Получаем результат создания пользователя в виде объекта")
    public static UserResponse createNewUser(UserRequest userRequest) {
        return given()
                .spec(reqSpec(CREATE_NEW_USER))
                .body(userRequest)
                .when().post()
                .then().extract().as(UserResponse.class);
    }

    @Step("Проверяем, что в ответе те же самые значения из запроса")
    public static void checkIfSame(UserRequest userRequest) {
        UserResponse userResponse = createNewUser(userRequest);
        Assert.assertTrue(userRequest.getName().equals(userResponse.getName()) &&
                userRequest.getJob().equals(userResponse.getJob()));
    }
}
