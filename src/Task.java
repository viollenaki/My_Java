class Task{
    private String taskName;
    private int duration;
    private int priority;
    public Task(String taskName, int priority, int duration) {
        this.taskName = taskName;
        this.priority = priority;
        this.duration = duration;
    }

    public String getTaskName() {
        return taskName;
    }   

    public int getDuration() {
        return duration;
    }

    public int getPriority() {
        return priority;
    }
}