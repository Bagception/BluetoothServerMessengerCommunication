package de.uniulm.bagception.bluetoothservermessengercommunication.service;

import android.os.Bundle;
import android.os.Message;
import de.philipphock.android.lib.services.messenger.MessengerService;
import de.uniulm.bagception.bluetoothservermessengercommunication.MessengerConstants;

public abstract class BundleMessengerService extends MessengerService{
	   public void sendBundle(Bundle b){
		   Message m = Message.obtain(null,
					MessengerConstants.MESSAGE_BUNDLE_MESSAGE);
		   m.setData(b);
		   sendToClients(m);
		  
	   }
}
