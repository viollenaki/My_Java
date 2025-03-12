
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Task implements Comparable<Task> {

    private String taskName;
    private int priority;
    private int duration;

    public Task(String taskName, int priority, int duration) {
        this.taskName = taskName;
        this.priority = priority;
        this.duration = duration;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getPriority() {
        return priority;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public int compareTo(Task other) {
        if (this.priority == other.priority) {
            return Integer.compare(this.duration, other.duration);
        }
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        return "Task:  name=" + taskName + ", priority=" + priority + ", duration=" + duration;
    }
}

class TaskScheduler {

    private List<Task> taskList;

    public TaskScheduler() {
        this.taskList = new LinkedList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
        taskList.sort(null);
        System.out.println("Добавлена задача: " + task);
    }

    public void processNextTask() {
        if (!taskList.isEmpty()) {
            Task task = taskList.remove(0);
            System.out.println("Выполняется задача: " + task);
        } else {
            System.out.println("Нет задач для выполнения.");
        }
    }

    public void showAllTasks() {

        System.out.println("Запланированные задачи:");
        for (Task task : taskList) {
            System.out.println(task);
        }

    }
}

class KeyValue {

    public static <K, V> void printKeyValue(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("key-" + entry.getKey() + "  value-" + entry.getValue());
        }
    }
}

class ToOneList {

    public static <E> List<E> toOne(List<E> first, List<E> second) {
        List<E> result = new ArrayList<>(first.size() + second.size());

        if (first.size() >= second.size()) {
            for (int i = 0; i < first.size(); i++) {
                result.add(first.get(i));
                if (i < second.size()) {
                    result.add(second.get(i));
                }
            }
        } else {
            for (int i = 0; i < second.size(); i++) {
                if (i < first.size()) {
                    result.add(first.get(i));
                }
                result.add(second.get(i));
            }
        }

        return result;
    }
}

public class Group {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8);

        List<Integer> mergedList1 = ToOneList.toOne(list1, list2);
        System.out.println("Объединенный список" + mergedList1);

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Tolon", 95);
        scores.put("ELina", 87);
        scores.put("Emil", 92);
        KeyValue.printKeyValue(scores);

        System.out.println();

        Map<Integer, String> idNames = new TreeMap<>();
        idNames.put(101, "Azam");
        idNames.put(103, "Otabek");
        idNames.put(102, "Jain");
        KeyValue.printKeyValue(idNames);
        System.out.println("==================================================================================");
        TaskScheduler scheduler = new TaskScheduler();
        
        scheduler.addTask(new Task("Разработка UI", 2, 30));
        scheduler.addTask(new Task("Настройка базы данных", 3, 40));
        scheduler.addTask(new Task("Тестирование", 3, 20));
        scheduler.addTask(new Task("Обновление документации", 1, 15));

        scheduler.processNextTask();
        scheduler.processNextTask();
        scheduler.showAllTasks();

    }
}
