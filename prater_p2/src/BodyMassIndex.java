public class BodyMassIndex {

    double BMI;
    public BodyMassIndex(double height, double weight) {

        //Calculate the BMI score store it into getScore
        BMI = calScore(height, weight);

        //gets Category
        //getCategory(BMI);

    }

    //Calculates the BMi Score
    public double calScore(double height, double weight){
        double x = 703 * weight / Math.pow(height, 2);
        return x;
    }

    public void getCategory(double x){
        if (x > 30.00){
            System.out.println(" overweight");
        }else if(x <= 29.99 && x >= 25 ){
            System.out.println(" obesity");
        }else if(x <= 24.99 && x >= 18.5 ){
            System.out.println(" normal Weight");
        }else if(x < 18.5)
            System.out.println(" underweight");

    }
    public double getScore(double x){
        x = BMI;
        return x;
    }
}
