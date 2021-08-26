## 1. API тестирование.
Задача: Используя этот сервис с тестовым REST-API https://reqres.in/, написать 2 теста. 

Первый – получить список пользователей (GET  https://reqres.in/api/users?page=2), замапить на объект и проверить, что все поля пришли (достаточно на notNull). 

Второй – создать пользователя (POST https://reqres.in/api/users) с данными из примера на сайте: подготовить тело запроса, отправить запрос с телом, замапить ответ на объект и проверить, что в ответе те же самые значения из запроса.
  
Автотесты необходимо написать, используя данный стек:
Java, testNG, restAssured.