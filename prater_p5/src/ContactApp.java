import java.time.LocalDate;
import java.util.Scanner;

public class ContactApp {
    private static Scanner input = new Scanner(System.in);
    private ContactList contactList;

    public static void displayMenu(){
        System.out.println("-Main menu-");
        System.out.println("-----------\n");
        System.out.println("--1) create a new contact list");
        System.out.println("--2) load an existing contact list ");
        System.out.println("--3) quit\n");

    }

    public static void displayListMenu(){
        System.out.println("\n-List Operation Menu-");
        System.out.println("-----------\n");
        System.out.println("-1) view list");
        System.out.println("-2) add an item");
        System.out.println("-3) edit an item");
        System.out.println("-4) remove an item");
        System.out.println("-5) save the current list");
        System.out.println("-6) quit to main menu\n");

    }

    public void createNewList(){
        contactList = new ContactList();
    }


    public void viewList(){
        //call the viewList method from taskList of all the elements in the List and it's content
        contactList.viewList();
    }

    public  void addToList() {

        //add an taskList to the arrayList
        System.out.println("First name: ");
        String first = input.nextLine();

        System.out.println("Last name: ");
        String last = input.nextLine();

        System.out.println("Phone number (xxx-xxx-xxxx): ");
        String phoneNumber = input.nextLine();

        System.out.println("Email Address (x@y.z): ");
        String email = input.nextLine();

        if (first.isBlank() && last.isBlank() && phoneNumber.isBlank() && email.isBlank()){
            System.out.printf("\nPlease provide at least one character in one of the categories. Nothing was added.\n\n");
        }
        else {
            ContactItem item = new ContactItem(first, last, phoneNumber, email);
            contactList.addItem(item);
        }
    }

    public  void editList(){
        //Calls the edit list method from taskList to update items in the list
        int index;

        System.out.println("Which Contact would you like to edit...");
        index = input.nextInt();
        input.nextLine();

        if(index < contactList.size()) {
            //Editing task in taskList to the arrayList
            System.out.println("New First: ");
            String first = input.nextLine();

            System.out.println("New Last name: ");
            String last = input.nextLine();

            System.out.println("New Phone number (xxx-xxx-xxxx): ");
            String phoneNumber = input.nextLine();

            System.out.println("New Email Address (x@y.z): ");
            String email = input.nextLine();

            if (first.isBlank() && last.isBlank() && phoneNumber.isBlank() && email.isBlank()){
                System.out.printf("\nPlease provide at least one character in one of the categories. Nothing was changed.\n\n");
            }
            else {
                contactList.editContact(index, first, last, phoneNumber, email);
            }
        }
        else {
            System.out.println("Invalid index, Please try again...");
        }
    }

    public void removeItem(){
        //Calls the remove method from TaskList
        int index;
        System.out.println("Which Contact would you like to remove...");
        index = input.nextInt();
        input.nextLine();
        contactList.removeItem(index);
        System.out.printf("Contact index %d  was removed.", index);
    }

    public void saveList(){
        //calls save list Method from taskList
        System.out.printf("What name would you like to give the file?\n");
        String name = input.nextLine();

        contactList.saveList(name);

        System.out.printf("Your file has been saved! Look for %s.txt\n", name);

    }

    public ContactList loadList() {
        String fileName;
        contactList = new ContactList();

        System.out.printf("What file would you like to open?\n");
        fileName = input.nextLine();


        contactList.loadList(fileName);


        System.out.printf("Loading....");

            return contactList;
    }


    public static void contactApp(){

        int menu = 0;
        int data = 0; //This will grab the prompt for the
        int index;
        String first, last, phoneNumber, email;

        ContactApp app = new ContactApp();

        while (menu != 3) {

            displayMenu();

            menu = input.nextInt();
            input.nextLine();

            //while menu is 1...
            if (menu == 1) {
                //needs to try to create a list, if and unsaved one exist then it needs throw an exception to continue on with the unsaved list data
                app.createNewList();//creates A new ArrayList of TaskList
                System.out.println("A  contact list was ceated...");

                while (menu == 1) {

                    displayListMenu();
                    data = input.nextInt();//scans for user input
                    input.nextLine();
                    if (data == 1) {
                        //views list
                        app.viewList();

                    } else if (data == 2) {
                        //add item to contact list
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
                        app.saveList();

                    }
                    else if (data == 6) {
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
                        //add item to contact list
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
                        app.saveList();

                    }
                    else if (data == 6) {
                        menu = 0;

                    }else System.out.println("Invalid Input: Try again...");

                }

            }else if (menu == 3){
                System.out.println("Back to main menu...");
            }
            else if (menu >= 4) System.out.printf("Invalid input try a smaller number");
        }
    }


}
