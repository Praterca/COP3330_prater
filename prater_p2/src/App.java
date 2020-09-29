import java.util.ArrayList;
import java.util.Scanner;
public class App {

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    //Line 18 Prints Statics for the ArrayList
    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        double total = 0.0;
        // Loop through the Array and add each score together until we reach the size of the arraylist
        for (BodyMassIndex TB : bmiData) {
            total += TB.BMI;
        }
        // Divide the total into the Arraylist Size
        double average = total / bmiData.size();
        //System out the Statics
        System.out.println("The Average BMI Score was: " + average);

    }


    //Line 13 Prints out Score and Category in this loop
    public static void displayBmiInfo(BodyMassIndex bmi) {

        //prints out the bmi for each index
        System.out.print(bmi.getScore(bmi.BMI));
        //Displays Category
        bmi.getCategory(bmi.BMI);


    }

    //Line 9 gets the users input for Height in inches
    public static double getUserHeight() {

        System.out.println("What is the Height(in inches)? : ");
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();

        while (x < 0) {
            System.out.println("Please type in a number greater than Zero...");
            x = input.nextDouble();
            if (x > 0) {
                return x;
            }
        }
        return x;
    }


    //Line 10 gets users input for Weight in lbs
    public static double getUserWeight() {
        System.out.println("What is the Weight? : ");
        Scanner input = new Scanner(System.in);
        double y = input.nextDouble();

        while (y < 0) {
            System.out.println("Please type in a number greater than Zero...");
            y = input.nextDouble();
            if (y > 0) {
                return y;
            }
        }
        return y;
    }

    public static boolean moreInput() {
        boolean b = true;
        System.out.println("Do you have more data to add? (Type Y or N)");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        if (s.equals("y") || s.equals("Y")) {
            b = true;
        } else if (s.equals("n") || s.equals("N"))
            b = false;
        else {
            System.out.println("Please try again...");
            moreInput();
        }
        return b;
    }
}
