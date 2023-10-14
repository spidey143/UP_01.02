package steps;

import io.qameta.allure.Step;
import main.SomeClass;
import org.testng.Assert;

public class DiscSteps {
    @Step(value = "вызов функции дискриминанта")
    public static Integer callDisc(Integer a, Integer b, Integer c) {
        return SomeClass.disc(a,b,c);
    }
    @Step(value = "Проверка на результат дискриминината")
    public static void checkDiscResult(Integer a, Integer b, Integer c, Integer n){
        Assert.assertEquals(callDisc(a,b,c), n, "ОшибОчка!");
    }
}
