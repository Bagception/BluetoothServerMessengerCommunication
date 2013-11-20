package de.uniulm.bagception.bluetoothservermessengercommunication.messenger;

import android.os.Bundle;

public interface MessengerHelperCallback {

	public void onBundleMessage(Bundle b);
	public void onResponseMessage(Bundle b);
	public void onStatusMessage(Bundle b);
	public void onError(Exception e);
}
