package util;

import java.io.IOException;
import java.io.InputStream;
import main.Constants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.IConnectionSingleton;


public class ResponseUtilityTests {
	IResponseUtility _testObject;
	@Mock IResponseUtilityHelper _responseUtilityHelper;
	@Mock IConnectionSingleton _connection;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		_testObject = new ResponseUtility(_responseUtilityHelper, _connection);
	}
	
	@Test
	public void getResponse_getsByteData() throws IOException{
		InputStream inStream = mock(InputStream.class);
		byte[] byteData = new byte[2];
		String fullResponse = "something fun" + Constants.PROMPT;
		
		when(_connection.getInputStream()).thenReturn(inStream);
		when(_responseUtilityHelper.getByteData(inStream)).thenReturn(byteData);
		when(_responseUtilityHelper.getStringData(byteData)).thenReturn(fullResponse);
		when(_responseUtilityHelper.trimStringData(fullResponse)).thenReturn("something fun");
		
		String actual = _testObject.getResponse();
		
		verify(_responseUtilityHelper, times(1)).getByteData(inStream);
		verify(_responseUtilityHelper, times(1)).getStringData(byteData);
		
		assertEquals(actual, "something fun");
	}
}
