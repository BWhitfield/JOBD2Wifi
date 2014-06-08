package util;

import java.io.InputStream;

import main.Constants;

public class ResponseUtilityHelper implements IResponseUtilityHelper{

	@Override
	public byte[] getByteData(InputStream inStream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStringData(byte[] byteData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String trimStringData(String fullResponse) {
		fullResponse = fullResponse.replace(Constants.CR, "");
		fullResponse = fullResponse.replace(Constants.LF, "");
		fullResponse = fullResponse.replace(Constants.PROMPT, "");
		return fullResponse;
	}

}
