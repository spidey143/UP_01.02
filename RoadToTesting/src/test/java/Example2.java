import Steps.DiscSteps;
import Steps.StrSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;

public class Example2 {

    @BeforeClass
    //Выполняется перед запуском всех тестовых методов в классе.
    public void beforeC(XmlTest xmlTest) {
        System.out.println(getClass().getSimpleName());
    }

    @BeforeMethod
    //Выполняется перед запуском всех тестовых методов в классе.
    public void beforeM(Method method) {
        System.out.println(method.getName());
    }

    @Test(testName = "Тест дискриминанта №1")
    public static void testDiscOne() {
        Assert.assertEquals(DiscSteps.stepOne(1, 2, 3), -8);
    }

    @Test(testName = "Тест дискриминанта №2")
    public static void testDiscTwo() {
        Assert.assertEquals(DiscSteps.stepOne(1, 2, 3), -8);
    }

    @Test(testName = "Тест номера телефона №1")
    public static void testPhoneOne() {
        String regex = "^(\\+7|8)[\\s-]?\\(?\\d{3}\\)?[\\s-]?\\d{3}[\\s-]?\\d{2}[\\s-]?\\d{2}$";
        Assert.assertTrue(StrSteps.generatePhone().matches(regex));
    }

    @Test(testName = "Тест номера телефона №2")
    public static void testSrtTwo() {
        String regex = "^(\\+7)[\\s-]?\\(?\\d{3}\\)?[\\s-]?\\d{3}[\\s-]?\\d{2}[\\s-]?\\d{2}$";
        Assert.assertTrue(StrSteps.generatePhone().matches(regex));
    }
}
