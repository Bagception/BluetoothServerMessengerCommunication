package de.uniulm.bagception.bluetooth;

import android.bluetooth.BluetoothDevice;

public interface CheckReachableCallback {

	public void isReachable(BluetoothDevice device,boolean reachable);
	
}
