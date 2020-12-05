import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class ContactList {


    private List<ContactItem> items;

    public ContactList() {
        this.items = new ArrayList<>();
    }

    //adds items to the array list
    public void addItem(ContactItem item) {
        items.add(item);
    }

    //gets the number of items in the Tasklist array
    public int size() {
        return items.size();
    }

    //get method for the TaskList array for each index
    private ContactItem get(int index) {
        return items.get(index);
    }

    //removeItem()
    public void removeItem(int index) {
        items.remove(index);
    }


    //Calls the editConcact in Contact items
    public void editContact(int index, String First, String Last, String phoneNumber, String email) {
        this.get(index).editContact(First, Last, phoneNumber, email);

    }

    public void viewList() {

        ContactItem tempContact;
        for (int i = 0; i < this.size(); i++) {
            tempContact = this.get(i);
            System.out.println(i + ")" + tempContact.toString());

        }
    }

    public void saveList(String fileName){
        try(Formatter file = new Formatter(fileName)){
            //file.format("Tasks\n");

            for (ContactItem items : items){
                file.format("%s\n", items.getFirst());
                file.format("%s\n", items.getLastName());
                file.format("%s\n", items.getPhoneNumber());
                file.format("%s\n", items.getEmail());

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loadList(String fileName) {
        List<ContactItem> tempList = items;
        items = new ArrayList<>();

        try (Scanner getFile = new Scanner(Paths.get(fileName))) {
            while (getFile.hasNext()) {
                String First = getFile.nextLine();
                String Last = getFile.nextLine();
                String phoneNumber = getFile.nextLine();
                String email = getFile.nextLine();

                ContactItem item = new ContactItem(First, Last, phoneNumber, email);

                this.addItem(item);
            }


        } catch (FileNotFoundException e) {
            items = tempList;
            throw new IllegalArgumentException("File no found; no file loaded");
        } catch (IOException e) {
            items = tempList;
            throw new IllegalArgumentException(" Error with data, no file loaded");
        }

    }


}
