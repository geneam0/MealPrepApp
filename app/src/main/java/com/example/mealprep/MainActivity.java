package com.example.mealprep;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import com.example.mealprep.ui.dashboard.DashboardFragment;
import com.example.mealprep.ui.dashboard.DashboardViewModel;
import com.example.mealprep.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = HomeFragment.class.getSimpleName();
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private int id = R.id.navigation_dashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        //fragmentManager = getSupportFragmentManager();
        //fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.replace(R.id.navigation_home, new HomeFragment());
        //fragmentTransaction.replace(id, new DashboardFragment());
        //fragmentTransaction.commit();
    }
    /*
    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof HomeFragment) {
            HomeFragment headlinesFragment = (HomeFragment) fragment;
            headlinesFragment.setCaloriesFrag(this);
        }
    }*/
    /*
    @Override
    public void setResult(String message) {
        // The user selected the headline of an article from the HeadlinesFragment
        // Do something here to display that article
        Log.d(TAG,message);
        //DashboardFragment articleFrag = (DashboardFragment)
           //     getSupportFragmentManager().findFragmentById(id);
        setContentView(R.layout.fragment_dashboard);
        DashboardFragment df = new DashboardFragment();
        df.setResult(message);
    }
     */
}
