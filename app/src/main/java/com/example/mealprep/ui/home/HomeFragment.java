package com.example.mealprep.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.mealprep.CaloriesPerDay;
import com.example.mealprep.R;
import com.example.mealprep.User;

public class HomeFragment extends Fragment{

    private static final String TAG = HomeFragment.class.getSimpleName();
    private RadioGroup sex;
    private RadioButton buttonSex;
    private EditText age,height,weight,goalWeight,days,physicalActivity,physicalActivityFinal;
    private Button submit;
    private String gender="";
    private double caloriesPerDay;
    private CaloriesPerDay listener;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        // initializes objects
        sex=(RadioGroup)root.findViewById(R.id.rg);
        age=(EditText)root.findViewById(R.id.textAge);
        height=(EditText)root.findViewById(R.id.textHeight);
        weight=(EditText)root.findViewById(R.id.textWeight);
        goalWeight=(EditText)root.findViewById(R.id.textGoalWeight);
        days=(EditText)root.findViewById(R.id.textDays);
        physicalActivity=(EditText)root.findViewById(R.id.textPhysicalActivity);
        physicalActivityFinal=(EditText)root.findViewById(R.id.textFinalPhysicalActivity);
        submit=(Button)root.findViewById(R.id.buttonSubmit);

        // on button click, creates a User object and passes in the data inputted
        submit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
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
                Log.d(TAG,user.toString());
                caloriesPerDay=user.caloriesToEat();
                Log.d(TAG,"Sending "+Double.toString(caloriesPerDay) + " to Main Activity");
                listener.setResult(Double.toString(caloriesPerDay));
            }
        });
        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CaloriesPerDay) {
            listener = (CaloriesPerDay) context;
        } else {
            throw new RuntimeException(context.toString()+ " must implement CaloriesPerDay");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
