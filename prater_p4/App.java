import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {


    private static Scanner input = new Scanner(System.in);
    private TaskList taskList;


    public static void displayMenu(){
        System.out.println("-Main menu-");
        System.out.println("-----------\n");
        System.out.println("--1) create a new list");
        System.out.println("--2) load an existing list ");
        System.out.println("--3) quit\n");

    }



    public static void displayListMenu(){
        System.out.println("\n-List Operation Menu-");
        System.out.println("-----------\n");
        System.out.println("-1) view list");
        System.out.println("-2) add an item");
        System.out.println("-3) edit an item");
        System.out.println("-4) remove an item");
        System.out.println("-5) mark an item as completed");
        System.out.println("-6) unmark an item as completed");
        System.out.println("-7) save the current list");
        System.out.println("-8) quit to main menu\n");


    }

    public void createNewList(){
        taskList = new TaskList();
    }

    public void viewList(){
        //call the viewList method from taskList of all the elements in the List and it's content
        taskList.viewList();
    }
    public  void addToList(){

        //add an taskList to the arrayList
        System.out.println("What would you like your task to be?  ");
        String task = input.nextLine();

        System.out.println("What is the description of the task?:  ");
        String script = input.nextLine();

        System.out.println("When would you like to complete this task? (YYYY-MM--DD):   ");
        String date = input.nextLine();

        try {
            TaskItem item = new TaskItem(task, script, date);

            taskList.addItem(item);
            //Edit the content inside of it for the new task
            //and display it to the user
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

    public  void editList(){
        //Calls the edit list method from taskList to update items in the list
        int index;

        System.out.println("Which Task would you like to edit...");
        index = input.nextInt();
        input.nextLine();

        if(index < taskList.size()) {
            //Editing task in taskList to the arrayList
            System.out.println("What would you like your new task to be?  ");
            String task = input.nextLine();

            System.out.println("What is the new description of the task?:  ");
            String script = input.nextLine();

            System.out.println("When would you like to complete this task? (YYYY-MM--DD):   ");
            String date = input.nextLine();

            try {
                //TaskItem item = new TaskItem(task, script, date);

                taskList.editTask(index, task, script, date);
                System.out.println("Your task was updated!!");
                //Edit the content inside of it for the new task
                //and display it to the user
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());

            }
        }
        else {
            System.out.println("Invalid index, Please try again...");
        }
    }
    public void removeItem(){
        //Calls the remove method from TaskList
        int index;
        System.out.println("Which Task would you like to remove...");
        index = input.nextInt();
        input.nextLine();
        taskList.removeItem(index);
        System.out.printf("Task at index %d  was removed.", index);
    }

    public  void isComplete(){
        int index;
        System.out.println("Which task is completed?");
        index = input.nextInt();
        input.nextLine();
        taskList.complete(index);
        System.out.printf("You have assigned task at index %d as complete.", index);

    }

    public void isIncomplete(){
        int index;
        System.out.println("Which task do you want to mark as incomplete?");
        index = input.nextInt();
        input.nextLine();
        taskList.incomplete(index);
        System.out.printf("You have marked task at index %d as incomplete.", index);
    }

    public void saveList(){
        //calls save list Method from taskList
        System.out.printf("What name would you like to give the file\n?");
        String name = input.nextLine();

        taskList.saveList(name);

        System.out.printf("Your file has been saved! Look for %s.txt\n", name);

    }

    public TaskList loadList(){
        String fileName;
        taskList = new TaskList();

        System.out.printf("What file would you like to open?\n");
        fileName = input.nextLine();


        taskList.loadList(fileName);


        System.out.printf("Loading....");
        return taskList;
    }


    public static void main(String[] args){

        int menu = 0;
        int data = 0; //This will grab the prompt for the
        int index;
        String title, task;
        LocalDate day;
        App app = new App();

        while (menu != 3) {

            displayMenu();

            menu = input.nextInt();
            input.nextLine();

            //while menu is 1...
            if (menu == 1) {
                //needs to try to create a list, if and unsaved one exist then it needs throw an exception to continue on with the unsaved list data
                app.createNewList();//creates A new ArrayList of TaskList
                System.out.println("A new task List was created...");

                while (menu == 1) {

                    displayListMenu();
                    data = input.nextInt();//scans for user input
                    input.nextLine();
                    if (data == 1) {
                        //views list
                        app.viewList();

                    } else if (data == 2) {
                        //add item to tasklist
                        app.addToList();

                    } else if (data == 3) {
                        //edit item: Should be able to choose between list numbers
                        app.viewList();
                        app.editList();

                    } else if (data == 4) {
                        //remove item from list
                        app.viewList();
                        app.removeItem();
                    } else if (data == 5) {
                        //mark an item as completed
                        //is completed method: Boolean
                        app.viewList();
                        app.isComplete();
                    } else if (data == 6) {
                        //unmark an item as completed
                        app.viewList();
                        app.isIncomplete();
                    } else if (data == 7) {
                        app.saveList();

                    }
                    else if (data == 8) {
                        menu = 0;

                    }else System.out.println("Invalid Input: Try again...");

                }
            }
                else if (menu == 2){
                    //Load List from file to RAM and modify the list
                    //needs loading method from taskList
                    //also exception if fails...
                    app.loadList();

                    System.out.println("Save file is loaded click");


                while (menu == 2) {

                    displayListMenu();
                    data = input.nextInt();//scans for user input
                    input.nextLine();
                    if (data == 1) {
                        //views list
                        app.viewList();

                    } else if (data == 2) {
                        //add item to tasklist
                        app.addToList();

                    } else if (data == 3) {
                        //edit item: Should be able to choose between list numbers
                        app.viewList();
                        app.editList();

                    } else if (data == 4) {
                        //remove item from list
                        app.viewList();
                        app.removeItem();
                    } else if (data == 5) {
                        //mark an item as completed
                        //is completed method: Boolean
                        app.viewList();
                        app.isComplete();
                    } else if (data == 6) {
                        //unmark an item as completed
                        app.viewList();
                        app.isIncomplete();
                    } else if (data == 7) {
                        app.saveList();

                    }
                    else if (data == 8) {
                        menu = 0;

                    }else System.out.println("Invalid Input: Try again...");

                }


                }else if (menu == 3){
                    System.out.println("Thank you for Checking out my program, have a good day!!");
                }
                else if (menu >= 4){
                System.out.println("Invalid Choice. Try again...");
                // break;
            }
        }
    }
}