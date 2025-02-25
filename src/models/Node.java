package models;

// models.Node class to handle the linking structure of the models.Task List
public class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }

    public Task getTask() {
        return task;
    }
}
