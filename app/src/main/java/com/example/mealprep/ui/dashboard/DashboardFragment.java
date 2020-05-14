package com.example.mealprep.ui.dashboard;

import android.content.Intent;
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
import android.widget.TextView;

import com.example.mealprep.CaloriesPerDay;
import com.example.mealprep.MainActivity;
import com.example.mealprep.R;
import com.example.mealprep.ui.home.HomeFragment;
import android.content.Intent;

import java.util.zip.Inflater;

public class DashboardFragment extends Fragment {
    private static final String TAG = HomeFragment.class.getSimpleName();

    private DashboardViewModel dashboardViewModel;
    private TextView txtData;
    private String message;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        txtData = (TextView) root.findViewById(R.id.textView);

        /*
        Intent iin=((MainActivity) getContext()).getIntent();
        Bundle b = iin.getExtras();
        if(b!=null)
        {
            String j =(String) b.get("STRING_I_NEED");
            txtData.setText(j);
        }
        */
        return root;
    }
    /*
    @Override
    public void setResult(String message) {
        Log.d(TAG,message);
        //txtData=(TextView) root.findViewById(R.id.textView);
        this.message=message;
        txtData.setText(message);
    }

     */
}
