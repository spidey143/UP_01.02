import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import steps.DiscSteps;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;

@Epic("Группа тестов №1")
@Feature("Тесты дискриминанта")
public class DisckTests {

    @BeforeClass
    public void beforeC(XmlTest xmlTest) {
        System.out.println("<" + getClass().getSimpleName() + ">");
    }

    @BeforeMethod
    public void beforeM(Method method) {
        System.out.println(method.getName());
    }

    @Test(testName = "Тест дискриминанта №1", description = "Тест дискриминанта №1")
    @Description("Позитивный тест")
    @Parameters({"a", "b", "c"})
    public static void testDiscOne(int a, int b, int c) {
        DiscSteps.checkDiscResult(a,b,c,-8);
    }

    @Test(testName = "Тест дискриминанта №2", description = "Тест дискриминанта №2")
    @Description("Негативный тест")
    @Parameters({"a", "b", "c"})
    public static void testDiscTwo(int a, int b, int c) {
        DiscSteps.checkDiscResult(a,b,c,-4);
    }

    @AfterClass
    public void afterC(XmlTest xmlTest) {
        System.out.println("End Testing Class: " + "<" + getClass().getSimpleName() + ">");
    }
}
