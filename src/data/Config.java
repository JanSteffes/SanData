package data;

import java.time.format.DateTimeFormatter;

public class Config {
	
	public final static int SERVER_PORT_PROD = 1234;

	public final static int SERVER_PORT_DEBUG = 1233;

	private final static String SERVER_ADDRESS_RASPBERRY = "raspberrypi";
	private final static String SERVER_ADDRESS_JAN = "jan";

	/**
	 * Used by server for folder date formats
	 */
	@SuppressWarnings("unused")
	public final static String dateFormat = "yyyy-MM-dd";

	private static DateTimeFormatter dateTimeFormatter;

	@SuppressWarnings("unused")
	public static DateTimeFormatter getDateTimeFormatter()
	{
		if (dateTimeFormatter == null)
		{
			dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
		}
		return dateTimeFormatter;
	}

	private static boolean DEBUG = false;

	/**
	 * Used by clients to switch between debug and live
	 */
	@SuppressWarnings("unused")
	public static void switchDebug()
	{
		DEBUG = !DEBUG;
	}

	public static String getServer()
	{
		return DEBUG ? SERVER_ADDRESS_JAN : SERVER_ADDRESS_RASPBERRY;
	}

	public static int getPort()
	{
		return DEBUG ? SERVER_PORT_DEBUG : SERVER_PORT_PROD;
	}

}
