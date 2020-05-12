package com.example.mealprep.ui.home;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mealprep.R;
import com.example.mealprep.User;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RadioGroup sex;
    private RadioButton buttonSex;
    private EditText age,height,weight,goalWeight,days,physicalActivity,physicalActivityFinal;
    private Button submit;
    private String gender="";
    private static final String TAG = HomeFragment.class.getSimpleName();
    private double caloriesPerDay;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        sex=(RadioGroup)root.findViewById(R.id.rg);
        age=(EditText)root.findViewById(R.id.textAge);
        height=(EditText)root.findViewById(R.id.textHeight);
        weight=(EditText)root.findViewById(R.id.textWeight);
        goalWeight=(EditText)root.findViewById(R.id.textGoalWeight);
        days=(EditText)root.findViewById(R.id.textDays);
        physicalActivity=(EditText)root.findViewById(R.id.textPhysicalActivity);
        physicalActivityFinal=(EditText)root.findViewById(R.id.textFinalPhysicalActivity);
        submit=(Button)root.findViewById(R.id.buttonSubmit);
        submit.setOnClickListener(new OnClickListener() {
            @Override
             {
                int selectedId = sex.getCheckedRadioButtonId();
                buttonSex = (RadioButton) root.findViewById(selectedId);
                gender=buttonSex.getText().toString();
                double w=Double.parseDouble(String.valueOf(weight.getText()));
                int a=Integer.parseInt(String.valueOf(age.getText()));
                double h=Double.parseDouble(String.valueOf(height.getText()));
                double pa=Double.parseDouble(String.valueOf(physicalActivity.getText()));
                double gw=Double.parseDouble(String.valueOf(goalWeight.getText()));
                int d=Integer.parseInt(String.valueOf(days.getText()));
                double pafinal=Double.parseDouble(String.valueOf(physicalActivityFinal.getText()));
                User user = new User(w,gender,a,h,pa,gw,d,pafinal);
                //Log.d(TAG,user.toString());
                caloriesPerDay=user.caloriesToEat();
                //Log.d(TAG,Double.toString(user.caloriesToEat()));
            }
        });
        return root;
    }
}
