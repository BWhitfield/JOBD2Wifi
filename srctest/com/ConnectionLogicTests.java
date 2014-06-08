package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ConnectionLogicTests {

	IConnectionLogic _testObject;
	@Mock IConnectionSingleton _connectionSingleton;
	@Mock Socket _socket;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		
		_testObject = new ConnectionLogic(_connectionSingleton, _socket);
	}
	
	@Test
	public void init_setInputStream() throws Exception{
		InputStream mockInput = mock(InputStream.class);
		when(_socket.getInputStream()).thenReturn(mockInput);

		_testObject.init();
		
		verify(_connectionSingleton, times(1)).setInputStream(mockInput);
	}

	@Test
	public void init_setOutputStream() throws Exception{
		OutputStream mockOutput = mock(OutputStream.class);
		when(_socket.getOutputStream()).thenReturn(mockOutput);

		_testObject.init();
		
		verify(_connectionSingleton, times(1)).setOutputStream(mockOutput);
	}
}
