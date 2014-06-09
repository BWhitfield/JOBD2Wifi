package util;

import java.io.IOException;

public interface ICommander {
	public int obd2(String mode, String command) throws IOException;
}
