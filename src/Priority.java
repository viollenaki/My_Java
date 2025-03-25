
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Priority {
    private PriorityQueue<Task> scheduledTasks;
    private ArrayDeque<Task> pendingTasks;
    private HashMap<Task, ArrayList<LocalDateTime>> completedTasks;

    public Priority() {
        this.scheduledTasks = new PriorityQueue<>((a,b)->Integer.compare(a.getPriority(),b.getPriority()));
        this.pendingTasks = new ArrayDeque<>();
        this.completedTasks = new HashMap<>();
    }

    public void addTask(Task t) {
        scheduledTasks.offer(t);
    }

    public void printAllTasks(){

        System.out.println("Scheduled tasks:");
        for (Task t : scheduledTasks) {
            System.out.println("[Priority "+t.getPriority() + "] " + t.getTaskName() + " " + t.getDuration());
        }

        System.out.println("Pending tasks:");
        for (Task t : pendingTasks) {
            System.out.println("[Priority "+t.getPriority() + "] " + t.getTaskName() + " " + t.getPriority());
        }
        
        System.out.println("Completed tasks:");
        for(Map.Entry<Task, ArrayList<LocalDateTime>> entry : completedTasks.entrySet()) {
            System.out.println("[Priority "+entry.getKey().getPriority() + "] " 
                                + entry.getKey().getTaskName() + " " 
                                + entry.getValue().get(0)+","+entry.getValue().get(1));
        }
    }
    
    public void delayTask(Task t){
        pendingTasks.offer(t);
        scheduledTasks.remove(t);   
    }

    public void processingTask(){
        if (!scheduledTasks.isEmpty()){
            Task t = scheduledTasks.poll();
            System.out.println("processing task" + t.getPriority()+", Name" + t.getTaskName() +"Duration"+t.getDuration());
            return; 
        }
        if(!pendingTasks.isEmpty()){
            Task t = pendingTasks.poll();
            System.out.println("processing task" + t.getPriority()+", Name" + t.getTaskName() +"Duration"+t.getDuration());
            return;
        }        
    }


}

    