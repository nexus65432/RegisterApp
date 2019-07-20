package co.register.search.controller;

import android.content.Context;
import android.content.SharedPreferences;

public class RegisterPreference {

    private static final String REGISTER_APP_PREF = "register_app_pref";
    private static final String KEY_INITIALIZE_DB = "load_db";

    private static RegisterPreference _instance;
    private SharedPreferences sPref;
    private SharedPreferences.Editor sEditor;
    private Context mContext;

    public static RegisterPreference getInstance(Context context) {
        if (_instance == null) {
            _instance = new RegisterPreference(context);
        }
        return _instance;
    }

    public RegisterPreference(Context context) {
        mContext = context;
        // 0 - for private mode
        sPref = mContext.getSharedPreferences(REGISTER_APP_PREF, 0);
    }

    public void initializeRegister() {
        sEditor = sPref.edit();
        sEditor.putBoolean(KEY_INITIALIZE_DB, true); // Storing boolean - true/false
        sEditor.commit();
    }

    public boolean isRegisterInitialized() {
        return sPref.getBoolean(KEY_INITIALIZE_DB, false);
    }

}
