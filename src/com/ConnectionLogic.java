package com;
public class ConnectionLogic implements IConnectionLogic{

	private IConnectionSingleton _connectionSingleton;
	ConnectionLogic(IConnectionSingleton connectionSingleton) {
		_connectionSingleton = connectionSingleton;
	}

	public void init() {
		
	}
	
}