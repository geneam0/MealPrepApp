# MealPrepApp
An app using Android Studio that takes in user input (sex, age, weight, goalWeight, height, days, starting physical activity, end physical activity) and creates a weekly meal plan for them using the Spoonacular API.

There are two main fragments: Home and Dashboard.

Home: User enters their given information. 

Once the 'submit' button is pressed, the caloriesPerDay is calculated and the app performs a GET request to Spoonacular to generate Breakfast, Lunch, and Dinner for 7 days.

Dashboard: The meals show up. This part is not implemented yet.

I don't recommend downloading Android Studio to run this app. What you can do, if you are interested in losing weight, is go to: 
'https://www.niddk.nih.gov/bwp'
to calculate your daily dietary intake. Download Postman and submitting a GET Request to:
'https://api.spoonacular.com/mealplanner/generate?apiKey=e3174c93ff0c4349a3648ded4813cc34&timeFrame=week&targetCalories=1500' 
Be sure to replace 1500 with your targetCalories.
