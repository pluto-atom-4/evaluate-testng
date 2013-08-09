package sdet.example.testng;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;

/**
 * Unit test for simple App.
 */
public class AppTest
{
	private String year = null;
	private String month = null;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	@Factory(dataProviderClass=DataProviderForApp.class, dataProvider=DataProviderForApp.JUNE)
    public AppTest( String param, String expected )
    {
		this.year = param;
		this.month = expected;
    }
    
	private App app = new App();

    /**
     * Rigourous Test :-)
     */
    @Test(dataProviderClass=DataProviderForApp.class, dataProvider=DataProviderForApp.FRIDAY)
	public void testApp(String param, String expected)
    {
    	Reporter.log(String.format("year=%s month=%s", year, month));
    	String actual = app.greeting(param);
		AssertJUnit.assertEquals(expected, actual);
    }
}
