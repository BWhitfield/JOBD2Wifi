package util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import main.Constants;

import org.apache.logging.log4j.Logger;
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
	@Mock Logger _logger;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		_testObject = new Commander(_connection, _responseUtility, _logger);
		
		when(_connection.getOutputStream()).thenReturn(mock(OutputStream.class));
	}
	
	@Test
	public void at() throws IOException{
		OutputStream outStream = mock(OutputStream.class);
		String response = "response";
		
		when(_connection.getOutputStream()).thenReturn(outStream);
		when(_responseUtility.getResponse()).thenReturn(response);
		
		String actual = _testObject.at("I");
		
		verify(_connection).getOutputStream();
		verify(outStream).write(("ATI" + Constants.CR_LF).getBytes());
		
		assertEquals(response, actual);
	}
	
	@Test
	public void obd2() throws IOException{
		OutputStream outStream = mock(OutputStream.class);
		String response = "1234";
		
		when(_connection.getOutputStream()).thenReturn(outStream);
		when(_responseUtility.getResponse()).thenReturn(response);
		
		String actual = _testObject.obd2("01","0C");
		
		verify(_connection).getOutputStream();
		verify(outStream).write(("010C" + Constants.CR_LF).getBytes());
		
		assertEquals(response, actual);
	}
	
	@Test
	public void obd2_logs_errors_writing_to_output_stream() throws Exception{
		OutputStream outStream = mock(OutputStream.class);
		
		when(_connection.getOutputStream()).thenReturn(outStream);
		doThrow(new IOException()).when(outStream).write(any(byte[].class));
		
		String actual = _testObject.obd2("01","0C");
		
		verify(_logger).error("Failed writing to output stream");
		
		assertEquals(null, actual);
	}

	@Test
	public void obd2_logs_errors_getting_response() throws Exception{
		when(_responseUtility.getResponse()).thenThrow(new IOException());
		
		String actual = _testObject.obd2("01","0C");
		
		verify(_logger).error("Failed getting response");
		
		assertEquals(null, actual);
	}
	
	@Test
	public void at_logs_errors_writing_to_output_stream() throws Exception{
		OutputStream outStream = mock(OutputStream.class);
		
		when(_connection.getOutputStream()).thenReturn(outStream);
		doThrow(new IOException()).when(outStream).write(any(byte[].class));
		
		String actual = _testObject.at("I");
		
		verify(_logger).error("Failed writing to output stream");
		
		assertEquals(null, actual);
	}
	
	@Test
	public void at_logs_errors_getting_response() throws Exception{
		when(_responseUtility.getResponse()).thenThrow(new IOException());
		
		String actual = _testObject.at("foobar");
		
		verify(_logger).error("Failed getting response");
		
		assertEquals(null, actual);
	}
	
	
	
	
	
}