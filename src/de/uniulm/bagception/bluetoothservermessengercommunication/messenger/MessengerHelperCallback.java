package de.uniulm.bagception.bluetoothservermessengercommunication.messenger;

import android.os.Bundle;

public interface MessengerHelperCallback {

	public void onMessage(Bundle b);
	public void onError(Exception e);
}
