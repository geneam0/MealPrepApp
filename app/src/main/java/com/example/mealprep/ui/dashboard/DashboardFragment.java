package com.example.mealprep.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mealprep.Constants;
import com.example.mealprep.ui.home.HomeFragment;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import com.example.mealprep.R;

public class DashboardFragment extends Fragment {
    private static final String TAG = HomeFragment.class.getSimpleName();
    private TextView txtData;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        txtData=(TextView)root.findViewById(R.id.CaloriesBar);

        return root;
    }

    public void setResult(String message) {
        Log.d(TAG,"Received message in Dashboard Fragment");
        Constants c = new Constants(message);
        String json = c.doInBackground();
        Log.d(TAG,"JSON: "+json);
        if(txtData!=null) {
            txtData.setText("Calories"+message);
        } else{
            Log.d(TAG,"txtData is NULL");
        }
    }
}
