package util;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import main.Constants;

import com.ConnectionSingleton;
import com.IConnectionSingleton;

public class Commander implements ICommander {

	private IConnectionSingleton _connection;
	private IResponseUtility _responseUtility;
	private org.apache.logging.log4j.Logger _logger;

	public Commander() {
		this(ConnectionSingleton.getInstance(), new ResponseUtility(), LogManager.getLogger("Driver"));
	}

	public Commander(IConnectionSingleton connection, IResponseUtility responseUtility, org.apache.logging.log4j.Logger logger) {
		_connection = connection;
		_responseUtility = responseUtility;
		_logger = logger;
	}

	@Override
	public String obd2(String mode, String command) {
		writeCommand(mode, command);
		return getResponse();
	}

	@Override
	public String at(String command) throws IOException {
		writeCommand("AT", command);
		return getResponse();
	}

	private String getResponse() {
		try {
			return _responseUtility.getResponse();
		} catch (IOException e) {
			_logger.error("Failed getting response");
		}
		return null;
	}

	private void writeCommand(String mode, String command) {
		try {
			_connection.getOutputStream().write((mode + command + Constants.CR_LF).getBytes());
		} catch (IOException e) {
			_logger.error("Failed writing to output stream");
		}
	}

}