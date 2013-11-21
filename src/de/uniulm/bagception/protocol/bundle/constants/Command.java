package de.uniulm.bagception.protocol.bundle.constants;

import android.os.Bundle;

public enum Command {
	TRIGGER_SCAN_DEVICES(0),PING(1),PONG(2),RESEND_STATUS(3),DISCONNECT(4);

	private static final String EXTRA_COMMAND = "de.uniulm.bundle.extra.bluetooth.comm.command";

	private final int commandcode;

	/*
	 * ############################################### 
	 * ###############  constructors ##############
	 * #################################################
	 */

	private Command(int code) {
		this.commandcode = code;
	}

	/*
	 * ############################################### 
	 * ###############	 * getters/setters #############
	 * #################################################
	 */

	public int getCommandCode() {
		return commandcode;
	}

	/*
	 * ############################################### 
	 * ############### statics ############# 
	 * #################################################
	 */

	public static Bundle getCommandBundle(Command com) {
		Bundle ret = new Bundle();
		ret.putInt(EXTRA_COMMAND, com.getCommandCode());
		return ret;
	}
	
	public static Command getCommand(Bundle b){
		Command ret = Command.values()[b.getInt(EXTRA_COMMAND)];
		
		return ret; 
	}
}
