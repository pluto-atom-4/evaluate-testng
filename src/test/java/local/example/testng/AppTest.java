package local.example.testng;

import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.NDC;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private String year = null;
    private String month = null;

    private static Logger logger = LoggerFactory.getLogger(AppTest.class);

    /**
     * Create the test case
     *
     * @param testName
     *            name of the test case
     */
    @Factory(dataProviderClass = DataProviderForApp.class, dataProvider = DataProviderForApp.JUNE)
    public AppTest(String param, String expected) {
	this.year = param;
	this.month = expected;
	updateLogConfig();
    }

    private App app = new App();

    /**
     * Rigourous Test :-)
     */
    @Test(dataProviderClass = DataProviderForApp.class, dataProvider = DataProviderForApp.FRIDAY)
    public void happyFriday(String param, String expected) {
	NDC.push("happyFriday");
	NDC.push("Given");
	logger.debug(
		"{ year: \"{}\", month: \"{}\", param: \"{}\", expected: \"{}\" }",
		year, month, param, expected);
	NDC.pop();

	NDC.push("When API called");
	String actual = app.greeting(param);
	Assert.assertNotNull(actual);
	logger.debug("{ Returns : \"" + actual + "\"}");
	Assert.assertEquals(actual, expected);
    }

    @Test(dataProviderClass = DataProviderForApp.class, dataProvider = DataProviderForApp.MON_N_WED)
    public void happyMondaAndWednesday(String param, String expected) {
	NDC.push("happyMondaAndWednesday");
	NDC.push("Given");
	logger.debug(
		"{ year: \"{}\", month: \"{}\", param: \"{}\", expected: \"{}\" }",
		year, month, param, expected);
	NDC.pop();

	NDC.push("When API called");
	String actual = app.greeting(param);
	Assert.assertNotNull(actual);
	logger.debug("{ Returns : \"" + actual + "\"}");
	Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    protected void afterMethod() {
	NDC.remove();
    }

    private void updateLogConfig() {
	Enumeration<URL> props;
	String configFilename = (System.getProperty(
		"local.example.testng.log4j",
		"local.example.testng.log4j.properties"));
	Properties p = new Properties();
	try {
	    props = getClass().getClassLoader().getResources(configFilename);
	    p.load(props.nextElement().openStream());
	    PropertyConfigurator.configure(p);
	} catch (Exception e) {
	    System.err.println("Logging initialisation failed, "
		    + "cannot find log4j.properties file:" + e);
	}
    }

}
