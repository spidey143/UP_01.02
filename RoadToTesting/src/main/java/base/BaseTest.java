package base;

import org.testng.annotations.*;

public class BaseTest {
    @BeforeSuite
    public static void beforeSuite() {
        System.out.print("//Suite Start//");
    }

    @AfterSuite
    public static void afterSuite() {
        System.out.print("//Suite end//");
    }

    @BeforeTest
    //Выполянется перед запуском всех тестовых методов
    public static void beforeT() {
        System.out.println();
        System.out.print("Start Testing Class: ");
    }

    @AfterTest
    //Выполянется после всех тестовых методов
    public static void afterT() {
        System.out.println("Tests Complete!");
    }


}
