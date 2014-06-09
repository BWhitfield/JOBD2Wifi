package util;

import java.io.IOException;

public interface ICommander {
	public String obd2(String mode, String command) throws IOException;

	public String at(String command) throws IOException;
}
