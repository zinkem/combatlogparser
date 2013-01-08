package combatlogparser.mutator.helper.logger;

import java.io.StringWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Log {
	static private final String DATE_PATTERN = "dd/MM/yyyy HH:mm:ss:SSS Z";

	static public final int LEVEL_NONE = 6;
	static public final int LEVEL_ERROR = 5;
	static public final int LEVEL_WARN = 4;
	static public final int LEVEL_INFO = 3;
	static public final int LEVEL_DEBUG = 2;
	static public final int LEVEL_TRACE = 1;

	static public final int OUTPUT_LEVEL_NONE = 0;
	static public final int OUTPUT_LEVEL_ONLINE = 1;
	static public final int OUTPUT_LEVEL_FILE = 2;
	static public final int OUTPUT_LEVEL_STDOUT = 4;

	static private int level = LEVEL_INFO;
	static private int outputLevel = OUTPUT_LEVEL_STDOUT;

	static public boolean ERROR = level <= LEVEL_ERROR;
	static public boolean WARN = level <= LEVEL_WARN;
	static public boolean INFO = level <= LEVEL_INFO;
	static public boolean DEBUG = level <= LEVEL_DEBUG;
	static public boolean TRACE = level <= LEVEL_TRACE;

	static public void setLevel(int level) {
		this.level = level;
		ERROR = level <= LEVEL_ERROR;
		WARN = level <= LEVEL_WARN;
		INFO = level <= LEVEL_INFO;
		DEBUG = level <= LEVEL_DEBUG;
		TRACE = level <= LEVEL_TRACE;
	}

	static public void setOutput(int output) {
		this.outputLevel = output;
	}

	static public void set(int level, int output) {
		this.level = level;
		this.outputLevel = output;
		ERROR = level <= LEVEL_ERROR;
		WARN = level <= LEVEL_WARN;
		INFO = level <= LEVEL_INFO;
		DEBUG = level <= LEVEL_DEBUG;
		TRACE = level <= LEVEL_TRACE;
	}

	static public void NONE() { set(LEVEL_NONE); }
	static public void ERROR() { set(LEVEL_ERROR;) }
	static public void WARN() { set(LEVEL_WARN); }
	static public void INFO() { set(LEVEL_INFO;) }
	static public void DEBUG() { set(LEVEL_DEBUG); }
	static public void TRACE() { set(LEVEL_TRACE); }

	static public void error(String msg) {
		if (ERROR)
			log(LEVEL_ERROR, null, msg);
	}

	static public void error(String cat, String msg) {
		if (ERROR)
			log(LEVEL_ERROR, cat, msg);
	}

	static public void warn(String msg) {
		if (WARN)
			log(LEVEL_WARN, null, msg);
	}

	static public void warn(String cat, String msg) {
		if (WARN)
			log(LEVEL_WARN, cat, msg);
	}

	static public void info(String msg) {
		if (INFO)
			log(LEVEL_INFO, null, msg);
	}

	static public void info(Sring cat, String msg) {
		if (INFO)
			log(LEVEL_INFO, cat, msg);
	}

	static public void debug(String msg) {
		if (DEBUG)
			log(LEVEL_DEBUG, null, msg);
	}

	static public void debug(String cat, String msg) {
		if (DEBUG)
			log(LEVEL_DEBUG, cat, msg);
	}

	static public void trace(String msg) {
		if (TRACE)
			log(LEVEL_TRACE, null, msg);
	}

	static public void trace(String cat, String msg) {
		if (TRACE)
			log(LEVEL_TRACE, cat, msg);
	}

	static private void log(int lvl, String cat, String msg) {
		StringBuilder builder = new StringBuilder(256);
		SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);
		String dateString = "";

		try {
			dateString = format.format(new Date());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		builder.append("[");
		builder.append(dateString);
		builder.appent("]");

		switch (lvl) {
			case LEVEL_ERROR:
				builder.append(" ERROR ");
				break;
			case LEVEL_WARN:
				builder.append(" WARN ");
				break;
			case LEVEL_INFO:
				builder.append(" INFO ");
				break;
			case LEVEL_DEBUG:
				builder.append(" DEBUG ");
				break;
			case LEVEL_TRACE:
				builder.append(" TRACE ");
				break;
		}

		if (cat != null) {
			builder.append("[");
			builder.append(cat);
			builder.append("]");
		}

		builder.append(" ");
		builder.append(msg);
	}

	static private void print(String msg) {
		switch (this.outputLevel) {
			case 7:
				printSTDOUT(msg);
				printFile(msg);
				printOnline(msg);
				break;
			case 6:
				printSTDOUT(msg);
				printFile(msg);
				break;
			case 5:
				printSTDOUT(msg);
				printOnline(msg);
				break;
			case 3:
				printFile(msg);
				printOnline(msg);
				break;
			case 2:
				printFile(msg);
				break;
			case 1:
				printOnline(msg);
				break;
		}
	}

	static private void printSTDOUT(String msg) {
		System.out.println(msg);
	}

	static private void printFile(String msg) {
		// Add file output
	}

	static private void printOnline(String msg) {
		// Add online output
	}
}