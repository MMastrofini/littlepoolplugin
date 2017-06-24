package com.situ.situscale.situbluetoothsample;

import android.content.Context;
import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Manuel.
 */
public class BluetoothActivatorPlugin extends CordovaPlugin {
    
    private static final int REQUEST_CODE = 22;
    private CallbackContext callbackContext;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("getWeight".equals(action)) {
            Intent yourIntent = new Intent(this.cordova.getActivity().getBaseContext(), LittlePoolBluetoothManager.class);
            cordova.getActivity().startActivityForResult(this, yourIntent, REQUEST_CODE);
            return true;
        }
        return false;  // Returning false results in a "MethodNotFound" error.
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if(requestCode==REQUEST_CODE) {
            String result = intent.getStringExtra("weight");
            this.callbackContext.success(result);
        }
    }

}
