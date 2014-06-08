package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import execption.ELMException;

public class ConnectionLogic implements IConnectionLogic {

	private IConnectionSingleton _connectionSingleton;
	private Socket _socketAdapter;

	ConnectionLogic(IConnectionSingleton connectionSingleton, Socket socketAdapter) {
		_connectionSingleton = connectionSingleton;
		_socketAdapter = socketAdapter;
	}

	public void init() throws ELMException, IOException {
		InputStream inputStream = _socketAdapter.getInputStream();
		OutputStream outputStream = _socketAdapter.getOutputStream();
		
		if (inputStream == null || outputStream == null) 
			throw new ELMException();
		
		_connectionSingleton.setInputStream(inputStream);
		_connectionSingleton.setOutputStream(outputStream);
	}

}