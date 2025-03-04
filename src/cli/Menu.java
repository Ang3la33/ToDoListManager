package cli;

import models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<User> users = new ArrayList<>();

    public static void display() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println();
            System.out.println("Welcome to the To-Do List Manager");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. Add User");
            System.out.println("2. Add Task to User");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View all Tasks for a User");
            System.out.println("5. Exit");
            System.out.println("Please choose an option:");

            String input = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> addUser();
                case 2 -> addTaskToUser();
                case 3 -> markTaskAsCompleted();
                case 4 -> viewUsersTasks();
                case 5 -> {
                    isRunning = false;
                    System.out.println("Thank you for using the To-Do List Manager!");
                }
                default -> System.out.println("Invalid choice: Please choose a valid option 1-5");
            }
        }
    }

    private static void addUser() {
        System.out.println("Please enter a user name:");
        String userName = scanner.nextLine().trim();

        if (userName.isEmpty()) {
            System.out.println("Username cannot be empty");
            return;
        }

        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(userName)) {
                System.out.println("Username is already in use");
                return;
            }
        }

        User newUser = new User(userName);
        users.add(new User(newUser));
        System.out.println("User " + newUser.getUserName() + " with ID " + newUser.getUserID() + " successfully added.");

    }

    private static User getUserByName() {
        System.out.println("Enter the user name: ");
        String userName = scanner.nextLine().trim();
        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(userName)) {
                return user;
            }
        }
        System.out.println("User not found.");
        return null;
    }

    private static void addTaskToUser() {
        User user = getUserByName();
        if (user == null) {
            return;
        }
        System.out.println("Please enter task description: ");
        String taskDescription = scanner.nextLine().trim();
        if (taskDescription.isEmpty()) {
            System.out.println("Task description cannot be empty");
            return;
        }
        user.addTask(taskDescription);
        System.out.println("Task for " + user.getUserName() + " added successfully.");
    }

    private static void markTaskAsCompleted() {
        User user = getUserByName();
        if (user == null) {
            return;
        }
        user.printTaskList();
        System.out.println("Enter the task number to mark as completed: ");
        String input = scanner.nextLine().trim();

        int taskIndex;
        try {
            taskIndex = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: Please enter a valid task number.");
            return;
        }

        user.markTaskAsCompleted(taskIndex);
    }

    private static void viewUsersTasks() {
        User user = getUserByName();
        if (user != null) {
            user.printTaskList();
        }
    }
}
