package de.uniulm.bagception.protocol.bundle.constants;

import android.os.Bundle;

public enum Response {
	Ask_For_Specific_Device(0), Confirm_Established_Connection(1);

	public static final String EXTRA_RESPONSECODE = "de.uniulm.bundle.extra.bluetooth.comm.responsecode";
	

	
	private final int responsecode;

	/*
	 * ############################################### ###############
	 * constructors ##############
	 * #################################################
	 */

	private Response(int code) {
		this.responsecode = code;
	}

	/*
	 * ############################################### ############### *
	 * getters/setters #############
	 * #################################################
	 */

	public int getResponseCode() {
		return responsecode;
	}
	
	public class EXTRA_KEYS{
		public static final String PAYLOAD = EXTRA_RESPONSECODE+"payload";  
	}

	/*
	 * ############################################### ############### statics
	 * ############# #################################################
	 */

	public static Bundle getResponseBundle(Response resp) {
		Bundle ret = new Bundle();
		ret.putInt(EXTRA_RESPONSECODE, resp.getResponseCode());
		return ret;
	}

	public static Response getResponse(Bundle b) {
		return Response.values()[b.getInt(EXTRA_RESPONSECODE)];
	}

	

}

