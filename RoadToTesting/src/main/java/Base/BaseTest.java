package Base;

import org.testng.annotations.*;
public class BaseTest {

    @BeforeTest
    //Выполянется перед запуском всех тестовых методов
    public static void beforeT() {
        System.out.println();
        System.out.print("Start Testing Class: ");
    }

    @AfterTest
    public static void afterT() {
        System.out.println("Tests Complete!");
    }

}
