import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class TaskItemTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){



    }
    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){


    }
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){


    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
    TaskItem item = new TaskItem("Task 1", "This task", "2020-12-01");

    assertEquals("Task 1",item.getTitle());
    assertEquals("This task", item.getScript());
    assertEquals("2020-12-01", item.getDate());
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        TaskItem item = new TaskItem("Task 1", "This task", "Dec. 1st 2020");


        assertEquals("Task 1",item.getTitle());
        assertEquals("This task", item.getScript());
        assertEquals("2020-12-01", item.getDate());

    }
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){


    }
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){


    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){


    }

}