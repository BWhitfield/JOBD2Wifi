package util;

import java.io.IOException;
import main.Constants;

import com.IConnectionSingleton;
import com.ConnectionSingleton;

public class ResponseUtility implements IResponseUtility {
	
	private IResponseUtilityHelper _responseUtilityHelper;
	private IConnectionSingleton _connection;
	
	public ResponseUtility() 
	{
		this(new ResponseUtilityHelper(), ConnectionSingleton.getInstance());
	}
	
	public ResponseUtility(IResponseUtilityHelper responseUtilityHelper, IConnectionSingleton connection) {
		_responseUtilityHelper = responseUtilityHelper;
		_connection = connection;
	}

	@Override
	public String getResponse() throws IOException {
		boolean reading = true;
		StringBuilder response = new StringBuilder();
		
		while(reading){// TODO test this
			byte[] byteData = _responseUtilityHelper.getByteData(_connection.getInputStream());
			String stringData = _responseUtilityHelper.getStringData(byteData);
			response.append(stringData);
			
			if (stringData.contains(Constants.PROMPT)) {
				reading = false;
			}
		}
		
		return _responseUtilityHelper.trimStringData(response.toString());
	}

}
