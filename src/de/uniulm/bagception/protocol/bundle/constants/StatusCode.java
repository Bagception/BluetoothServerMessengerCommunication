package de.uniulm.bagception.protocol.bundle.constants;

import android.os.Bundle;

public enum StatusCode {


	
	DISCONNECTED(0),
	CONNECTED(1),
	ERROR(2),
	SCAN_DEVICES_DONE(3);
	
	private static final String EXTRA_STATUSCODE = "de.uniulm.bundle.extra.bluetooth.comm.statuscode";	


	private final int statuscode;
	

	
	/*###############################################
	###############     constructors   ##############
	#################################################*/
	
	private StatusCode(int code) {
		this.statuscode=code;
	}
	

	
	/*###############################################
	###############   getters/setters   #############
	#################################################*/

	public int getStatusCode(){
		return statuscode;
	}

	public class EXTRA_KEYS{
		public static final String ERROR_MESSAGE = EXTRA_STATUSCODE+"error";  
	}
	

	
	/*###############################################
	###############       statics       #############
	#################################################*/

	public static Bundle getStatusBundle(StatusCode statuscode){
		Bundle ret = new Bundle();
		ret.putInt(EXTRA_STATUSCODE, statuscode.getStatusCode());
		
		return ret;
	}
	
	
	public static StatusCode getStatusCode(Bundle b){
		
		StatusCode ret = StatusCode.values()[b.getInt(EXTRA_STATUSCODE)];
		return ret;
	}
}
