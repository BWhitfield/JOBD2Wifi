package util;

import java.io.IOException;
import java.util.Arrays;

import main.Constants;

import com.IConnectionSingleton;

public class ResponseUtility implements IResponseUtility {
	
	private IResponseUtilityHelper _responseUtilityHelper;
	private IConnectionSingleton _connection;
	
	public ResponseUtility(IResponseUtilityHelper responseUtilityHelper, IConnectionSingleton connection) {
		_responseUtilityHelper = responseUtilityHelper;
		_connection = connection;
	}

	@Override
	public String getResponse() throws IOException {
		boolean reading = true;
		StringBuilder response = new StringBuilder();
		
		while(reading){
			byte[] byteData = _responseUtilityHelper.getByteData(_connection.getInputStream());
			String stringData = _responseUtilityHelper.getStringData(byteData);
			response.append(stringData);
			
			if (stringData.contains(Constants.PROMPT)) {
				reading = false;
			}
		}
		
		return _responseUtilityHelper.trimStringData(response.toString());
//		while (!readComplete) {
//			byte[] bytes = null;
//			
//			int readLength = _connection.getInputStream().read(bytes);
//			
//			String data = new String(Arrays.copyOfRange(bytes, 0, readLength));
//			responseBuilder.append(data);
//
//			if (data.contains(Constants.PROMPT)) {
//				break;
//			}
//		}
	}

}
