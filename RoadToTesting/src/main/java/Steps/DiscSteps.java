package Steps;

import io.qameta.allure.Step;
import Main.SomeClass;

public class DiscSteps {
    @Step("вызов функции дискриминанта")
    public static int stepOne(int a, int b, int c){
        return SomeClass.disc(a,b,c);
    }
}
