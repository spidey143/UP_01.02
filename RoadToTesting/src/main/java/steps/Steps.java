package steps;

import useless.UserListSteps;
import useless.UserPasswordSteps;

public interface Steps {
    UserListSteps USER_LIST_STEPS = new UserListSteps();
    UserPasswordSteps USER_PASSWORD_STEPS = new UserPasswordSteps();

    ReqresSteps REQRES_STEPS = new ReqresSteps();
}
