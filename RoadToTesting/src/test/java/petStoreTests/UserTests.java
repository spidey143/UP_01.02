package petStoreTests;

import base.ApiBaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import model.requestModel.petStoreRequests.UserRequest;
import model.responseModel.petStoreResponses.ApiResponse;
import model.responseModel.petStoreResponses.UserResponse;
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
        PET_STORE_STEPS.checkApiResponse(apiResponse, Long.valueOf(userRequest.id));
    }

    @Test(priority = 2)
    public void createListOfUsersWithInputArray(){
        UserRequest[] usersList= new UserRequest[1];
        usersList[0] = new UserRequest(143,
                "darlingFF", "Danya", "Bekenev",
                "darlingFF@gmail.com", "qwerty", "phone", 1);
        ApiResponse apiResponse = PET_STORE_STEPS.postArraytOfUsers(usersList);
        PET_STORE_STEPS.checkUsersListApiResponse(apiResponse);
    }

    @Test(priority = 3)
    public void createListOfUsersWithInputList(){
        List<UserRequest> usersList= new ArrayList<>();
        usersList.add(new UserRequest(143,
                "darlingFF", "Danya", "Bekenev",
                "darlingFF@gmail.com", "qwerty", "phone", 1));
        ApiResponse apiResponse = PET_STORE_STEPS.postListOfUsers(usersList);
        PET_STORE_STEPS.checkUsersListApiResponse(apiResponse);
    }

    @Test(priority = 4)
    public void getUserByUserNameTest(){
        UserResponse user = PET_STORE_STEPS.getUserByUserName("darlingFF");
        PET_STORE_STEPS.checkUserWasFoundRight(user, "darlingFF", "Danya", "Bekenev");
    }

    @Test(priority = 5)
    public void updateUserTest(){
        UserRequest userUpdateRequest = new UserRequest(143,
                "darlingFF", "1Danya1", "2Bekenev2",
                "darlingFF@gmail.com", "qwerty", "phone", 2);
        ApiResponse apiResponse = PET_STORE_STEPS.updateUser(userUpdateRequest);
        PET_STORE_STEPS.checkApiResponse(apiResponse, Long.valueOf(userUpdateRequest.id));
    }

    @Test(priority = 6)
    public void deleteUserTest(){
        ApiResponse apiResponse = PET_STORE_STEPS.deleteUser("darlingFF");
        PET_STORE_STEPS.checkUserIsDeleted(apiResponse, "darlingFF");
    }

    @Test(priority = 7)
    public void userLogInTest(){
        ApiResponse apiResponse = PET_STORE_STEPS.authUser("darlingFF", "qwerty");
        PET_STORE_STEPS.checkUserIsAuthenticated(apiResponse);
    }

    @Test(priority = 8)
    public void userLogOutTest(){
        PET_STORE_STEPS.logoutUser();
    }
}
