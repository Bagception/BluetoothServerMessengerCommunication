package de.uniulm.bagception.protocol.bundle.constants;

import de.uniulm.bagception.bluetoothservermessengercommunication.messenger.MessengerHelper;
import android.os.Bundle;
/**
 * Answer Message to Response @see {@link Response}
 * @author phil
 *
 */
public enum ResponseAnswer {
	
	Ask_For_Specific_Device(0), 
	
	Confirm_Established_Connection(1);

	
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
	
	/**
	 * ACKnowledgement that the message is received by an endpoint
	 * @return
	 */
	public Bundle getACK(){
		Bundle ret = toBundle();
		ret.putBoolean(ResponseAnswer.EXTRA_KEYS.isACK, true);
		return ret;
	}
	
	/**
	 * creates a bundle ready to send
	 * Alternatively use the static method {@link #getResponseAnswer(Bundle)}
	 * @return a bundle that can be sent via {@link MessengerHelper#sendResponseBundle(Bundle)}
	 */
	public Bundle toBundle(){
		return ResponseAnswer.getResponseAnswerBundle(this);
	}

	/*
	 * ############################################### ############### statics
	 * ############# #################################################
	 */

	
	
	/**
	 * creates a bundle ready to send
	 * Alternatively use the static method {@link #toBundle()}
	 * @return a bundle that can be sent via {@link MessengerHelper#sendResponseBundle(Bundle)}
	 */
	public static Bundle getResponseAnswerBundle(ResponseAnswer resp) {
		Bundle ret = new Bundle();
		ret.putInt(EXTRA_RESPONSE_ANSWER_CODE, resp.getResponseAnswerCode());
		return ret;
	}

	/**
	 * 
	 * @param b the bundle received from a remote endpoint
	 * @return enum representation of the bundle
	 */
	public static ResponseAnswer getResponseAnswer(Bundle b) {
		return ResponseAnswer.values()[b.getInt(EXTRA_RESPONSE_ANSWER_CODE)];
		
	}
	
	/**
	 * HelperClass with String-Constants.
	 * All additional information is added after the Enum is created.
	 * The EXTRA_KEYS are the Strings used in the KEY part of bundle.putExtra
	 * @author phil
	 *
	 */
	public class EXTRA_KEYS{
		public static final String PAYLOAD = EXTRA_RESPONSE_ANSWER_CODE+"payload";  
		public static final String isACK = EXTRA_RESPONSE_ANSWER_CODE+"isack";
	}
	

	public static boolean isACK(Bundle b){
		boolean ack = b.getBoolean(ResponseAnswer.EXTRA_KEYS.isACK, false);
		return ack;
		
	}
	
	

}

