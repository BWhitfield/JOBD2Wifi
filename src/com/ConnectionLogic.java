package com;

import java.io.IOException;
import java.net.Socket;

public class ConnectionLogic implements IConnectionLogic{

	private IConnectionSingleton _connectionSingleton;
	private Socket _socketAdapter;
	
	ConnectionLogic(IConnectionSingleton connectionSingleton, Socket socketAdapter) {
		_connectionSingleton = connectionSingleton;
		_socketAdapter = socketAdapter;
	}

	public void init() {
		try {
			_connectionSingleton.setInputStream(_socketAdapter.getInputStream());
			_connectionSingleton.setOutputStream(_socketAdapter.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}