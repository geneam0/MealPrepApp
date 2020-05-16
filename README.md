# MealPrepApp
An app using Android Studio that takes in user input (sex, age, weight, goalWeight, height, days, starting physical activity, end physical activity) and creates a weekly meal plan for them using the Spoonacular API.
There are two main fragments: Home and Dashboard.
Home: User enters their given information. 
Once the 'submit' button is pressed, the caloriesPerDay is calculated and the app performs a GET request to Spoonacular to generate Breakfast, Lunch, and Dinner for 7 days.
Dashboard: The meals show up. This part is not implemented yet.
