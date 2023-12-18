import java.util.ArrayList;
import java.util.List;

public class TaskCarousel {

    private final int capacity;
    private final List<Task> taskList;
    private int counter = -1;
    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        taskList = new ArrayList<>(capacity);
    }

    public boolean addTask(Task task) {
        if(task == null || task.isFinished() || taskList.size()>= capacity){
            return false;
        }else{
            taskList.add(task);
            return true;
        }
    }

    public boolean execute() {
        if(!isEmpty()){
            counter++;
            if(counter == taskList.size()){
                counter = 0;
            }
            Task task = taskList.get(counter);
            task.execute();
            if(task.isFinished()){
                taskList.remove(task);
                counter--;
            }
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return taskList.size()>=capacity;
    }

    public boolean isEmpty() {
        return taskList.isEmpty();
    }
}
