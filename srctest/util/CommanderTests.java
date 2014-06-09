package util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import main.Constants;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.IConnectionSingleton;

import static org.mockito.Mockito.*;

public class CommanderTests{

	ICommander _testObject;
	@Mock IConnectionSingleton _connection;
	@Mock IResponseUtility _responseUtility;
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		_testObject = new Commander(_connection, _responseUtility);
	}
	
	@Test
	public void obd2() throws IOException{
		OutputStream outStream = mock(OutputStream.class);
		String response = "1234";
		
		when(_connection.getOutputStream()).thenReturn(outStream);
		when(_responseUtility.getResponse()).thenReturn(response);
		
		int actual = _testObject.obd2("01","0C");
		
		verify(_connection).getOutputStream();
		verify(outStream).write(("010C" + Constants.CR_LF).getBytes());
		
		assertEquals(1234, actual);
	}
}