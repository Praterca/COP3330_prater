import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class TaskList {
    private List<TaskItem> items;

    public TaskList() {
        this.items = new ArrayList<>();
    }

    //adds items to the array list
    public void addItem(TaskItem item) {
        items.add(item);
    }

    //gets the number of items in the Tasklist array
    public int size() {
        return items.size();
    }

    //get method for the TaskList array for each index
    private TaskItem get(int index) {
        return items.get(index);
    }

    //removeItem()
    public void removeItem(int index) {
        items.remove(index);
    }

    //Will return item as complete
    public void complete(int index) {
        this.get(index).complete();
    }

    public void incomplete(int index) {
        this.get(index).incomplete();
    }

//List Operation menu methods


    public void editTask(int index, String task, String description, String date) {
        this.get(index).editTask(task, description, date);

    }

    public void viewList() {

        TaskItem tempItem;
        for (int i = 0; i < this.size(); i++) {
            tempItem = this.get(i);
            if (tempItem.isComplete()) {
                System.out.println(i + ") *** " + tempItem.toString());
            } else {
                System.out.println(i + ") " + tempItem.toString());
            }
        }


    }

    public void saveList(String fileName){
        try(Formatter file = new Formatter(fileName)){
            //file.format("Tasks\n");

            for (TaskItem items : items){
                file.format("%s\n", items.getDate());
                file.format("%s\n", items.getTitle());
                file.format("%s\n", items.getScript());

                if(items.isComplete()){
                    file.format("Completed\n");
                }else
                {
                    file.format("Incomplete \n");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void loadList(String fileName){
       List<TaskItem> tempList = items;
       items = new ArrayList<>();

       try(Scanner getFile = new Scanner(Paths.get(fileName))){
           while(getFile.hasNext()){
               String date = getFile.nextLine();
               String title = getFile.nextLine();
               String script = getFile.nextLine();
               String complete = getFile.nextLine();


               TaskItem item = new TaskItem( title,script, date);
               //Check to see if item is complete
               if(complete == "Completed"){
                   item.isComplete();
               }

               this.addItem(item);
           }


       }catch(FileNotFoundException e){
        items = tempList;
        throw new IllegalArgumentException("File no found; no file loaded");
       } catch (IOException e) {
           items = tempList;
           throw new IllegalArgumentException(" Error with data, no file loaded");
       }


    }

}

