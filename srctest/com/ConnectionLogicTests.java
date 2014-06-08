package com;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import execption.ELMException;
import static org.mockito.Mockito.*;

public class ConnectionLogicTests {

	IConnectionLogic _testObject;
	@Mock IConnectionSingleton _connectionSingleton;
	@Mock Socket _socket;
	@Mock OutputStream _mockOutput;
	@Mock InputStream _mockInput;
	
	@Before
	public void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
		when(_socket.getInputStream()).thenReturn(_mockInput);
		when(_socket.getOutputStream()).thenReturn(_mockOutput);
		
		_testObject = new ConnectionLogic(_connectionSingleton, _socket);

	}
	
	@Test
	public void init_setInputStream() throws Exception{
		_testObject.init();
		
		verify(_connectionSingleton, times(1)).setInputStream(_mockInput);
	}

	@Test
	public void init_setOutputStream() throws Exception{
		_testObject.init();
		
		verify(_connectionSingleton, times(1)).setOutputStream(_mockOutput);
	}

	@Test(expected = ELMException.class)
	public void init_setInputStream_null() throws Exception{
		when(_socket.getInputStream()).thenReturn(null);
		
		_testObject.init();
	}

	@Test(expected = ELMException.class)
	public void init_setOutputStream_null() throws Exception{
		when(_socket.getOutputStream()).thenReturn(null);

		_testObject.init();
	}
}
