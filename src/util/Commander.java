package util;

import java.io.IOException;

import main.Constants;

import com.IConnectionSingleton;

public class Commander implements ICommander{

	private IConnectionSingleton _connection;
	private IResponseUtility _responseUtility;

	public Commander(IConnectionSingleton connection, IResponseUtility responseUtility) {
		_connection = connection;
		_responseUtility = responseUtility;
	}

	@Override
	public String obd2(String mode, String command) throws IOException {
		_connection.getOutputStream().write((mode + command + Constants.CR_LF).getBytes());
		return _responseUtility.getResponse();
	}

	@Override
	public String at(String command) throws IOException {
		_connection.getOutputStream().write(("AT" + command + Constants.CR_LF).getBytes());
		return _responseUtility.getResponse();
	}

}