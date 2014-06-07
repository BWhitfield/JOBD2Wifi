package com;

import java.net.Socket;

public class ConnectionLogic implements IConnectionLogic{

	private IConnectionSingleton _connectionSingleton;
	private Socket _socketAdapter;
	
	ConnectionLogic(IConnectionSingleton connectionSingleton, Socket socketAdapter) {
		_connectionSingleton = connectionSingleton;
		_socketAdapter = socketAdapter;
	}

	public void init() {
		_connectionSingleton.getInputStream();
	}
	
}