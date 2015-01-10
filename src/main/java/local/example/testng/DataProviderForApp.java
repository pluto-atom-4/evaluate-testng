package local.example.testng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

public class DataProviderForApp {
	
	private static Logger logger = LoggerFactory.getLogger(DataProvider.class);
	
	@DataProvider(name = DataProviderForApp.FRIDAY)
	public static Iterator<Object[]>  data() {
		List<String> strList = Arrays.asList("a","c");
		List<Object[]> dataToBeReturned = new ArrayList<Object[]>();
		for (String str : strList) {
			dataToBeReturned.add(new Object[] { str, "Happy Friday" });
		}
		logger.debug("dataToBeReturned.size=" + dataToBeReturned.size());
		return dataToBeReturned.iterator();	
	}
	
	@DataProvider(name = DataProviderForApp.MON_N_WED)
	public static Iterator<Object[]> monAndWed() {
		List<Object[]> dataToBeReturned = new ArrayList<Object[]>();
		dataToBeReturned.add(new Object[] { "b", "Happy Monday" });
		dataToBeReturned.add(new Object[] { "d", "Happy Wednesday" });
		logger.debug("dataToBeReturned.size=" + dataToBeReturned.size());
		return dataToBeReturned.iterator();	
	    	}
	
	@DataProvider(name = DataProviderForApp.JUNE)
	public static Iterator<Object[]>  dataForFactory() {
		List<String> strList = Arrays.asList("2012","2013");
		List<Object[]> dataToBeReturned = new ArrayList<Object[]>();
		for (String str : strList) {
			dataToBeReturned.add(new Object[] { str, "June" });
		}
		logger.debug("dataToBeReturned.size=" + dataToBeReturned.size());
		return dataToBeReturned.iterator();	
	}
	
	
	final public static String FRIDAY = "YES_I_LIKE_EVERY_FRIDAY";
	final public static String JUNE = "YES_I_LIKE_JUNE_BEGINNING_OF_SUMMER";
	final public static String MON_N_WED = "MON_N_WED";
}
