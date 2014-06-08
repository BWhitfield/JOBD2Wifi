package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import execption.ELMException;
import main.Constants;

public class ConnectionSingleton implements IConnectionSingleton {

	private static IConnectionSingleton instance = null;

	private OutputStream _outStream;
	private InputStream _inStream;
	private IConnectionLogic _conLog;

	public static IConnectionSingleton getInstance() {
		if (instance == null) 
			instance = new ConnectionSingleton();
		
		return instance;
	}

	private ConnectionSingleton() {
		try {
			_conLog = new ConnectionLogic(this, new Socket(Constants.ELM327_IP_ADDRESS, Constants.ELM327_IP_PORT));
			_conLog.init();
		} catch (UnknownHostException e) {
			// TODO Log 4 J
		} catch (IOException e) {
			// TODO Log 4 J
		} catch (ELMException e) {
			// TODO Log 4 J
		} 
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
	
	public void setOutputStream(OutputStream outStream){
		_outStream = outStream;
	}
}


