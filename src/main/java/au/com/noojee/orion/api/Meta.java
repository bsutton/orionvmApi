package au.com.noojee.orion.api;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public class Meta
{
	@SuppressFBWarnings
	String status;
	@SuppressFBWarnings
	String more_info;
	String message;
	@Override
	public String toString()
	{
		return "Meta [status=" + status + ", more_info=" + more_info + ", message=" + message + "]";
	}
	public String getStatusMessage()
	{
		return status + ":" + message;
	}
	public boolean isOK()
	{
		return status.compareToIgnoreCase("ok") == 0;
	}
}