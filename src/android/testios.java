package setting.config;

import android.content.Intent;
import android.content.Context;
import android.provider.Settings;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class testios extends CordovaPlugin {
    
    String setting;
    Intent intent;
    Context context;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
         // Verify that the user sent a 'open' action
      if (!action.equals("coolMethod")) {
        callbackContext.error("\"" + action + "\" is not a recognized action.");
        return false;
      }

      try{
        JSONObject options = args.getJSONObject(0);
        setting = options.getString(0);
      } catch (JSONException e) {
        callbackContext.error("Error encountered: " + e.getMessage());
        return false;
      }

      context=this.cordova.getActivity().getApplicationContext();

      if (setting.equals("wifi")) {
        //Create new Intent
        intent = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
      }else if(setting.equals("location")){

        intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
      }else{
            // Send a positive result to the callbackContext
            PluginResult pluginResult = new PluginResult(PluginResult.Status.INVALID_ACTION);
            callbackContext.sendPluginResult(pluginResult);
            return false;
      }

      this.cordova.getActivity().startActivity(intent); 

      // Send a positive result to the callbackContext
      PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
      callbackContext.sendPluginResult(pluginResult);
      return true;
    }
}
