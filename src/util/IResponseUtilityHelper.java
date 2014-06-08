package util;

import java.io.InputStream;

public interface IResponseUtilityHelper {

	public byte[] getByteData(InputStream inStream);

	public String getStringData(byte[] byteData);

	public String trimStringData(String fullResponse);

}
