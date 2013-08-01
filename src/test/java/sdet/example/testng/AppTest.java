package sdet.example.testng;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
    }
    
	private App app = new App();

    /**
     * Rigourous Test :-)
     */
    @Test(dataProviderClass=DataProviderForApp.class, dataProvider=DataProviderForApp.FRIDAY)
	public void testApp(String param, String expected)
    {
    	String actual = app.greeting(param);
		AssertJUnit.assertEquals(expected, actual);
    }
}
