import java.util.Scanner;

public class NewApp {

    private static Scanner input = new Scanner(System.in);
    private static TaskApp tApp;
    private static ContactApp cApp;

    public static void displayMenu(){

        System.out.printf("Select your application\n");
        System.out.printf("________________________\n\n");
        System.out.printf("1) Task List\n");
        System.out.printf("2) Contact List\n");
        System.out.printf("3) quit\n\n");

    }

    public static void main(String args[]) {


        int menu = 0;

        tApp = new TaskApp();
        cApp = new ContactApp();


        while (menu != 3) {

           displayMenu();
           menu = input.nextInt();
           input.nextLine();


            if (menu == 1) {

                tApp.taskApp();

            } else if (menu == 2) {

                cApp.contactApp();

            } else if (menu == 3) {

                System.out.println("Thanking you for checking out my updated program!!");

            } else System.out.printf("Invalid input please try again...");


        }
    }
}
