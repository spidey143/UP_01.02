import steps.DiscSteps;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;

public class DisckTests {

    @BeforeClass
    //Выполняется перед запуском всех тестовых методов в классе.
    public void beforeC(XmlTest xmlTest) {
        System.out.println("<" + getClass().getSimpleName() + ">");
    }

    @BeforeMethod
    //Выполняется перед запуском каждого тестового метода
    public void beforeM(Method method) {
        System.out.println(method.getName());
    }

    @Test(testName = "Тест дискриминанта №1")
    @Parameters({"a", "b", "c"})
    public static void testDiscOne(int a, int b, int c ) {
        Assert.assertEquals(DiscSteps.stepOne(a, b, c), -8);
    }

    @Test(testName = "Тест дискриминанта №2", expectedExceptions = AssertionError.class)
    @Parameters({"a", "b", "c"})
    public static void testDiscTwo(int a, int b, int c) {
        Assert.assertEquals(DiscSteps.stepOne(a, b, c), -4);
    }

}
