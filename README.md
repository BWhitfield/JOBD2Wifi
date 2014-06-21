JOBD2Wifi
=========

Utility Library for connecting to a wireless ELM327

# Dependencies

ELM327 wifi adapter (These are like 30 bucks)
Java

# How to use this lib



	public static void main(String[] args) {
		ICommander commander = new Commander();

		try {
			commander.at("E0");// turn off the echo
			System.out.println("Interface version" + commander.at("I"));
			while (true) {
				String response = commander.obd2("01", "0C"); //get the rpm
				response = response.replace("41", ""); //remove mode from response
				response = response.replace("0C", ""); //remove obd2 command from response
				response = response.replace(" " , ""); //remove whitespaces
				if (response.length() > 0) { //sometimes rpms return 0
					int humanVal = Integer.parseInt(response, 16) / 4; //turn the hex into an rpm
					System.out.println("RPM: " + humanVal);// get rpms //print it out so you can rev your motor up and laugh
				}
			}
		} catch (IOException e) {
			e.printStackTrace(); //kaboom
		}
	}



