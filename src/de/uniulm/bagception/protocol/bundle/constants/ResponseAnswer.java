package de.uniulm.bagception.protocol.bundle.constants;

import android.os.Bundle;

public enum ResponseAnswer {
	Ask_For_Specific_Device(0), Confirm_Established_Connection(1);

	
	private static final String EXTRA_RESPONSE_ANSWER_CODE = "de.uniulm.bundle.extra.bluetooth.comm.responsecode";

	
	private final int responseanswercode;

	/*
	 * ############################################### ###############
	 * constructors ##############
	 * #################################################
	 */

	private ResponseAnswer(int code) {
		this.responseanswercode = code;
	}

	/*
	 * ############################################### ############### *
	 * getters/setters #############
	 * #################################################
	 */

	public int getResponseAnswerCode() {
		return responseanswercode;
	}

	/*
	 * ############################################### ############### statics
	 * ############# #################################################
	 */

	public static Bundle getResponseAnswerBundle(ResponseAnswer resp) {
		Bundle ret = new Bundle();
		ret.putInt(EXTRA_RESPONSE_ANSWER_CODE, resp.getResponseAnswerCode());
		return ret;
	}

	public static ResponseAnswer getResponseAnswer(Bundle b) {
		return ResponseAnswer.values()[b.getInt(EXTRA_RESPONSE_ANSWER_CODE)];
		
	}
	
	public class EXTRA_KEYS{
		public static final String PAYLOAD = EXTRA_RESPONSE_ANSWER_CODE+"payload";  
	}
	

	

}

