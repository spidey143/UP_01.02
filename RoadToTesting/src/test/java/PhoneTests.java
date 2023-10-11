import steps.PhoneSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;

public class PhoneTests {
    @BeforeClass
    //Выполняется перед запуском всех тестовых методов в классе
    public void beforeC(XmlTest xmlTest) {
        System.out.println("<" + getClass().getSimpleName() + ">");
    }

    @BeforeMethod
    //Выполняется перед запуском каждого тестового метода
    public void beforeM(Method method) {
        System.out.println(method.getName());
    }

    @Test(testName = "Тест номера телефона №1")
    public static void testPhoneOne() {
        String regex = "^(\\+7|8)[\\s-]?\\(?\\d{3}\\)?[\\s-]?\\d{3}[\\s-]?\\d{2}[\\s-]?\\d{2}$";
        Assert.assertTrue(PhoneSteps.generatePhone().matches(regex));
    }

    @Test(testName = "Тест номера телефона №2", expectedExceptions = AssertionError.class)
    public static void testPhoneTwo() {
        String regex = "^(\\+8)[\\s-]?\\(?\\d{3}\\)?[\\s-]?\\d{3}[\\s-]?\\d{2}[\\s-]?\\d{2}$";
        Assert.assertTrue(PhoneSteps.generatePhone().matches(regex));
    }
}
