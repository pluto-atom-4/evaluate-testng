package local.example.testng.annotation;

import org.testng.annotations.Test;

/**
 * Created by kaede on 2/14/16.
 */
public class Sequencing {

    @Test(priority = 2)
    public void testCase1() {
        System.out.println("This is the test case 1.");
    }

    @Test(priority = 3)
    public void testCase2() {
        System.out.println("This is the test case 2.");

    }

    @Test(priority = 0)
    public void testCase3() {
        System.out.println("This is the test case 3.");

    }

    @Test(priority = 1)
    public void testCase4() {
        System.out.println("This is the test case 4.");

    }


}