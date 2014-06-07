package com;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ConnectionSingleton implements IConnectionSingleton {

	private static IConnectionSingleton instance = null;

	private OutputStream _outStream;
	private InputStream _inStream;

	public static IConnectionSingleton getInstance() {
		if (instance == null) {
			instance = new ConnectionSingleton();
		}
		return instance;
	}

	private ConnectionSingleton() {
		IConnectionLogic conLog = new ConnectionLogic(this, new Socket());
		conLog.init();
	}
	
	public OutputStream getOutputStream(){
		return _outStream;
	}
	
	public InputStream getInputStream(){
		return _inStream;
	}
	
	public void setInputStream(InputStream inStream){
		_inStream = inStream;
	}
	
	public void seOutputStream(OutputStream outStream){
		_outStream = outStream;
	}
}


