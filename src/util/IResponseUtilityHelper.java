package util;

import java.io.IOException;
import java.io.InputStream;

public interface IResponseUtilityHelper {

	public byte[] getByteData(InputStream inStream) throws IOException;

	public String getStringData(byte[] byteData);

	public String trimStringData(String fullResponse);

}
