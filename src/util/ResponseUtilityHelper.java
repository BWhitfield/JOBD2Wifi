package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import main.Constants;

public class ResponseUtilityHelper implements IResponseUtilityHelper{
	private int currentLength;
	
	@Override
	public byte[] getByteData(InputStream inStream) throws IOException {
		byte[] bytes = new byte[1024];
		currentLength = inStream.read(bytes);
		return bytes;
	}

	@Override
	public String getStringData(byte[] byteData) {
		return new String(Arrays.copyOfRange(byteData, 0, currentLength)); 
	}

	@Override
	public String trimStringData(String fullResponse) {
		fullResponse = fullResponse.replace(Constants.CR, "");
		fullResponse = fullResponse.replace(Constants.LF, "");
		fullResponse = fullResponse.replace(Constants.PROMPT, "");
		return fullResponse;
	}

}
