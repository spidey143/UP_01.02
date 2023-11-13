package petStoreTests;

import base.ApiBaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import model.requestModel.petStoreRequests.UserRequest;
import model.responseModel.petStoreResponses.ApiResponse;
import model.responseModel.petStoreResponses.UserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Epic("Тесты сайта petStore")
@Feature("Группа тестов направленная на User")
public class UserTests extends ApiBaseTest {
    @Test(priority = 1)
    public void createUserTest(){
        UserRequest userRequest = new UserRequest(143,
                "darlingFF", "Danya", "Bekenev",
                "darlingFF@gmail.com", "qwerty", "phone", 1);
        ApiResponse apiResponse = PET_STORE_STEPS.postUser(userRequest);
        Assert.assertTrue(apiResponse.code == 200 && apiResponse.message.equals(userRequest.id.toString()));
    }

    @Test(priority = 2)
    public void createListOfUsersWithInputArray(){
        UserRequest[] usersList= new UserRequest[1];
        usersList[0] = new UserRequest(143,
                "darlingFF", "Danya", "Bekenev",
                "darlingFF@gmail.com", "qwerty", "phone", 1);
        ApiResponse apiResponse = PET_STORE_STEPS.postArraytOfUsers(usersList);
        Assert.assertTrue(apiResponse.code == 200 && apiResponse.message.contains("ok"));
    }

    @Test(priority = 3)
    public void createListOfUsersWithInputList(){
        List<UserRequest> usersList= new ArrayList<>();
        usersList.add(new UserRequest(143,
                "darlingFF", "Danya", "Bekenev",
                "darlingFF@gmail.com", "qwerty", "phone", 1));
        ApiResponse apiResponse = PET_STORE_STEPS.postListOfUsers(usersList);
       Assert.assertTrue(apiResponse.code == 200 && apiResponse.message.contains("ok"));
    }

    @Test(priority = 4)
    public void getUserByUserNameTest(){
        UserResponse userResponse = PET_STORE_STEPS.getUserByUserName("darlingFF");
        Assert.assertTrue(userResponse.username.equals("darlingFF") &&
                userResponse.firstName.equals("Danya") && userResponse.lastName.equals("Bekenev"));
    }

    @Test(priority = 5)
    public void updateUserTest(){
        UserRequest userUpdateRequest = new UserRequest(143,
                "darlingFF", "1Danya1", "2Bekenev2",
                "darlingFF@gmail.com", "qwerty", "phone", 2);
        ApiResponse apiResponse = PET_STORE_STEPS.updateUser(userUpdateRequest);
        Assert.assertTrue(apiResponse.code == 200 && apiResponse.message.equals(userUpdateRequest.id.toString()));
    }

    @Test(priority = 6)
    public void deleteUserTest(){
        ApiResponse apiResponse = PET_STORE_STEPS.deleteUser("darlingFF");
        Assert.assertTrue(apiResponse.code == 200 && apiResponse.message.equals("darlingFF"));
    }

    @Test(priority = 7)
    public void userLogInTest(){
        ApiResponse apiResponse = PET_STORE_STEPS.authUser("darlingFF", "qwerty");
        Assert.assertTrue(apiResponse.code == 200 && apiResponse.message.contains("logged in user session"));
    }

    @Test(priority = 8)
    public void userLogOutTest(){
        ApiResponse apiResponse = PET_STORE_STEPS.logoutUser();
        Assert.assertTrue(apiResponse.code == 200 && apiResponse.message.contains("ok"));
    }
}
