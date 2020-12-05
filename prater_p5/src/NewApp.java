import java.util.Scanner;

public class NewApp {

    public static void main(String args[]){

        int menu = 0 ;
        Scanner input = new Scanner(System.in);

        menu = input.nextInt();

        System.out.printf("Select your application\n");
        System.out.printf("________________________\n\n");
        System.out.printf("1) Task List\n");
        System.out.printf("2) Contact List\n");
        System.out.printf("3) quit\n");

        if(menu == 1){

            TaskApp.taskApp();

        }else if (menu == 2){



        }else if(menu == 3){



        }else System.out.printf("Invalid inuput please try again...");




    }

}
