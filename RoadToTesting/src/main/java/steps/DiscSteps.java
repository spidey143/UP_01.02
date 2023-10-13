package steps;

import io.qameta.allure.Step;
import main.SomeClass;
import org.testng.Assert;

public class DiscSteps {
    @Step(value = "вызов функции дискриминанта")
    public static int callDisc(int a, int b, int c) {
        return SomeClass.disc(a,b,c);
    }
    @Step(value = "Проверка на результат дискриминината")
    public static void checkDiscResult(int a, int b, int c, int n){
        Assert.assertEquals(callDisc(a,b,c), n);
    }
}
