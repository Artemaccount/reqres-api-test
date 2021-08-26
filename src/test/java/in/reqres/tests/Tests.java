package in.reqres.tests;

import in.reqres.data.DProvider;
import in.reqres.steps.Steps;
import in.reqres.users.UserRequest;
import org.testng.annotations.Test;

public class Tests {

    @Test(description = "Тест 1. Все поля пользователей в списке заполнены")
    public void usersFieldsNotNullTest() {
        Steps.checkUsersNotNull();
    }

    @Test(description = "Тест 2. Ответ содержит те же поля, что и запрос",
            dataProvider = "data", dataProviderClass = DProvider.class)
    public void addNewUserTest(String name, String job) {
        Steps.checkIfSame(new UserRequest(name, job));
    }
}
