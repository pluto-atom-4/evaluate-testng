package local.example.testng;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Logger logger = LoggerFactory.getLogger(App.class);
	
	final Map<String, String> map =  new HashMap<String, String>() {/**
		 * 
		 */
		private static final long serialVersionUID = 5832164405897131880L;

	{
		    	  put("a", "Happy Friday");
		    	  put("b", "Happy Monday");
		    	  put("c", "Happy Friday");
		    	}};
	

    public String greeting(String param)
    {
        logger.info( map.get(param) );
        return map.get(param);
    }
}
