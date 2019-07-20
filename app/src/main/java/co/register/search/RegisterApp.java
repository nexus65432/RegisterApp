package co.register.search;

import android.app.Application;

import co.register.search.controller.RegisterPreference;
import co.register.search.database.DbHelper;


public class RegisterApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (!RegisterPreference.getInstance(this).isRegisterInitialized()) {
            DbHelper.getInstance(this).initializeDatabaseWithDefaultMenu(this);
        }
    }

}
