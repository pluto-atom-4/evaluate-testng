package local.example.testng;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.testng.Reporter;

public class ReporterAppender extends AppenderSkeleton {

	public void close() {}

	public boolean requiresLayout() {
		return true;
	}

	@Override
	protected void append(LoggingEvent event) {
		Reporter.log(getLayout().format(event), false);
	}

}
