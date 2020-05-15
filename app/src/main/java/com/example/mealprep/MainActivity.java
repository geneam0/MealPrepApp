package com.example.mealprep;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import com.example.mealprep.ui.dashboard.DashboardFragment;
import com.example.mealprep.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity implements CaloriesPerDay{

    private static final String TAG = HomeFragment.class.getSimpleName();
    private DashboardFragment df;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializes DF to be used in setResult class
        df = new DashboardFragment();
        // StrictMode is for the Constant class so it doesn't raise a warning when sending an HTTP request
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    // From the CaloriesPerDay Interface, defines the method for setting result
    // MainActivity moves to DF and then calls its setResult Method
    public void setResult(String message) {
        Log.d(TAG,"Sending message from MainActivity -> DashboardFragment");
        navController.navigate(R.id.navigation_dashboard);
        df.setResult(message);
    }
}
