package steps;

import io.qameta.allure.Step;
import lombok.Data;
import model.User;
import utils.MyAsserts;
import utils.Generator;
import utils.Generator;
import utils.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class UserSteps {
    public static List<User> users = new ArrayList<>();

    @Step("Проверка что список пользоватей не пустой")
    public static void checkUsersListIsEmpty(){
        MyAsserts.myAssertTrue(!users.isEmpty(), "Список пользователей пуст!");
    }

    @Step("Проверяем что пользователь с указанным логином есть в списке")
    public static User findUser(String login){
        Optional<User> userOptional = users.stream().filter(us -> us.getLogin().equals(login)).findFirst();
        return userOptional.orElse(null);
    }

    @Step("Проверяем валидность данных пользователя")
    public static void checkValidUser(User user){
        MyAsserts.myAssertTrue(user != null, "Такого пользователя нет в списке!");
        String regex = "^\\+7\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
        MyAsserts.myAssertTrue(user.getEmail().contains("@example.com"), "Невалидная почта!");
        MyAsserts.myAssertTrue(user.getPhone().matches(regex), "Невалидный телефон!");
    }
}
