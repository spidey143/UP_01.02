
import base.BaseTest;
import model.ReqresUserData;
import org.testng.annotations.Test;
import steps.Steps;

import java.awt.*;
import java.util.List;

public class ReqresTests extends BaseTest{
    @Test(description = "Проверка что аватар содержит id пользователя")
    public static void checkAvatarContainsdId() {
        List<ReqresUserData> userDataList = REQRES_STEPS.getUsersList();
        REQRES_STEPS.checkAvatarsContainsId(userDataList);
    }
}
