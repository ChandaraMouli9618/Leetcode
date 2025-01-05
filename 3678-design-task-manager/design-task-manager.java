class TaskManager {

    TreeSet<Task> taskPQ = new TreeSet<>( (t1, t2) -> {
        if(t1.priority == t2.priority) return Integer.compare(t2.taskId, t1.taskId);
        return Integer.compare(t2.priority, t1.priority);
    });

    Map<Integer, Task> taskMap = new HashMap<>();

    public TaskManager(List<List<Integer>> tasks) {
        for(List<Integer> task : tasks){
            Task currTask = new Task(task.get(0), task.get(1), task.get(2));
            taskPQ.add(currTask);
            taskMap.put(task.get(1), currTask);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskPQ.add(task);
        taskMap.put(taskId, task);
    }
    
    public void edit(int taskId, int newPriority) {
        Task task = taskMap.get(taskId);
        taskPQ.remove(task);
        task.priority = newPriority;
        taskMap.put(taskId, task);
        taskPQ.add(task);
    }
    
    public void rmv(int taskId) {
        Task task = taskMap.get(taskId);
        taskPQ.remove(task);
        taskMap.remove(taskId);
    }
    
    public int execTop() {
        return taskPQ.isEmpty() ? -1 : taskPQ.pollFirst().userId;
    }
}

class Task{

    int userId;
    int taskId;
    int priority;

    public Task(int userId, int taskId, int priority){
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */