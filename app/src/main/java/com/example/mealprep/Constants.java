package com.example.mealprep;

import android.os.AsyncTask;
import android.util.Log;
import com.example.mealprep.ui.home.HomeFragment;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// Constant class is used to collect Json data from the Spoonacular API
// This class extends the AsyncTask class so that when the phone is loading in the background, it doesn't crash your phone
public class Constants extends AsyncTask<Void, Void, String> {

    private static final String TAG = HomeFragment.class.getSimpleName();
    private Exception exception;
    private static final String BASE_URL = "https://api.spoonacular.com/mealplanner/generate?apiKey=";
    private static final String API_KEY = "e3174c93ff0c4349a3648ded4813cc34";
    // calories is passed in because the API can generate meals for the week based on how many calories you want to eat in a day
    // which is calculated in User
    private String calories;

    public Constants(String calories){
        this.calories=calories;
    }

    @Override
    public String doInBackground(Void... voids) {
        try {
            // Start the request
            URL url = new URL(BASE_URL + API_KEY + "&timeFrame=week" + "&targetCalories="+calories);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            // Try the request and return an exception if it doesn't work
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    response.append(line).append("\n");
                }
                bufferedReader.close();
                Log.d(TAG,response.toString());
                return response.toString();
            }
            finally{
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
    }
}
