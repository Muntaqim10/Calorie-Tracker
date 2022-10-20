//import java.util.IllegalFormatCodePointException;

public class User {   
    // Instance Variables 
    private String name;
    private int age;
    private char sex;
    private double weight; 
    private int suggestedCalories;
    private int calorieIntake; 
    private int calorieBurned;
 
    // Set methods
    public void setName(String fn, String ln) {
        name = fn + " " + ln;
    }

    public void setAge(int a) {
       age = a;
    }
   
    public void setSex(char s) {
       sex = s;
        if(s == 'M'){
            sex = 'M';
        }
        else if(s == 'F'){
            sex = 'F';
        } 
        else{
            sex = 'W' ;
        }  
    }

    public void setWeight(double w) {
        weight = w;
    }

    public void setsuggestedCalories() {
        if(sex == 'M'){
            if(age >= 19 && age < 30){
                suggestedCalories = 2200;
            }
            else{
                suggestedCalories = 2000;
            }
        }
        else if(sex == 'F'){
            if(age >= 19 && age < 30){
                suggestedCalories = 2000;
            }
            else{
                suggestedCalories = 1800;
            }
        }
        else{
            suggestedCalories = (1800 + 2000) / 2;
        }   
    }

    public void setcalorieIntake(int cIntake){
        calorieIntake += cIntake;
        //System.out.println("Total Calorie " + calorieIntake);
    }

    public void setcalorieBurned(int cBurned){
        calorieBurned += cBurned;
    }

    public double calculateCalorieBurned(double activity_time, String activity){
        double MET;
        if (activity.equals("Biking")) {
            MET = 7.5;
        }
        else if (activity.equals("Running")) {
            MET = 6.0;
        }
        else if (activity.equals("Swimming")) {
            MET = 7.0;
        }
        else {
            MET = 5.0;
        }
        double burnedCalorie = MET * weight * (activity_time / 60.0);
        return burnedCalorie;
    }

    public int requiredCalories() {
        int netCalories = calorieIntake - calorieBurned;
        return suggestedCalories - netCalories;
    }

    
}