package steps;

import useless.DiscSteps;
import useless.UserListSteps;
import useless.UserPasswordSteps;

public interface Steps {
    UserPasswordSteps USER_PASSWORD_STEPS = new UserPasswordSteps();
    UserListSteps USER_LIST_STEPS = new UserListSteps();
    ReqresSteps REQRES_STEPS = new ReqresSteps();
    PetStoreSteps PET_STORE_STEPS = new PetStoreSteps();
    UiSteps UI_STEPS = new UiSteps();
}
