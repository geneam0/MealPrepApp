package com.example.mealprep;

public class User {
    private double weight; // in poumds
    private String sex;
    private int age;
    private double height; // in feet (5'10" -> 5.833)
    private double PA; // physical activity (1.4 sedentary to 2.5 very active)
    private double goalWeight; // in pounds
    private int daysToReachGoal;
    private double finalPA; // physical activity (1.4 sedentary to 2.5 very active)

    public User(double weight, String sex, int age, double height, double PA, double goalWeight, int daysToReachGoal, double finalPA){
        this.weight=weight;
        this.sex=sex;
        this.age=age;
        this.height=height;
        this.PA=PA;
        this.goalWeight=goalWeight;
        this.daysToReachGoal=daysToReachGoal;
        this.finalPA=finalPA;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getPA() {
        return PA;
    }

    public void setPA(double PA) {
        this.PA = PA;
    }

    public double getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(double goalWeight) {
        this.goalWeight = goalWeight;
    }

    public int getDaysToReachGoal() {
        return daysToReachGoal;
    }

    public void setDaysToReachGoal(int daysToReachGoal) {
        this.daysToReachGoal = daysToReachGoal;
    }

    public double getFinalPA() {
        return finalPA;
    }

    public void setFinalPA(double finalPA) {
        this.finalPA = finalPA;
    }

    // Based on Mifflin-St Jeor equation
    public double BMR(){
        if(sex.equals("Male")){
            return 10*0.453592*weight+6.25*height*30.48-5*age+5;
        } else{
            return 10*0.453592*weight+6.25*height*30.48-5*age-161;
        }
    }

    public double changeBW(){
        return goalWeight-weight;
    }
    public double changeCPD(){
        return changeBW()*7.77777777778/daysToReachGoal;
    }
    public double caloriesToEat(){
        return Math.round(((changeCPD()+BMR()*PA)/finalPA) * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "User{" +
                "weight=" + weight +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", PA=" + PA +
                ", goalWeight=" + goalWeight +
                ", daysToReachGoal=" + daysToReachGoal +
                ", finalPA=" + finalPA +
                '}';
    }
}
