import java.time.LocalDate;

//This is were all the things the task item should do should be placed

public class TaskItem {
//handles the data of the arraylist
    //Should be an item in the Task List so Object item
    //format 00-00-0000 for the date
    //
    private LocalDate dueDate;
    private String title;
    private String script;
    boolean done;

    //constructor lets us get the full date and ADD it to the list
    public TaskItem(String title, String script, String dueDate){
        if(title.isBlank()){
            System.out.println("Please provide a title that is at least 1 character long...");
        }
       LocalDate today;
        try
        {
            today = LocalDate.parse(dueDate);

        }catch(java.time.format.DateTimeParseException e){
            throw new IllegalArgumentException("WARNING: invalid due date; task not updated");
        }

        this.dueDate = today;
        this.title = title;
        this.script = script;
        this.done = false;

    }


    // Needs to update date and stuff
    public void editTask( String title, String script,String dueDate){
            if(title.isBlank()){
                System.out.println("Please provide a title that is at least 1 character long...");
            }
            LocalDate today;
            try
            {
                today = LocalDate.parse(dueDate);

            }catch(java.time.format.DateTimeParseException e){
                throw new IllegalArgumentException("WARNING: invalid due date; task not updated");
            }

            this.dueDate = today;
            this.title = title;
            this.script = script;
            this.done = false;

        }

    public String toString(){

        return "[" + this.dueDate + "]  " + this.title + ":  " + this.script + "  ";
    }

    public void complete() {
        this.done = true;
    }

    public void incomplete() {
        this.done = false;
    }

    //Checks if item is or is not complete
    public boolean isComplete(){
        return this.done;
    }


    public String getTitle() {
       return this.title;
    }

    public String getScript(){
        return this.script;
    }

    public String getDate(){
        return this.dueDate.toString();
    }


}
