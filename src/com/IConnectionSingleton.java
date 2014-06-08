package com;

import java.io.InputStream;
import java.io.OutputStream;

public interface IConnectionSingleton {
	void setOutputStream(OutputStream outStream);

	void setInputStream(InputStream inStream);

	InputStream getInputStream();

	OutputStream getOutputStream();
}