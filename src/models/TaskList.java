package models;
// models.Task List to hold Users tasks - Created as a Single Linked List

public class TaskList {
    private Node head;

    // Add a task to the end of models.TaskList
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Mark a task as completed using its index
    public void markTaskAsCompleted(int taskIndex) {
        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }

        Node current = head;
        int counter = 1;
        while (current != null) {
            if (counter == taskIndex) {
                current.task.markAsComplete();
                System.out.println("Task: " + current.task.getDescription() + " - complete.");
                return;
            }
            current = current.next;
            counter++;
        }
        System.out.println("Invalid index: No task found at index " + taskIndex);
    }

    // Print list of tasks
    public void displayTaskList() {
        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }

        Node current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.task.toString());
            current = current.next;
            index++;
        }
    }
}
