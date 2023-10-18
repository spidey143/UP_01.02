package useless;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.*;
import steps.PhoneSteps;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;

@Epic("Тестовая Группа №2")
@Feature("Тесты номера телефона")
public class PhoneTests{
    @BeforeClass
    public void beforeC(XmlTest xmlTest) {
        System.out.println("<" + getClass().getSimpleName() + ">");
    }

    @BeforeMethod
    public void beforeM(Method method) {
        System.out.println(method.getName());
    }

    @Test(testName = "Тест номера телефона №1", description = "Тест номера телефона №1")
    @Description("Позитивный тест")
    @Parameters({"regex1"})
    public static void testPhoneOne(String regex) {
        PhoneSteps.checkPhoneAtTemplate(regex);
    }

    @Test(testName = "Тест номера телефона №2", description = "Тест номера телефона №2")
    @Description("Негативный тест")
    @Parameters({"regex2"})
    public static void testPhoneTwo(String regex) {
        PhoneSteps.checkPhoneAtTemplate(regex);
    }

    @AfterClass
    public void afterC(XmlTest xmlTest) {
        System.out.println("End Testing Class: " + "<" + getClass().getSimpleName() + ">");
    }
}
