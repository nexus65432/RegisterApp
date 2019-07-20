package co.register.search.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import co.register.search.ui.MainActivity;
import co.register.search.R;

/**
 * This class is for showing loading screen or loading animation when opening the application
 * The time interval can change based on the requirement
 */
public class SplashActivity extends AppCompatActivity {

    public static final int SPLASH_DISPLAY_INTERVAL = 1000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_layout);

        showLoginActivity();
    }

    public void showLoginActivity() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                showMainActivity();
            }
        }, SPLASH_DISPLAY_INTERVAL);
    }

    private void showMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
