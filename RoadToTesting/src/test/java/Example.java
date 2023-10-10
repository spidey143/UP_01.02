import Steps.DiscSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example {

    @Test(testName = "тест дискриминанта")
    public static void testDisc(){
        Assert.assertEquals(DiscSteps.stepOne(1,2,3), -8);
    }

}
