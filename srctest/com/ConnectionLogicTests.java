package com;

import java.net.Socket;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ConnectionLogicTests {

	IConnectionLogic _testObject;
	
	@Test
	public void init_gets_socket_sets_streams(){
		IConnectionSingleton connectionSingleton = mock(ConnectionSingleton.class);
		Socket socketAdapter = mock(Socket.class);
		_testObject = new ConnectionLogic(connectionSingleton, socketAdapter);
		
		_testObject.init();
		
		verify(connectionSingleton, times(1)).getInputStream();
	}
}
