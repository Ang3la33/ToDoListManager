package models;

public class User {

    private int userID;
    private int IDcounter = 1;
    private String userName;
    private TaskList taskList;

    public User(String userName) {
        this.userName = userName;
        this.userID = IDcounter++;
        taskList = new TaskList();
    }

    public User(User newUser) {
        this.userID = newUser.getUserID();
        this.userName = newUser.getUserName();
    }

    public String getUserName() {
        return userName;
    }

    public int getUserID() {
        return userID;
    }

    public void addTask(String task) {
        taskList.addTask(new Task(task));
    }

    public void markTaskAsCompleted(int taskIndex) {
        taskList.markTaskAsCompleted(taskIndex);
    }

    public void printTaskList() {
        System.out.println("models.Task List for " + userName + ":");
        taskList.displayTaskList();
    }
}
