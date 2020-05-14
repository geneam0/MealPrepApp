package com.example.mealprep.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mealprep.CaloriesPerDay;
import com.example.mealprep.R;
import com.example.mealprep.ui.home.HomeFragment;

public class DashboardFragment extends Fragment implements HomeFragment.CaloriesFrag {
    private static final String TAG = HomeFragment.class.getSimpleName();

    private DashboardViewModel dashboardViewModel;
    private TextView txtData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        txtData = (TextView) root.findViewById(R.id.textView);
        return root;
    }

    public void setResult(String message) {
        txtData.setText(message);
    }

}
