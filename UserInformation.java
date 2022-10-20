/* MIS 350 Project Milestone 2
   6/20/2021
   Muntaqim Elahi
   This program calculates the maintenance calories based off of
   the user's age, gender and weight using the MET scale.
   https://sites.google.com/site/compendiumofphysicalactivities/Activity-Categories
*/
import java.util.Scanner;

public class UserInformation { 
    public static void main(String []args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Instantiate the User class - Create a User object
        User user = new User();

        // Set the user name
        System.out.println("First name: \n");
        String firstName = input.next();                 
        System.out.println("Last name: \n");
        String lastName = input.next();
        user.setName(firstName, lastName);
        
        // Set the age
        System.out.println("Enter your age: \n"); 
        int age = input.nextInt(); 
        user.setAge(age);

        // Set the gender
        System.out.println("Sex: M or F: \n");
        char sex = input.next().charAt(0);
        user.setSex(sex);
        
        // User gets the option to input their weight in pound or kg then sets weight
        System.out.println("Do you measure your weight in pound or kg?: \n");
        String weight = input.next();
        if(weight.equals("pound")){
            System.out.println("Enter your weight in pound: \n");
            // input double value for pound
            double pound = input.nextDouble();
            double kg = pound / 2.2046;  // Converting Pound to kg
            user.setWeight(kg);
        }
        else{
            System.out.println("Enter your weight in kg: \n");
            // input double value for kg
            double kg = input.nextDouble();
            user.setWeight(kg);
        }
        // Input calorie Intake from meals
        System.out.println("Did you eat?: \n");
        String ans = input.next();
        String meal;
        do{
            // Prompt user and take user input of meal name
            //System.out.println("Did you eat?: \n");
            
            if(ans.equals("Yes")){
                System.out.println("What did you eat? \n");
                meal = input.next();
            }
            else{
                ans.equals("No");
                System.out.println("Quickly have your meal and come back when you finished!\n"); //Write your own thing!
                return;
            }
            // Prompt and take user input of calorie from the meal name
            System.out.println("How many calories were in your meal?: \n");
            // Call setCalorieIntake
            user.setcalorieIntake(input.nextInt()); // set calorie Intake
            // Prompt do you have another meal to enter 
            System.out.println("Did you eat anything else?: \n");
            ans = input.next();
            }
            
        while(ans.equals("Yes") || ans.equals("yes"));

        // Input Calorie consuming from activities
        System.out.println("Did you exercise?: \n");
        String exercise = input.next();
        if(exercise.equals("Yes") || exercise.equals("yes")){
            System.out.println("What type of activity did you do?\n");
            String activity = input.next();
            System.out.println("How long did you do your " + activity + " in minutes?\n");
            double activity_time = input.nextDouble();
            double burnedCalorie = user.calculateCalorieBurned(activity_time, activity); 
            user.setcalorieBurned((int)burnedCalorie);
        }
        else {
            user.setcalorieBurned(0);
        }
        int requiredCalorie = user.requiredCalories();
        // Display daily report
        if (requiredCalorie >= 0) {
            System.out.println("You would need to eat " + requiredCalorie + " calories to meet your maintenance calories.\n");
        }
        else {
            requiredCalorie = requiredCalorie * (-1);
            System.out.println("You need to burn " + requiredCalorie + " calories to meet your maintenance calories.\n");
        }
    }
}

        

