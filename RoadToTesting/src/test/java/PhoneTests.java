import org.testng.annotations.Parameters;
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
    @Parameters({"regex1"})
    public static void testPhoneOne(String regex) {
        PhoneSteps.checkPhoneAtTemplate(regex);
    }

    @Test(testName = "Тест номера телефона №2", expectedExceptions = AssertionError.class)
    @Parameters({"regex2"})
    public static void testPhoneTwo(String regex) {
        PhoneSteps.checkPhoneAtTemplate(regex);
    }
}
