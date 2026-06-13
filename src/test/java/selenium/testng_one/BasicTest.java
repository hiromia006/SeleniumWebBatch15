package selenium.testng_one;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTest {
    @Test(description = "Test 1", priority = 1, enabled = false)
    public void test1() {
        System.out.println("Test 1");
        Assert.assertEquals("Hello", "Hello", "sddsf1");
        System.out.println("Test 2");
    }

    @Test(description = "Test 2", priority = 0)
    public void test2() {
        System.out.println("Test 21");
        Assert.assertEquals("Hello", "Hello", "sddsf2");
        System.out.println("Test 22");
    }

    @Test(description = "Test 2", priority = 2)
    public void atest() {
        System.out.println("Test 21");
        Assert.assertEquals("Hello", "Hello", "sddsf2");
        System.out.println("Test 22");
    }
}
