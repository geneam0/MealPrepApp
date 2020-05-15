package com.example.mealprep.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DashboardViewModel(String m) {
        mText = new MutableLiveData<>();
        mText.setValue(m);
    }

    public LiveData<String> getText() {
        return mText;
    }
}